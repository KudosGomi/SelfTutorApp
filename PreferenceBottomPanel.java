package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PreferenceBottomPanel extends JPanel {
	
//	private PreferenceFrame preferenceFrame;
	private DialogPreferencePanel dialogPreferencePanel;
	private JButton applyAndCloseBtn;
	private JButton cancelBtn;
	
//	public PreferenceBottomPanel(PreferenceFrame preferenceFrame) {
	public PreferenceBottomPanel(DialogPreferencePanel dialogPreferencePanel) {
//		this.preferenceFrame = preferenceFrame;
		this.dialogPreferencePanel = dialogPreferencePanel;
		setLayout(new FlowLayout(FlowLayout.RIGHT));
//		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
//		setBorder(BorderFactory.createEtchedBorder());
//		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(-1, 0, -1, -1), 
//	            BorderFactory.createEtchedBorder()));
		
		cancelBtn = new JButton("Cancel");
		applyAndCloseBtn = new JButton("Apply and Close");
		applyAndCloseBtn.setSelected(true);
//		preferenceFrame.getRootPane().setDefaultButton(applyAndCloseBtn);
		dialogPreferencePanel.getRootPane().setDefaultButton(applyAndCloseBtn);
		applyAndCloseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				preferenceFrame.dispose();
				dialogPreferencePanel.dispose();
			}
		});
		add(cancelBtn);
		add(applyAndCloseBtn);
		applyAndCloseBtn.requestFocusInWindow();
	}

}
