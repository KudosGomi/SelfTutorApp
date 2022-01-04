package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {

	private JButton btn;
	
	public ToolBar() {
		
		btn = new JButton("Button");
		add(btn);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}
	
}
