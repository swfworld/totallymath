package GUI;
import javax.swing.*;
import main.loader;

public class main {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Load");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("JavaTM Launcher");
		frame.getContentPane().add(label);
		Toolkit.getDefaultToolkit().getImage(frame.class.getResource(loader.dir+"resources/icon.png"));
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {createAndShowGUI();}
			});
		}
	}
	public main(String[] args) {
		System.out.println("Test.");
	}
}
