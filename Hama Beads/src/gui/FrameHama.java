package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.TableroCircular;

/**
 * Frame basico de la aplicación
 * @author Alejandro Pérez Manzano
 *
 */
public class FrameHama extends JFrame {

	private static final long serialVersionUID = -3773159968701313806L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHama frame = new FrameHama();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos el Frame.
	 */
	public FrameHama() {
		setResizable(false);
		setTitle("Editor de Hama Beads");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 806);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		TableroCircular tablero = new TableroCircular();
		PanelCircular canvas = new PanelCircular(tablero);
		canvas.setBounds(5, 5, 700, 700);
		contentPane.add(canvas);
		
		PanelColores colores = new PanelColores();
		colores.setBounds(5, 710, 900, 50);
		contentPane.add(colores);
	}

}
