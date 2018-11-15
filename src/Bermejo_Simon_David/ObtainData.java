package Bermejo_Simon_David;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/**
 * <h2>Clase ObtainData:</h2>
 * Clase encargada de obtener los datos del fichero de texto que introduzca el usuario.
 * consta de tres métodos principales:
 * @see ObtainData#readData() : metodo encargado de leer los datos del fichero y volcarlos en una colección
 * @see ObtainData#getNameAxisX() : metodo encargado de leer del fichero el nombre establecido al eje x
 * @see ObtainData#getNameAxisY() : metodo encargado de leer del fichero el nombre establecido al eje y
 *
 * @author David Bermejo Simon
 **/
public class ObtainData {
    File file;
    JPanel containerPanel;
    HashMap<String, Integer> collectionData;


    public ObtainData(String filePath, JPanel container) {
        this.file = new File(filePath);
        this.containerPanel = container;
        this.collectionData = new HashMap<>();

    }


    /**
     * Metodo encargado de obtener los datos del fichero y añadirlo a la memoria
     * para posteriormente imprimirlo en la gráfica
     */
    public void readData() {
        String line;
        String key;
        int value;
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            line = br.readLine();
            while (line != null) {
                if (!line.startsWith("axisX") && !line.startsWith("axisY")) {
                    key = line.split(":")[0];
                    value = Integer.parseInt(line.split(":")[1]);
                    this.collectionData.put(key, value);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(containerPanel.getParent(), "No se pueden cargar los datos, no se encuentra ningun fichero ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo encargado de devolver la colección de datos almacenados en el fichero
     *
     * @return HashMap collectionData : colección de datos incluidos en el fichero
     */
    public HashMap<String, Integer> getCollectionData() {
        return this.collectionData;
    }

    /**
     * Método encargado de obtener del fichero el nombre asignado al eje X
     */
    public String getNameAxisX() {
        String line;
        String nameX = null;
        boolean complete = false;

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            line = br.readLine();
            while (line != null && !complete) {
                if (line.startsWith("axisX=")) {
                    nameX = line.split("=")[1];
                    complete = true;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(containerPanel.getParent(), "No se ha establecido nombre para el eje X");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameX;
    }

    /**
     * Método encargado de obtener del fichero el nombre asignado al eje Y
     */
    public String getNameAxisY() {
        String line;
        String nameY = null;
        boolean complete = false;

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            line = br.readLine();
            while (line != null && !complete) {
                if (line.startsWith("axisY=")) {
                    nameY = line.split("=")[1];
                    complete = true;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(containerPanel.getParent(), "No se ha establecido nombre para el eje Y");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameY;
    }

}
