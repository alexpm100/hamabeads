package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import core.TableroCircular;

/**
 * Creamos un JPanel para dibujar un Panel Hama circular.
 * 
 * @author Alejandro Pérez Manzano
 *
 */
public class PanelCircular extends JPanel {

	private static final long serialVersionUID = -7030889712637933076L;
	
	/**
	 * El ángulo máximo de una circunferencia en radianes (2 PI)
	 */
	private static double ANGULO_MAXIMO = 2 * Math.PI;
	
	/**
	 * Ancho del panel.
	 */
	private static final int WIDTH = 700;
	
	/**
	 * Alto del panel.
	 */
	private static final int HEIGHT = 700;
	
	/**
	 * Tablero asociado al panel.
	 */
	private TableroCircular tablero;
	
	/**
	 * Creamos un panel para el Hama Circular.
	 * @param tablero El tablero asociado al panel.
	 */
	public PanelCircular(TableroCircular tablero) {
		this.tablero = tablero;
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[][] colores = tablero.getTablero();
		
		int xc = WIDTH / 2;
		int yc = HEIGHT / 2;
		double ang;
		double dAng;
		double r = 0;
		double dR = (WIDTH / 2) / colores.length;
		double w = 0.9 * dR;
		
		for (int i=0;i<colores.length;i++) {
			dAng = ANGULO_MAXIMO / colores[i].length;
			ang = 0;
			for (int j=0;j<colores[i].length;j++) {
				double x = xc + r*Math.cos(ang);
				double y =yc + r*Math.sin(ang);
				g.drawOval((int)x,(int)y, (int)w , (int)w);
				ang += dAng;
			}
			r += dR;
		}
    }

}
