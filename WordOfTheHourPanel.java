package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordOfTheHourPanel extends JPanel {

	private JLabel word, description;
	
	public WordOfTheHourPanel(MainFrame mainFrame) {
		Dimension dim = getPreferredSize();
//		dim.width = (int) (mainFrame.screenSize.getWidth() / 3.5);
//		dim.height = (int) (mainFrame.screenSize.getHeight() / 4);
//		dim.height = (int) mainFrame.getHeight() / 5;
//		dim.height = 90;
		dim.height = mainFrame.getHeight() / 4;
//		System.out.println(dim.getHeight());
		setPreferredSize(dim);
		
		word = new JLabel("[ - WORD - ]");
		word.setFont(new Font("Serif", Font.PLAIN, 44));
		word.setForeground(new Color(251, 170, 45));
//		word.setAlignmentX(Component.CENTER_ALIGNMENT);
		description = new JLabel("Define the word here!!");
		description.setFont(new Font("Serif", Font.PLAIN, 19));
		description.setForeground(Color.WHITE);
//		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		setBorder(BorderFactory.createEtchedBorder());
		setBackground(new Color(95, 17, 215));
		setLayout(new GridBagLayout()); // BoxLayout(this, BoxLayout.Y_AXIS));
		GridBagConstraints gc = new GridBagConstraints();
		
		/////////////// First ROW ///////////////
		
		gc.weightx = 0.1;
		gc.weighty = 0;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
//		gc.insets = new Insets(0, 0, 0, 5);
		add(word, gc);
		
		////////////// Second ROW /////////////////
		
		gc.weighty = 0;
		gc.weightx = 0;
		
		gc.gridy = 1;
		gc.gridx = 0;
//		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.CENTER;
		add(description, gc);
		
		/////////////////////////////////////////
		
		mainFrame.addComponentListener(new ComponentAdapter() {  
			public void componentResized(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				dim.height = c.getHeight() / 4;
			}
		});
		
	}
	
}
