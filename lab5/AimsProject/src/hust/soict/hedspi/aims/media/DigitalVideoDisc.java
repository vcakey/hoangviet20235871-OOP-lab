package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director = director;
		this.length = length;
	}

   
   public String toString() {
       return "DVD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost + " $";
   }
    
    public boolean isMatch(String title) {
    	if (this.title.equals(title) == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	public void play() {
	    System.out.println("Playing DVD: " + this.getTitle());
	    System.out.println("DVD length: " + this.getLength());
	}
}