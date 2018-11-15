package misael_harinero;



import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Reproductor  extends JDialog  {
    private static final long serialVersionUID  = 1L;
    private JTextField text;
    private JButton boton;
    private JProgressBar barra;
    private Music music;
    private JFXPanel panel;
    private String direccionCancion;

    public Reproductor() {
        super();
        this.setVisible(true);
        setBounds(100,100,400,200);
        this.direccionCancion = null;
        addElementos();        
    }
    public Reproductor(String urlCancion) {
        super();
        this.setVisible(true);
        setBounds(100,100,400,200);
        this.direccionCancion = urlCancion;
        addElementos();
    }
    public Reproductor(String urlCancion, int posx, int posy) {
        super();
        this.setVisible(true);
        setBounds(posx,posy,400,200);
        this.direccionCancion = urlCancion;
        addElementos();
    }

    public void addElementos(){
        this.setLayout(new GridLayout(1,1));
        this.panel = new JFXPanel();
        this.add(panel);
       if(this.direccionCancion != null) {
    	   this.music = new Music(this.direccionCancion);
       }else {
    	   this.music = new Music();
       }
        Platform.runLater(()->{
            try {
               initFX(this.panel);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });



    }
    public void initFX(JFXPanel panel){
        Scene scene =  music.createScene();
        panel.setScene(scene);
    }

}
