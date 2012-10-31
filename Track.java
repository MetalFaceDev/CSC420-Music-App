//

public class Track{

	String artist;
	String title;
	String album;
	int totalTime; //To be changed to clock time
	int currentTime; //To be changed to clock time 

	int fBLikes; //counter for "Likes" recieved from facebook

	//Constructor for track with only one attribute
	//Assigns attribute to title by default
	public Track(String title){
		this.title = title;

	}

	

	//Constructor for track with a track artist and a title
	public Track(String artist, String title){
			this.artist = artist;
			this.title = title;
			//To be referenced to a music file
	}

	public void setAttributes(){
		//Allow other attributes to be set
	}

	public void addLike(){
		//Recieves information from facebook and adds fBLikes counter 

	}

	public String timeToString(){
		String minutes, seconds, stringTime = 0;
		minutes = currentTime / 60;
		seconds = currentTime % 60;
		stringTime = minutes + ":" + seconds;
		return stringTime;
		
	}

}

/*
this Track class will be updated to work with the 
Java sounds api 
*/
