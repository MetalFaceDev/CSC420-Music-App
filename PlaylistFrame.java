import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class PlaylistFrame extends JFrame implements ActionListener{
    JPanel newPlaylist = new JPanel();
    PlaylistFrame thisFrame;
    JPanel moBtns;
    private DefaultListModel listmodel;
    JTextField pName;
    JList playlist;

  PlaylistFrame(){
    this.setLayout(new VerticalLayout());
    JPanel panel = new JPanel();
    listmodel = new DefaultListModel();
    playlist = new JList(listmodel);
    playlist.setForeground(Color.BLACK);
    playlist.setPreferredSize(new Dimension(190,240));
    thisFrame = this;

    panel.add(playlist);
    this.add(playlist);

    this.setSize(new Dimension(210,300));

    //panel with buttons for playlist
    JPanel buttonPanel = new JPanel();
    JButton playDel = new JButton(""); //button for removing playlist track
    JButton playAdd = new JButton(""); //button for adding playlist track
    ImageIcon addTagIcon = new ImageIcon("img/plus.png");
    ImageIcon delTagIcon = new ImageIcon("img/minus.png");
    playDel.setPreferredSize(new Dimension(40,27));
    playAdd.setPreferredSize(new Dimension(40,27));
    buttonPanel.add(playAdd);
    buttonPanel.add(playDel);
    playAdd.setIcon(addTagIcon);
    playDel.setIcon(delTagIcon);
    buttonPanel.setPreferredSize(new Dimension(210,35));
   

    //new playlist
    newPlaylist.setLayout(new FlowLayout());
    JLabel nlab = new JLabel("Name:");
    pName = new JTextField(10);
    pName.setForeground(Color.BLACK);
    newPlaylist.add(nlab);
    newPlaylist.add(pName);
 
    this.add(buttonPanel);

    playDel.setToolTipText("Remove a playlist.");
    playAdd.setToolTipText("Create a new playlist.");
   
    JButton create = new JButton("Create");
    JButton cancel = new JButton("Cancel");
    moBtns = new JPanel();
    moBtns.setLayout(new FlowLayout());
    moBtns.add(create);
    moBtns.add(cancel);

   playAdd.addActionListener( new ActionListener() {
     public void actionPerformed(ActionEvent e){
        thisFrame.add(newPlaylist);
        newPlaylist.setVisible(true);
        thisFrame.add(moBtns);
	pName.setText("");
	thisFrame.setSize(new Dimension(210,370));
     }
   });
   
   cancel.addActionListener( new ActionListener() {
     public void actionPerformed(ActionEvent e){
        thisFrame.remove(newPlaylist);
        thisFrame.remove(moBtns);
	thisFrame.setSize(new Dimension(210,300));
     }
   });
   
   create.addActionListener( new ActionListener() {
     public void actionPerformed(ActionEvent e){
	String song = pName.getText();   
        listmodel.addElement(song);
        thisFrame.remove(newPlaylist);
        thisFrame.remove(moBtns);
	thisFrame.setSize(new Dimension(210,300));
     }
   });
    playDel.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
        //deleted hilighted song
          DefaultListModel lm  = (DefaultListModel) playlist.getModel();
	  lm.removeElement(playlist.getSelectedValue());     
	  //int i = playlist.getSelectedIndex();
	  //playlist.removeSelectionInterval(i,i);
	}
    });
  }
  
  public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Cancel"))
	     this.setVisible(false);
  }
}
