package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	    private static Store store;
	    private static Cart cart;

	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
	        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
	        fxmlLoader.setController(viewStoreController);
	        Parent root = fxmlLoader.load();

	        primaryStage.setTitle("Store");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        store = new Store();
	        cart = new Cart();
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	        store.addMedia(dvd1);
		    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		    store.addMedia(dvd2);
		    
		    CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "John Landis", 15.99f, "Michael Jackson");
		    
		    cd1.addTrack(new Track("Wanna Be Startin' Somethin'", 6));
		    cd1.addTrack(new Track("Baby Be Mine", 4));
		    cd1.addTrack(new Track("The Girl Is Mine", 3));
		    cd1.addTrack(new Track("Thriller", 6));
		    cd1.addTrack(new Track("Beat It", 4));
		    cd1.addTrack(new Track("Billie Jean", 5));
		    cd1.addTrack(new Track("Human Nature", 4));
		    cd1.addTrack(new Track("P.Y.T. (Pretty Young Thing)", 4));
		    cd1.addTrack(new Track("The Lady in My Life", 5));
		    
		    store.addMedia(cd1);
		    
		    CompactDisc cd2 = new CompactDisc("The Eminem Show", "Hip-Hop", "Joseph Kahn", 16.99f, "Eminem");
		    
		    cd2.addTrack(new Track("White America", 5));
		    cd2.addTrack(new Track("Cleanin' Out My Closet", 4));
		    cd2.addTrack(new Track("Without Me", 4));
		    cd2.addTrack(new Track("Sing for the Moment", 5));
		    cd2.addTrack(new Track("Superman", 5));
		    cd2.addTrack(new Track("Hailie's Song", 5));
		    cd2.addTrack(new Track("Till I Collapse", 5));
		    cd2.addTrack(new Track("My Dad's Gone Crazy", 5));

		    store.addMedia(cd2);
		    
		    book book1 = new book("To Kill a Mockingbird", "Fiction", 12.99f);
		    store.addMedia(book1);
		    book book2 = new book("1984", "Dystopian", 10.00f);
		    store.addMedia(book2);


	        launch(args);
	    }

}