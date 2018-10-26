package GUI;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

import GUI.buildWindow;

public class init extends buildWindow{
	public init(JFrame f) {
		super(f);
	}
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("JavaTM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		frame.setPreferredSize(new Dimension(gd.getDisplayMode().getWidth(),gd.getDisplayMode().getHeight()));
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
