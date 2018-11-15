package jonathan_franco;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class DialogFuente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton botonAceptar, botonCambiar;
	private JComboBox combo;
	private JLabel texto;
	private String fuentes[];
	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Font fuente;

	public DialogFuente(JComponent componente, Font fuenteInicial) {
		super();
		setModal(true); // PARA HACERLO MODAL
		setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 300, 500);
		this.fuente = fuenteInicial;
		fuentes = environment.getAvailableFontFamilyNames();
		anadirElementos();
		anadirListeners();
	}

	public void anadirElementos() {
		this.setLayout(new GridBagLayout());
		
		combo = new JComboBox(fuentes);
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.insets = new Insets(20, 0, 50, 0);
		add(combo, settings);
		
		botonCambiar = new JButton("Cambiar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(20, 0, 50, 0);
		add(botonCambiar, settings);
		
		texto = new JLabel("Texto de ejemplo");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		settings.insets = new Insets(20, 0, 50, 0);
		add(texto, settings);

		botonAceptar = new JButton("Aceptar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		settings.insets = new Insets(20, 0, 50, 0);
		add(botonAceptar, settings);
	}

	public void anadirListeners() {
		botonCambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font(fuentes[combo.getSelectedIndex()],Font.PLAIN, 16));
			}
		});
		botonAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fuente = texto.getFont();
		this.dispose();
	}
}
