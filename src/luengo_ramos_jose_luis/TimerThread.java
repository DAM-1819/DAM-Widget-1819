package luengo_ramos_jose_luis;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;


public class TimerThread extends Thread {

    LocalTime nextBoss;
    JLabel timer;
    Manager manager;

    public TimerThread(JLabel timer, Manager manager) {
        this.nextBoss = manager.getNextBoss();
        this.timer = timer;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            LocalTime now = LocalTime.now();
            Duration duration = Duration.between(now, nextBoss);
            timer.setText(String.format("%02d : %02d", duration.toHours(), duration.minusHours(duration.toHours()).toMinutes()));
            timer.validate();
            timer.repaint();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
