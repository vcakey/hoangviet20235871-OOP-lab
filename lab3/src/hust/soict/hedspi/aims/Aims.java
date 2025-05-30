package hust.soict.hedspi.aims;

import java.util.Collections;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		new Aims().originalMenuLoop();
	}
	
	public void originalMenuLoop() {
        int option0 = -1;
        while (option0 != 0) {
            showMenu();
            option0 = Integer.parseInt(scanner.nextLine());

            switch (option0) {
                case 1:
                    storeMenuLoop();
                    break;
                case 2:
                    updateStoreLoop();
                    break;
                case 3:
                    cart.print();
                    cartMenuLoop();
                    break;
                case 0:
                    System.out.println("Exited");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
	
    public void showMenu() {
        System.out.println("AIMS:");
        System.out.println("-------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    
    public void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4: ");
    }
    
    public void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
    }
    
    public void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Delete a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
    }
    
    public void addMediaMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a DVD");
        System.out.println("2. Add a CD");
        System.out.println("3. Add a Book");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3: ");
    }
    
    public void removeMediaMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Remove a DVD");
        System.out.println("2. Remove a CD");
        System.out.println("3. Remove a Book");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3: ");
    }
    
    public void cartMenu() {
        System.out.println("Options : ");
        System.out.println("-------------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    
    public void filterMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
    }
    
    public void sortMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2: ");
    }
    
    public void storeMenuLoop() {
        int option1 = -1;
        while (option1 != 0) {
            store.print();
            storeMenu();
            option1 = Integer.parseInt(scanner.nextLine());

            switch (option1) {
                case 1:
                    askMediaLoop();
                    break;
                case 2:
                    addMediaToCartLoop();
                    break;
                case 3:
                    playMediaLoop();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                	originalMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void askMediaLoop() {
    	boolean valid = false;
    	while (valid == false) {
    		System.out.println("Please enter the title:");
    		String title = scanner.nextLine();
    		Media request = store.search(title);
    		if (request == null) {
    			System.out.println("Invalid title or title doesn't exist.");
    		} else {
    			valid = true;
    			System.out.println(request.toString());
    			mediaDetailsLoop(request);
    		}
    	}
    }
    
    public void mediaDetailsLoop(Media selected) {
        int option2 = -1;
        while (option2 != 0) {
        	mediaDetailsMenu();
            option2 = Integer.parseInt(scanner.nextLine());
            
            switch (option2) {
                case 1:
                    cart.addMedia(selected);
                    break;
                case 2:
                    if (selected.getClass()==DigitalVideoDisc.class) {
                    	((DigitalVideoDisc) selected).play();
                    } else if (selected.getClass()==CompactDisc.class) {
                    	((CompactDisc) selected).play();
                    } else {
                    	System.out.println("Item can't be play.");
                    }
                    break;
                case 0:
                	storeMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void addMediaToCartLoop() {
    	boolean valid = false;
    	while (valid == false) {
    		System.out.println("Please enter the title:");
    		String title = scanner.nextLine();
    		Media request = store.search(title);
    		if (request == null) {
    			System.out.println("Invalid title or title doesn't exist.");
    		} else {
    			valid = true;
    			cart.addMedia(request);
    			System.out.println("Number of medias in cart: " + cart.size());
    		}
    	}
    }
    
    public void playMediaLoop() {
    	boolean valid = false;
    	while (valid == false) {
    		System.out.println("Please enter the title:");
    		String title = scanner.nextLine();
    		Media request = store.search(title);
    		if (request == null) {
    			System.out.println("Invalid title or title doesn't exist.");
    		} else {
    			valid = true;
                if (request.getClass()==DigitalVideoDisc.class) {
                	((DigitalVideoDisc) request).play();
                } else if (request.getClass()==CompactDisc.class) {
                	((CompactDisc) request).play();
                } else {
                	System.out.println("Item can't be play.");
                }
    		}
    	}
    }
    public void updateStoreLoop() {
        int option3 = -1;
        while (option3 != 0) {
        	updateStoreMenu();
            option3 = Integer.parseInt(scanner.nextLine());
            
            switch (option3) {
                case 1:
                    addMediaLoop();
                    break;
                case 2:
                	removeMediaLoop();
                    break;
                case 0:
                	originalMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public void addMediaLoop() {
        int option4 = -1;
        while (option4 != 0) {
        	addMediaMenu();
            option4 = Integer.parseInt(scanner.nextLine());
            
            switch (option4) {
                case 1:
                	System.out.println("Enter DVD title:");
                	String dvdTitle = scanner.nextLine();
                	System.out.println("Enter DVD category:");
                	String dvdCategory = scanner.nextLine();
                	System.out.println("Enter DVD director:");
                	String dvdDirector = scanner.nextLine();
                	System.out.println("Enter DVD length:");
                	int dvdLength = Integer.parseInt(scanner.nextLine());
                	System.out.println("Enter DVD cost:");
                	float dvdCost = Float.parseFloat(scanner.nextLine());
                	DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                	store.addMedia(dvd);
                    break;
                case 2:
                	System.out.println("Enter CD title:");
                	String cdTitle = scanner.nextLine();
                	System.out.println("Enter CD category:");
                	String cdCategory = scanner.nextLine();
                	System.out.println("Enter CD director:");
                	String cdDirector = scanner.nextLine();
                	System.out.println("Enter CD cost:");
                	float cdCost = Float.parseFloat(scanner.nextLine());
                	System.out.println("Enter CD artist:");
                	String cdArtist = scanner.nextLine();
                	CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdDirector, cdCost, cdArtist);
                	store.addMedia(cd);
                    break;
                case 3:
                	System.out.println("Enter book title:");
                	String bookTitle = scanner.nextLine();
                	System.out.println("Enter book category:");
                	String bookCategory = scanner.nextLine();
                	System.out.println("Enter book cost:");
                	float bookCost = Float.parseFloat(scanner.nextLine());
                	book book = new book(bookTitle, bookCategory, bookCost);
                	store.addMedia(book);
                    break;
                case 0:
                	updateStoreLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public void removeMediaLoop() {
        int option5 = -1;
        while (option5 != 0) {
        	removeMediaMenu();
            option5 = Integer.parseInt(scanner.nextLine());
            
            switch (option5) {
                case 1:
                	System.out.println("Enter DVD title:");
                	String dvdTitle = scanner.nextLine();
                	System.out.println("Enter DVD category:");
                	String dvdCategory = scanner.nextLine();
                	System.out.println("Enter DVD director:");
                	String dvdDirector = scanner.nextLine();
                	System.out.println("Enter DVD length:");
                	int dvdLength = Integer.parseInt(scanner.nextLine());
                	System.out.println("Enter DVD cost:");
                	float dvdCost = Float.parseFloat(scanner.nextLine());
                	DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                	store.removeMedia(dvd);
                    break;
                case 2:
                	System.out.println("Enter CD title:");
                	String cdTitle = scanner.nextLine();
                	System.out.println("Enter CD category:");
                	String cdCategory = scanner.nextLine();
                	System.out.println("Enter CD director:");
                	String cdDirector = scanner.nextLine();
                	System.out.println("Enter CD cost:");
                	float cdCost = Float.parseFloat(scanner.nextLine());
                	System.out.println("Enter CD artist:");
                	String cdArtist = scanner.nextLine();
                	CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdDirector, cdCost, cdArtist);
                	store.removeMedia(cd);
                    break;
                case 3:
                	System.out.println("Enter book title:");
                	String bookTitle = scanner.nextLine();
                	System.out.println("Enter book category:");
                	String bookCategory = scanner.nextLine();
                	System.out.println("Enter book cost:");
                	float bookCost = Float.parseFloat(scanner.nextLine());
                	book book = new book(bookTitle, bookCategory, bookCost);
                	store.removeMedia(book);
                    break;
                case 0:
                	updateStoreLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void cartMenuLoop() {
        int option6 = -1;
        while (option6 != 0) {
        	cartMenu();
            option6 = Integer.parseInt(scanner.nextLine());
            
            switch (option6) {
                case 1:
                	filterCartLoop();
                    break;
                case 2:
                	sortCartLoop();
                    break;
                case 3:
                	removeMediaCartLoop();
                    break;
                case 4:
                	playMediaCartLoop();
                    break;
                case 5:
                	System.out.println("The order has been placed.");
                	cart.clearCart();
                    break;
                case 0:
                	originalMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void filterCartLoop() {
        int option7 = -1;
        while (option7 != 0) {
        	filterMenu();
            option7 = Integer.parseInt(scanner.nextLine());
            
            switch (option7) {
                case 1:
                	System.out.println("Enter id to search:");
                	int id = Integer.parseInt(scanner.nextLine());
                	cart.search(id);
                    break;
                case 2:
                	System.out.println("Enter title to search:");
                	String title = scanner.nextLine();
                	cart.search(title);
                    break;
                case 0:
                	cartMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void sortCartLoop() {
        int option8 = -1;
        while (option8 != 0) {
        	sortMenu();
            option8 = Integer.parseInt(scanner.nextLine());
            
            switch (option8) {
                case 1:
                	Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                	System.out.println("Cart has been sorted.");
                    break;
                case 2:
                	Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                	System.out.println("Cart has been sorted.");
                    break;
                case 0:
                	cartMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void removeMediaCartLoop() {
        int option9 = -1;
        while (option9 != 0) {
        	removeMediaMenu();
            option9 = Integer.parseInt(scanner.nextLine());
            
            switch (option9) {
                case 1:
                	System.out.println("Enter DVD title:");
                	String dvdTitle = scanner.nextLine();
                	System.out.println("Enter DVD category:");
                	String dvdCategory = scanner.nextLine();
                	System.out.println("Enter DVD director:");
                	String dvdDirector = scanner.nextLine();
                	System.out.println("Enter DVD length:");
                	int dvdLength = Integer.parseInt(scanner.nextLine());
                	System.out.println("Enter DVD cost:");
                	float dvdCost = Float.parseFloat(scanner.nextLine());
                	DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                	cart.removeMedia(dvd);
                    break;
                case 2:
                	System.out.println("Enter CD title:");
                	String cdTitle = scanner.nextLine();
                	System.out.println("Enter CD category:");
                	String cdCategory = scanner.nextLine();
                	System.out.println("Enter CD director:");
                	String cdDirector = scanner.nextLine();
                	System.out.println("Enter CD cost:");
                	float cdCost = Float.parseFloat(scanner.nextLine());
                	System.out.println("Enter CD artist:");
                	String cdArtist = scanner.nextLine();
                	CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdDirector, cdCost, cdArtist);
                	cart.removeMedia(cd);
                    break;
                case 3:
                	System.out.println("Enter book title:");
                	String bookTitle = scanner.nextLine();
                	System.out.println("Enter book category:");
                	String bookCategory = scanner.nextLine();
                	System.out.println("Enter book cost:");
                	float bookCost = Float.parseFloat(scanner.nextLine());
                	book book = new book(bookTitle, bookCategory, bookCost);
                	cart.removeMedia(book);
                    break;
                case 0:
                	cartMenuLoop();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    public void playMediaCartLoop() {
    	boolean valid = false;
    	while (valid == false) {
    		System.out.println("Please enter the title:");
    		String title = scanner.nextLine();
    		Media request = cart.searchAndReturn(title);
    		if (request == null) {
    			System.out.println("Invalid title or title doesn't exist.");
    		} else {
    			valid = true;
                if (request.getClass()==DigitalVideoDisc.class) {
                	((DigitalVideoDisc) request).play();
                } else if (request.getClass()==CompactDisc.class) {
                	((CompactDisc) request).play();
                } else {
                	System.out.println("Item can't be play.");
                }
    		}
    	}
    }
}