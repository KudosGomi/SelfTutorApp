package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.omg.CORBA.DynamicImplementation;

public class MainFrame extends JFrame {

	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension miniFrameSize;

	private TextPanel txtPanel;
	private FeaturesPanel ftsPanel;
	private OptionsPanel optsPanel;
	public LoginPanel loginPanel;
//	private PreferenceFrame preferenceFrame;

	public MainFrame() {
		super("Self Tutor");
		setVisible(true);
		setLayout(new BorderLayout());
//		setSize(screenSize.width,screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(new Dimension(750, 470));
		miniFrameSize = new Dimension(750, 470);
		setMinimumSize(miniFrameSize);
		setLocation(100, 100);
//		pack();
//		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		txtPanel = new TextPanel(this);
		add(txtPanel, BorderLayout.WEST);
		ftsPanel = new FeaturesPanel(this);
		add(ftsPanel, BorderLayout.CENTER);
		optsPanel = new OptionsPanel(this);
		add(optsPanel, BorderLayout.SOUTH);
		
	}
	
	public JPanel getFtsPanel() {
		return ftsPanel;
	}
	
	public JPanel getTextPanel() {
		return txtPanel;
	}
	
	public Dimension getMinimumDimension() {
		return miniFrameSize;
	}
	
}
