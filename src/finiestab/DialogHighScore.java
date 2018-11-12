package finiestab;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;


public class DialogHighScore extends JDialog {

	JLabel titulo=new JLabel("PUNTUACIONES");
	
	public DialogHighScore() {
	super();
	setModal(true);
	setBounds(0,0, 300, 500); 
	anadirElementos();
	}

	public void anadirElementos() {
		this.setLayout(new GridBagLayout());
		Font fuente=new Font("Arial", 30, 1);
		titulo.setFont(fuente);
		GridBagConstraints settTitulo= new GridBagConstraints();
		settTitulo.gridx=0;
		settTitulo.gridy=0;
		settTitulo.gridwidth=3;
		settTitulo.weightx=1;
		settTitulo.fill=GridBagConstraints.BOTH;
		this.add(titulo,settTitulo);
	}
	
}
