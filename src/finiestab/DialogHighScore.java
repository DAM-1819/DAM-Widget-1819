package finiestab;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DialogHighScore extends JDialog {

	JLabel titulo;
	String nombre;
	int puntuacion;
	Jugador[] scores=new Jugador[10];
	JLabel[] punt=new JLabel[10];
	
	public DialogHighScore(int puntuacion, JFrame ventana, String nombre) {
	super();
	this.puntuacion=puntuacion;
	this.nombre=nombre;
	setModal(true);
	this.setLayout(new GridBagLayout());
	setBounds((int)ventana.getLocationOnScreen().getX(),(int)ventana.getLocationOnScreen().getY(), 300, 500);
	leerFichero();
	if(comprobarPuntuacion()) {
		Arrays.sort(scores);
		escribirFichero();
	}
	anadirElementos();
	setVisible(true);
	}
	


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
		titulo=new JLabel("PUNTUACIONES");
		Font fuente=new Font("Arial", 1, 20);
		titulo.setFont(fuente);
		
		GridBagConstraints settTitulo= new GridBagConstraints();
		settTitulo.gridx=0;
		settTitulo.gridy=0;
		settTitulo.gridwidth=3;
		settTitulo.weightx=1;
		settTitulo.fill=GridBagConstraints.BOTH;
		
		this.add(titulo,settTitulo);
		
		GridBagConstraints settScores= new GridBagConstraints();
		settScores.gridx=1;
		for (int i = 0; i < scores.length; i++) {
			
			settScores.gridy=i+1;
			punt[i]=new JLabel(scores[i].getNombre()+"-"+scores[i].getScore());
			this.add(punt[i], settScores);
		}
		
	}
	
	public void leerFichero() {
		int i=0;
		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader("recursos_iniesta//scores.txt"));
			linea=br.readLine();
			while(linea!=null && i<=9) {
				String []split=linea.split("-");
				System.out.println(split[0]);
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
