package Bermejo_Simon_David;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <h2>Clase ChartManager:</h2>
 * Clase encargada de generar el gráfico para poder imprimirlo en el JPanel contenedor
 * de la clase GraphicPainter.
 *
 * @see GraphicPainter : ventana principal donde se situa el contenedor de la gráfica.
 * @see ObtainData : Obtendrá los datos del fichero con la instancia de la clase ObtainData
 *
 * @author David Bermejo Simon
 **/
public class ChartManager {

    String graphTitle;
    String nameAxisX;
    String nameAxisY;
    /**
     * Panel contenedor de la gráfica en la ventana principal.
     */
    JPanel containerPanel;


    /**
     * Instancia de la clase ObtainData desde donde se extraerán los datos del fichero
     *
     * @see ObtainData
     */
    ObtainData obtainData;

    /**
     * Colección de datos obtenidos desde la clase ObtainData
     *
     * @see ObtainData#getCollectionData()
     */
    HashMap<String, Integer> dataCollection;

    /**
     * DataSet donde se guardaran los datos para imprimirlos en la gráfica
     */
    DefaultCategoryDataset dataset;


    JFreeChart lineGraph;
    ChartPanel chartPanel;


    /**
     * Constructor de la clase.
     * En el constructor además de inicializar los componentes principales, se obtendrá la coleccion de datos
     * almacenada en el fichero con la ruta indicada y además se obtendrá el nombre de los ejes x e y.
     *
     * @param panel    : panel donde se dibujará la gráfica
     * @param filePath : Ruta al fichero donde se encuentran los datos que deberán ser representados en la gráfica
     */
    public ChartManager(JPanel panel, String filePath, String graphTitle) {
        this.obtainData = new ObtainData(filePath, panel);
        this.obtainData.readData();
        //establecer nombres a los ejes.
        this.nameAxisX = obtainData.getNameAxisX();
        if (this.nameAxisX == null) {
            this.nameAxisX = "";
        }
        this.nameAxisY = obtainData.getNameAxisY();
        if (this.nameAxisY == null) {
            this.nameAxisY = "";
        }
        //poner el titulo al gráfico
        this.graphTitle = graphTitle;
        if (this.graphTitle.equalsIgnoreCase("")) {
            String[] fichName = filePath.split("/");
            this.graphTitle = fichName[fichName.length - 1];
        }
        //obtener la coleccion de datos de la instancia obtain data
        dataCollection = obtainData.getCollectionData();


        this.containerPanel = panel;
    }

    /**
     * Metodo encargado de crear el gráfico e introducirlo en el panel
     * contenedor del frame del dialogo GraphicPainter
     */
    public ChartPanel createChart() {
        this.lineGraph = ChartFactory.createLineChart(
                this.graphTitle, this.nameAxisX, this.nameAxisY,
                generateDataSet(), PlotOrientation.VERTICAL,
                true, true, false);

        this.chartPanel = new ChartPanel(lineGraph);
        chartPanel.setBounds(containerPanel.getX(), containerPanel.getY(), containerPanel.getWidth(), containerPanel.getHeight());
        return chartPanel;
    }

    /**
     * Metodo encargado de obtener los datos de la coleccion dataCollection
     * y volcarlos en un dataset para que sean tratados en la gráfica
     *
     * @return DefaultCategoryDataset dataset : dataset con los datos obtenidos del fichero
     * y almacenados en la colección dataCollection
     */
    public DefaultCategoryDataset generateDataSet() {
        dataset = new DefaultCategoryDataset();
        Map map = dataCollection;
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            dataset.addValue(value, this.nameAxisY, key);
        }
        return this.dataset;
    }

    /**
     * Metodo encargado de guardar la gŕafica en formato PNG.
     */
    public void saveChartAsPNG() {
        try {
            File dir = new File("imagenes");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File image = new File("imagenes/" + graphTitle + ".png");
            OutputStream out = new FileOutputStream(image);
            ChartUtilities.writeChartAsPNG(out, this.lineGraph, this.chartPanel.getWidth(), this.chartPanel.getHeight());
            JOptionPane.showMessageDialog(containerPanel.getParent(), "Se ha guardado la imagen con éxito. Se ha almacenado en la carpeta imagenes ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(containerPanel.getParent(), "No se pueden cargar los datos, no se encuentra ningun fichero ");
        }
    }
}
