package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private static final int MAX_ITEMS = 100;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
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
    
    public void addMedia(Media media) throws IllegalArgumentException, IllegalStateException {
        if (media == null) {
            throw new IllegalArgumentException("Cannot add null media to cart.");
        }

        if (itemsOrdered.contains(media)) {
            throw new IllegalArgumentException("The item \"" + media.getTitle() + "\" already exists in the cart.");
        }

        if (itemsOrdered.size() >= MAX_ITEMS) {
            throw new IllegalStateException("Cannot add more items. The cart has reached its maximum capacity of " + MAX_ITEMS + " items.");
        }

        itemsOrdered.add(media);
        System.out.println("The item \"" + media.getTitle() + "\" has been added to the cart.");
    }
    
    public void removeMedia(Media media) throws NoSuchElementException {
        if (media == null) {
            throw new IllegalArgumentException("Cannot remove null media from cart.");
        }

        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            throw new NoSuchElementException("The item \"" + media.getTitle() + "\" doesn't exist in the cart.");
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
    
    public void search(String mediaTitle) {
        if (mediaTitle == null) {
            System.out.println("Title cannot be null.");
            return;
        }

        boolean found = false;
        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (mediaTitle.equals(media.getTitle())) {
                System.out.println("Item with title \"" + mediaTitle + "\" has been found:");
                System.out.println(media);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item with title \"" + mediaTitle + "\" doesn't exist.");
        }
    }
    
    public int size() {
    	return itemsOrdered.size();
    }
    
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
    public Media searchAndReturn(String mediaTitle) {
        if (mediaTitle == null) {
            return null;
        }

        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (mediaTitle.equals(media.getTitle())) {
                return media;
            }
        }

        return null;
    }
    
    public void clearCart() {
    	itemsOrdered.clear();
    }
   
}