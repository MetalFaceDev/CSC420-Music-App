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

  Music() {
    frm = new JFrame("Music App");
    frm.setLayout(gbag);
    frm.setSize(850,850);
    //frm.setMinimumSize();
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    topPanel = new JPanel();

    btnPanel = new ButtonControlPanel();
    infoDisplay = new CenterConsole();
    sharePanel = new SharePanel();
    collapse = new JButton("↑");
    topLeftPanel = new JPanel();
    JPanel p = new JPanel();
    bottomPanel = new BottomPanel();


//TOP PANEL STUFF HERE --->
    topPanel.setLayout(new FlowLayout());
    infoDisplay.setBackground(Color.white);

    collapse.setPreferredSize(new Dimension(60, 30));
    collapse.addActionListener(this);

    topPanel.add(btnPanel);
    topPanel.add(infoDisplay);

    topLeftPanel.setLayout(new FlowLayout());
    topLeftPanel.add(sharePanel);

    p.setLayout(new FlowLayout());
    p.add(collapse);
    topLeftPanel.add(p);
    topPanel.add(topLeftPanel);

    gbc.gridx =0;
    gbc.gridy =0;
    gbag.setConstraints(topPanel, gbc);
    frm.add(topPanel);

//BOTTOM PANEL STUFF HERE --->
    gbc.gridx =0;
    gbc.gridy = 1;
    gbag.setConstraints(bottomPanel, gbc);
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
      gbc.gridx =0;
      gbc.gridy = 1;
      gbag.setConstraints(bottomPanel, gbc);
      frm.add(bottomPanel);
      frm.pack();
      collapse.setText("↑");
    }
  }
}

//Do we want to use a liquid layout?
