import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPanel extends JPanel{
		JTextField searchTextField;
		JTextField trackSelection;
		JButton backButton;
		JButton forwardButton;
		JButton searchButton;

		public SearchPanel(){
			super();
			initComponents();
		}

		private void initComponents(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			backButton = new JButton("<");

			trackSelection = new JTextField(13);
			trackSelection.setText("Next Track");
					
			forwardButton = new JButton(">");

			searchTextField = new JTextField(8);
			searchTextField.setText("Search..");
			searchTextField.setActionCommand("search");
			searchTextField.setSelectedTextColor(Color.gray);	
		
			searchButton = new JButton("Enter");
			setCollapseSearchVisible(false);
		
			c.gridx = 0;
			c.gridy = 0;
			
			this.add(backButton,c);

			c.gridx = 3;
			c.gridy = 0;
			c.gridwidth = 3;
			c.fill = GridBagConstraints.HORIZONTAL;
			this.add(trackSelection);

			c.gridx = 4;
			c.gridy = 0;
			c.gridwidth = 1;
			this.add(forwardButton);
						
			c.gridx = 5;
			c.gridy = 0;
			c.weightx = 1;
			c.anchor = GridBagConstraints.LINE_END;
			this.add(searchTextField,c);
			
			c.gridx = 6;
			c.gridy = 6;
			this.add(searchButton);

			searchTextField.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					searchTextField.setText("");					
				}
			});

			searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					searchTextField.setText("Search..");	
				}
			});

	
		}

		public void setCollapseSearchVisible(boolean b){
				if(b){
					backButton.setVisible(true);
					trackSelection.setVisible(true);
					forwardButton.setVisible(true);
				}else{
					backButton.setVisible(false);
					trackSelection.setVisible(false);
					forwardButton.setVisible(false);
				}
		}
}
