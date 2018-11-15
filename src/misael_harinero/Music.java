package misael_harinero;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

/**
 * Clase que genera el panel de JavaFX controlador y ademas controla el flujo de la Reproduccion
 * @author Misael Harinero
 * @version 1.0
 */
public class Music {
    private String direccionCancion;
    private final static String SONG_DEFAULT = "src/misael_harinero/raw/mau2.mp3";
    /*
     * JAVA FX ELEMENTS
     * */
    private MediaView reproductor;
    private Label songName;
    private ProgressBar progressBar;
    private ChangeListener<javafx.util.Duration> progressChangeListener;
    private Button play;
    private Button reStart;
    private static File cancion;
    private Button botonCambiarMp3;
    private FileChooser fileChooser;
    private Scene scene;


    /**
     * Constructor en el que le pasamos una Url al Constructor para que inicie con esa Cancion
     * @param url:String
     *           Direccion del Fichero
     */
    public Music(String url) {
        this.reproductor = new MediaView();
        this.direccionCancion = url;
        cancion = new File(this.direccionCancion);
        this.fileChooser = new FileChooser();


    }

    /**
     * Constructor que no recibe ningun parametro, y que introduce una cancion Default
     */
    public Music() {

        this.reproductor = new MediaView();
        cancion = new File(SONG_DEFAULT);
        this.fileChooser = new FileChooser();
    }

    public String getDireccionCancion() {
        return direccionCancion;
    }

    public void setDireccionCancion(String direccionCancion) {
        this.direccionCancion = direccionCancion;
    }


    /**
     * Clase que genera el Objeto MediaPlayer a partir de un archivo al que se hace referencia en el atributo cancion,
     * Luego establecemos el MediaPlayer al atributo reproductor de la clase MediaView
     */
    public void enlazarAudio() {

        if (this.cancion.exists()) {
            Media media = new Media(cancion.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            this.reproductor.setMediaPlayer(mediaPlayer);
            this.reproductor.getMediaPlayer().play();
            this.play.setText("Pause");

        }


    }
    public void asignFile(){
        this.fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Audios","*.*"),
                new FileChooser.ExtensionFilter("MP3","*.mp3"),
                new FileChooser.ExtensionFilter("MP4","*.mp4"),
                new FileChooser.ExtensionFilter("WMA","*.wma"),
                new FileChooser.ExtensionFilter("FLAC","*.flac")
        );

    }

    /**
     * Generamos la scene de JavaFX  le introducimos un Label, una ProgressBar y 3 Botones y la retornamos.
     *
     * @return : Scene
     */
    public Scene createScene() {
        this.songName = new Label();

        this.songName.setStyle("-fx-font-size: 25px;  -fx-text-fill: #50ADC9;");
        this.progressBar = new ProgressBar();
        StackPane layout = new StackPane();
        asignFile();
        this.play = new Button("Pause");
        this.reStart = new Button("ReStart");
        this.botonCambiarMp3 = new Button("Change");
        enlazarAudio();
        this.play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (play.getText().equals("Pause")) {
                    reproductor.getMediaPlayer().pause();
                    play.setText("Play");
                } else {
                    reproductor.getMediaPlayer().play();
                    play.setText("Pause");
                }
            }
        });
        this.reStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enlazarAudio();
            }
        });
        this.botonCambiarMp3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                reproductor.getMediaPlayer().stop();
                File file = fileChooser.showOpenDialog(scene.getWindow());
                if (file != null){
                    cancion = file;
                    enlazarAudio();
                }
            }
        });
        this.reproductor.mediaPlayerProperty().addListener(new ChangeListener<MediaPlayer>() {
            @Override
            public void changed(ObservableValue<? extends MediaPlayer> observable, MediaPlayer oldValue, MediaPlayer newValue) {
                setCurrentPlaying(reproductor.getMediaPlayer());
            }
        });
        setCurrentPlaying(this.reproductor.getMediaPlayer());
        layout.setStyle("-fx-background-color: #797E96; -fx-font-size: 20px; -fx-aligment: center; -fx-color: #7555F4;");
        VBox box = new VBox();
        HBox hbox = new HBox();
        progressBar.setMaxWidth(Double.MAX_VALUE);
        progressBar.setStyle("-fx-accent: #B72C9B;-fx-box-border: #7D8299;");
        hbox.getChildren().addAll(this.play, this.reStart,this.botonCambiarMp3);
        hbox.setAlignment(Pos.CENTER);
        box.getChildren().addAll(this.songName, this.progressBar, hbox);
        box.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box);
        this.scene = new Scene(layout, 800, 600);
        return  this.scene;
    }

    public void setCurrentPlaying(MediaPlayer player) {
        progressBar.setProgress(0);
        progressChangeListener = new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                progressBar.setProgress(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis());
            }
        };
        player.currentTimeProperty().addListener(progressChangeListener);
        String ruta = player.getMedia().getSource();
        String parse []= ruta.split("/");
        ruta = parse[parse.length-1];
        this.songName.setText(ruta);
    }

}
