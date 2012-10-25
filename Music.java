import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Music implements ActionListener {
 
 JFrame frm;
 CenterConsole infoDisplay; //holds the center display w/ info's
 ButtonControlPanel btnPanel; //holds play,rwd,ff buttons
 SharePanel sharePanel; //holds share related stuff
 JTextField search; //search textbox
 JButton collapse; //switches interface from full to compact
 JPanel topPanel;
 JPanel topLeftPanel;
 BottomPanel bottomPanel;

  Music() {
    frm = new JFrame("Music App");
    //frm.setLayout( new FlowLayout());
    frm.setLayout( new GridLayout(0,1));

    frm.setSize(850,850);
    //frm.setMinimumSize();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//TOP PANEL STUFF HERE --->
    topPanel = new JPanel();
    
    btnPanel = new ButtonControlPanel();
    infoDisplay = new CenterConsole();
    sharePanel = new SharePanel();
    infoDisplay.setBackground(Color.white); //this is white for debugging purposes
    collapse = new JButton("↑");
    collapse.setPreferredSize(new Dimension(25, 25));
    collapse.addActionListener(this);

    topPanel.add(btnPanel);
    topPanel.add(infoDisplay);
    topLeftPanel = new JPanel();
    topLeftPanel.setLayout(new GridLayout(2,1));
    topLeftPanel.add(sharePanel);
    topLeftPanel.add(collapse);
    topPanel.add(topLeftPanel);

    frm.add(topPanel);

//BOTTOM PANEL STUFF HERE --->
    bottomPanel = new BottomPanel();
    frm.add(bottomPanel);
    frm.pack();
    frm.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("↑")) {
      frm.remove(bottomPanel);
      frm.pack();
      collapse.setText("↓");
       
    }
    else if (e.getActionCommand().equals("↓")) {
      frm.add(bottomPanel);
      frm.pack();
      collapse.setText("↑");
    }
  }
}

//Do we want to use a liquid layout?
