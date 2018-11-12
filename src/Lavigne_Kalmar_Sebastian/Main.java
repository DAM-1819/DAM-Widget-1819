package Lavigne_Kalmar_Sebastian;

import java.awt.EventQueue;

/**
*@author Sebas Lavigne
*
*/

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MainWindow mainWindow = new MainWindow();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
	}
}

