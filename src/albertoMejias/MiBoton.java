package albertoMejias;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MiBoton extends JButton implements MouseListener, ActionListener{
	JTextField posit;
	int i, j;
	
	
	public MiBoton(JTextField posit, int col,int fila ) {
		super(" Nuevo evento ");
		this.posit = posit;
		col = i;
		fila = j;
		this.addMouseListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			posit.setEditable( true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
