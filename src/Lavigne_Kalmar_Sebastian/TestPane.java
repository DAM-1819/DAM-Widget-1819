package Lavigne_Kalmar_Sebastian;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
*@author Sebas Lavigne
*
*/

public class TestPane extends JPanel {

    private BufferedImage img;
    private Point imgPoint;

    public TestPane() {
        try {
            img = ImageIO.read(new File("Computer.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imgPoint = new Point(100-img.getWidth()/2, 0);

        MouseAdapter ma = new MouseAdapter() {

            private Point offset;

            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle bounds = getImageBounds();
                Point mp = e.getPoint();
                if (bounds.contains(mp)) {
                    offset = new Point();
                    offset.x = mp.x - bounds.x;
                    offset.y = mp.y - bounds.y;
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
                    keepWithin();
                    repaint();
                }
            }

        };
        addMouseListener(ma);
        addMouseMotionListener(ma);
    }
    
    private void keepWithin() {
    	Rectangle bounds = getImageBounds();
    	if (imgPoint.y < 0) {
			imgPoint.y = 0;
		}
    	if (imgPoint.y > bounds.getHeight()) {
    		imgPoint.y = (int) bounds.getHeight();
    	}
    }

    protected Rectangle getImageBounds() {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        if (img != null) {
            bounds.setLocation(imgPoint);
            bounds.setSize(img.getWidth(), img.getHeight());
        }
        return bounds;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, imgPoint.x, imgPoint.y, this);
            g2d.dispose();
        }
    }
}