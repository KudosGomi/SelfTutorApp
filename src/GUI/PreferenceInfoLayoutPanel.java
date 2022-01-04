package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PreferenceInfoLayoutPanel extends JPanel {
	
	private JPanel titlePanel;
	private JLabel title;
	private GeneralPanel generalPanel;
	private PreferenceSideMenuTablePanel preferenceSideMenuTablePanel;
//	private LoginQuestionPromtPanel loginQuestionPromtPanel;
	
	public PreferenceInfoLayoutPanel() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
//		setBorder(BorderFactory.createEtchedBorder());
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		titlePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, -2, 0, -2), 
//	            BorderFactory.createEtchedBorder()));
		titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		title = new JLabel("General");
		titlePanel.add(title);
		
		add(titlePanel, BorderLayout.NORTH);
		add(createGeneralPanel(), BorderLayout.CENTER);
		
	}
	
	public JPanel createGeneralPanel() {
		generalPanel = new GeneralPanel();
		return generalPanel;
	}

}
