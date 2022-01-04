package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AlertsPanel extends JPanel {

	private JButton setAlertsBtn;
	
	public AlertsPanel(MainFrame mainFrame) {
//		Dimension dim = getPreferredSize();
//		dim.height = 70;
//		setPreferredSize(dim);
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(1, 1));
		setBorder(BorderFactory.createEtchedBorder());
		
		
		setAlertsBtn = new JButton("Set Alerts");
//		Font alertFont = new Font("MS PGothic", Font.ITALIC, 40);
		setAlertsBtn.setFont(new Font("MS PGothic", Font.ITALIC, 40));
		add(setAlertsBtn);
		
		/*
		 * Move to main frame 
		 */
//		mainFrame.addComponentListener(new ComponentAdapter() {  
//			public void componentResized(ComponentEvent evt) {
//				Component c = (Component) evt.getSource();
//				fontSize = c.getWidth() / 33;
//				setAlertsBtn.setFont(new Font("MS PGothic", Font.ITALIC, fontSize - (int)(0.2)));
//			}
//		});
		
	}
	
}
