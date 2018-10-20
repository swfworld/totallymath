package GUI;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;

public class buildWindow extends JPanel {
	private static JTable table;
	public buildWindow(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, 0));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		splitPane.setRightComponent(tabbedPane);
		JToolBar toolbar=new JToolBar();
		splitPane.setLeftComponent(toolbar);
		
		JLabel lblJavatm = new JLabel("JavaTM");
		toolbar.add(lblJavatm);
		JPanel home=new JPanel();
		JPanel yprgms=new JPanel();
		JPanel gprgms=new JPanel();
		JPanel tools=new JPanel();
		JPanel settings=new JPanel();
		table = new JTable();
		table.setShowGrid(false);
		tabbedPane.addTab("Home", null, home, null);
		tabbedPane.addTab("Your Programs", null, yprgms, null);
		tabbedPane.addTab("Get Programs", null, gprgms, null);
		tabbedPane.addTab("Tools", null, tools, null);
		tabbedPane.addTab("Settings", null, settings, null);
		
		f.getContentPane().add(panel);
	}
}
