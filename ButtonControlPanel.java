//this panel holds the rewind, play, fastForward, Shuffle and Repeat Buttons

import javax.swing.*;

class ButtonControlPanel extends JPanel {
 JButton play; //play button
 JButton rewind; //rewind button
 JButton fastForward; //fast forward button
 JButton shuffle; //toggles shuffle
 JButton repeat; //toggles repeat

 ButtonControlPanel() {
    play = new JButton(">"); 
    rewind = new JButton("<<");
    fastForward = new JButton(">>");

    this.add(rewind); //adds rwd btn to panel
    this.add(play); //adds play btn to panel
    this.add(fastForward); //adds ff btn to panel
 }
}

/*
NEEDS LISTENERS FOR all of the buttons here 
*/
