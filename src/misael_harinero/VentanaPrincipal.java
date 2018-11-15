package misael_harinero;

import javax.swing.*;
import java.awt.*;

/**
 * Clase en la que generamos la Interfaz principal
 * @author misael_harinero
 *
 */
public class VentanaPrincipal {
    private JFrame ventana;
    private JButton boton;
    /**
     * Constructor de la Ventana de Test
     */
    public VentanaPrincipal(){
        this.ventana = new JFrame("Ejercicio05T5");
        this.ventana.setBounds(400,300,400,400);
        this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Invocamos los elementos de la ventana de Test
     */
    public void invocar(){
        this.ventana.setVisible(true);
        this.ventana.setLayout(new GridLayout());
        this.boton = new JButton("Pulsa y Escucha");
        this.boton.addActionListener((e)->{
            Reproductor reproductor = new Reproductor();
        });
        this.ventana.add(boton);



    }
}
