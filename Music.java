import javax.swing.*;
import java.awt.*;

class Music {
 
 CenterConsole infoDisplay; //holds the center display w/ info's
 ButtonControlPanel btnPanel; //holds play,rwd,ff buttons
 JSlider volume; //slider for volume
 JTextField search; //search textbox
 JButton collapse; //switches interface from full to compact

  Music() {
    JFrame frm = new JFrame("Music App");
    frm.setLayout( new FlowLayout());
    frm.setSize(720,500);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    btnPanel = new ButtonControlPanel();
    frm.add(btnPanel);

    frm.setVisible(true);
  }
}

//Do we want to use a liquid layout?
