package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class book extends Media{

	private List<String> authors = new ArrayList<String>();

	public book(String title) {
		super(title);
	}
	
	public book(String title, String category, float cost) {
		super(title,category,cost);
	}
	
	public void addAuthor(String authorName) {
	    if (!authors.contains(authorName)) {
	        authors.add(authorName);
	    } else {
	        System.out.println("Author '" + authorName + "' already exists.");
	    }
	}

	public void removeAuthor(String authorName) {
	    if (authors.contains(authorName)) {
	        authors.remove(authorName);
	    } else {
	        System.out.println("Author '" + authorName + "' doesn't exist.");
	    }
	}
	
	 @Override
	 public String toString() {
	     return "Book - " + this.id + " - " + this.title + " - " + this.category + " - " + this.authors + ": " + this.cost + " $";
	 }


}