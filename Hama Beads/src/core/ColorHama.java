package core;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Clase para representar un color Hama.
 * @author areku
 *
 */
public class ColorHama {
	
	/**
	 * Codigo del color.
	 */
	private int cod;
	
	/**
	 * El nombre del color.
	 */
	private String nombre;
	
	/**
	 * Color representado.
	 */
	private Color color;
	
	/**
	 * Obtenemos el codigo del color.
	 * @return El codigo del color.
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 * Obtenemos el nombre del color.
	 * @return El nombre del color.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtenemos el color.
	 * @return El color.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Mapa de colores 
	 */
	private static HashMap<Integer,ColorHama> mapaColores;
	
	public static final int NO_COLOR = 0;
	
	private static final String RUTA_XML = "res/hama.xml";
	
	/**
	 * Grabamos un nuevo color.
	 * @param cod El codigo del color.
	 * @param nombre El nombre del color.
	 * @param color El color en RGB.
	 */
	public ColorHama(int cod,String nombre,Color color) {
		this.cod = cod;
		this.nombre = nombre;
		this.color = color;
	}
	
	/**
	 * Grabamos un nuevo color.
	 * @param cod El código del color.
	 * @param nombre El nombre del color.
	 * @param r Componente R
	 * @param g Componente G
	 * @param b Componente B
	 */
	public ColorHama(int cod,String nombre,int r,int g,int b) {
		this(cod,nombre,new Color(r, g, b));
	}
	
	/**
	 * Leemos la lista de colores Hama.
	 * @param xml La ruta del archivo xml.
	 * @return El mapa de colores.
	 */
	private static HashMap<Integer,ColorHama> leerXml(String xml) {
		SAXBuilder builder = new SAXBuilder();
		File f = new File(xml);
		HashMap<Integer,ColorHama> mapaColores = new HashMap<Integer, ColorHama>();
		try {
			Document document = (Document) builder.build(f);
			Element rootNode = document.getRootElement();
			List<Element> colores = rootNode.getChildren("color");
			for (Element e : colores) {
				ColorHama color = leerElemento(e);
				mapaColores.put(color.getCod(), color);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mapaColores;
	}
	
	/**
	 * Leemos un color Hama del documento XML.
	 * @param e El elemento XML.
	 * @return El color Hama.
	 */
	private static ColorHama leerElemento(Element e) {
		String r = e.getChildText("r");
		String g = e.getChildText("g");
		String b = e.getChildText("b");
		String name = e.getChildText("name");
		
		try {
			Color color = new Color(Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b));
			int index = name.indexOf(' ');
			String cod = name.substring(0,index);
			String nombre = name.substring(index);
			return new ColorHama(Integer.parseInt(cod), nombre, color);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Devuelve el mapa de colores de Hama.
	 * @return El mapa de colores de Hama.
	 */
	public static HashMap<Integer,ColorHama> getMapaColores() {
		if (mapaColores == null) {
			mapaColores = leerXml(RUTA_XML);
		}
		return mapaColores;
	}
	
	
}
