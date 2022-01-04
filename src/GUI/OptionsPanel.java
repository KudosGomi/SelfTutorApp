package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements ActionListener {

	private JButton notesBtn;
	public JButton dictionaryBtn;
	private JButton problemsBtn;
	private JButton subjectsBtn;
//	private JButton settingsBtn;
//	private JComboBox<String> tabs;
	
//	private DictionaryBtnListener dictionaryBtnPressed;
	
	public OptionsPanel(MainFrame mainFrame) {
		Dimension btnDims = new Dimension(180, 40);
		setLayout(new FlowLayout());
		
		problemsBtn = new JButton("Problems");
		problemsBtn.setPreferredSize(btnDims);
		dictionaryBtn = new JButton("Dictionary");
		dictionaryBtn.addActionListener(this);
		dictionaryBtn.setPreferredSize(btnDims);
		notesBtn = new JButton("Notes");
		notesBtn.setPreferredSize(btnDims);
		subjectsBtn = new JButton("Subjects");
		subjectsBtn.setPreferredSize(btnDims);
//		settingsBtn = new JButton("Settings");
//		settingsBtn.setPreferredSize(btnDims);
//		tabs = new JComboBox<String>();
//		tabs.setPreferredSize(btnDims);
//		tabs.addItem("Notes");
//		tabs.addItem("Settings");
//		tabs.addItem("Add New Tab");
		
		/*
		 * Move to main frame
		 */
		mainFrame.addComponentListener(new ComponentAdapter() {  
			public void componentResized(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				if(c.getWidth() <= 850 && c.getWidth() >= 750)
				{
				}
				else if(c.getWidth() >= 976)
				{
				}
//				System.out.println(c.getSize());
			}
		});
		
		add(notesBtn);
		add(dictionaryBtn);
		add(problemsBtn);
		add(subjectsBtn);
//		add(settingsBtn);
		
	}
	
//	public void changePanels(DictionaryBtnListener btnListener) {
//		this.dictionaryBtnPressed = btnListener;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton panelBtns = (JButton) e.getSource();
		
		if(panelBtns == problemsBtn)
		{
			
		}
		else if(panelBtns == dictionaryBtn)
		{
			new DictionaryFrame();
		}
	}
	
}
