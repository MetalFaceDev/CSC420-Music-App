//this panel is the center panel that contains the info of the current track playing.

import javax.swing.*;

class CenterConsole extends JPanel {
  JLabel artist; //artist 
  JLabel songTitle; //song name
  JLabel albumTitle; //album title
  JButton setTag; //button to set tag
  JLabel timeNow; //shows current time in track
  JLabel totTime; //shows total time in track
  JProgressBar trackTime; //shows current time position in song
  JPanel tagPanel; //holds buttons for tags
 
  CenterConsole() {
   //add content to panel
  }
}

/*
NEED LISTENERS FOR
-JButton setTag
-JLabel timeNow needs to always update with current time position
-JProgressBar trackTime should always update with current time position
-JButton setTag needs actionListener
**JPanel tagPanel should update whenever a new tag is created and should load a tag when a tag is chosen
   --also this 'tagPanel' should hold buttons for the tags
     --do we want to generate a new button anytime a setTag is pushed and a new tag is made or
     have a static amount of buttons?

-JLabel totTime is a static label...shouldn't change
