package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import GUI.buildWindow;
import main.GUI;


public class loading{
	private static JTextField txtWidth;
	private static JTextField txtHeight;
	/**
	 * @return 
	 * @wbp.parser.entryPoint
	 */
	public static void loadingframe(JFrame frame){
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
		if(Integer.parseInt(System.getProperty("defaultWidth"))!=720) {
			txtWidth.setText(System.getProperty("defaultWidth"));
		}
		else {
			txtWidth.setText("Width");
		}
		
		toolBar_1.add(txtWidth);
		txtWidth.setColumns(10);
		txtWidth.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent fEvt) {
				JTextField tField = (JTextField)fEvt.getSource();
				txtWidth.setText(null);
			}
		});
		
		txtHeight = new JTextField();
		if(Integer.parseInt(System.getProperty("defaultHeight"))!=480) {
			txtHeight.setText(System.getProperty("defaultHeight"));
		}
		else {
			txtHeight.setText("Height");
		}
		toolBar_1.add(txtHeight);
		txtHeight.setColumns(10);
		txtHeight.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent fEvt) {
				JTextField tField = (JTextField)fEvt.getSource();
				txtHeight.setText(null);
			}
		});
		
		JCheckBoxMenuItem setDefault = new JCheckBoxMenuItem("Set as default");
		toolBar_1.add(setDefault);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
		    	try {
		    		Integer width=Integer.parseInt(txtWidth.getText());
		    		Integer height=Integer.parseInt(txtHeight.getText());
		    		if(width<720 || height<480) {
		    			main.setPreferredSize(new Dimension(720,480));
		    		}
		    		else {
		    			main.setPreferredSize(new Dimension(width,height));
		    			if(setDefault.isSelected()){
		    				System.getProperties().setProperty("defaultWidth", Integer.toString(width));
		    				System.getProperties().setProperty("defaultHeight", Integer.toString(height));
		    			}
		    		}
		    	}
		    	catch(NumberFormatException ex) {
		    		main.setPreferredSize(new Dimension(720,480));
		    	}
		    	main.pack();
		    	buildWindow.start(main);
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
