package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
	    Cart anOrder = new Cart();
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	    anOrder.addMedia(dvd1);
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	    anOrder.addMedia(dvd2);
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
	    anOrder.addMedia(dvd3);
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 123, 26.7f);
	    anOrder.addMedia(dvd4);
	    anOrder.print();
	    anOrder.search(1);
	    anOrder.search(3);
	    anOrder.search(10);
	    anOrder.search("Star Wars");
	    anOrder.search("Harry Potter");
	}
}