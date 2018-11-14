package jonathan_franco;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogFuente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel titulo, lFuente, texto1, label2;
	JButton botonAceptar, bFuente1, botonBoton;
	JLabel mostradorFuente;
	
	Font fuente0=new Font("Arial", Font.ITALIC, 15);
    Font fuente1=new Font("Tahoma", Font.BOLD, 50);
    Font fuente2=new Font("Times New Roman", Font.PLAIN, 10);
    
    Font fuente;

	public DialogFuente(JComponent componente, Font fuenteInicial) {
		super();
		setModal(true); // PARA HACERLO MODAL
		setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 300, 500);
		this.fuente = fuenteInicial;
		anadirElementos();
		anadirListeners();
	}

	public void anadirElementos() {
		this.setLayout(new GridBagLayout());

		// PANEL PRINCIPAL
		// Titulo
		/*
		titulo = new JLabel("Editor de texto:");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(20, 0, 50, 0);
		add(titulo, settings);
		
		JLabel label1 = new JLabel("Etiqueta con otra fuente");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(20, 0, 50, 0);
		label1.setFont(fuente0);
	    add(label1, settings);
		*/
		// Rojo
	    /*
		lFuente = new JLabel("Selecciona la fuente: ");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		add(lFuente, settings);
		*/
	    
		label2 = new JLabel("Fuente 1");
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
	    // lblEtiquetaConOtra_1.setBounds(56, 163, 350, 36);
		label2.setFont(fuente1);
	    add(label2, settings);
		
	    /*
		texto1 = new JLabel("Texto de ejemplo");
		texto1.setFont(fuente);
		bFuente1 = new JButton(texto1.toString());
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		add(bFuente1,settings);
		*/
	    
		botonAceptar = new JButton("Aceptar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
	    // btnBotonConDistinta.setBounds(56, 101, 218, 23);
		//botonBoton.setFont(fuente1);
	    add(botonAceptar, settings);
	}
	

	public void anadirListeners() {

		botonAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fuente = label2.getFont();
		this.dispose();
		
	}
}
