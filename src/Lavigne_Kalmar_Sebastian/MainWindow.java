package Lavigne_Kalmar_Sebastian;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
*@author Sebas Lavigne
*
*/

public class MainWindow {
	
	private JFrame window;
	private PumpSlider pump;
	private JPanel panelColor;

	public MainWindow() {
		window = new JFrame();
		window.setBounds(100, 50, 400, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initializeComponents() {
		window.setLayout(new GridBagLayout());
		GridBagConstraints settings;
		
		//Bomba
		pump = new PumpSlider();
		pump.setMaxValue(255);
		pump.setInitValue(127);
		pump.initialize();
		
		settings = new GridBagConstraints();
		window.add(pump, settings);
		
		//Cuadro de color
		panelColor = new JPanel();
		panelColor.setBackground(Color.BLACK);
		
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.ipadx = 100;
		settings.ipady = 100;
		settings.fill = GridBagConstraints.BOTH;
		window.add(panelColor, settings);
	}
	
	public void initializeListeners() {
		pump.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				panelColor.setBackground(new Color(pump.getValue(), 0, 0));
			}
		});
	}
	
	public void initialize() {
		window.setVisible(true);
		initializeComponents();
		initializeListeners();
	}
}

