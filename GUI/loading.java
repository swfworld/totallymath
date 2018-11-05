package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import GUI.buildWindow;
import main.GUI;


public class loading{
	private JTextField txtWidth;
	private JTextField txtHeight;
	/**
	 * @wbp.parser.entryPoint
	 */
	public loading(JFrame frame){
		JLabel lblJavatmLauncher = new JLabel("JavaTM Launcher");
		lblJavatmLauncher.setEnabled(false);
		frame.getContentPane().add(lblJavatmLauncher, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane, BorderLayout.CENTER);
		
		JToolBar toolBar_1 = new JToolBar();
		splitPane.setLeftComponent(toolBar_1);
		
		txtWidth = new JTextField();
		txtWidth.setText("Width");
		toolBar_1.add(txtWidth);
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setText("Height");
		toolBar_1.add(txtHeight);
		txtHeight.setColumns(10);
		
		JCheckBoxMenuItem chckbxmntmSetAsDefault = new JCheckBoxMenuItem("Set as default");
		toolBar_1.add(chckbxmntmSetAsDefault);
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.SOUTH);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	frame.dispose();
		    	JFrame main=new JFrame();
		    	main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	if(Integer.parseInt(txtWidth.getText())<=768 || Integer.parseInt(txtHeight.getText())<=480) {
		    		main.setPreferredSize(new Dimension(1280, 720));
		    	}
		    	else {
		    		main.setPreferredSize(new Dimension(Integer.parseInt(txtWidth.getText()), Integer.parseInt(txtHeight.getText())));
		    	}
		    	main.pack();
		    	new buildWindow(main);
		    	
		    	main.setVisible(true);
		    }
		});
		toolBar.add(btnStart);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		});
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
