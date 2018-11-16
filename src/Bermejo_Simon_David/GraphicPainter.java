package Bermejo_Simon_David;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * <h2>Clase Graphic Painter</h2>
 * Clase que hereda de JDialog.
 * Esta clase nos permite abrir un dialogo emergente que nos permitirá introducir un fichero con una serie de datos
 * y al pulsar el botón pintar gráfica nos mostrará en un panel contenido en el mismo dialogo la gráfica según los datos
 * incluidos en el fichero.
 * Además nos permitirá guardar esta gráfica como una imagen PNG.
 * Esta clase utiliza otras dos clases para este fin:
 *
 * @author David Bermejo Simon
 * @see ChartManager : Esta clase gestiona la creación de la gráfica y su transformación a una imagen PNG.
 * @see ObtainData : Esta clase gestiona el flujo de datos entre el fichero y el programa para su posterior utilización.
 **/
public class GraphicPainter extends JDialog {

    /**
     * Botón encargado de pintar la gráfica en un panel.
     */
    JButton paintGraphic;

    /**
     * Botón que permitirá vacíar todos los elementos del dialogo
     */
    JButton resetAll;

    /**
     * Boton que permitirá guardar la imagen del gráfico
     */
    JButton saveGraph;


    JButton selectFile;

    /**
     * Se pintará la gráfica en este panel
     */
    JPanel graphicContainer;

    /**
     * Caja de texto en la que el usuario introducirá el fichero de donde quiere que se lean los datos
     */
    JTextField insertFile;

    /**
     * Caja de texto que recogerá el nombre que deseamos introducir a nuestra gráfica
     */
    JTextField graphicTitle;

    /**
     * Label que especificará donde se deberá introducir el titulo de la gráfica.
     */
    JLabel labelGraphicTitle;

    /**
     * Etiqueta de Fichero a leer
     */
    JLabel labelFile;


    /**
     * Etiqueta del titulo del panel
     */
    JLabel labelTitle;

    /**
     * Instancia de GenerateChar sobre la que se creará el gráfico
     *
     * @see ChartManager
     */
    ChartManager gc;


    /**
     * Constructor de la clase
     *
     * @param button : boton desde el que se ha llamado al Dialogo
     * @param owner  : ventana desde la que se ha llamado al dialogo
     * @param title  : titulo del dialogo
     * @param modal  : modal del dialogo
     */
    public GraphicPainter(JButton button, JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        super.setBounds((int) button.getLocationOnScreen().getX() - 10, (int) button.getLocationOnScreen().getY(), 800, 650);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setResizable(false);

        addComponents();
        addListeners();
        this.setVisible(true);
    }

    /**
     * Metodo encargado de añadir componentes a la interfaz
     */
    public void addComponents() {
        //preparacion de ventana
        this.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();
        this.getContentPane().setBackground(new Color(204, 255, 204));

        //etiqueta del titulo del dialogo
        labelTitle = new JLabel("Dibuja tu gráfica");
        Font labelTitleFont = new FontUIResource(Font.MONOSPACED, Font.BOLD, 24);
        labelTitle.setFont(labelTitleFont);
        settings = new GridBagConstraints();
        settings.gridy = 0;
        settings.gridx = 1;
        settings.fill = GridBagConstraints.BOTH;
        settings.anchor = GridBagConstraints.CENTER;
        //settings.gridwidth=2;
        settings.insets = new Insets(20, 40, 20, 20);
        this.add(labelTitle, settings);


        //etiqueta label path to file
        labelFile = new JLabel("Fichero: ");
        Font labelFileFont = new FontUIResource(Font.MONOSPACED, Font.ITALIC, 15);
        labelFile.setFont(labelFileFont);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 1;
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.anchor = GridBagConstraints.EAST;
        this.add(labelFile, settings);


        //caja de introducción de texto para la ruta al fichero
        insertFile = new JTextField();
        settings = new GridBagConstraints();
        settings.gridx = 1;
        settings.gridy = 1;
        settings.ipadx = 100;
        settings.fill = GridBagConstraints.BOTH;
        this.add(insertFile, settings);



        //boton de selección de fichero.
        selectFile = new JButton();
        Font selectFileFont = new FontUIResource(Font.MONOSPACED, Font.ITALIC, 8);
        ImageIcon icon = new ImageIcon("image/file-upload.png");
        selectFile.setIcon(icon);
        selectFile.setFont(selectFileFont);
        settings = new GridBagConstraints();
        settings.gridx=2;
        settings.gridy=1;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(selectFile,settings);










        //etiqueta label para indicar la casilla de introducción de titulo
        labelGraphicTitle = new JLabel("Titulo del gráfico: ");
        Font graphicTitleFont = new FontUIResource(Font.MONOSPACED, Font.ITALIC, 15);
        labelGraphicTitle.setFont(graphicTitleFont);
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 2;
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.anchor = GridBagConstraints.EAST;
        this.add(labelGraphicTitle, settings);


        //caja de introducción de texto para el titulo del gráfico
        graphicTitle = new JTextField();
        settings = new GridBagConstraints();
        settings.gridx = 1;
        settings.gridy = 2;
        settings.gridwidth=2;
        settings.fill = GridBagConstraints.BOTH;
        this.add(graphicTitle, settings);


        //panel de la gráfica
        graphicContainer = new JPanel();
        graphicContainer.setLayout(new BorderLayout());
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 3;
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.BOTH;
        settings.ipadx = 600;
        settings.ipady = 400;
        this.add(graphicContainer, settings);


        //boton de pintar gráfica.
        this.paintGraphic = new JButton("Pintar Gráfica");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 4;
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(paintGraphic, settings);

        //Boton para guardar la imagen de la gráfica
        this.saveGraph = new JButton("Guardar Imagen");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 5;
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(saveGraph, settings);

        //boton para resetear los valores.
        this.resetAll = new JButton("Resetear Contenido");
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 6;
        settings.gridwidth = 3;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(resetAll, settings);
    }

    /**
     * Metodo encargado de refrescar la ventana principal con los cambios en los elementos
     */
    public void refreshInterface() {
        this.revalidate();
        this.repaint();
    }

    /**
     * Metodo encargado de reiniciar la interfaz desde el punto de su creación.
     */
    public void resetInterface() {
        this.setContentPane(new JPanel(new BorderLayout()));
        this.addComponents();
        this.addListeners();
        this.refreshInterface();
    }


    /**
     * Metodos encargados de inicializar los listeners de los botones
     */
    public void addListeners() {

        this.paintGraphic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gc = new ChartManager(graphicContainer, insertFile.getText(), graphicTitle.getText());
                graphicContainer.removeAll();
                graphicContainer.add(gc.createChart());
                refreshInterface();
            }
        });
        this.resetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetInterface();
            }
        });

        this.saveGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (gc != null) {
                    gc.saveChartAsPNG();
                } else {
                    JOptionPane.showMessageDialog(graphicContainer.getParent(), "No hay gráfica que guardar");
                }
            }
        });


        this.selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    insertFile.setText(selectedFile.getPath());
                }
            }
        });

    }


}
