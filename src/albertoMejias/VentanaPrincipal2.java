package albertoMejias;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal2 {

	JFrame ventana = new JFrame();
	JPanel mes;
	JPanel dia [][] = new JPanel[4][7];
	public VentanaPrincipal2() {
		this.ventana = new JFrame("CALENDARIO");
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GridBagLayout layout = new GridBagLayout();
		ventana.getContentPane().setLayout(layout);
		ventana.setDefaultCloseOperation(3);

	}

	public void inicializarComponentes() {
		mes = new JPanel(new GridLayout(4, 7));

		for (int i = 0; i < dia.length; i++) {
			for (int j = 0; j < dia[i].length; j++) {
				GridBagConstraints gb1 = new GridBagConstraints();
				dia [i][j]= new JPanel();
				gb1.fill = GridBagConstraints.BOTH;
				gb1.gridx = i;
				gb1.weightx=1;
				gb1.weighty=1;
				gb1.gridy = j;
				dia[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				mes.add(dia[i][j], gb1);
				ventana.getContentPane().add(mes, gb1);
			}
		}
	}

	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();

	}

}
