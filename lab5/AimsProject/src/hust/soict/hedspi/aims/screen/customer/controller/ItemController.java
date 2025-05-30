package hust.soict.hedspi.aims.screen.customer.controller;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
	private Media media;
    private Cart cart;
	
	public void setData(Media media) {
	    this.media = media;
	    lblTitle.setText(media.getTitle());
	    lblCost.setText(media.getCost() + " $");
	    if (media instanceof Playable) {
	        btnPlay.setVisible(true);
	    } else {
	        btnPlay.setVisible(false);
	        HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 109));
	    }
	}
	
    public void setCart(Cart cart) {
        this.cart = cart;
    }
	
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	if (media instanceof DigitalVideoDisc) {
    		DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            Alert playAlert = new Alert(Alert.AlertType.INFORMATION);
            playAlert.setTitle("Playing...");
            playAlert.setHeaderText(null);
            playAlert.setContentText("Title: " + dvd.getTitle() + "\nDirector: " + dvd.getDirector() + "\nLength: " + dvd.getLength() + " min");
            playAlert.showAndWait();
    	} else {
    		CompactDisc cd = (CompactDisc) media;
    		int count = cd.getTracks().size();
    		String noti = "Title: " + cd.getTitle() + "\nDirector: " + cd.getDirector() + "\nArtist: " + cd.getArtist()+ "\nNumber of tracks: " + count + "\nList of tracks:";
    		for (Track track : cd.getTracks()) {
    			noti = noti + "\n+ " + track.getTitle() + " - " + track.getLength() + " min";
    		}
            Alert playAlert = new Alert(Alert.AlertType.INFORMATION);
            playAlert.setTitle("Playing...");
            playAlert.setHeaderText(null);
            playAlert.setContentText(noti);
            playAlert.showAndWait();
    	}
    }
}