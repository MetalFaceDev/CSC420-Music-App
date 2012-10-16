//this panel holds share-related components

import javax.swing.*;
import java.awt.*;

class SharePanel extends JPanel {
  JButton shareIt;
  JCheckBox autoShare;
  JLabel likesIcon;
  JLabel likesHere;
  JPanel likes;

  SharePanel() {
   this.setLayout(new GridLayout(3,1)); //layout for panel
   this.add(shareIt = new JButton("Share"));
   this.add(new JLabel(""));//blank cell in grid
   this.add(autoShare = new JCheckBox("Auto-Share"));
   this.add(new JLabel(""));//blank cell in grid
//here i compacted the "likes" stuff into a jpanel to fit it in same cell
   ImageIcon likeThumb = new ImageIcon("img/like.gif");
   likes = new JPanel();
   likes.setLayout(new FlowLayout());
   likes.add(likesIcon = new JLabel(likeThumb));
   likes.add(likesHere = new JLabel("(Likes)"));

   this.add(likes);
  }
}
