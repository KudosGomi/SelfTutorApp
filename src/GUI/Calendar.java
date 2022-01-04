package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Calendar extends JPanel {

	private JPanel northPanel;
	
	private GregorianCalendar cal;

	private JLabel monthLbl, yearLbl;
	private JButton btnPrev, btnNext;
	private JTable calendar;
	private DefaultTableModel defaultCalendar;
	private CalendarTableModel tableModel;
	private int realYear, realMonth, realDay, currentYear, currentMonth;
	//	private JComboBox cmbYear;

	public Calendar() {
		//		Dimension dim = getPreferredSize();
		//		dim.width = -22;
		//		dim.height = 80;
		//		setPreferredSize(dim);

		setLayout(new BorderLayout());
		//setBorder(BorderFactory.createEtchedBorder());

		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}

		cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;

		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		northPanel = new JPanel(new GridBagLayout());
//		tableModel = new CalendarTableModel(cal);
		defaultCalendar = new DefaultTableModel(null, days);
		calendar = new JTable(defaultCalendar);
		JScrollPane pane = new JScrollPane(calendar);
		monthLbl = new JLabel ("January");
		yearLbl = new JLabel ("Change year:");
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
		add(northPanel, BorderLayout.NORTH);
		add(calendar, BorderLayout.CENTER);
//		calendar.setSize(new Dimension(this.getWidth(), this.getHeight()));
		
	    btnPrev.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        cal.add(cal.MONTH, -1);
	        updateMonth();
	      }
	    });
	 
	    btnNext.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent ae) {
	        cal.add(cal.MONTH, +1);
	        updateMonth();
	      }
	    });

		GridBagConstraints gc = new GridBagConstraints();
		///////// LEFT/BTNPREV ///////////
		gc.weighty = 0;
		gc.weightx = 0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		northPanel.add(btnPrev, gc);
		/////// CENTER/MONTH ////////////
		gc.weighty = 0;
		gc.weightx = 1;
		gc.gridy = 0;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.CENTER;
		northPanel.add(monthLbl, gc);
		//////// RIGHT/BTNNEXT //////////
		gc.weighty = 0;
		gc.weightx = 0;
		gc.gridy = 0;
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.CENTER;
		northPanel.add(btnNext, gc);

		this.updateMonth();
		
//		for (int i = 0; i < 7; i++){
//			defaultCalendar.addColumn(days[i]);
//		}
//
		calendar.getParent().setBackground(calendar.getBackground());
		calendar.setColumnSelectionAllowed(true);
		calendar.setRowSelectionAllowed(true);
//		calendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//		calendar.setRowHeight(38);
//		defaultCalendar.setColumnCount(7);
//		defaultCalendar.setRowCount(6);
//
//		refreshCalendar(realMonth, realYear);
//
//	}
//
//	public void refreshCalendar(int month, int year){
//		//Variables
//		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
//		int nod, som; //Number Of Days, Start Of Month
//
//		//Allow/disallow buttons
//		btnPrev.setEnabled(true);
//		btnNext.setEnabled(true);
//		if (month == 0 && year <= realYear - 10){btnPrev.setEnabled(false);} //Too early
//		if (month == 11 && year >= realYear + 100){btnNext.setEnabled(false);} //Too late
//		monthLbl.setText(months[month]); //Refresh the month label (at the top)
//		monthLbl.setBounds(160 - monthLbl.getPreferredSize().width / 2, 25, 180, 25); //Re-align label with calendar
//		//        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
//
//		//Clear table
//		for (int i = 0; i < 6; i++){
//			for (int j = 0; j < 7; j++){
////				calendar.setValueAt(null, i, j);
//			}
//		}
//
//		//Get first day of month and number of days
//		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
//		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
//		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
//
//		//Draw calendar
//		for (int i = 1; i <= nod; i++){
//			int row = new Integer((i + som - 2) / 7);
//			int column  =  (i + som - 2) % 7;
////			calendar.setValueAt(i, row, column);
//		}
//
//		//Apply renderers
//		calendar.setDefaultRenderer(calendar.getColumnClass(0), new tblCalendarRenderer());
//	}
//
//	class tblCalendarRenderer extends DefaultTableCellRenderer{
//		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
//			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
//			if(column == 0 || column == 6) // Week-end
//			{ 
//				setBackground(new Color(255, 220, 220));
//			}
//			else // Week
//			{ 
//				setBackground(new Color(255, 255, 255));
//			}
//			if(value != null)
//			{
//				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear) 
//				{ //Today
//					setBackground(new Color(220, 220, 255));
//				}
//			}
//			setBorder(null);
//			setForeground(Color.black);
//			return this;
//		}
	}
	
	public void updateMonth() {
		
	    cal.set(cal.DAY_OF_MONTH, 1);
	 
	    String month = cal.getDisplayName(cal.MONTH, cal.LONG, Locale.US);
	    int year = cal.get(cal.YEAR);
	    monthLbl.setText(month + " " + year);
	 
	    int startDay = cal.get(cal.DAY_OF_WEEK);
	    int numberOfDays = cal.getActualMaximum(cal.DAY_OF_MONTH);
	    int weeks = cal.getActualMaximum(cal.WEEK_OF_MONTH);
	 
	    defaultCalendar.setRowCount(0);
	    defaultCalendar.setRowCount(weeks);
	 
	    int i = startDay - 1;
	    for(int day = 1; day <= numberOfDays; day++)
	    {
	    	defaultCalendar.setValueAt(day, i / 7, i % 7);    
	    	i = i + 1;
	    }
	 
	  }
	
}
