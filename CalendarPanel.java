package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class CalendarPanel extends JPanel {

	public static GregorianCalendar cal = new GregorianCalendar();
	public String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
	public int year = cal.get(Calendar.YEAR);
//	private int startDay = cal.get(Calendar.DAY_OF_WEEK);
//	private int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//	private int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	public JTable calendarTable;
	public CalendarTableModel calendarTableModel;
	private JPopupMenu popupMenu;
	private Dimension dim;
	
	public CalendarPanel(MainFrame mainFrame) {
		
		super(new BorderLayout());
		dim = getPreferredSize();
		dim.height = mainFrame.getHeight() / 4;
		setPreferredSize(dim);
		
		BtnsPanel btnsPanel = new BtnsPanel(this);
		add(btnsPanel, BorderLayout.NORTH);
		
		calendarTableModel = new CalendarTableModel(this);
		calendarTable = new JTable(calendarTableModel);
//		calendarTable.setPreferredScrollableViewportSize(new Dimension(10, 70));
		calendarTable.setFillsViewportHeight(true);
		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		calendarTable.getTableHeader().setReorderingAllowed(false);
		
		popupMenu = new JPopupMenu();
		
		JMenuItem addEvent = new JMenuItem("Add Event");
		popupMenu.add(addEvent);
		
		calendarTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
//				int row = calendarTable.rowAtPoint(e.getPoint());
//				int col = calendarTable.columnAtPoint(e.getPoint());
//				int row = calendarTable.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), calendarTable));
//				calendarTable.getSelectionModel().setSelectionInterval(col, col);
//				System.out.println("Col: " + col + " Row: " + row);
				if(e.getButton() == MouseEvent.BUTTON3) 
				{
					popupMenu.show(calendarTable, e.getX(), e.getY());
				}
			}
		});
		
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = calendarTable.getSelectedColumn();
				
			}
		});
		
//		JScrollPane scrollPane = new JScrollPane(calendarTable);
//	    add(scrollPane);
		add(calendarTable);
		
	    mainFrame.addComponentListener(new ComponentAdapter() {  
			public void componentResized(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				dim.height = c.getHeight() / 4;
				refresh();
			}
		});
	    
	    refresh();
	    
	}
	
	public void refresh() {
		calendarTableModel.fireTableDataChanged();
	}
	
}

class CalendarTableModel extends AbstractTableModel {
	
//	public GregorianCalendar cal = new GregorianCalendar();
	public String month = CalendarPanel.cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
//	private int year = cal.get(Calendar.YEAR);
	private int startDay = CalendarPanel.cal.get(Calendar.DAY_OF_WEEK);
	private int numOfDays = CalendarPanel.cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	private int weeks = CalendarPanel.cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	private String dayNames[] = {"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"};
//	public Object days[][] = new String[weeks][numOfDays];
	public Object days[][] = new JLabel[weeks][numOfDays];
	private CalendarPanel calendarPanel;

	
	public  CalendarTableModel(CalendarPanel calendarPanel) {
		this.calendarPanel = calendarPanel;
		int row, col;
		for (int i = 1; i <= numOfDays; i++)
		{
			row = (i + startDay - 2) / 7;
			col = (i + startDay - 2) % 7;
//			days[row][col] = i + "";
//			days[row][col] = new JLabel();
//			((JComponent) days[row][col]).setOpaque(true);
//			days[row][col] = i + "";
		}
	}
	
	public int getRowCount() {
		calendarPanel.refresh();
		return days.length;
	}

	public int getColumnCount() {
		calendarPanel.refresh();
		System.out.println(dayNames.length);
		return dayNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		calendarPanel.refresh();
		return days[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		calendarPanel.refresh();
		return dayNames[column];
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		calendarPanel.refresh();
		fireTableCellUpdated(rowIndex, columnIndex);
		days[rowIndex][columnIndex] = value;
	}
	
}