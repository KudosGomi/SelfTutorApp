package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogPreferencePanel extends JDialog {
	
	private JPanel mainPanel;
	private PreferenceSideMenuTablePanel preferenceSideMenuTablePanel;
	private PreferenceBottomPanel preferenceBottomPanel;
	private PreferenceInfoLayoutPanel preferenceInfoPanel;
	
	public DialogPreferencePanel(MainFrame mainFrame) {
		setTitle("Preferences");
		setSize(new Dimension(500, 400));
		setMinimumSize(new Dimension(500, 400));
		setLocationRelativeTo(mainFrame);
		setLayout(new BorderLayout());
		setAlwaysOnTop(true);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.LIGHT_GRAY);
		add(mainPanel, BorderLayout.CENTER);
		
		mainPanel.add(createSideMenuPanel(), BorderLayout.WEST);
		mainPanel.add(createInfoPanel(), BorderLayout.CENTER);
		mainPanel.add(createBottomPanel(), BorderLayout.SOUTH);

		pack();
		setModal(true);
		setVisible(true);
		
	}

	public JPanel createSideMenuPanel() {
		preferenceSideMenuTablePanel = new PreferenceSideMenuTablePanel();
		return preferenceSideMenuTablePanel;
	}
	
	public JPanel createInfoPanel() {
		preferenceInfoPanel = new PreferenceInfoLayoutPanel();
		return preferenceInfoPanel;
	}
	
	public JPanel createBottomPanel() {
		preferenceBottomPanel = new PreferenceBottomPanel(this);
		return preferenceBottomPanel;
	}
}
