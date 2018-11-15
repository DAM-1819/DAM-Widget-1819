package luengo_ramos_jose_luis;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;


public class TimerThreadBoss extends Thread {

    LocalTime nextBoss;
    JLabel imagen;
    Manager manager;

    public TimerThreadBoss(Manager manager, JLabel imagen) {
        this.nextBoss = manager.getNextBoss();
        this.manager = manager;
        this.imagen = imagen;
    }

    @Override
    public void run() {
        while (true) {
            imagen.setIcon(manager.getIconBoss());
            imagen.validate();
            imagen.repaint();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
