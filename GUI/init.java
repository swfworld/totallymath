package GUI;
import java.awt.Dimension;
import javax.swing.*;

public class init{
	public static void main(String[] args) {
		JFrame frame = new JFrame("JavaTM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(720, 480));
		new loading(frame);
		frame.pack();
		frame.setVisible(true);
	}
	public static void destroyGUI() {
		System.exit(0);
	}
}
