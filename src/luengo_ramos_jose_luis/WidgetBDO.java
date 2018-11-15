package luengo_ramos_jose_luis;

import javax.swing.*;

import java.awt.*;

public class WidgetBDO extends JDialog {

    Manager manager;
    JLabel jLName, jLTime, jLTitle1, jLTitle2, jLImage;


    public WidgetBDO() {
        super();
        this.setVisible(true);
        this.setBounds(100,100,400,400);

    }


    public void initializeWidget(){
        manager = new Manager();
        jLName = new JLabel();
        jLTime = new JLabel();
        jLTitle1 = new JLabel();
        jLTitle2 = new JLabel();
        jLImage = new JLabel();

        this.setLayout(new GridBagLayout());
        GridBagConstraints setting = new GridBagConstraints();
        setting.weighty=3;
        setting.weightx=1;
        setting.gridheight = 4;
        setting.fill = GridBagConstraints.BOTH;
        jLImage.setIcon(manager.getIconBoss());
//        jLImage.setIcon(new ImageIcon(Main.class.getResource("image/Kutum.jpg")));
        this.add(jLImage,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 0;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLTitle1.setText("Boss:");
        this.add(jLTitle1,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 1;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLName.setText(manager.getBossNow());
        this.add(jLName, setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 2;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLTitle2.setText("Tiempo:");
        this.add(jLTitle2,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 3;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        this.add(jLTime,setting);

        TimerThread timerThread = new TimerThread(jLTime, manager);
        TimerThreadBoss timerThreadBoss = new TimerThreadBoss(manager,jLImage);

        timerThread.start();
        timerThreadBoss.start();
    }


}
