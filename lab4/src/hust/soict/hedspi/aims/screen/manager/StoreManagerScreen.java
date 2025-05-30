package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.manager.update.AddBookToStoreScreen;
import hust.soict.hedspi.aims.screen.manager.update.AddCompactDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.manager.update.AddDigitalVideoDiscToStoreScreen;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	
	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    north.add(createHeader());
	    return north;
	}
	
	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");
	    menu.add(new JMenuItem("View store"));

	    JMenu smUpdateStore = new JMenu("Update Store");
	    
	    JMenuItem bookOption = new JMenuItem("Add Book");
	    smUpdateStore.add(bookOption);
	    bookOption.addActionListener(new TFBookListener());
	    
	    JMenuItem CDOption = new JMenuItem("Add CD");
	    smUpdateStore.add(CDOption);
	    CDOption.addActionListener(new TFCDListener());
	    
	    JMenuItem DVDOption = new JMenuItem("Add DVD");
	    smUpdateStore.add(DVDOption);
	    DVDOption.addActionListener(new TFDVDListener());
	    
	    menu.add(smUpdateStore);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}
	
	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}
	
	JPanel createCenter() {
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }

	    return center;
	}
	
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class TFBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	dispose();
        	new AddBookToStoreScreen(store);
        }
    }
    
    private class TFCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	dispose();
        	new AddCompactDiscToStoreScreen(store);
        }
    }
    
    private class TFDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	dispose();
        	new AddDigitalVideoDiscToStoreScreen(store);
        }
    }
    
    public static void main(String[] args) {
		Store store = new Store();
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
        new StoreManagerScreen(store);
    }

}
 