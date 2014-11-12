package gui;

import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

import core.ColorHama;

/**
 * Creamos un JPanel para dibujar el selector de colores.
 * 
 * @author Alejandro Pérez Manzano
 *
 */
public class PanelColores extends JPanel {
	
	private static final long serialVersionUID = -260780171986806918L;
	
	/**
	 * Ancho para el selector de colores.
	 */
	private static final int WIDTH = 700;
	/**
	 * Alto para el selector de colores.
	 */
	private static final int HEIGHT = 50;
	/**
	 * Número de columnas para los colores favoritos.
	 */
	private static final int NUM_COLUMNAS = 10;
	/**
	 * Número de filas para los colores favoritas.
	 */
	private static final int NUM_FILAS = 2;
	
	/**
	 * El mapa de colores Hama.
	 */
	private HashMap<Integer,ColorHama> mapaColores;
	
	//TODO: Un selector para los colores.
	
	/**
	 * Creamos un panel para el selector de colores.
	 */
	public PanelColores() {
		mapaColores = ColorHama.getMapaColores();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double alpha = 0.9;
		double w = WIDTH / (NUM_COLUMNAS + (NUM_COLUMNAS + 1) * alpha);
		double gapX = alpha * w;
		double dx = w + gapX;
		double gapY = (HEIGHT - NUM_FILAS * w) / (NUM_FILAS + 1);
		double dy = w + gapY;
		double x = 0;
		double y = 0;
		
		for (int i=0;i<NUM_FILAS;i++) {
			x = 0;
			y += dy;
			for (int j=0;j<NUM_COLUMNAS;j++) {
				x += dx;
				g.drawRect((int)x, (int)y, (int)w, (int)w);
			}
		}
	}

}
