package Lavigne_Kalmar_Sebastian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Este panel contiene un valor que va disminuyendo debido a una "fuga". Si se quiere "inflar" el valor
 * debe arrastrarse la manija de la bomba con el ratón de arriba a abajo.
 * 
 * Los valores que definen la bomba de aire se pueden ajustar: su valor máximo, la velocidad de escape,
 * la cantidad que se escapa, la fuerza necesaria para inflar, la cantidad que se infla...
 * 
 * Se puede observar el valor que tiene la bomba en cualquier momento con el método {@link #getValue()},
 * pero la forma de ligar este valor como control de otra parte del programa es mediante un {@link PropertyChangeListener}
 * 
 * Un ejemplo de uso de este componente:
 * <pre>{@code
 * public void inicializarBomba(){
		PumpSlider pump = new PumpSlider();
		
		//El cambio de propiedades es opcional
		pump.setMaxValue(310);
		pump.setInitValue(42);
		pump.setLeakRate(100);
		pump.setLeakAmount(3);
		pump.setPumpForce(5);
		pump.setPumpAmount(10);
		
		//Se debe inicializar la bomba
		pump.initialize();
		
		//Y para ligarla con otra parte de nuestro programa se añade un Listener
		pump.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				//Acción que ocurre cada vez que cambia el valor de la bomba
			}
		});
 * }</pre>
 * @author Sebas Lavigne
 */
