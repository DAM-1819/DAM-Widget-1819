package Ramos_Gil_Jorge;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame jframe;
	private JButton[][] jbutton;
	private int i;
	private int j;
	
	public MainWindow() {
		jframe = new JFrame("Principal");
		jframe.setBounds(0, 0, 600, 600);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void inicializarComponentes() {
		
		GridBagConstraints settings;
		jframe.setLayout(new GridBagLayout());
		jbutton = new JButton[3][3];
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				jbutton[i][j] = new JButton("A�ade una nota");
				jbutton[i][j].setBackground(Color.decode("#C0FFDE"));
				settings = new GridBagConstraints();
				settings.gridx = i;
				settings.gridy = j;
				settings.ipady = 165;
				settings.ipadx = 75;
				settings.fill = GridBagConstraints.BOTH;
				jframe.add(jbutton[i][j], settings);
			}
		}
	}
	
	public void inicializarListeners() {
		
		for (i = 0; i < jbutton.length; i++) {
			for (j = 0; j < jbutton[i].length; j++) {
				
		jbutton[i][j].addActionListener(new ActionListener() {
			private int indexx;
			
			{
                this.indexx = i;
            }
			
			private int indexy;
			
			{
                this.indexy = j;
            }
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jbutton[indexx][indexy].setVisible(false);
				jframe.remove(jbutton[indexx][indexy]);
				jframe.revalidate();
				jframe.repaint();
				JTextArea jtextarea = new JTextArea();
				jtextarea.setLineWrap(true);
				jtextarea.setWrapStyleWord(true);
				jtextarea.setBackground(Color.decode("#C0FEFF"));
				GridBagConstraints settings;
				settings = new GridBagConstraints();
				settings.gridx = indexx;
				settings.gridy = indexy;
				settings.fill = GridBagConstraints.BOTH;
				jframe.add(jtextarea, settings);
				jtextarea.addMouseListener(new MouseListener() {
					
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
						if (e.getButton() == MouseEvent.BUTTON3) {
							String opciones[] = {"Cambiar color","Eliminar nota"};
							int answer = JOptionPane.showOptionDialog(jframe, "�Qu� deseas hacer?", 
														"Enhorabuena", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
							
							if (answer == 0) {
								MyDialog dialog = new MyDialog(jtextarea);
								dialog.setVisible(true);
							} else if (answer == 1) {
								jtextarea.setVisible(false);
								jframe.remove(jtextarea);
								jframe.revalidate();
								jframe.repaint();
								GridBagConstraints settings;
								settings = new GridBagConstraints();
								settings.gridx = indexx;
								settings.gridy = indexy;
								settings.ipady = 165;
								settings.ipadx = 75;
								settings.fill = GridBagConstraints.BOTH;
								jbutton[indexx][indexy].setVisible(true);
								jframe.add(jbutton[indexx][indexy], settings);
							}
						}
					}
				});
			}
		});
			}
		}
	}
	
	public void inicializar() {
		jframe.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
}