import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TagPanel extends JPanel{
	
	Tag[] tags = new Tag[11];	
	
	boolean clear = true;

	int xPosition;
	int yPosition = 0;
	String tagNumber;

	public TagPanel(){
		super();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!clear){
			g.setColor(Color.BLACK);
			
		for(int i = 0; i<tags.length; i++){
			if(tags[i] != null){
				g.drawRect(tags[i].xPosition, 0, 8,8);
				g.drawString(tags[i].value,tags[i].xPosition,0);
			}
		}
	
		}else{
			//draw a blank panel
		}

	}

	public void addTag(int time, int position){
		
		for(int i = 0; i<tags.length; i++){
			if(tags[i] == null){
				Tag tag = new Tag(i+1,time);
				tag.slidePosition = position;
				double temp = (double)position;
				temp = temp *.01;
				System.out.println(temp);	
				tag.xPosition = (int)(this.getWidth() * temp) -3;
				System.out.println(tag.xPosition);
				Integer tempInt = new Integer(i);
				tag.value = tempInt.toString();
				tags[i] = tag;
				
				xPosition = time;
				break;
			}
	
		}

		drawTag();
	}

	public void removeTag(int tagNumber){
		tags[tagNumber - 1] = null;
	}

	public void calcPosition(){
		
	}

	public void clearTags(){
		clear = true;
		this.repaint();
		
	}
	
	public void drawTag(){
		clear = false;	
		repaint();	
	}


}
