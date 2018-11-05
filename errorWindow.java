import javax.swing.JFrame;
import javax.swing.JLabel;

public class errorWindow {
	public errorWindow(String errorText) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel error= new JLabel(errorText);
		frame.add(error);
		frame.pack();
		
	}
}
