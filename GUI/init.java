package GUI;
import java.awt.Dimension;
import GUI.loading;
import javax.swing.*;

public class init{
	public static void main(String[] args) {
		start();
	}
	public static void start(){
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName()
			);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("JavaTM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(720, 480));
		loading.loadingframe(frame);
		frame.pack();
		frame.setVisible(true);
	}
	public static void destroyGUI() {
		System.exit(0);
	}
}
