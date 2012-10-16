import javax.swing.*;
import java.awt.*;

class Music {
 
 CenterConsole infoDisplay; //holds the center display w/ info's
 ButtonControlPanel btnPanel; //holds play,rwd,ff buttons
 SharePanel sharePanel; //holds share related stuff
 JTextField search; //search textbox
 JButton collapse; //switches interface from full to compact
 JPanel topPanel;
 JPanel bottomPanel;
 //these should go on the bottom custom panel
 JScrollPane tracksPane;
 JScrollPane playListPane;

  Music() {
    JFrame frm = new JFrame("Music App");
    frm.setLayout( new FlowLayout(FlowLayout.CENTER));
    frm.setSize(850,500);
    //frm.setMinimumSize();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//TOP PANEL STUFF HERE --->
    topPanel = new JPanel();
     
    btnPanel = new ButtonControlPanel();
    infoDisplay = new CenterConsole();
    sharePanel = new SharePanel();
    infoDisplay.setBackground(Color.white); //this is white for debugging purposes

    topPanel.add(btnPanel);
    topPanel.add(infoDisplay);
    topPanel.add(sharePanel);
    frm.add(topPanel);

//BOTTOM PANEL STUFF HERE --->
    bottomPanel = new JPanel();

    frm.setVisible(true);
  }
}

//Do we want to use a liquid layout?
