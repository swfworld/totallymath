package GUI;
import javax.swing.*;


import GUI.buildWindow;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class loading{
	/**
	 * @wbp.parser.entryPoint
	 */
	public loading(JFrame frame){
		JLabel lblJavatmLauncher = new JLabel("JavaTM Launcher");
		lblJavatmLauncher.setEnabled(false);
		frame.getContentPane().add(lblJavatmLauncher, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.SOUTH);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnStart = new JButton("Start");
		toolBar.add(btnStart);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		
		JButton btnExit = new JButton("Exit");
		toolBar.add(btnExit);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_5);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_4);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_3);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		frame.pack();
	}
}
