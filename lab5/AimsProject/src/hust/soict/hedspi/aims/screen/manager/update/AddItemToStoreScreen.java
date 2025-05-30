package hust.soict.hedspi.aims.screen.manager.update;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton buttonSubmit;
	protected Store store;
	
	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    return north;
	}
	
	JPanel createSouth() {
	    JPanel south = new JPanel();
	    south.setLayout(new FlowLayout(FlowLayout.CENTER));
	    
        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(new TFSubmitListener());
	    
	    south.add(buttonSubmit);
	    return south;
	}
	
	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");
	    JMenuItem backOption = new JMenuItem("View Store");
	    menu.add(backOption);
	    backOption.addActionListener(new TFReturnListener());

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);
	    return menuBar;
	}
    
    protected abstract JPanel createCenter();
	
	protected abstract Media createMedia();
    
    private class TFSubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Media newMedia = createMedia();
        	store.addMedia(newMedia);
        	JOptionPane.showMessageDialog(null, "The item " + newMedia.getTitle() + " has been added to the store!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class TFReturnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	dispose();
        	new StoreManagerScreen(store);
        }
    }
	
    public AddItemToStoreScreen(Store store) {
    	this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);

        setTitle("Add Item To Store");
        setSize(720, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}