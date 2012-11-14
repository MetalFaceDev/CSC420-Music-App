//this panel will hold the menu on the bottom left panel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;


class BottomPanel extends JPanel {
  JScrollPane libraryPane;
  JList leftMenu;
  JList playlist;
  JTable library;
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

  BottomPanel() {

    leftMenu = new JList(menuOptions);
    leftMenu.setPreferredSize(new Dimension(65,400));
    leftMenu.setBorder(BorderFactory.createEtchedBorder());
    JPanel menuLabel = new JPanel();
    //menuLabel.setPreferredSize(new Dimension(30,30));
    menuLabel.add(new JLabel("Menu"));
    JPanel menuPane = new JPanel();
    menuPane.setLayout(new VerticalLayout());
    menuPane.add(menuLabel);
    menuPane.add(leftMenu);
    //menuPane.setPreferredSize(new Dimension(65,400));
    menuPane.setBorder(BorderFactory.createEtchedBorder());

    playlist = new JList(playlistOptions);
    JPanel playBar = new JPanel();
    playBar.setLayout(new VerticalLayout());
    playBar.add(new JLabel("Current Playlist"));
    library = new JTable(sampleTracks,tableHeaders){
  	public Component prepareRenderer
  	  (TableCellRenderer renderer,int Index_row, int Index_col) {
  	    Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
  	    //even index, selected or not selected
  	    if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
  		comp.setBackground(Color.white);

  	    } else {
  		comp.setBackground( new Color (217, 217, 237));
  	    }  if (isCellSelected(Index_row, Index_col)) {
  	        comp.setBackground(Color.blue);
  	    }
  	    return comp;
  	  }
   };

    //DefaultCellEditor dce = library.getDefaultEditor(Object.class);
    //Component editor = dce.getComponent();
    //editor.addMouseListener(...);

    library.setColumnSelectionAllowed(false);
    library.setShowHorizontalLines(true);
    popup = new JPopupMenu();
    popup.add(new JMenuItem("Play"));
    popup.add(new JMenuItem("Rename"));
    popup.add(new JMenuItem("Add to Playlist"));
    popup.add(new JMenuItem("Delete"));

    library.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
        if(SwingUtilities.isRightMouseButton(e) == true) { 
       // if (e.isPopupTrigger()){
            JTable source = (JTable)e.getSource();
            int row = source.rowAtPoint( e.getPoint() );
            int column = source.columnAtPoint( e.getPoint() );

            if (! source.isRowSelected(row))
                source.changeSelection(row, column, false, false);

            popup.show(e.getComponent(), e.getX(), e.getY());
        
         } 
       }
     });

    JScrollPane lib = new JScrollPane(library);
    //lib.setPreferredSize(new Dimension(600,400));
    JScrollPane pList = new JScrollPane(playlist);
    pList.setPreferredSize(new Dimension(150,400));
    playBar.add(pList);
    playBar.setBorder(BorderFactory.createEtchedBorder());
    JScrollPane scroll = new JScrollPane(library);

    //leftMenu.setPreferredSize(new Dimension(100,410));
    JSplitPane b = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,playBar);
    JPanel top = new JPanel();
    top.add(b);
    libraryAndPlaylist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPane, top);
    this.add(libraryAndPlaylist);
  }
}
