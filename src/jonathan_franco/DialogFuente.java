package jonathan_franco;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DialogFuente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton botonAceptar, botonCambiar;
	private JComboBox combo;
	private JLabel texto, tamanio, imagen;
	private String fuentes[];
	private JSlider sliderTamanio;
	private int valor;
	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Font fuente;

	public DialogFuente(JComponent componente, Font fuenteInicial) {
		super();
		setModal(true); // PARA HACERLO MODAL
		setBounds((int) componente.getLocationOnScreen().getX(), (int) componente.getLocationOnScreen().getY(), 500, 800);
		this.fuente = fuenteInicial;
		fuentes = environment.getAvailableFontFamilyNames();
		anadirElementos();
		anadirListeners();
	}

	public void anadirElementos() {
		this.setLayout(new GridBagLayout());
		
		ImageIcon image = new ImageIcon(("src/jonathan_franco/fuente.png"));
		imagen = new JLabel(image);
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		add(imagen, settings);
		
		combo = new JComboBox(fuentes);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.insets = new Insets(20, 0, 50, 0);
		add(combo, settings);
		
		sliderTamanio = new JSlider(0, 50);
		sliderTamanio.setMinorTickSpacing(1);
		sliderTamanio.setMajorTickSpacing(50);
		sliderTamanio.setPaintTicks(true);
		sliderTamanio.setPaintLabels(true);
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		add(sliderTamanio,settings);
		
		tamanio = new JLabel("0");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
		add(tamanio, settings);
		
		botonCambiar = new JButton("Cambiar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 4;
		settings.insets = new Insets(20, 0, 50, 0);
		add(botonCambiar, settings);
		
		texto = new JLabel("Texto de ejemplo");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 5;
		settings.insets = new Insets(20, 0, 50, 0);
		add(texto, settings);

		botonAceptar = new JButton("Aceptar");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 6;
		settings.insets = new Insets(20, 0, 50, 0);
		add(botonAceptar, settings);
	}

	public void anadirListeners() {
		sliderTamanio.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				valor = sliderTamanio.getValue();
				String valorTexto = String.valueOf(valor);
				tamanio.setText(valorTexto);
			}
		});
		botonCambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font(fuentes[combo.getSelectedIndex()],Font.PLAIN, valor));
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
