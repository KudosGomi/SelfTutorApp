package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class CalendarTablePanel extends JPanel {
	
	private JTable calTable;
	
	public CalendarTablePanel() {
		setLayout(new BorderLayout());
		String col[] = {"Yoo"};
		Object menuOptions[][] = {
				{"General"},
				{"Login Question Prompt"},
				{"New File Settings"},
				{"Another One"}
		};
		calTable = new JTable(menuOptions, col);
		calTable.setPreferredScrollableViewportSize(new Dimension(270, 370));
		calTable.setFillsViewportHeight(true);
//		table.row
//		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		calTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		add(calTable, BorderLayout.CENTER);
//		Border border = BorderFactory.createEmptyBorder();
//		table.setBorder(BorderFactory.createCompoundBorder(border, 
//		            BorderFactory.createEmptyBorder(100, 100, 100, 100)));
	}

}

class MyTableModel extends AbstractTableModel {
//	private String colNames[] = {"No","ok"};
	private Object menuOptions[][] = {
			{" "},
			{"General"},
			{"Login Question Prompt"},
			{"New File Settings"},
			{"Another One"}
	};
	
	public int getRowCount() {
		return menuOptions.length;
	}

	public int getColumnCount() {
		return 1;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return menuOptions[rowIndex][columnIndex];
	}
	
}