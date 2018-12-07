package launcher;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import GUI.buildWindow;

public class Setup {
	/**
	 * @wbp.parser.entryPoint
	 */
	public Setup(){
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1280, 720));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel1=new JPanel();
		tabbedPane.setBounds(0, 0, 1264, 31);
			tabbedPane.addTab("REEE", panel1);
		
		
		panel.add(tabbedPane);
		
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String args[]) {
		new Setup();
	}
}
