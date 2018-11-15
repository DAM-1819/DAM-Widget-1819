package Carretero_Miranda_Victor;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MiBoton extends JButton implements ActionListener, MouseListener{

	JPanel panelAsociado;
	static Color color = Color.BLACK;
	static DialogSelectorColor dialogo = new DialogSelectorColor();
	
	public MiBoton(JPanel panelAsociado, String texto) {
		super(texto);
		this.panelAsociado = panelAsociado;
		this.addActionListener(this);
		this.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialogo.cambioColor.setBackground(Color.white);
		panelAsociado.setBackground(dialogo.getColor());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.isMetaDown()) {
			dialogo.inicializar();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
