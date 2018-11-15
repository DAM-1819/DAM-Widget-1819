package RamPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WidgetNoticias extends JPanel implements Runnable {
	int iF;
	JTextArea noticias;
	static ArrayList<String> articulos = new ArrayList<>();
	ArrayList<String> localizaciones = new ArrayList<>();
	ArrayList<String> enlaces= new ArrayList<>();

	public WidgetNoticias() {
		inicializarComponentes();
		inicializarListeners();
	

	}

	public void inicializarComponentes() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		gb.fill = GridBagConstraints.BOTH;
		gb.weightx = 1;
		gb.weighty = 1;
		noticias = new JTextArea("Vacio");
		noticias.setEditable(false);
		noticias.setLineWrap(true);
		noticias.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createBevelBorder(1, Color.BLUE, Color.GRAY));
		Font fuente = new Font("Tahoma", Font.PLAIN, 20);
		noticias.setForeground(Color.WHITE);
		noticias.setFont(fuente);
		this.add(noticias, gb);
		insertarNoticias();
	}

	private void insertarNoticias() {

		

		String url = "https://elpais.com/internacional/";
		String url2 = "https://elpais.com/elpais/ciencia.html";
		String url3 = "https://elpais.com/tecnologia";
		String url4 = "https://elpais.com/politica/";
		
		articulos = obtenerArticulos(url);
		localizaciones = obtenerLocalizaciones(url);
		enlaces= obtenerEnlaces(url);
		System.out.println("entra");
		Thread t = new Thread(this);
		t.start();

	}


	//No funciona
	private ArrayList<String> obtenerEnlaces(String url) {
		ArrayList<String> enlaces = new ArrayList<>();
		Document doc = getHtmlDocument(url);
		// Compruebo si me da un 200 al hacer la petición
		if (getStatusConnectionCode(url) == 200) {

			// Obtengo el HTML de la web en un objeto Document
			Document document = getHtmlDocument(url);

			// Busco todas las entradas que estan dentro de:

			Elements entradas2 = document.select("div.articulo-datos").after("p.articulo-entradilla");
			System.out
					.println("Número de enlaces en la página inicial de El Mundo : " + entradas2.size() + "\n");
			// Paseo cada una de las entradas
			for (Element elem : entradas2) {
				
				String localizacion  = elem.attr("abs:href");
				enlaces.add(localizacion);
				for (int i = 0; i < enlaces.size(); i++) {
					System.out.println(enlaces.get(i));
				}

				// Con el método "text()" obtengo el contenido que hay dentro de las etiquetas
				// HTML
				// Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
			}

			System.out.println(enlaces.size());

			return enlaces;

		} else
			System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		return enlaces;
	}

	private static ArrayList<String> obtenerLocalizaciones(String url) {
		ArrayList<String> localizaciones = new ArrayList<>();
		Document doc = getHtmlDocument(url);
		// Compruebo si me da un 200 al hacer la petición
		if (getStatusConnectionCode(url) == 200) {

			// Obtengo el HTML de la web en un objeto Document
			Document document = getHtmlDocument(url);

			// Busco todas las entradas que estan dentro de:

			Elements entradas2 = document.select("div.articulo-datos").after("p.articulo-entradilla");
			System.out
					.println("Número de Localizaciones en la página inicial de El Mundo : " + entradas2.size() + "\n");
			// Paseo cada una de las entradas
			for (Element elem : entradas2) {

				String localizacion = elem.getElementsByClass("articulo-localizacion").text();
				localizaciones.add(localizacion);

				// Con el método "text()" obtengo el contenido que hay dentro de las etiquetas
				// HTML
				// Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
			}

			System.out.println(localizaciones.size());

			return localizaciones;

		} else
			System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		return localizaciones;

	}

	private static ArrayList<String> obtenerArticulos(String url) {

		Document doc = getHtmlDocument(url);
		// Compruebo si me da un 200 al hacer la petición
		if (getStatusConnectionCode(url) == 200) {

			// Obtengo el HTML de la web en un objeto Document
			Document document = getHtmlDocument(url);

			// Busco todas las entradas que estan dentro de:
			Elements entradas = document.select(".articulo__interior");
			System.out.println("Número de Artículos en la página inicial de El Mundo : " + entradas.size() + "\n");

			// Paseo cada una de las entradas
			for (Element elem : entradas) {
				String articulo = elem.getElementsByClass("articulo-titulo").text();

				articulos.add(articulo);

				// Con el método "text()" obtengo el contenido que hay dentro de las etiquetas
				// HTML
				// Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
			}

			System.out.println(articulos.size());
			return articulos;

		} else
			System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		return articulos;

	}

	public static Document getHtmlDocument(String url) {

		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		} catch (IOException ex) {
			System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
		}
		return doc;
	}

	public static int getStatusConnectionCode(String url) {

		Response response = null;

		try {
			response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
		} catch (IOException ex) {
			System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
		}
		return response.statusCode();
	}

	@Override
	public void run() {
		System.out.println("entro");
		while(true) {
			for ( iF = 0; iF < articulos.size(); iF++) {
				if (iF < localizaciones.size()) {
					String not = localizaciones.get(iF) + " - " + articulos.get(iF) + ".";
					noticias.setText(not);
					System.out.println("entro");
				} else {

					String not = articulos.get(iF) + ".";
					noticias.setText(not);
				}
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		
	}

	public void inicializarListeners() {
		noticias.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://elpais.com/internacional/");
							desktop.browse(uri);

						} catch (URISyntaxException | IOException ex) {

						}
					}
				}

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

			}
		});
	}

}
