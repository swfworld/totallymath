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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;

public class buildWindow extends JPanel {
	private static JTable table;

	/**
	 * Create the panel.
	 */
	public static void buildWindow(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		splitPane.setRightComponent(tabbedPane);
		
		table = new JTable();
		table.setShowGrid(false);
		tabbedPane.addTab("Launch Programs", null, table, null);
		
		f.getContentPane().add(panel);
	}

}
