package RamPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;



public class VentanaPrincipal2 {
	//La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	WidgetNoticias not;

	//Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal2() {
		ventana = new JFrame();
		ventana.setBounds(0, 0, 1300,85);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){
		
		//Definimos el layout:
		ventana.setLayout(new GridBagLayout());
	GridBagConstraints gb= new GridBagConstraints();
	//gb.gridx=0;
	//gb.gridy=0;
	gb.fill=GridBagConstraints.BOTH;
	gb.weightx=1;
	gb.weighty=1;

		not= new WidgetNoticias();
	
		ventana.add(not,gb);
		
	
	}
	


	

	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
	
		
	}
	

	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}


}
