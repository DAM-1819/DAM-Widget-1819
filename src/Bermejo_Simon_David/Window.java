package Bermejo_Simon_David;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author David Bermejo Simon
 **/
public class Window {


    JFrame frame;
    JButton button;


    public Window(){
        frame = new JFrame("Ejemplo para Widget");
        frame.setBounds(100,100,100,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void inicializarComponentes(){
        frame.setLayout(new BorderLayout());
        button = new JButton("Pruebame");
        frame.add(button);
    }


    public void inicializarListeners(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicPainter gp = new GraphicPainter(button,frame,"PintaGraficas",true);
            }
        });
    }


    public void iniciar(){
        inicializarComponentes();
        inicializarListeners();
        frame.setVisible(true);
    }
}
