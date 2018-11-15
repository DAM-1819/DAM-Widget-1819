package Lavigne_Kalmar_Sebastian;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
*@author Sebas Lavigne
*
*/

public class MainWindow {

	public MainWindow() {
		JFrame frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new PumpSlider());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

