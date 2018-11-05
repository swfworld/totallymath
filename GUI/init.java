package GUI;
import java.awt.Dimension;
<<<<<<< HEAD
import GUI.loading;

=======
>>>>>>> cbb9fda3c0465973f2f290ef1b1fdf879ebd34a4
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
