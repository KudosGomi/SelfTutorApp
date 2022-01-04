package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class PreferenceSideMenuTablePanel extends JPanel {
	
	public JTable preferenceTable;
	private PreferenceTableModel pTM;
	
	public PreferenceSideMenuTablePanel() {
		setLayout(new BorderLayout());
		Dimension dim = getPreferredSize();
		dim.width = 170;
		setPreferredSize(dim);
		pTM = new PreferenceTableModel(this);
		preferenceTable = new JTable(pTM);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		preferenceTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		preferenceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		preferenceTable.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke("ENTER"), "none");
//		preferenceTable.setBorder(BorderFactory.createEtchedBorder());
		preferenceTable.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		preferenceTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
//	            System.out.println(preferenceTable.getValueAt(preferenceTable.getSelectedRow(), 0));
	        		if(preferenceTable.getSelectedRow() == 1)
	        		{
	        			System.out.println("1");
	        		}
	        		else if(preferenceTable.getSelectedRow() == 2) 
	        		{
	        			System.out.println("2");
	        		}
	        		else if(preferenceTable.getSelectedRow() == 3) 
	        		{
	        			System.out.println("3");
	        		}
	        }
	    });
		add(preferenceTable, BorderLayout.CENTER);
	}
	
//	public void refresh() {
//		pTM.fireTableDataChanged();
//	}

}

class PreferenceTableModel extends AbstractTableModel {
	private PreferenceSideMenuTablePanel preferenceSideMenuTablePanel;
	private String menuOptions[][] = {
			{null},
			{"General"},
			{"Login Question Prompt"},
			{"New File Settings"},
			{"Another One"}
	};
	
	public PreferenceTableModel(PreferenceSideMenuTablePanel preferenceSideMenuTablePanel) {
		this.preferenceSideMenuTablePanel = preferenceSideMenuTablePanel;
//		menuOptions[0][0].
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(rowIndex == 0 && columnIndex == 0)
		{
			preferenceSideMenuTablePanel.preferenceTable.setFocusable(false);
			preferenceSideMenuTablePanel.preferenceTable.setRowSelectionAllowed(false);
		}
		else
		{
			preferenceSideMenuTablePanel.preferenceTable.setFocusable(true);
			preferenceSideMenuTablePanel.preferenceTable.setRowSelectionAllowed(true);

		}
		return false;
	}
	
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