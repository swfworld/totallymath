package GUI;
import javax.swing.*;
import GUI.buildWindow;

public class loading{
	public static void LoadingFrame(){
		JFrame frame = new JFrame("Load");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("JavaTM Launcher");
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {LoadingFrame();}
		});
	}
}
