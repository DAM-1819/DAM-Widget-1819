package Blanca_Erdieta;



import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class TamañoPincel extends JDialog implements ActionListener{

JButton aceptar;
JPanel contenedor;
JPanel panelContenedor;
JSlider slider;
JPanel panelSlider;
JPanel panelAceptar;
Image img;
JLabel jlabel;
ImageIcon imagen;

	
	public TamañoPincel() {
		super();
		setModal(true); // PARA HACERLO MODAL
		setBounds(0,0,300, 500);
		
		anadirElementos();
		anadirListeners();
		
	}
	



	public JLabel agregarImagen() {
		 	JLabel jlabel2 = new JLabel();
		 	
			  img = new javax.swing.ImageIcon(getClass().getResource("descarga.png")).getImage();
			 
			  imagen=new ImageIcon(img.getScaledInstance(255, 255, Image.SCALE_SMOOTH));

			   jlabel2.setIcon(imagen);
			   
			   return jlabel2;
		
		
	}

	
	public ImageIcon getImagen() {
		return imagen;
	}



	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	private void anadirElementos() {
		aceptar = new JButton("Aceptar");
		contenedor= new JPanel();
		panelContenedor = new JPanel();
		panelAceptar = new JPanel();
		panelSlider = new JPanel();
		slider = new JSlider();
		slider.setMaximum(254);
		slider.setMinimum(10);
		slider.setValue(255);
		contenedor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlabel=agregarImagen();
		contenedor.setLayout( new GridLayout(1,1));
		contenedor.add(jlabel);
		panelSlider.add(slider);
		panelAceptar.add(aceptar);
		
		
		panelContenedor.setLayout( new GridLayout(1,1));
		
		panelContenedor.add(contenedor);
		
		
		this.setLayout( new GridBagLayout());
		GridBagConstraints settingObject = new GridBagConstraints();
		settingObject.gridx=0;
		settingObject.gridy=0;
		settingObject.weightx=0;
		settingObject.weighty=1;
		settingObject.fill=GridBagConstraints.NONE;
		this.add(panelContenedor,settingObject);
		settingObject.gridx=0;
		settingObject.gridy=1;
		settingObject.weightx=0;
		settingObject.weighty=1;
		settingObject.fill=GridBagConstraints.NONE;
		this.add(panelSlider,settingObject);
		settingObject.gridx=0;
		settingObject.gridy=2;
		settingObject.weightx=0;
		settingObject.weighty=1;
		settingObject.fill=GridBagConstraints.NONE;
		this.add(panelAceptar,settingObject);
		
	}


	private void anadirListeners() {
		
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				imagen=new ImageIcon(img.getScaledInstance(jlabel.getHeight(), jlabel.getWidth(), Image.SCALE_SMOOTH));
				jlabel.setBounds(0, 0, slider.getValue(),slider.getValue());
				jlabel.setIcon(imagen);

			}
		});
		 aceptar.addActionListener(this);
		

	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
		
	}
}