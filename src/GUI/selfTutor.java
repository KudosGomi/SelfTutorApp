package GUI;

import javax.swing.SwingUtilities;

public class selfTutor {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
//				new LoginFrame();
			}
		});
	}
}
