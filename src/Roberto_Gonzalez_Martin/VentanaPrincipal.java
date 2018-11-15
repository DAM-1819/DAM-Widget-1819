package Roberto_Gonzalez_Martin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal {

	private JFrame frame;
	private JButton widget;
	private JTextField titulo;
	private JTextField texto;

	public VentanaPrincipal() {
		frame = new JFrame("Widget Roberto González Martín");
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints settingsObjeto = new GridBagConstraints();
		titulo = new JTextField("Editor de las dimensiones de ventana y el color de fondo y texto");
		titulo.setEditable(false);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 0;
		frame.add(titulo,settingsObjeto);
		texto = new JTextField("Este widget está hecho para cambiar el tamaño de la ventana y el color de la letra y el fondo a su gusto");
		texto.setEditable(false);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 1;
		frame.add(texto,settingsObjeto);
		widget = new JButton("Widget");
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 2;
		frame.add(widget,settingsObjeto);
	}

	public void inicializarListener() {
		widget.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogSelectorColorDimension dialogo = new DialogSelectorColorDimension();
			}
		});
	}

	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		inicializarListener();
	}
}
