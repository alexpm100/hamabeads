package core;

/**
 * Clase para representar un tablero circular.
 * 
 * @author Alejandro Pérez Manzano
 *
 */
public class TableroCircular {
	
	/**
	 * El número estandar de radios.
	 */
	public static final int STANDARD_RADIUS = 15;
	
	/**
	 * El tablero. Se considera el primer índice el radio desde el centro y el segundo el elemento dentro de dicho radio.
	 */
	private int[][] tablero;
	
	/**
	 * Devolvemos el tablero.
	 * @return El tablero.
	 */
	public int[][] getTablero() {
		return tablero;
	}

	/**
	 * Fijamos el tablero.
	 * @param tablero El tablero.
	 */
	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	/**
	 * Creamos un tablero circular.
	 * @param numRadius Numero de radios del tablero
	 */
	public TableroCircular(int numRadius) {
		tablero = new int[numRadius][];
		for (int i=0;i<numRadius;i++) {
			if (i==0) {
				tablero[i] = new int[1];
			}
			else if (i==1) {
				tablero[i] = new int[6];
			}
			else {
				tablero[i] = new int[tablero[i-1].length+6];
			}
			for (int j=0;j<tablero[i].length;j++) {
				tablero[i][j] = ColorHama.NO_COLOR;
			}
		}
	}
	
	/**
	 * Creamos un tablero circular de radio estandar.
	 */
	public TableroCircular() {
		this(STANDARD_RADIUS);
	}
}
