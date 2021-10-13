package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	
//	private JPanel reuseablePanel;
	private MainFrame mainFrame;
	private JTextField passwordTextField;
	public JButton enterBtn;
	private LoginListener loginListener;

	public LoginPanel(MainFrame mainFrame) { // Main Panel
		
		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		
		this.mainFrame = mainFrame;
		passwordTextField = new JTextField(10);
		passwordTextField.setText("Enter Password");
		enterBtn = new JButton("Enter");
		
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordTextField.getText().equals("a"))
				{
					mainFrame.loginPanel.setVisible(false);
					mainFrame.remove(mainFrame.loginPanel);
					mainFrame.repaint();
//					JPanel p = new JPanel();
//					p.setBackground(Color.RED);
//					mainFrame.add(p, BorderLayout.CENTER);
				}
			}
		});
		
//		passwordTextField.addKeyListener(new KeyListener() {
//			public void keyTyped(KeyEvent e) {
//			}
//			public void keyReleased(KeyEvent e) {
//			}
//			public void keyPressed(KeyEvent e) {
////				String text = passwordTextField.getText();
//				boolean passwordVerification = false;
//				if(e.getKeyCode() == KeyEvent.VK_ENTER)
//				{
//					if(passwordTextField.getText().isEmpty())
//					{
//						passwordTextField.setText("Enter Password");
//					}
//					else if(passwordTextField.getText().equals("yo"))
//					{
//						passwordVerification = true;
////						System.out.println("cool");
//					}
//				}
//				LoginEvent login = new LoginEvent(this, passwordVerification);
//				if(passwordTextFieldListener != null)
//				{
//					passwordTextFieldListener.loginEventHandler(login);
//				}
//			}
//		});
		
		GridBagConstraints gc = new GridBagConstraints();
		
		/////////////// First ROW ///////////////
		
		gc.weightx = 1;
		gc.weighty = 0;
		
		gc.gridy = 0;
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(0, 0, 0, 5);
		add(passwordTextField, gc);
	
//		gc.gridy = 0;
		gc.gridx = 1;
//		gc.insets = new Insets(0, 0, 0, 0);
//		gc.anchor = GridBagConstraints.CENTER;
		add(enterBtn, gc);
		
	}
	
//	public void setLoginListener(LoginListener log) {
//		this.loginListener = log;
//	}
//	
//	public boolean checkPassword() {
//		if(passwordTextField.getText().equals("yo"))
//		{
//			return true;
//		}
//		return false;
//	}

}
