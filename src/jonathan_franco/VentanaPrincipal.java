package jonathan_franco;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal {

	private JFrame ventana;
	private JPanel panelFuente;
	private JButton botonDialogo;
	private JLabel texto;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 900, 350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		// Definimos el layout:
		ventana.setLayout(new GridLayout(1, 2));

		// Creamos el boton y lo a�ado a la ventana
		botonDialogo = new JButton("Cambiar fuente");
		ventana.add(botonDialogo);

		// Creamos el panel y lo a�ado a la ventana
		panelFuente = new JPanel();
		panelFuente.setLayout(new GridLayout(1, 1));
		texto = new JLabel("Texto de ejemplo");	
		texto.setHorizontalAlignment(JLabel.CENTER);
		panelFuente.add(texto);
		ventana.add(panelFuente);
	}

	public void inicializarListeners() {
		botonDialogo.addActionListener(e -> {
			DialogFuente dialogo = new DialogFuente(botonDialogo, texto.getFont());
			dialogo.setVisible(true);
			dialogo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {
					texto.setFont(dialogo.fuente);
				}
			});
		});
	}
	
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}
