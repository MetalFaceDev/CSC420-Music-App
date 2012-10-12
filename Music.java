import javax.swing.*;
import java.awt.*;

class Music {
 
 JPanel infoDisplay; //holds the center display with progress bar
 JPanel buttonPanel; //holds buttons on left side
 JPanel tagPanel; //holds buttons for tags
 JSlider volume; //slider for volume
 JTextField search; //search textbox
 JLabel artist; //artist 
 JLabel songTitle; //song name
 JLabel albumTitle; //album title
 JButton setTag; //button to set tag
 JLabel timeNow; //current time in track
 JLabel totTime; //total time in track
 JProgressBar trackTime; //shows current time position in song

  Music() {
    JFrame frm = new JFrame("Music App");
    frm.setLayout( new FlowLayout());
    frm.setSize(720,500);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    frm.setVisible(true);
  }
}
