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
  String[] menuOptions = {"Music","Playlist","Likes"}; //for debugging
  private String[] tableHeaders = {"Title", "Artist", "Album"};
  private String[][] sampleTracks = {{"Optimist","P.O.S","Never Better"},{"Skipping Rocks","Oddisee","People See What They Hear"}};
  //arraylist to hold track objects

  BottomPanel() {
    this.setLayout(new GridLayout(1,3)); //layout for panel
    //this.add(new JLabel("Menu here."));
    //this.add(new JLabel("Playlist here."));
    leftMenu = new JList(menuOptions);
    playlist = new JList(menuOptions);

    JScrollPane lib = new JScrollPane(leftMenu);
    JScrollPane pList = new JScrollPane(playlist);
    //leftMenu.addMouseListener(mouseListener); //add a mouse listener
    //playList.addMouseListener(mouseListener2); //add a mouse listener
    this.add(lib);
    library = new JTable(sampleTracks,tableHeaders);
    JScrollPane scroll = new JScrollPane(library);
    this.add(scroll);
    this.add(pList);
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