public class PumpSlider extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int PANEL_WIDTH = 140;
	public static final int PANEL_HEIGHT = 160;
	/* Rectangulo define limites de movimiento de la imagen. Solo se usa la vertical */
	public static final Rectangle PUMP_TRAVEL = new Rectangle(0, 20, 0, 27);
	
	public static final int BAR_WIDTH = 10;
	public static final int BAR_HEIGHT = 60;
	public static final int BAR_X_OFFSET = 58;
	public static final int BAR_Y_OFFSET = 75;
	public static final int NUMBER_X_OFFSET = 100;
	public static final int NUMBER_Y_OFFSET = 50;
	
	public static final int DEFAULT_LEAK_RATE = 200;
	public static final int DEFAULT_LEAK_AMOUNT = 1;
	public static final int DEFAULT_MAX_VALUE = 100;
	public static final int DEFAULT_PUMP_FORCE = 2;
	public static final int DEFAULT_PUMP_AMOUNT = 1;
	public static final int DEFAULT_INIT_VALUE = 0;
	
	private BufferedImage handle;
	private BufferedImage body;
	private Point imgPoint;
	
	/* La barra que representa el valor del componente */
	private Rectangle valueBar;
	
	/* El valor que tiene este componente. */
	private int value;
	/* El valor maximo que puede tener este componente */
	private int maxValue;
	private int initValue;
	
	// https://www.baeldung.com/java-observer-pattern
	private PropertyChangeSupport support;
	
	/* Timer que controla la "perdida de presion" */
	private Timer leakTimer;
	/* El periodo en que salta el Timer */
	private int leakRate;
	/* La cantidad que se pierde cada vez que salta el Timer */
	private int leakAmount;
	/* La "fuerza" que hace falta para incrementar el valor
	 * Se traduce en la velocidad a la que hay que mover el raton */
	private int pumpForce;
	private int pumpAmount;

	public PumpSlider() {
		initValue = DEFAULT_INIT_VALUE;
		maxValue = DEFAULT_MAX_VALUE;
		leakRate = DEFAULT_LEAK_RATE;
		leakAmount = DEFAULT_LEAK_AMOUNT;
		pumpForce = DEFAULT_PUMP_FORCE;
		pumpAmount = DEFAULT_PUMP_AMOUNT;
		initialize();
		leakTimer.start();
		
	}
	
	public void initialize() {
		value = initValue;
		try {
			handle = ImageIO.read(Main.class.getResource("pumphandle.png"));
			body = ImageIO.read(Main.class.getResource("pumpbody.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Establece el punto en que se dibuja la imagen
		imgPoint = new Point(PANEL_WIDTH/2 - handle.getWidth()/2, (int) PUMP_TRAVEL.getMinY());
		//Establece el tamano para dibujar la barra de valor
		valueBar = new Rectangle();
		resizeValueBar();
		
		support = new PropertyChangeSupport(this);
		
		ActionListener leakListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				keepValueWithinLimits(value - leakAmount);
				resizeValueBar();
				repaint();
			}
		};
		
		leakTimer = new Timer(leakRate, leakListener);
		
		MouseAdapter ma = new MouseAdapter() {

            private Point offset;
            private int lastY;

            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle bounds = getImageBounds();
                Point mp = e.getPoint();
                if (bounds.contains(mp)) {
                    offset = new Point();
                    offset.x = mp.x - bounds.x;
                    offset.y = mp.y - bounds.y;
                    lastY = imgPoint.y;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                offset = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (offset != null) {
                    Point mp = e.getPoint();
//                    imgPoint.x = mp.x - offset.x;
                    imgPoint.y = mp.y - offset.y;
                    keepPumpWithinLimits();
                    if (imgPoint.y - lastY > pumpForce) {
						pumpValue();
					}
                    lastY = imgPoint.y;
                    repaint();
                }
            }

        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
	}
	
	/**
	 * Establece el tamano de la barra de valor acorde con el valor
	 * que tiene el objeto en este momento
	 * Se calcula de tal manera que el lado inferior sea siempre el mismo
	 * y la barra "se rellene hacia arriba"
	 */
	private void resizeValueBar() {
		int height = (int) (BAR_HEIGHT * ((double)value / (double)maxValue));
		
		valueBar.setBounds(
				BAR_X_OFFSET,
				BAR_HEIGHT - height + BAR_Y_OFFSET,
				BAR_WIDTH,
				height
				);
	}
	
	/**
	 * Asigna un nuevo valor a value
	 * Mantiene el valor entre 0 y maximo
	 * @param newValue el nuevo valor que se quiere asignar
	 */
	private void keepValueWithinLimits(int newValue) {
		newValue = (newValue < 0) ? 0 : newValue;
		newValue = (newValue > maxValue) ? maxValue : newValue;
		setValue(newValue);
	}
	
	/**
	 * "Infla" el valor de la bomba
	 */
	private void pumpValue() {
		keepValueWithinLimits(value + pumpAmount);
	}
	
	/**
	 * Mantiene el grafico de la manija de la bomba dentro de un cuadro
	 */
	private void keepPumpWithinLimits() {
		if (imgPoint.y < PUMP_TRAVEL.getMinY()) {
			imgPoint.y = (int) PUMP_TRAVEL.getMinY();
		}
		if (imgPoint.y > PUMP_TRAVEL.getMaxY()) {
			imgPoint.y = (int) PUMP_TRAVEL.getMaxY();
		}
	}
	
	/**
	 * Obtiene la posicion y las dimensiones de la imagen si existe
	 * @return el rectangulo contenedor de la imagen
	 */
	protected Rectangle getImageBounds() {
		Rectangle bounds = new Rectangle(0, 0, 0, 0);
		if (handle != null) {
			bounds.setLocation(imgPoint);
			bounds.setSize(handle.getWidth(), handle.getHeight());
		}
		return bounds;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
	}
	
	/**
	 * Pinta en el JPanel las dos imagenes que componen la bomba,
	 * una barra de cantidad y el valor del componente
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (handle != null) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.drawImage(handle, imgPoint.x, imgPoint.y, this);
			g2d.drawImage(body, PANEL_WIDTH/2 - handle.getWidth()/2, (int) PUMP_TRAVEL.getMinY() + 38, this);
			g2d.setColor(Color.WHITE);
			g2d.fill(valueBar);
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			g2d.drawString(value+"", NUMBER_X_OFFSET, NUMBER_Y_OFFSET);
			g2d.dispose();
		}
	}

	/**
	 * Establece un listener para el valor de este componente
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Desvincula un listener para el valor de este componente
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	/**
	 * Lanza un evento PropertyChangeEvent y actualiza el valor del componente
	 * @param value el nuevo valor que tendra el componente
	 */
	private void setValue(int value) {
		support.firePropertyChange("value", this.value, value);
		this.value = value;
	}
	
	/**
	 * @return el valor de este componente
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the maxValue
	 */
	public int getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the leakRate
	 */
	public int getLeakRate() {
		return leakRate;
	}

	/**
	 * @param leakRate the leakRate to set
	 */
	public void setLeakRate(int leakRate) {
		this.leakRate = leakRate;
	}

	/**
	 * @return the leakAmount
	 */
	public int getLeakAmount() {
		return leakAmount;
	}

	/**
	 * @param leakAmount the leakAmount to set
	 */
	public void setLeakAmount(int leakAmount) {
		this.leakAmount = leakAmount;
	}

	/**
	 * @return the pumpForce
	 */
	public int getPumpForce() {
		return pumpForce;
	}

	/**
	 * @param pumpForce the pumpForce to set
	 */
	public void setPumpForce(int pumpForce) {
		this.pumpForce = pumpForce;
	}

	/**
	 * @return the pumpAmount
	 */
	public int getPumpAmount() {
		return pumpAmount;
	}

	/**
	 * @param pumpAmount the pumpAmount to set
	 */
	public void setPumpAmount(int pumpAmount) {
		this.pumpAmount = pumpAmount;
	}

	/**
	 * @return the initValue
	 */
	public int getInitValue() {
		return initValue;
	}

	/**
	 * @param initValue the initValue to set
	 */
	public void setInitValue(int initValue) {
		this.initValue = initValue;
	}
	
}
