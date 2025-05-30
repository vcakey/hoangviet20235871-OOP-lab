package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc("CDtest", "CategoryCD", "DirectorCD", 13.54f, "ArtistCD");
		DigitalVideoDisc dvd = new DigitalVideoDisc("DVDtest", "CategoryDVD", "DirectorDVD", 57, 20.43f);
		book book = new book("Booktest", "CategoryBook", 5.97f);

		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);

		for(Media m: mediae) {
		    System.out.println(m.toString());
		}
	}



}