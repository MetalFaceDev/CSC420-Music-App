//this panel will hold the menu on the bottom left panel

import javax.swing.*;

import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

class BottomPanel extends JPanel {
  private DefaultListModel listmodel;
  private static BottomPanel bottompanel;
  JScrollPane libraryPane;
  JList leftMenu;
  JList playlist;
  JTable library;
  int cellX;
  int cellY;
final JPopupMenu popup;
  String[] menuOptions = {"Music","Playlist"};
  String[] playlistOptions = {"next songs go here","Song1","Song2","Song3","Song4","anotherSong",
  "MoreSongs..","Song1","Song2","Song3","Song4","anotherSong","MoreSongs..","somemoremusic","anotheranotheranothersong","moremoremoremusic"};
  private String[] tableHeaders = {"Track Title", "Artist", "Album", "Likes"};
  private String[][] sampleTracks = {{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"},{"Time Leak","Analogtronics","Union","9"},
  {"Skipping Rocks","Oddisee","People See What They Hear", "15"}};

  //arraylist to hold track objects
  JSplitPane libraryAndPlaylist; //holds library and playlist jscrollpanes

  private BottomPanel() {
    //create leftmenu
    leftMenu = new JList(menuOptions);
    leftMenu.setPreferredSize(new Dimension(65,435));
    leftMenu.setBorder(BorderFactory.createEtchedBorder());
    leftMenu.setBackground(new Color(235,235,235));
    leftMenu.setForeground(Color.BLACK);

    JPanel menuLabel = new JPanel();
    menuLabel.add(new JLabel("Menu"));
    JPanel menuPane = new JPanel();
    menuPane.setLayout(new VerticalLayout());
    menuPane.add(menuLabel);
    menuPane.add(leftMenu);
    menuPane.setBorder(BorderFactory.createEtchedBorder());

    //create playlist jlist
    listmodel = new DefaultListModel();
    playlist = new JList(listmodel);
    JPanel playBar = new JPanel();
    playBar.setLayout(new VerticalLayout());
    playBar.add(new JLabel("Current Playlist"));
    
    //buttons for the playlist section
    JPanel playDelBar = new JPanel();
    JButton playDel = new JButton(""); //button for removing playlist track
    JButton playAdd = new JButton(""); //button for adding playlist track
    JButton playTrash = new JButton(""); //button for trashing whole playlist
    ImageIcon removeTagIcon = new ImageIcon("img/remove_tag_icon.png");
    ImageIcon addTagIcon = new ImageIcon("img/plus.png");
    ImageIcon delTagIcon = new ImageIcon("img/minus.png");
    playTrash.setIcon(removeTagIcon);
    playAdd.setIcon(addTagIcon);
    playDel.setIcon(delTagIcon);
    playDel.setPreferredSize(new Dimension(40,27));
    playAdd.setPreferredSize(new Dimension(40,27));
    playTrash.setPreferredSize(new Dimension(40,27));
    playDelBar.add(playAdd);
    playDelBar.add(playDel);
    playDelBar.add(new JLabel("   "));
    playDelBar.add(playTrash);
    playDelBar.setPreferredSize(new Dimension(160,29));

    //listeners for buttons on playlist side
    playDel.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //deleted hilighted song
          DefaultListModel lm  = (DefaultListModel) playlist.getModel();
	  lm.removeElement(playlist.getSelectedValue());     
	  //int i = playlist.getSelectedIndex();
	  //playlist.removeSelectionInterval(i,i);
	}
    });

    playAdd.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //add highlighted song
	 String trak = getSelectedTrack();
	 addToList(trak);
	}
    });

    playTrash.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //delete everything 	
	playlist.setListData(new String[0]);
	}
    });

    playlist.setDropMode(DropMode.INSERT);
    playlist.setBackground(new Color(235,235,235));
    playlist.setForeground(Color.BLACK);

    //create library jtable
    library = new JTable(sampleTracks,tableHeaders){
  	public Component prepareRenderer
  	  (TableCellRenderer renderer,int Index_row, int Index_col) {
  	    Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
  	    //even index, selected or not selected
  	    if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
  		comp.setBackground(new Color(235,235,235));
  	    } else {
  		comp.setBackground( new Color (204, 204, 204));
  	    }  if (isCellSelected(Index_row, Index_col)) {
  	        comp.setBackground(new Color(7,66,60));
  	    }
  	    return comp;
  	  }
       public boolean isCellEditable(int rowIndex, int colIndex) {
           return true;   //Disallow the editing of any cell
       }
   };
    library.setColumnSelectionAllowed(false);
    library.setShowHorizontalLines(true);
    library.setDragEnabled(true);
    //library.setTransferHandler(new TransferHandler("text"));
    TransferHandler t = library.getTransferHandler(); 
    library.setForeground(Color.BLACK);

    //create jpopupmenu
    popup = new JPopupMenu();
    JMenuItem edit = new JMenuItem("Rename");
    JMenuItem play = new JMenuItem("Play");
    JMenuItem add = new JMenuItem("Add to Playlist");
    JMenuItem delete = new JMenuItem("Delete");

    //actionlistener for edit
    edit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Rename")){
        //TagPopupFrame f = new TagPopupFrame();
        library.editCellAt(cellX,cellY);
        //f.setVisible(true);
      }
       }
    });
    
    //actionlistener for play
    play.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Play")){
       CenterConsole c = CenterConsole.getInstance();
       c.setPlaySong();
      }
       }
    });

    //actionlistener for adding to playlist   
    add.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add to Playlist")){
	 String trak = getSelectedTrack();
	 addToList(trak);
	}
      }
    });

    delete.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Delete")){
	  removeFromTable();
	}
      }
    });

    //add jmenuitems to rightclick popup
    popup.add(play);
    popup.add(add);
    popup.add(edit);
    popup.add(delete);
    
    //JTable right-click popup menu section
    library.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
        if(SwingUtilities.isRightMouseButton(e) == true) { 
       // if (e.isPopupTrigger()){
            JTable source = (JTable)e.getSource();
            int row = source.rowAtPoint( e.getPoint() );
            int column = source.columnAtPoint( e.getPoint() );

            if (! source.isRowSelected(row)){
                source.changeSelection(row, column, false, false);
            }
 	    getMousePos(row,column);
            popup.show(e.getComponent(), e.getX(), e.getY());
           
         } 
       }
     });

    JScrollPane lib = new JScrollPane(library);
    //lib.setPreferredSize(new Dimension(600,400));
    JScrollPane pList = new JScrollPane(playlist);
    pList.setPreferredSize(new Dimension(160,400));
    playBar.add(pList);
    playBar.setBorder(BorderFactory.createEtchedBorder());
    playBar.add(playDelBar);
    JScrollPane scroll = new JScrollPane(library);

    //leftMenu.setPreferredSize(new Dimension(100,410));
    JSplitPane b = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,playBar);
    JPanel top = new JPanel();
    top.add(b);
    libraryAndPlaylist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPane, top);
    this.add(libraryAndPlaylist);
    libraryAndPlaylist.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                @Override
                    public void paint(Graphics g) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
            };
            }
        });
       // libraryAndPlaylist.setBorder(null);
       
    b.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                @Override
                    public void paint(Graphics g) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
            };
            }
        });
  }

  //gets the position of the mouse
  public void getMousePos(int x, int y) {
    cellX = x;
    cellY = y;
  }

  //gets the selected track in the library jtable
  public String getSelectedTrack() {
    //get the row index
    int selectedRowIndex = library.getSelectedRow(); 
    String selectedObject = (String) library.getModel().getValueAt(selectedRowIndex, 0);
    selectedObject = selectedObject+" - "+(String) library.getModel().getValueAt(selectedRowIndex, 1);
    return selectedObject;
  }

  //create the instance of this bottom panel
  public static BottomPanel create() {
    if (bottompanel == null) {
	    bottompanel = new BottomPanel();
    }
    return bottompanel;
  }

  public static BottomPanel getInstance() {
    return bottompanel;
  }

  private void addToList(String song) {
    listmodel.addElement(song);
  }

  private void removeFromTable() {
    int selectedRowIndex = library.getSelectedRow(); 
    DefaultTableModel t = (DefaultTableModel) library.getModel();
    t.removeRow(selectedRowIndex);
  }
  public Object[] getPlaylistArray(){
		return playlist.getSelectedValues();

  } 
 
  //returns an array of the song info selected
  public String[] getSongToPlay() {
    String[] info = new String[3];
    int selectedRowIndex = library.getSelectedRow(); 
    String song = (String) library.getModel().getValueAt(selectedRowIndex, 0);
    String artist = (String) library.getModel().getValueAt(selectedRowIndex, 1);
    String album = (String) library.getModel().getValueAt(selectedRowIndex, 2);
    info[0] = song;
    info[1] = artist;
    info[2] = album;
    
    return info;
  }
}
