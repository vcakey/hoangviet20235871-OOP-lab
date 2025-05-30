package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.manager.update.AddDigitalVideoDiscToStoreScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            playButton.addActionListener(new TFPlayListener());
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private class TFPlayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
        	if (media instanceof DigitalVideoDisc) {
        		DigitalVideoDisc dvd = (DigitalVideoDisc) media;
        		JOptionPane.showMessageDialog(null, "Title: " + dvd.getTitle() + "\nDirector: " + dvd.getDirector() + "\nLength: " + dvd.getLength() + " min", "Playing...", JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		CompactDisc cd = (CompactDisc) media;
        		int count = cd.getTracks().size();
        		String noti = "Title: " + cd.getTitle() + "\nDirector: " + cd.getDirector() + "\nArtist: " + cd.getArtist()+ "\nNumber of tracks: " + count + "\nList of tracks:";
        		for (Track track : cd.getTracks()) {
        			noti = noti + "\n+ " + track.getTitle() + " - " + track.getLength() + " min";
        		}
        		JOptionPane.showMessageDialog(null, noti, "Playing...", JOptionPane.INFORMATION_MESSAGE);
        	}
        }
    }
}