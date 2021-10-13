//package GUI;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class PreferenceFrame extends JFrame {
//	
//	private MainFrame mainFrame;
//	private JPanel mainPanel;
//	private PreferenceSideMenuTablePanel preferenceSideMenuTablePanel;
//	private PreferenceBottomPanel preferenceBottomPanel;
//	private JPanel infoPanel;
//	
//	public PreferenceFrame(MainFrame mainFrame) {
//		super("Preferences");
//		this.mainFrame = mainFrame;
//		setVisible(true);
////		setResizable(false);
//		// Fix where the Preference frame appears
//		setBounds((int) (mainFrame.getX() + mainFrame.getX()), mainFrame.getY() - 21, 500, 400);
//		setLayout(new BorderLayout());
//		setAlwaysOnTop(true);
//		
//		
//		mainPanel = new JPanel(new BorderLayout());
//		mainPanel.setBackground(Color.LIGHT_GRAY);
//		add(mainPanel, BorderLayout.CENTER);
//		
//		infoPanel = new JPanel(new BorderLayout());
//		infoPanel.setBackground(Color.LIGHT_GRAY);
//		
//		mainPanel.add(createSideMenuPanel(), BorderLayout.WEST);
//		mainPanel.add(infoPanel, BorderLayout.CENTER);
//		mainPanel.add(createBottomPanel(), BorderLayout.SOUTH);
//		
//	}
//	
//	public JPanel createSideMenuPanel() {
//		preferenceSideMenuTablePanel = new PreferenceSideMenuTablePanel();
//		return preferenceSideMenuTablePanel;
//	}
//	
//	public JPanel createBottomPanel() {
//		preferenceBottomPanel = new PreferenceBottomPanel(this);
//		return preferenceBottomPanel;
//	}
//}