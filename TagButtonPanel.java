import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TagButtonPanel extends JPanel{
	JButton tagButton1;
	JButton tagButton2;
	JButton tagButton3;
	JButton tagButton4;
	JButton tagButton5;
	JButton tagButton6;
	JButton tagButton7;
	JButton tagButton8;
	JButton tagButton9;
	JButton tagButton10;
	JButton removeButton;

	public TagButtonPanel(){
		this.setLayout(new FlowLayout());
		initComponents();
		setBackground(Color.WHITE);
		
	}

	public void initComponents(){
		Dimension buttonSize = new Dimension(20,20);

		tagButton1= new JButton("1");
		tagButton1.setPreferredSize(buttonSize);
		tagButton2 = new JButton("2");
		tagButton2.setPreferredSize(buttonSize);
		tagButton3 = new JButton("3");
		tagButton3.setPreferredSize(buttonSize);
		tagButton4 = new JButton("4");
		tagButton4.setPreferredSize(buttonSize);
		tagButton5 = new JButton("5");
		tagButton5.setPreferredSize(buttonSize);
		tagButton6 = new JButton("6");
		tagButton6.setPreferredSize(buttonSize);
		tagButton7 = new JButton("7");
		tagButton7.setPreferredSize(buttonSize);
		tagButton8 = new JButton("8");
		tagButton8.setPreferredSize(buttonSize);
		tagButton9 = new JButton("9");
		tagButton9.setPreferredSize(buttonSize);
		tagButton10 = new JButton("10");
		tagButton10.setPreferredSize(buttonSize);
		removeButton = new JButton("R");
		removeButton.setPreferredSize(buttonSize);

		add(tagButton1);
		add(tagButton2);
		add(tagButton3);
		add(tagButton4);
		add(tagButton5);
		add(tagButton6);
		add(tagButton7);
		add(tagButton8);
		add(tagButton9);
		add(tagButton10);
		add(removeButton);

		
		tagButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});
	
		tagButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});
		
		tagButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});
		
		tagButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});

		tagButton5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});
		tagButton6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});
		
		tagButton7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});

		tagButton8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});

		tagButton9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});

		tagButton10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
			}
		});

		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//remove currrently selected tag		
			}
		});
		
	}

}
