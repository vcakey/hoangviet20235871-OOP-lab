package hust.soict.hedspi.aims.screen.manager.update;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}

    @Override
    
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 20, 20));
        center.setBorder(BorderFactory.createTitledBorder("DVD's Information"));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField(20);
        center.add(tfLength);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        center.add(tfCost);
        
        center.add(new JLabel());
        
        center.add(new JLabel());
        
		return center;
    }
    
    protected Media createMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        float cost = Float.parseFloat(tfCost.getText());
        return new DigitalVideoDisc(title, category, director, length, cost);
    }

}