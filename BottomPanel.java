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
  String[] playlistOptions = {"next songs go here","Song1","Song2","Song3","Song4","anotherSong",
  "MoreSongs..","Song1","Song2","Song3","Song4","anotherSong","MoreSongs..","somemoremusic","anotheranotheranothersong","moremoremoremusic"};
  private String[] tableHeaders = {"Track Title", "Artist", "Album"};
  private String[][] sampleTracks = {{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"},{"Time Leak","Analogtronics","Union"},
  {"Skipping Rocks","Oddisee","People See What They Hear"}};

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
    library = new JTable(sampleTracks,tableHeaders);
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

    //leftMenu.setMaximumSize(new Dimension(1000,1000));

    //leftMenu.addMouseListener(mouseListener); //add a mouse listener
    //playList.addMouseListener(mouseListener2); //add a mouse listener
    this.add(libraryAndPlaylist);
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
