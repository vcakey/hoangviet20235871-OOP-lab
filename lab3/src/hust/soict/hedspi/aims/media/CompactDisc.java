package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title) {
		super(title);
		this.tracks = new ArrayList<>();
	}
	public CompactDisc(String title, String category, float cost) {
		super(title,category,cost);
		this.tracks = new ArrayList<>();
	}
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title,category,cost);
		this.artist = artist;
		this.tracks = new ArrayList<>();
		this.director = director;
	}

	public String getArtist() {
		return artist;
	}
	
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void addTrack(Track track) {
    	if (tracks.contains(track)) {
    		System.out.println("The track " + track.getTitle() + " already exists.");
    	} else {
        	tracks.add(track);
        	System.out.println("The track " + track.getTitle() + " has been added to the disc.");
    	}
    }

	public void removeTrack(Track track) {
	    if (tracks.contains(track)) {
	        tracks.remove(track);
	        System.out.println("The track " + track.getTitle() + " has been removed from the disc.");
	    } else {
	        System.out.println("The track " + track.getTitle() + " doesn't exist.");
	    }
	}
	@Override
	public void play() {
        for (Track track : tracks) {
            track.play();
        }
	}
	@Override
	public String toString() {
	    return "CD - " + this.id + " - " + this.title + " - " + this.category + " - " + this.director + " - " + this.artist + " - " + this.length + ": " + this.cost + " $";
	}
}