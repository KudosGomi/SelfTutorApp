package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.nio.ByteOrder;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FeaturesPanel  extends JPanel {

	private WordOfTheHourPanel wordHourPanel;
	private CalendarPanel calendarPanel;
	private AlertsPanel alertPanel;
	
	public FeaturesPanel(MainFrame mainFrame) {
//		Dimension dim = getPreferredSize();
//		dim.width = (int) (mainFrame.screenSize.getWidth() / 9); // (int) (mainFrame.screenSize.getWidth() / 4);
//		setPreferredSize(dim);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder());
		
		wordHourPanel = new WordOfTheHourPanel(mainFrame);
		calendarPanel = new CalendarPanel(mainFrame);
		alertPanel = new AlertsPanel(mainFrame);
		add(wordHourPanel, BorderLayout.NORTH);
		add(calendarPanel, BorderLayout.CENTER);
		add(alertPanel, BorderLayout.SOUTH);
		
	}
	
}
