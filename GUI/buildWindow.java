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
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;

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
		JPanel home=new JPanel();
		JPanel yprgms=new JPanel();
		JPanel gprgms=new JPanel();
		JPanel tools=new JPanel();
		JPanel settings=new JPanel();
		table = new JTable();
		table.setShowGrid(false);
		tabbedPane.addTab("Home", null, home, null);
		home.setLayout(new BorderLayout(0, 0));
		
		JButton btnUpdateTm = new JButton("Update TM");
		btnUpdateTm.setEnabled(false);
		home.add(btnUpdateTm, BorderLayout.NORTH);
		tabbedPane.addTab("Your Programs", null, yprgms, null);
		yprgms.setLayout(new BoxLayout(yprgms, BoxLayout.X_AXIS));
		tabbedPane.addTab("Get Programs", null, gprgms, null);
		tabbedPane.addTab("Tools", null, tools, null);
		tabbedPane.addTab("Settings", null, settings, null);
		JToolBar toolbar=new JToolBar();
		toolbar.setEnabled(false);
		splitPane.setLeftComponent(toolbar);
		
		JLabel lblJavatm = new JLabel("JavaTM");
		toolbar.add(lblJavatm);
		
		f.getContentPane().add(panel);
	}
}
