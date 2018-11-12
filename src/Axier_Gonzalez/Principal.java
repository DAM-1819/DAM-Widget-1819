package Axier_Gonzalez;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Login log = new Login();
				log.inicializar();				
			}
		});
	}
}
