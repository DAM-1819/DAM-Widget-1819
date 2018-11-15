package Bermejo_Simon_David;

import java.awt.*;

/**
 * @author David Bermejo Simon
 **/
public class Main {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window window = new Window();
                window.iniciar();
            }
        });
    }
}
