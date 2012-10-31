import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TagButtonPanel extends JPanel{
	
	JButton[] buttonArray = new JButton[11];

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
	TagPanel tagPanel;
	JSlider jSlider;
	int currentButtonNumber;


	public TagButtonPanel(){
		this.setLayout(new FlowLayout());
		initComponents();
		setBackground(Color.WHITE);
		
	}

	public void initComponents(){
		Dimension buttonSize = new Dimension(20,20);

		tagButton1= new JButton("1");
		tagButton1.setPreferredSize(buttonSize);
		tagButton1.setBackground(Color.white);
		tagButton1.setEnabled(false);
		buttonArray[0] = tagButton1;
		
		tagButton2 = new JButton("2");
		tagButton2.setPreferredSize(buttonSize);
		tagButton2.setEnabled(false);
		buttonArray[1] = tagButton2;

		tagButton3 = new JButton("3");
		tagButton3.setPreferredSize(buttonSize);
		tagButton3.setEnabled(false);
		buttonArray[2] = tagButton3;

		tagButton4 = new JButton("4");
		tagButton4.setPreferredSize(buttonSize);
		tagButton4.setEnabled(false);
		buttonArray[3] = tagButton4;

		tagButton5 = new JButton("5");
		tagButton5.setPreferredSize(buttonSize);
		tagButton5.setEnabled(false);
		buttonArray[4] = tagButton5;

		tagButton6 = new JButton("6");
		tagButton6.setPreferredSize(buttonSize);
		tagButton6.setEnabled(false);
		buttonArray[5] = tagButton6;

		tagButton7 = new JButton("7");
		tagButton7.setPreferredSize(buttonSize);
		tagButton7.setEnabled(false);
		buttonArray[6] = tagButton7;

		tagButton8 = new JButton("8");
		tagButton8.setPreferredSize(buttonSize);
		tagButton8.setEnabled(false);
		buttonArray[7] = tagButton8;

		tagButton9 = new JButton("9");
		tagButton9.setPreferredSize(buttonSize);
		tagButton9.setEnabled(false);
		buttonArray[8] = tagButton9;

		tagButton10 = new JButton("10");
		tagButton10.setPreferredSize(buttonSize);
		tagButton10.setEnabled(false);
		buttonArray[9] = tagButton10;

		removeButton = new JButton("R");
		removeButton.setPreferredSize(buttonSize);
		buttonArray[10] = removeButton;

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
				moveSlider(1);
				currentButtonNumber = 1;		
			}
		});
	
		tagButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(2);		
				currentButtonNumber = 2;
			}
		});
		
		tagButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(3);		
				currentButtonNumber = 3;
			}
		});
		
		tagButton4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(4);		
				currentButtonNumber = 4;
			}
		});

		tagButton5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(5);		
				currentButtonNumber = 5;
			}
		});
		tagButton6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(6);		
				currentButtonNumber = 6;
			}
		});
		
		tagButton7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(7);		
				currentButtonNumber = 7;
			}
		});

		tagButton8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(8);		
				currentButtonNumber = 8;
			}
		});

		tagButton9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(9);		
				currentButtonNumber = 9;
			}
		});

		tagButton10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//play track from tag pointer		
				moveSlider(10);		
				currentButtonNumber = 10;
			}
		});

		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//remove currrently selected tag		
			}
		});
		
	}
	
	public void setTagPanel(TagPanel tP){
			this.tagPanel = tP;
	}
	
	public void setSlider(JSlider jS){
			this.jSlider = jS;
	}


	public void moveSlider(int buttonNumber){
		if(tagPanel.tags[buttonNumber-1] != null){
			jSlider.setValue(tagPanel.tags[buttonNumber-1].slidePosition);	
		}
	}

}
