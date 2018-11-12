package AdrianGomez;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal=new VentanaPrincipal("Prueba Widget");
					ventanaPrincipal.inicializar();
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});

	}

}
