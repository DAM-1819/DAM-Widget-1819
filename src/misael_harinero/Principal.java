package misael_harinero;

import java.awt.EventQueue;

/**
 * @author missi
 * @version 1.0
 * Hilo principal de Ejecucion 
 */
public class Principal {
    public static void main(String[] args) {
    	 EventQueue.invokeLater(()->{
             VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
             ventanaPrincipal.invocar();

         });
    }
}
