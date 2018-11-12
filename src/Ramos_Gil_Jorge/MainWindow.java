package Ramos_Gil_Jorge;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame jframe;
	private JLabel[][] jlabel = new JLabel[3][3];
	private int i;
	private int j;
	
	public MainWindow() {
		jframe = new JFrame("Principal");
		jframe.setBounds(0, 0, 800, 600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes() {
		
		GridBagConstraints settings;
		jframe.setLayout(new GridBagLayout());
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				jlabel[i][j] = new JLabel("Añade una nota");
				settings = new GridBagConstraints();
				settings.gridx = i;
				settings.gridy = j;
				jlabel[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (e.getButton() == MouseEvent.BUTTON1) {
							jlabel[i][j].setVisible(false);
							System.out.println(i);
							System.out.println(j);
							jframe.remove(jlabel[i][j]);
						}
					}
				});
				jframe.add(jlabel[i][j], settings);
			}
		}
	}
	
	public void inicializar() {
		jframe.setVisible(true);
		inicializarComponentes();
	}
}