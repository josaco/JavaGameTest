package game;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public static final int WIDTH = 800, HEIGHT = 600;
	
	public Ventana()
	{
		setTitle("Juego de naves");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new Ventana();
	

	}

}
