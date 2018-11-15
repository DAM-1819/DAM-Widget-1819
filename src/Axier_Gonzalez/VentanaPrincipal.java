package Axier_Gonzalez;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame{

	JFrame ventana;
	JPanel panelTitulo;
	JLabel titulo;

	JButton iniciarSesion;

	public VentanaPrincipal() {
		super();
		ventana = new JFrame();
		ventana.setSize(350, 550);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.getContentPane().setBackground(new Color(28, 188, 137));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}

	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		panelTitulo = new JPanel();
		
		titulo = new JLabel("WhatsLogin");
		titulo.setForeground(Color.WHITE);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelTitulo.setLayout(new GridLayout());

		panelTitulo.setBackground(new Color(118, 36, 150));
		panelTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelTitulo.add(titulo);

		GridBagConstraints ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 0;
		ajustes.ipadx = 274;
		ajustes.insets = new Insets(0, 0, 505, 0);
		ajustes.fill = GridBagConstraints.BOTH;		
		ventana.add(panelTitulo, ajustes);

		ajustes = new GridBagConstraints();
		iniciarSesion = new JButton("Iniciar sesion");
		ajustes = new GridBagConstraints();
		ajustes.gridx = 0;
		ajustes.gridy = 1;
		ajustes.insets = new Insets(-550, 0, 0, 0);
		ventana.add(iniciarSesion, ajustes);

	}

	public void inicializarListeners() {
		iniciarSesion.addActionListener(e -> {
			Login log = new Login();
			log.setVisible(true);
			log.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent arg0) {

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
