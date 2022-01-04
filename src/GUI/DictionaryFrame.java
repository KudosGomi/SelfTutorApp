package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class DictionaryFrame extends JFrame {

	private JMenuBar menu;
	private JPanel wordsPanel;
	private JPanel wordDescriptionPanel;
	private JList<String> words;
	
	public DictionaryFrame() {
		super("Dictionary");
		setVisible(true);
		setBounds(100, 100, 900, 620);
		setLayout(new BorderLayout());
		
		String arr[] = new String[50];
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = "word" + i;
		}
		
		menu = new JMenuBar();
		JMenu fileMenu = new JMenu("Add A New Word");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		JMenu windowMenu = new JMenu("Remove A Word");
		JMenu showMenu = new JMenu("Show");
		JMenuItem showFormItem = new JMenuItem("Person Form");
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		menu.add(fileMenu);
		menu.add(windowMenu);
		add(menu, BorderLayout.NORTH);
		
		words = new JList<String>(arr);
		words.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		words.setLayoutOrientation(JList.VERTICAL);
		words.setVisibleRowCount(-1);
		
		wordsPanel = new JPanel();
		wordsPanel.setBackground(Color.LIGHT_GRAY);
		wordsPanel.setPreferredSize(new Dimension(100, this.getHeight()));
		wordsPanel.setLayout(new BorderLayout());
		add(wordsPanel, BorderLayout.WEST);
		
		wordDescriptionPanel = new JPanel();
		wordDescriptionPanel.setBackground(Color.LIGHT_GRAY);
		wordDescriptionPanel.setLayout(new BorderLayout());
		add(wordDescriptionPanel, BorderLayout.CENTER);
		
//		String aWord = words.getSelectedIndex() + "";
//		JLabel theWord = new JLabel(aWord);
//		System.out.println(aWord);
		wordDescriptionPanel.add(new JLabel(words.getSelectedValue()), BorderLayout.CENTER);
		
		wordsPanel.add(new JScrollPane(words), BorderLayout.CENTER);
	}
	
}
