import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TagPanel extends JPanel{
	
	ArrayList<Tag> tags = new ArrayList<Tag>();	
	
	boolean clear = false;

	public TagPanel(){
		super();
		setBackground(Color.WHITE);		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!clear){
			//draw a blank panel
		}else{
			//draw a blank panel
		}

	}

	public void addTag(int tagNumber, int time){
		Tag tag = new Tag(tagNumber, time);	
		tags.add(tagNumber - 1,tag);
	}

	public void removeTag(int tagNumber){
		tags.remove(tagNumber - 1);
	}

	public void clearTags(){
		clear = true;
		this.repaint();
		
	}
	
	public void drawTag(){
		

	}


}
