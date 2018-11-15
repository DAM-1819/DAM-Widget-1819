package RobertoSanAndres;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargarImagen extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 111742466211189198L;
	String rutaIncial = "\\home\\";
	JPanel panel;
	JLabel label;



	public CargarImagen(JLabel label) {
		super();
		this.label = label;
		this.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser selector = new JFileChooser(rutaIncial);
		selector.setSelectedFile(new File(rutaIncial));
		selector.setDialogTitle("Cargar imagen...");
		selector.setFileFilter(new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif"));
		int fileSelected = selector.showOpenDialog(label);
		if (fileSelected == JFileChooser.APPROVE_OPTION) {
			File imageFile = selector.getSelectedFile().getAbsoluteFile();
			String ruta = imageFile.getAbsolutePath();
			rutaIncial=ruta;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(
					label.getParent().getWidth(), label.getParent().getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(imageIcon);
		}
	}

}
