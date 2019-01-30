package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class errorWindow {
	public errorWindow(String errorText) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(0,0));
		JLabel error= new JLabel(errorText);
		error.setHorizontalAlignment(JLabel.CENTER);
		frame.add(error, BorderLayout.CENTER);
		JButton exitbtn=new JButton("Quit");
		exitbtn.setHorizontalAlignment(JButton.CENTER);
		exitbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(1);
			}
		});
		frame.add(exitbtn,BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(384, 240));
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String args[]){
		new errorWindow("gay");
	}
}
