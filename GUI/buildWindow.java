package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class buildWindow extends JPanel {
	private static JTable table;
	private JTextField textField;
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
		JPanel download=new JPanel();
		JPanel tools=new JPanel();
		JPanel settings=new JPanel();
		table = new JTable();
		table.setShowGrid(false);
		tabbedPane.addTab("Home", null, home, null);
		home.setLayout(new BorderLayout(0, 0));
			JButton btnNewButton_1 = new JButton("Check For Updates");
			home.add(btnNewButton_1, BorderLayout.NORTH);
			JButton btnNewButton_2 = new JButton("Get Programs");
			btnNewButton_2.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        tabbedPane.setSelectedIndex(2);
			    }
			});
			home.add(btnNewButton_2, BorderLayout.SOUTH);
			JEditorPane nestHome=new JEditorPane();
			nestHome.setEnabled(false);
			home.add(nestHome, BorderLayout.CENTER);
		tabbedPane.addTab("Your Programs", null, yprgms, null);
			yprgms.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("Get Programs", null, gprgms, null);
			gprgms.setLayout(new BorderLayout(0, 0));
			JToolBar toolBar = new JToolBar();
			gprgms.add(toolBar, BorderLayout.NORTH);
			textField = new JTextField();
			toolBar.add(textField);
			textField.setColumns(1);
			JButton btnNewButton = new JButton("Search");
			btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
			toolBar.add(btnNewButton);
		tabbedPane.addTab("Downloading", null, download, null);
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
