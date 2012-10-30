//this panel will hold the menu on the bottom left panel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class BottomPanel extends JPanel {
  JScrollPane libraryPane;
  JList leftMenu;
  JList playlist;
  JTable library;
  String[] menuOptions = {"Music","Playlist","Likes"};
  private String[] tableHeaders = {"Title", "Artist", "Album"};
  private String[][] sampleTracks = {{"Optimist","P.O.S","Never Better"},
  {"Skipping Rocks","Oddisee","People See What They Hear"}};
  //arraylist to hold track objects
  JSplitPane libraryAndPlaylist; //holds library and playlist jscrollpanes
  GridBagLayout gbag = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();

  BottomPanel() {
    this.setLayout(gbag); //layout for panel

    leftMenu = new JList(menuOptions);
    JPanel menuTop = new JPanel();
    menuTop.setPreferredSize(new Dimension(30,30));
    menuTop.add(new JLabel("Menu"));
    JPanel menuPane = new JPanel();
    //menuPane.setLayout(new GridLayout(0,1));
    //menuPane.setLayout(new GridLayout(0,1));
    menuPane.setLayout(new BoxLayout(menuPane, BoxLayout.Y_AXIS)); 
    menuPane.add(leftMenu);
    //menuPane.add(menuTop);
    menuPane.setBorder(BorderFactory.createEtchedBorder());

    playlist = new JList(menuOptions);
    library = new JTable(sampleTracks,tableHeaders);
    JScrollPane lib = new JScrollPane(library);
    JScrollPane pList = new JScrollPane(playlist);
    JScrollPane scroll = new JScrollPane(library);

    //leftMenu.setPreferredSize(new Dimension(100,410));
    JSplitPane b = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scroll,pList);
    JPanel top = new JPanel();
    top.add(b);
    libraryAndPlaylist = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPane, top);

    //leftMenu.setMaximumSize(new Dimension(1000,1000));

    //leftMenu.addMouseListener(mouseListener); //add a mouse listener
    //playList.addMouseListener(mouseListener2); //add a mouse listener
    gbc.gridx =0;
    gbc.gridy =0;
    //gbag.setConstraints(leftMenu, gbc);
    gbag.setConstraints(libraryAndPlaylist, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    this.add(libraryAndPlaylist);

  //  gbc.gridx =1;
  //  gbc.gridy =0;
 //   gbag.setConstraints(libraryAndPlaylist, gbc);

   // this.add(libraryAndPlaylist);
  }

  /*
   MouseListener mouseListener = new MouseAdapter() {
     public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 2) {
             int index = list.locationToIndex(e.getPoint());
             System.out.println("Double clicked on Item " + index);
          }
     }
 };
 list.addMouseListener(mouseListener);
  */


}
