package GUI;
import javax.swing.*;
import GUI.buildWindow;

@SuppressWarnings("serial")
public class main extends buildWindow{
	public main(JFrame f) {
		super();
	}
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("Load");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("JavaTM Launcher");
		frame.getContentPane().add(label);
		frame.pack();
		buildWindow(frame);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {createAndShowGUI();}
		});
	}
}
