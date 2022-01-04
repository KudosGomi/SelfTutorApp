package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoginFrame extends JFrame {

	private JPanel mainPanel;
	private JTextArea firsTimeMsgTextArea; 
	private JScrollPane jScrollPane;
//	private boolean firstTimeUse = false;
	private JTextField passwordTextField;
	public JButton enterBtn;

	public LoginFrame( ) { 

		super("Login");
		setLayout(new BorderLayout());
		setVisible(true);
//		setSize(screenSize.width,screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(750, 470));
		setLocation(100, 150);

		mainPanel = new JPanel();
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(217, 159, 49));
		
		// Set Prompt Message
//		firstTimeUse = false;
		
		JLabel welcomeLabel = new JLabel("   Welcome Ignoramus Fool!");
		welcomeLabel.setForeground(new Color(132, 13, 217));
		welcomeLabel.setFont(new Font("Chalkduster", Font.PLAIN, 13));
		welcomeLabel.setBounds(30, 50, 300, 40);
		welcomeLabel.setBorder(BorderFactory.createEtchedBorder());
		
		// Set "Question" Method 
		// First Time Greetings: Welcome Message 
		firsTimeMsgTextArea = new JTextArea();
		InputStream in = getClass().getResourceAsStream("content.txt");
		try {
			firsTimeMsgTextArea.read(new InputStreamReader(in), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		firsTimeMsgTextArea.setBounds(27, 145, 700, 170);
		firsTimeMsgTextArea.setColumns(20);
		firsTimeMsgTextArea.setLineWrap(true);
		firsTimeMsgTextArea.setRows(5);
		firsTimeMsgTextArea.setWrapStyleWord(true);
		firsTimeMsgTextArea.setEditable(false);
		firsTimeMsgTextArea.setBackground(new Color(213, 147, 41));
		firsTimeMsgTextArea.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 18));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		firsTimeMsgTextArea.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
//		firsTimeMsgTextArea.setBorder(BorderFactory.createEtchedBorder());
		
		passwordTextField = new JTextField(); // 40
		passwordTextField.setText("Enter Answer");
		passwordTextField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTextField.setBounds(320, 350, 370, 45);
//		passwordTextField.setFont(new Font("Times New Roman", Font.PLAIN, size));
		
		enterBtn = new JButton("Enter");
		enterBtn.setBounds(100, 362, 100, 20);
		this.getRootPane().setDefaultButton(enterBtn);
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordTextField.getText().equalsIgnoreCase("ok"))
				{
					dispose();
					new MainFrame();
				}
//				else if(!passwordTextField.getText().equals(usrPassword))
//				{
//					
//				}
				if(passwordTextField.getText().isEmpty())
				{
//					passwordTextField.setForeground(Color.LIGHT_GRAY);
					passwordTextField.setText("Enter Answer");
				}
//				else if(!passwordTextField.getText().isEmpty())
//				{
//					passwordTextField.setForeground(Color.BLACK);
////					passwordTextField.setText("Enter Answer");
//				}
			}
		});
		
		mainPanel.add(welcomeLabel);
		mainPanel.add(firsTimeMsgTextArea);
		mainPanel.add(passwordTextField);
		mainPanel.add(enterBtn);
		passwordTextField.requestFocusInWindow();

	}
}