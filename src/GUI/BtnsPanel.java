package GUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class BtnsPanel extends JPanel {
	
	private JButton prevBtn;
	private JButton nextBtn;
	private JLabel monthLbl;
	private CalendarPanel calendarPanel;
	
	public BtnsPanel(CalendarPanel calendarPanel) {
		
		super(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		this.calendarPanel = calendarPanel;
		
		prevBtn = new JButton("<<");
		nextBtn = new JButton(">>");
		monthLbl = new JLabel(calendarPanel.month + " " + calendarPanel.year);
		
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarPanel.cal.add(Calendar.MONTH, -1);
		        updateMonth();
			}
		});
		
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarPanel.cal.add(Calendar.MONTH, +1);
		        updateMonth();
			}
		});
		
		///////// LEFT/BTNPREV ///////////
		gc.weighty = 0;
		gc.weightx = 0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		add(prevBtn, gc);
		/////// CENTER/MONTH ////////////
		gc.weighty = 0;
		gc.weightx = 1;
		gc.gridy = 0;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		add(monthLbl, gc);
		//////// RIGHT/BTNNEXT //////////
		gc.weighty = 0;
		gc.weightx = 0;
		gc.gridy = 0;
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.CENTER;
		add(nextBtn, gc);
		
	}
	
	public void updateMonth() {

		calendarPanel.cal.set(Calendar.DAY_OF_MONTH, 1);

		String month = calendarPanel.cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = calendarPanel.cal.get(Calendar.YEAR);
		int startDay = calendarPanel.cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = calendarPanel.cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = calendarPanel.cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		monthLbl.setText(month + " " + year);
		calendarPanel.calendarTableModel.days = new String[weeks][numberOfDays];
		
		int row = 0, col = 0;
		for(int i = 1; i <= numberOfDays; i++){
			row = (i + startDay - 2) / 7;
			col = (i + startDay - 2) % 7;
			calendarPanel.calendarTableModel.days[row][col] = i + "";
		}
		
		calendarPanel.calendarTableModel.fireTableDataChanged();
		
	}

}
