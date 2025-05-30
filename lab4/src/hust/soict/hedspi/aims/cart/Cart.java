package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public Cart() {
    }
	public float totalCost() {
		float sum = 0;
		for (Media media: itemsOrdered) {
			sum = sum + media.getCost();
		}
		return sum;
	}
    public void displayCart() {
        for (Media media: itemsOrdered) {
            System.out.printf(media.getTitle() + " : " + media.getCost() + "\n");
        }
        System.out.printf("Total Cost: " + totalCost() + "\n");
    }
    public void addMedia(Media media) {
    	if (itemsOrdered.contains(media)) {
    		System.out.println("The item " + media.getTitle() + " already exists.");
    	} else {
        	itemsOrdered.add(media);
        	System.out.println("The item " + media.getTitle() + " has been added to the cart.");
    	}
    }
	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println("The item " + media.getTitle() + " has been removed from the cart.");
	    } else {
	        System.out.println("The item " + media.getTitle() + " doesn't exist.");
	    }
	}

    public void print() {
    	System.out.printf("***********************CART***********************\n");
    	System.out.printf("Ordered Items:\n");
    	for (Media media: itemsOrdered) { 
    		System.out.println(media);
    	}
    	System.out.printf("**************************************************\n");
    }
    public void search(int mediaid) {
    	for (Media media: itemsOrdered) { 
    		if (media.getId() == mediaid) {
    			System.out.printf("Item with id " + mediaid + " has been found:\n");
    			System.out.println(media);
    			return;
    		}
    	}
    	System.out.printf("Item with id " + mediaid + " doesn't exist.\n");
    }
    public void search(String mediatitle) {
    	boolean found = false;
        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equals(mediatitle)) {
            	System.out.printf("Item with title " + mediatitle + " has been found:\n");
            	System.out.println(media);
            	found = true;
            }
        }
    	if (found == false) {
    		System.out.printf("Item with title " + mediatitle + " doesn't exist.\n");
    	}
    }
    public int size() {
    	return itemsOrdered.size();
    }
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
    public Media searchAndReturn(String mediatitle) {
        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equals(mediatitle)) {
            	return media;
            }
        }
        return null;
    }
    
    public void clearCart() {
    	itemsOrdered.clear();
    }
   
}