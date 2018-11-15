package Roberto_Gonzalez_Martin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
		titulo = new JTextField("Editor de la resolución de la ventana y el color de fondo y texto");
		titulo.setEditable(false);
		settingsObjeto.gridx = 0;
		settingsObjeto.gridy = 0;
		frame.add(titulo,settingsObjeto);
		texto = new JTextField("Este widget está hecho para cambiar el tamaño de la ventana, el color de la letra y el color del fondo a tu gusto");
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
				DialogSelectorColorDimension dialogo = new DialogSelectorColorDimension(frame,titulo,texto);
			}
		});
	}

	public void inicializar() {
		frame.setVisible(true);
		inicializarComponentes();
		inicializarListener();
	}
}
