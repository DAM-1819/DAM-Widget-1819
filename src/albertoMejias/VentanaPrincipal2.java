package albertoMejias;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class VentanaPrincipal2 {

	JFrame ventana = new JFrame();
	JPanel mes;
	JPanel dia[][] = new JPanel[4][7];
	JLabel label;
	JLabel diario;
	JTextField posit ;
	MiBoton evento; 
	MiBoton2 finalizado;

	public VentanaPrincipal2() {
		this.ventana = new JFrame("CALENDARIO");
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GridBagLayout layout = new GridBagLayout();
		ventana.getContentPane().setLayout(layout);
		ventana.setDefaultCloseOperation(3);

	}
	
	public static void volcarFichero(DataOutputStream dos){
		
	}
	
	public static void guardarFichero() {
			
		File fichero = new File("Calendario.txt");
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream(fichero));
			volcarFichero( dos);
		}catch (IOException e) {
			
		}finally {
			if(dos != null) {
				try {
					dos.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void inicializarComponentes() {
		mes = new JPanel(new GridLayout(4, 7));
		int cont = 1;
		Font font = new Font("Agency FB", Font.BOLD, 24);
		
		for (int i = 0; i < dia.length; i++) {
			for (int j = 0; j < dia[i].length; j++) {
				dia[i][j] = new JPanel(new GridBagLayout());
				label = new JLabel("-DIA- " + Integer.toString(cont));
				label.setFont(font);
				label.setForeground(new java.awt.Color(238, 234, 13)); 

				posit = new JTextField();
				dia[i][j].add(label);
				
				GridBagConstraints gb1 = new GridBagConstraints();
				gb1.fill = GridBagConstraints.BOTH;
				gb1.gridx = i;
				gb1.gridy = j;
				gb1.weightx = 1;
				gb1.weighty = 1;
				dia[i][j].setBackground(new java.awt.Color(120, 92, 39   ));

				mes.add(dia[i][j], gb1);
				ventana.getContentPane().add(mes, gb1);
				
				
				GridBagConstraints gb = new GridBagConstraints();
				gb.gridy = 1;
				gb.gridheight = 2;
				gb.gridwidth=2;
				gb.weightx=2;
				gb.weighty=2;
				gb.fill = GridBagConstraints.BOTH;
				posit.setBackground(new java.awt.Color(238, 234, 13));
				dia[i][j].add(posit, gb);

				
				GridBagConstraints boton1 = new GridBagConstraints();
				evento = new MiBoton(posit, i, j);
				boton1.gridx = 0;
				boton1.gridy = 5;
				dia[i][j].add(evento, boton1);

				
				
				GridBagConstraints boton2 = new GridBagConstraints();
				finalizado = new MiBoton2(posit, i , j);
				boton2.gridx = 1;
				boton2.gridy = 5;
				dia[i][j].add(finalizado, boton2);

				dia[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				cont++;
				posit.setEditable(false);
			}
		}
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();

	}

}
