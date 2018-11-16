package Ramos_Gil_Jorge;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel jlabelseleccion;
	private JLabel jlabelrojo;
	private JSlider jsliderrojo;
	private JLabel jlabelverde;
	private JSlider jsliderverde;
	private JLabel jlabelazul;
	private JSlider jsliderazul;
	private JPanel jpanelcolor;
	private JButton jbuttonaceptar;
	private JTextArea jtextarea;
	
	public MyDialog(JTextArea jtextarea) {
		super();
		setModal(true);
		setBounds(0, 0, 400, 600);
		addElements();
		addListeners();
		this.jtextarea = jtextarea;
	}
	
	public void addElements() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		this.jlabelseleccion = new JLabel("Selecciona tu color");
		this.add(jlabelseleccion, settings);
		
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		this.jlabelrojo = new JLabel("Nivel de rojo");
		this.add(jlabelrojo, settings);
		
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 2;
		this.jsliderrojo = new JSlider(0, 255);
		this.jsliderrojo.setPaintTicks(true);
		this.jsliderrojo.setPaintLabels(true);
	    this.jsliderrojo.setMajorTickSpacing(255);
	    this.jsliderrojo.setMinorTickSpacing(0);
	    this.add(jsliderrojo, settings);
	    
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 3;
	    this.jlabelverde = new JLabel("Nivel de verde");
	    this.add(jlabelverde, settings);
	    
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 4;
		this.jsliderverde = new JSlider(0, 255);		
		this.jsliderverde.setPaintTicks(true);
		this.jsliderverde.setPaintLabels(true);
	    this.jsliderverde.setMajorTickSpacing(255);
	    this.jsliderverde.setMinorTickSpacing(0);
	    this.add(jsliderverde, settings);
	    
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 5;
	    this.jlabelazul = new JLabel("Nivel de azul");
	    this.add(jlabelazul, settings);
	    
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 6;
		this.jsliderazul = new JSlider(0, 255);
		this.jsliderazul.setPaintTicks(true);
		this.jsliderazul.setPaintLabels(true);
	    this.jsliderazul.setMajorTickSpacing(255);
	    this.jsliderazul.setMinorTickSpacing(0);
	    this.add(jsliderazul, settings);
	    
	    jpanelcolor = new JPanel();
	    Color color = new Color(jsliderrojo.getValue(), jsliderverde.getValue(), jsliderazul.getValue());
	    jpanelcolor.setBackground(color);
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 7;
		settings.ipady = 50;
		settings.fill = GridBagConstraints.BOTH;
	    this.add(jpanelcolor, settings);
	    
	    jbuttonaceptar = new JButton("Aceptar");
	    settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 8;
	    this.add(jbuttonaceptar, settings);
	}
	
	public void addListeners() {
		
		jsliderrojo.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Color color = new Color(jsliderrojo.getValue(), jsliderverde.getValue(), jsliderazul.getValue());
			    jpanelcolor.setBackground(color);
			}
		});
		jsliderverde.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Color color = new Color(jsliderrojo.getValue(), jsliderverde.getValue(), jsliderazul.getValue());
			    jpanelcolor.setBackground(color);
			}
		});
		jsliderazul.addChangeListener(new ChangeListener() {
	
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Color color = new Color(jsliderrojo.getValue(), jsliderverde.getValue(), jsliderazul.getValue());
				jpanelcolor.setBackground(color);
			}
		});
		jbuttonaceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color = new Color(jsliderrojo.getValue(), jsliderverde.getValue(), jsliderazul.getValue());
				jtextarea.setForeground(color);
				dispose();
			}
		});
	}
}
