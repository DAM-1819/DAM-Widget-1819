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
*@author Sebas Lavigne
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
	public static final int INIT_VALUE = 50;
	
	private BufferedImage handle;
	private BufferedImage body;
	private Point imgPoint;
	
	/* La barra que representa el valor del componente */
	private Rectangle valueBar;
	
	/* El valor que tiene este componente. */
	private int value;
	/* El valor maximo que puede tener este componente */
	private int maxValue;
	
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
		value = INIT_VALUE;
		maxValue = DEFAULT_MAX_VALUE;
		leakRate = DEFAULT_LEAK_RATE;
		leakAmount = DEFAULT_LEAK_AMOUNT;
		pumpForce = DEFAULT_PUMP_FORCE;
		pumpAmount = DEFAULT_PUMP_AMOUNT;
		initPumpSlider();
		leakTimer.start();
		
	}
	
	private void initPumpSlider() {
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
				setValue(value - leakAmount);
				keepValueWithinLimits();
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
	 * Mantiene el valor siempre entre los valores 0 y maximo
	 */
	private void keepValueWithinLimits() {
		setValue(value < 0 ? 0 : value);
		setValue(value > maxValue ? maxValue : value);
	}
	
	private void pumpValue() {
		setValue(value + pumpAmount);
		keepValueWithinLimits();
	}
	
	private void keepPumpWithinLimits() {
		if (imgPoint.y < PUMP_TRAVEL.getMinY()) {
			imgPoint.y = (int) PUMP_TRAVEL.getMinY();
		}
		if (imgPoint.y > PUMP_TRAVEL.getMaxY()) {
			imgPoint.y = (int) PUMP_TRAVEL.getMaxY();
		}
	}
	
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
}
