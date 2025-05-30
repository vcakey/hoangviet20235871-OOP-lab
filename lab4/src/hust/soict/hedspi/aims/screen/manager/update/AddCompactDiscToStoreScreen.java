package hust.soict.hedspi.aims.screen.manager.update;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTitle, tfCategory, tfDirector, tfArtist, tfCost, tfCount;
	private List<Track> trackList = new ArrayList<Track>();
	private JButton buttonAdd;
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}

    @Override
    
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 20, 20));
        center.setBorder(BorderFactory.createTitledBorder("CD's Information"));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        center.add(tfCategory);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        center.add(tfDirector);

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        center.add(tfArtist);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        center.add(tfCost);
        
        center.add(new JLabel("Number of tracks:"));
        tfCount = new JTextField(20);
        center.add(tfCount);
        
        center.add(new JLabel("Make sure to enter number of tracks before adding tracks!"));
        
        buttonAdd = new JButton("Add Tracks");
        center.add(buttonAdd);
        buttonAdd.addActionListener(new TFAddListener());
        
		return center;
    }
    
    private class TFAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	int count = 0;
        	try {
        		count = Integer.parseInt(tfCount.getText());
        	} catch (NumberFormatException e) {
        		JOptionPane.showMessageDialog(null, "Invalid number of tracks!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        	}
        	for (int i = 0; i < count; i++) {
				String title = JOptionPane.showInputDialog("Enter title of track " + (i + 1) + ":");
				int length = Integer.parseInt(JOptionPane.showInputDialog("Enter length of track " + (i + 1) + ":"));
				Track track = new Track(title, length);
        		trackList.add(track);
        	}
        }
    }
    
    protected Media createMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        String artist = tfArtist.getText();
        float cost = Float.parseFloat(tfCost.getText());
        CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
        cd.setTracks(trackList);
        return cd;
    }

}