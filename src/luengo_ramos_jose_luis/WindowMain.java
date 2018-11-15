package luengo_ramos_jose_luis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para probar el widget
 *
 */
public class WindowMain implements ActionListener {
    JFrame window;
    JButton jButton;
    public WindowMain() {
        window = new JFrame();
        window.setBounds(100,100,400,400);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initialize() {
        window.setVisible(true);
        initializeComponents();
        initializeListeners();
    }

    private void initializeComponents() {
        window.setLayout(new GridLayout());
        jButton = new JButton("Pulsa");
        window.add(jButton);
    }

    private void initializeListeners() {
        jButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WidgetBDO widget = new WidgetBDO();
        widget.initializeWidget();
    }
}
