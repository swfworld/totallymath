package GUI;
import javax.swing.*;


import GUI.buildWindow;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loading{
	private JTextField txtSelectScreenResolution;
	/**
	 * @wbp.parser.entryPoint
	 */
	public loading(JFrame frame){
		JLabel lblJavatmLauncher = new JLabel("JavaTM Launcher");
		lblJavatmLauncher.setEnabled(false);
		frame.getContentPane().add(lblJavatmLauncher, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtSelectScreenResolution = new JTextField();
		txtSelectScreenResolution.setText("Set Screen Resolution");
		txtSelectScreenResolution.setEditable(false);
		txtSelectScreenResolution.setEnabled(false);
		GridBagConstraints gbc_txtSelectScreenResolution = new GridBagConstraints();
		gbc_txtSelectScreenResolution.gridwidth = 9;
		gbc_txtSelectScreenResolution.insets = new Insets(0, 0, 5, 5);
		gbc_txtSelectScreenResolution.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSelectScreenResolution.gridx = 5;
		gbc_txtSelectScreenResolution.gridy = 1;
		panel.add(txtSelectScreenResolution, gbc_txtSelectScreenResolution);
		txtSelectScreenResolution.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 9;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 12;
		gbc_btnStart.gridy = 7;
		panel.add(btnStart, gbc_btnStart);
		JButton btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnExit.gridx = 13;
		gbc_btnExit.gridy = 7;
		panel.add(btnExit, gbc_btnExit);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
	}
}
