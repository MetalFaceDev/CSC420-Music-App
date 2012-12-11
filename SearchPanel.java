import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPanel extends JPanel implements MouseListener {
		JTextField searchTextField;
		JLabel trackSelection;
		JButton backButton;
		JButton forwardButton;
		JButton searchButton;
		String[] trackArray;
		int positionCount = 0;
		JButton quickPlayButton;

		public SearchPanel(){
			super();
			this.setBackground(Color.DARK_GRAY);
			initComponents();
			//quickSearchArray = BottomPanel.getInstance().playlist.getSelectedValues();;
		}

		private void initComponents(){
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			backButton = new JButton("<");

			trackSelection = new JLabel();
			Dimension labelSize = new Dimension(200,50);
			trackSelection.setPreferredSize(labelSize);
			trackSelection.setText("Next Track");
			trackSelection.setHorizontalTextPosition(JLabel.CENTER);

			forwardButton = new JButton(">");
			
			quickPlayButton = new JButton("Quick Play");
			quickPlayButton.setVisible(false);

			searchTextField = new JTextField(10);
			searchTextField.setText("Search..");
			searchTextField.setActionCommand("search");
			searchTextField.setSelectedTextColor(Color.gray);
			searchTextField.setForeground(Color.gray);
			searchTextField.setToolTipText("Search for a track, artist or album");

			searchButton = new JButton("Enter");
            searchButton.setToolTipText("Search");
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
			
			c.gridx = 4;
			c.gridy = 0;
			c.gridwidth = 1;
			this.add(quickPlayButton);

			c.gridx = 5;
			c.gridy = 0;
			c.weightx = 1;
			c.anchor = GridBagConstraints.LINE_END;
			this.add(searchTextField,c);

			c.gridx = 6;
			c.gridy = 6;
			this.add(searchButton);

			searchTextField.addMouseListener(this);			

			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					positionCount--;
					if(positionCount >=0 ){	
						trackSelection.setText(trackArray[positionCount]);
					}
					else{
						positionCount = trackArray.length;
						trackSelection.setText(trackArray[positionCount]);

					}
				}
			});

			forwardButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					positionCount++;

					if(positionCount < trackArray.length) {
						
						trackSelection.setText(trackArray[positionCount]);
						

					}else{
						positionCount = 0;
						trackSelection.setText(trackArray[positionCount]);
					}
				}
			});			
	
		}

		public void populateQuickSearch(){
					
			JList tempList = BottomPanel.getInstance().playlist;
			int size = tempList.getModel().getSize();
			
		

			if(tempList.isSelectionEmpty() !=true && size!=0){
				int point = tempList.getSelectedIndex();
				int anchor = tempList.getSelectedIndex();
				
				trackArray = new String[size];
				int arrayCount = 0;
				trackSelection.setText(tempList.getSelectedValue().toString());
			
					while(point <	size){
						tempList.setSelectedIndex(point);
						trackArray[arrayCount] = tempList.getSelectedValue().toString();
						arrayCount++;
						point++;
					}
					int i = 0;
				
					while(i< anchor){
						tempList.setSelectedIndex(i);
						trackArray[arrayCount] = tempList.getSelectedValue().toString();
						i++;
					}
				
					tempList.setSelectedIndex(anchor);	
			
			}else{
				trackSelection.setText("playlist is empty");
				
			}
		}

		public void setCollapseSearchVisible(boolean b){
				if(b){
					backButton.setVisible(true);
					trackSelection.setVisible(true);
					forwardButton.setVisible(true);
					quickPlayButton.setVisible(true);
					
					searchTextField.setVisible(false);
					searchButton.setVisible(false);
					
					populateQuickSearch();
					//quickSearchArray = BottomPanel.getInstance().getPlaylistArray();
					//trackSelection.setText(quickSearchArray[0].toString());  

				}else{
					backButton.setVisible(false);
					trackSelection.setVisible(false);
					forwardButton.setVisible(false);
					quickPlayButton.setVisible(false);
			
					searchTextField.setVisible(true);
					searchButton.setVisible(true);
				}
		}

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
          searchTextField.setText("Search");

    }

    public void mouseEntered(MouseEvent e) {
          searchTextField.setText("");

    }

    public void mouseExited(MouseEvent e) {
          searchTextField.setText("Search");

    }

    public void mouseClicked(MouseEvent e) {
          searchTextField.setText("");

    }
}
