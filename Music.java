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
 JPanel topLeftPanel; //holds sharepanel and collapse btn
 BottomPanel bottomPanel;
 GridBagLayout gbag = new GridBagLayout();
 GridBagConstraints gbc = new GridBagConstraints();
 SearchPanel searchPanel;


  Music() {
    frm = new JFrame("Music Player");
    //frm.setLayout(gbag);
    frm.setLayout(new VerticalLayout());
	frm.setBackground(Color.DARK_GRAY);
    frm.setSize(890,920);
	frm.getContentPane().setBackground(Color.DARK_GRAY); 
   //frm.setMinimumSize();
   // frm.setResizable(false);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    topPanel = new JPanel();

    btnPanel = new ButtonControlPanel();
    infoDisplay = CenterConsole.create();
    sharePanel = new SharePanel();
    collapse = new JButton("↑");
    collapse.setToolTipText("Switch to compact mode.");
    topLeftPanel = new JPanel();
    JPanel p = new JPanel();
    bottomPanel = BottomPanel.create();


//TOP PANEL STUFF HERE --->
    topPanel.setLayout(new FlowLayout());
	topPanel.setBackground(Color.DARK_GRAY);

    infoDisplay.setBackground(Color.LIGHT_GRAY);

    collapse.setPreferredSize(new Dimension(60, 30));
    collapse.addActionListener(this);
    topPanel.add(btnPanel);
    topPanel.add(infoDisplay);

    topLeftPanel.setLayout(new VerticalLayout());
    topLeftPanel.add(sharePanel);

    p.setLayout(new FlowLayout());
	p.setBackground(Color.DARK_GRAY);
    p.add(collapse);
    topLeftPanel.add(p);
    topPanel.add(topLeftPanel);

    //gbc.gridx =0;
    //gbc.gridy =0;
    //gbag.setConstraints(topPanel, gbc);
    frm.add(topPanel);

//SEARCH PANEL STUFF HERE --->
		searchPanel = new SearchPanel();
		frm.add(searchPanel);


//BOTTOM PANEL STUFF HERE --->
    //gbc.gridx =0;
    //gbc.gridy = 1;
    //gbag.setConstraints(bottomPanel, gbc);
    frm.add(bottomPanel);
    frm.pack();

    frm.setVisible(true);
  //  TagPopupFrame f = new TagPopupFrame();
   // f.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("↑")) {
      frm.remove(bottomPanel);
      searchPanel.setCollapseSearchVisible(true);
      frm.pack();
      collapse.setText("↓");
    collapse.setToolTipText("Switch to full mode.");
    }
    else if (e.getActionCommand().equals("↓")) {
      gbc.gridx =0;
      gbc.gridy = 1;
      gbag.setConstraints(bottomPanel, gbc);
      frm.add(bottomPanel);
      searchPanel.setCollapseSearchVisible(false);
      collapse.setToolTipText("Switch to compact mode.");
      frm.pack();
      collapse.setText("↑");
    }
  }
}

//Do we want to use a liquid layout?
