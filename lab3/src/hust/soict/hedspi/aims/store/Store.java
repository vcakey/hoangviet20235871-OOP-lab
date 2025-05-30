package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public Store() {
	}
    public void addMedia(Media media) {
    	itemsInStore.add(media);
    	System.out.println("The item " + media.getTitle() + " has been added to the store.");
    }
	public void removeMedia(Media media) {
	    if (itemsInStore.contains(media)) {
	        itemsInStore.remove(media);
	        System.out.println("The item " + media.getTitle() + " has been removed from the store.");
	    } else {
	        System.out.println("The item " + media.getTitle() + " doesn't exist.");
	    }
	}
    public void print() {
    	System.out.printf("---------------------STORE---------------------\n");
    	System.out.printf("Items in store:\n");
    	for (Media media: itemsInStore) { 
    		System.out.println(media);
    	}
    	System.out.printf("-----------------------------------------------------\n");
    }
    public Media search(String mediatitle) {
        for (int i = itemsInStore.size() - 1; i >= 0; i--) {
            Media media = itemsInStore.get(i);
            if (media.getTitle().equals(mediatitle)) {
            	return media;
            }
        }
        return null;
    }
}