package finiestab;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class DialogHighScore extends JDialog {

	JLabel titulo;
	String nombre;
	int puntuacion;
	Jugador[] scores=new Jugador[10];
	JLabel[] punt=new JLabel[10];
	JPanel izq=new JPanel();
	JPanel der=new JPanel();
	JPanel contenido=new JPanel();
	ImageIcon icon;

	
	public DialogHighScore(int puntuacion, JFrame ventana, String nombre) {
	super();
	this.puntuacion=puntuacion;
	this.nombre=nombre;
	setModal(true);
	this.setLayout(new GridBagLayout());
	setBounds((int)ventana.getLocationOnScreen().getX(),(int)ventana.getLocationOnScreen().getY(), 644, 600);
	leerFichero();
	if(comprobarPuntuacion()) {
		Arrays.sort(scores);
		escribirFichero();
	}
	anadirElementos();
	setVisible(true);
	}
	

	/**
	 * Método para comprobar si la puntuación entra en el TOP10
	 * @return devuelve un booleano true para actulizar el fichero 
	 */
	public boolean comprobarPuntuacion() {
		for (int i = 0; i < scores.length; i++) {
			if(this.puntuacion>scores[i].getScore()) {
				scores[9]=new Jugador(this.nombre, this.puntuacion);
				return true;
			}
		}
		return false;
	}

	public void anadirElementos() {	
		
		icon=new ImageIcon(("recursos_iniesta/titulo.PNG"));
		titulo=new JLabel(icon);
		
		GridBagConstraints settTitulo= new GridBagConstraints();
		settTitulo.gridx=0;
		settTitulo.gridy=0;
		settTitulo.gridwidth=3;
		settTitulo.weightx=1;
		settTitulo.fill=GridBagConstraints.BOTH;

		this.add(titulo,settTitulo);
		
		ImageIcon panes=new ImageIcon(("recursos_iniesta/Panes2.PNG"));
		izq.add(new JLabel(panes));
		der.add(new JLabel(panes));
		izq.setBackground(Color.BLACK);
		der.setBackground(Color.BLACK);
		
		contenido.setLayout(new GridBagLayout());
		contenido.setBackground(Color.BLACK);
		GridBagConstraints settPanes=new GridBagConstraints();	
		settPanes.gridy=1;
		settPanes.weightx=2;
		settPanes.weighty=2;
		settPanes.fill=GridBagConstraints.BOTH;
		settPanes.gridx=0;//izquierda
		this.add(izq, settPanes);
		settPanes.gridx=1;//contenido
		this.add(contenido, settPanes);
		settPanes.gridx=2;//derecha
		this.add(der, settPanes);
		
		GridBagConstraints settScores= new GridBagConstraints();
		settScores.gridx=0;
		settScores.weightx=1;
		settScores.weighty=1;
		settScores.fill=GridBagConstraints.BOTH;
		int j=9;
		for (int i = 0; i < scores.length; i++) {			
			settScores.gridy=i;
			punt[i]=new JLabel(scores[i].getNombre()+"-"+scores[i].getScore());
			punt[i].setHorizontalAlignment(SwingConstants.CENTER);
			punt[i].setOpaque(true);
			punt[i].setForeground(new Color(255-(j*6), 255-(j*26), 255-(j*26)));
			punt[i].setBackground(Color.BLACK);
			contenido.add(punt[i], settScores);
			j--;
		}
		this.repaint();
	}
	
	public void leerFichero() {
		int i=0;
		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader("recursos_iniesta//scores.txt"));
			linea=br.readLine();
			while(linea!=null && i<=9) {
				String []split=linea.split("-");
				scores[i]=new Jugador(split[0], Integer.parseInt(split[1]));
				i++;
				linea=br.readLine();
			}
			br.close();			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribirFichero() {
		try {
			PrintWriter pw=new PrintWriter(new FileWriter("recursos_iniesta//scores.txt"));
			for (int j = 0; j < scores.length; j++) {
				pw.println(scores[j].getNombre()+"-"+scores[j].getScore());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
