package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.GUI;

import java.io.IOException;

public class buildWindow extends JPanel {
	private static JTable table;
	private JTextField textField;
	private JTextField txtRootEnabled;
	public buildWindow(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, 0));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		tabbedPane.setEnabledAt(0, true);
			home.setLayout(new BorderLayout(0, 0));
			JButton btnNewButton_1 = new JButton("Check For Updates");
			btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
			home.add(btnNewButton_1, BorderLayout.NORTH);
			JButton btnNewButton_2 = new JButton("Get Programs");
			btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
			btnNewButton_2.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        tabbedPane.setSelectedIndex(2);
			    }
			});
			home.add(btnNewButton_2, BorderLayout.SOUTH);
		tabbedPane.addTab("Your Programs", null, yprgms, null);
		tabbedPane.setEnabledAt(1, true);
			yprgms.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("Get Programs", null, gprgms, null);
		tabbedPane.setEnabledAt(2, true);
			gprgms.setLayout(new BorderLayout(0, 0));
			JToolBar toolBar = new JToolBar();
			toolBar.setFloatable(false);
			gprgms.add(toolBar, BorderLayout.NORTH);
			JTextField textField = new JTextField();
			toolBar.add(textField);
			textField.setColumns(1);
			JButton btnNewButton = new JButton("Search");
			btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
			btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					GUI.search(textField.getText());
				}
			});
			toolBar.add(btnNewButton);
			
			JScrollPane scrollPane = new JScrollPane();
			gprgms.add(scrollPane, BorderLayout.CENTER);
		tabbedPane.addTab("Downloading", null, download, null);
			tabbedPane.setEnabledAt(3, true);
		tabbedPane.addTab("Tools", null, tools, null);
		
		JTextPane txtpnDevmodeNo = new JTextPane();
		txtpnDevmodeNo.setEditable(false);
		tools.add(txtpnDevmodeNo);
			tabbedPane.setEnabledAt(4, true);
			if(System.getProperty("isDev")=="true") {
				txtpnDevmodeNo.setText("Devmode Enabled");
			}
			else {
				txtpnDevmodeNo.setText("Devmode not enabled");
			}
		tabbedPane.addTab("Settings", null, settings, null);
			tabbedPane.setEnabledAt(5, true);
			settings.setLayout(new BorderLayout(0,0));
		JToolBar toolbar=new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setEnabled(false);
		splitPane.setLeftComponent(toolbar);
		
		JLabel lblJavatm = new JLabel("JavaTM");
		toolbar.add(lblJavatm);
		
		txtRootEnabled = new JTextField();
		if(System.getProperty("rootEnabled")=="true") {
			txtRootEnabled.setEnabled(true);
			txtRootEnabled.setText("ROOT ENABLED");
		}
		else {
			txtRootEnabled.setEnabled(false);
		}
		txtRootEnabled.setEditable(false);
		txtRootEnabled.setHorizontalAlignment(SwingConstants.TRAILING);
		toolbar.add(txtRootEnabled);
		txtRootEnabled.setColumns(10);
		
		f.getContentPane().add(panel, BorderLayout.CENTER);
	}
}
