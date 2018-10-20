package GUI;
import java.awt.Dimension;

import javax.swing.*;
import GUI.buildWindow;

@SuppressWarnings("serial")
public class init extends buildWindow{
	public init(JFrame f) {
		super(f);
	}
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("JavaTM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1280,720));
		frame.pack();
		new buildWindow(frame);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {createAndShowGUI();}
		});
	}
}
