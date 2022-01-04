package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class TextPanel extends JPanel {

	private MainFrame mainFrame;
	private JMenuBar menuBar;
	private JTextArea textArea;
	private String filePathName; 
	private Dimension dim;
	private boolean checkedFtsPanel;

	public TextPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		dim = getPreferredSize();
		dim.width = (mainFrame.getWidth()) - ((mainFrame.getWidth() / 2) - 75);
		setPreferredSize(dim);
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());	

		menuBar = new JMenuBar();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Cambria (Body)", Font.PLAIN, 18));

		createMenuBar(mainFrame);
		add(menuBar, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		mainFrame.addComponentListener(new ComponentAdapter() {  
			public void componentResized(ComponentEvent evt) {
				Component c = (Component) evt.getSource();
				dim.width = (mainFrame.getWidth()) - ((mainFrame.getWidth() / 2) - 78);
			}
		});

	}

	public void createMenuBar(MainFrame mF) {

		JMenu seflTutorMenu = new JMenu("Self Tutor");
		JMenuItem quitItem = new JMenuItem("Quit selfTutor");
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK));
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenuItem preferencesItem = new JMenuItem("Preferences...");
		preferencesItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA, ActionEvent.META_MASK));
		preferencesItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new PreferenceFrame(mF);
				new DialogPreferencePanel(mF);
			}
		});
		seflTutorMenu.add(preferencesItem);
		seflTutorMenu.addSeparator();
		seflTutorMenu.add(quitItem);
		JMenu fileMenu = new JMenu("File");
		JMenu newFileMenu = new JMenu("New");
		JMenuItem newFileItem = new JMenuItem("Java File");
//		newFileItem.setSelected(true);
		newFileItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean firstLine = textArea.getLineCount() == 1;
				if(firstLine == true && textArea.getText().isEmpty())
				{
					textArea.append("-----------------------\n");
				}
				else if(firstLine == true && !textArea.getText().isEmpty())
				{
					textArea.append("\n-----------------------\n");
				}
				else if(firstLine != true)
				{
					textArea.append("\n-----------------------\n");
				}
			}
		});
		newFileMenu.add(newFileItem);
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		exportDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK));
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser SaveAs = new JFileChooser();
				SaveAs.setApproveButtonText("Save");
				if (SaveAs.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
					return;
				}
				File fileName = new File(SaveAs.getSelectedFile() + ".txt");
				BufferedWriter outFile = null;
				try {
					outFile = new BufferedWriter(new FileWriter(fileName));
					textArea.write(outFile);

				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					if (outFile != null) {
						try {
							outFile.close();
						} catch (IOException ex) {
							System.out.println("Error Here!");
						}
					}
				}
			}
		});
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.META_MASK));
		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					String filePath = file.getAbsolutePath();
					System.out.println(filePath);
					try {
						InputStream fileInput = new FileInputStream(new File(filePath));
						textArea.read(new InputStreamReader(fileInput), null);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		fileMenu.add(newFileMenu);
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show/Hide Windows");
		JCheckBoxMenuItem showFtsItem = new JCheckBoxMenuItem("Show Features");
		showFtsItem.setSelected(true);
//		checkedFtsPanel = true;
		showFtsItem.addActionListener(new ActionListener() { // ********** NEED CORRECTIONS ********** // 
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
//				mainFrame.getFtsPanel().setVisible(menuItem.isSelected());
				final int originalWidth = (int) dim.getWidth();
				if(!menuItem.isSelected())
				{
					mainFrame.getFtsPanel().setVisible(false);
					dim.width = mainFrame.getWidth();
					mainFrame.addComponentListener(new ComponentAdapter() {  
						public void componentResized(ComponentEvent evt) {
							Component c = (Component) evt.getSource();
							dim.width = mainFrame.getWidth();
//							mainFrame.setMinimumSize(mainFrame.getMinimumDimension());
//							mainFrame.repaint();
						}
					});
				}
				else if(menuItem.isSelected())
				{
					mainFrame.getFtsPanel().setVisible(true);
					dim.width = (mainFrame.getWidth()) - ((mainFrame.getWidth() / 2) - 75); //mainFrame.getWidth();
					mainFrame.addComponentListener(new ComponentAdapter() {  
						public void componentResized(ComponentEvent evt) {
							Component c = (Component) evt.getSource();
							dim.width = (mainFrame.getWidth()) - ((mainFrame.getWidth() / 2) - 75);
							mainFrame.setMinimumSize(mainFrame.getMinimumDimension());
							mainFrame.repaint();
						}
					});
				}
			}
		});
		JCheckBoxMenuItem showTextFtsItem = new JCheckBoxMenuItem("Show Text Editing");
		showMenu.add(showFtsItem);
		showMenu.add(showTextFtsItem);
		windowMenu.add(showMenu);
		menuBar.add(seflTutorMenu);
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
	}
	
	public void appendText(String text) {
		this.appendText(text);
	}
	
}