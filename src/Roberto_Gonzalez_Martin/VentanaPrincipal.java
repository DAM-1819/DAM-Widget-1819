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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField titulo;
	private JTextField contenido;
	private JButton widget;

	public VentanaPrincipal() {
		frame = new JFrame("Widget Roberto González Martín");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void inicializarComponentes() {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints settingsObjeto = new GridBagConstraints();
		titulo = new JTextField("Página de ejemplo");
		titulo.setEditable(false);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 0;
		settingsObjeto.weightx = 4;
		settingsObjeto.weighty = 1;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		frame.add(titulo,settingsObjeto);
		contenido = new JTextField(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry./n"
				+"/n Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,when an unknown printer took a galley of type and scrambled it to make a type specimen book."
				+"/n It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
				+"/n It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, "
				+"/n and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		contenido.setEditable(false);
		contenido.setHorizontalAlignment(SwingConstants.CENTER);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 1;
		settingsObjeto.weightx = 4;
		settingsObjeto.weighty = 10;
		settingsObjeto.fill = GridBagConstraints.BOTH;
		frame.add(contenido,settingsObjeto);
		widget = new JButton("Widget");
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 3;
		settingsObjeto.weightx = 1;
		settingsObjeto.weighty = 1;
		frame.add(widget,settingsObjeto);
	}

	public void inicializarListener() {
		widget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogSelectorColorDimension selector = new DialogSelectorColorDimension();
			}
		});
	}

	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		inicializarListener();
	}
}
