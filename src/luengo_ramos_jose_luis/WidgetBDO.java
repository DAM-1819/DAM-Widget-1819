package luengo_ramos_jose_luis;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class WidgetBDO extends JDialog {

    Manager manager;
    JLabel jLName, jLTime, jLTitle1, jLTitle2, jLImage;
    JPanel jPBorder;

    public WidgetBDO() {
        super();
        this.setTitle("Global Timer Black Desert Online");
        this.setVisible(true);
        this.setBounds(100,100,500,300);

    }


    public void initializeWidget(){
        manager = new Manager();
        jLName = new JLabel();
        jLTime = new JLabel();
        jLTitle1 = new JLabel();
        jLTitle2 = new JLabel();
        jLImage = new JLabel();
        jPBorder = new JPanel();

        this.setLayout(new GridLayout(1,1));

        jPBorder.setBorder(new TitledBorder("Black Desert Online"));

        jPBorder.setLayout(new GridBagLayout());

        GridBagConstraints setting = new GridBagConstraints();
        setting.weighty=3;
        setting.weightx=1;
        setting.gridheight = 4;
        setting.fill = GridBagConstraints.BOTH;
        jLImage.setIcon(manager.getIconBoss());
        jLImage.setHorizontalAlignment(SwingConstants.CENTER);

        jPBorder.add(jLImage,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 0;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLTitle1.setText("Boss Actual:");
        jLTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        jLTitle1.setFont(new Font(jLTitle1.getFont().getName(),Font.BOLD,14));
        jLTitle1.setBorder(new LineBorder(Color.BLACK));
        jPBorder.add(jLTitle1,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 1;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLName.setText(manager.getBossNow());
        jLName.setHorizontalAlignment(SwingConstants.CENTER);
        jLName.setBorder(new LineBorder(Color.BLACK));
        jPBorder.add(jLName, setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 2;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLTitle2.setFont(new Font(jLTitle2.getFont().getName(),Font.BOLD,14));
        jLTitle2.setText("Siguiente Boss en:");
        jLTitle2.setHorizontalAlignment(SwingConstants.CENTER);
        jLTitle2.setBorder(new LineBorder(Color.BLACK));
        jPBorder.add(jLTitle2,setting);

        setting = new GridBagConstraints();
        setting.gridx = 1;
        setting.gridy = 3;
        setting.weighty=2;
        setting.weightx=1;
        setting.fill = GridBagConstraints.BOTH;
        jLTime.setBorder(new LineBorder(Color.BLACK));
        jLTime.setHorizontalAlignment(SwingConstants.CENTER);
        jPBorder.add(jLTime,setting);

        this.add(jPBorder);
        TimerThread timerThread = new TimerThread(jLTime, manager);
        TimerThreadBoss timerThreadBoss = new TimerThreadBoss(manager,jLImage);

        timerThread.start();
        timerThreadBoss.start();
    }


}
