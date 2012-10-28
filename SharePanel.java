//this panel holds share-related components

import javax.swing.*;
import java.awt.*;

class SharePanel extends JPanel {
  JButton shareIt;
  JCheckBox autoShare;
  JLabel likesIcon;
  JLabel likesHere;
  JPanel likes;
  JTextField search;
  GridBagLayout gbag = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();

  SharePanel() {
   //setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
   //this.setLayout(new GridLayout(3,1)); //layout for panel
   this.setLayout(gbag); //layout for panel
    
   shareIt = new JButton("Share");
   gbc.gridx =0;
   gbc.gridy =0;
   gbc.anchor = GridBagConstraints.NORTHWEST;
   gbag.setConstraints(shareIt, gbc);
   this.add(shareIt);

   autoShare = new JCheckBox("Auto-Share");
   gbc.gridx =0;
   gbc.gridy =1;
   gbc.anchor = GridBagConstraints.WEST;
   gbag.setConstraints(autoShare, gbc);
   this.add(autoShare);

   //here i compacted the "likes" stuff into a jpanel to fit it in same cell
   ImageIcon likeThumb = new ImageIcon("img/like.gif");
   likes = new JPanel();
   likes.setLayout(new FlowLayout());
   likes.add(likesIcon = new JLabel(likeThumb));
   likes.add(likesHere = new JLabel("(Likes)"));
   gbc.gridx =0;
   gbc.gridy =2;
   gbag.setConstraints(likes, gbc);
   this.add(likes);
   
   search = new JTextField(8);
   gbc.gridx =0;
   gbc.gridy=3;
   gbag.setConstraints(search, gbc);
   search.setActionCommand("search");
   this.add(search);
  }
}
