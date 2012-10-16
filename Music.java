import javax.swing.*;
import java.awt.*;

class Music {
 
 CenterConsole infoDisplay; //holds the center display w/ info's
 ButtonControlPanel btnPanel; //holds play,rwd,ff buttons
 JSlider volume; //slider for volume
 JTextField search; //search textbox
<<<<<<< HEAD
 JButton collapse; //switches interface from full to compact
=======
 JLabel artist; //artist 
 JLabel songTitle; //song name
 JLabel albumTitle; //album title
 JButton setTag; //button to set tag
 JLabel timeNow; //current time in track
 JLabel totTime; //total time in track
 JProgressBar trackTime; //shows current time position in song
 
//Start Update
  
//Update:
  JSlider volumeSlider;
  JTextField searchBox;
  JLabel artistLabel, titleLabel, albumLabel, timeNowLabel, totalTimeLabel;
 
//New: 
  JScrollPane tracksPane;
  JScrollPane playListPane;



//End update
>>>>>>> bd0004eb821c1485bbe52989e5e0b55b32c6dda1

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
