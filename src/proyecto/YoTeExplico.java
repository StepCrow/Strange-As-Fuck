package proyecto;

import javax.swing.*;
import java.awt.*;

public class YoTeExplico extends JFrame{
	
	public YoTeExplico() {
		
		Container cp = getContentPane();
		JPanel a = new JPanel(new GridLayout(20, 1));
		
		JLabel m = new JLabel("Bienvenido al juego de la vida de Conway.");
		JLabel p = new JLabel("   ");
		JLabel m2 = new JLabel("Modos: ");
		JLabel m3 = new JLabel("Aleatorio, se basa en un estado inicial cuyas c�lulas est�n vivas o muertas en funci�n a un algoritmo aleatorio.");
		JLabel m4 = new JLabel("Predefinido, con este modo podr�s seleccionar un estado inicial que hayas guardado anteriormente, tambi�n te ense�a una previsualizaci�n del mismo para confirmar si es el deseado.");
		JLabel p2 = new JLabel("   ");
		JLabel m5 = new JLabel("Tipo de c�lulas:");
		JLabel m6 = new JLabel("Mundo de las amebas: sobrevive con 1, 3, 5 u 8 y nace con 3, 5 u 8 c�lulas vecinas");
		JLabel m7 = new JLabel("High Life: sobrevive con 2 o 3 y nace con 3 o 6 c�lulas vecinas");
		JLabel m8 = new JLabel("Conway: sobrevive con 2 o 3 y nace con 3 c�lulas vecinas.");
		JLabel m9 = new JLabel("Las c�lulas vecinas son las c�lulas que rodean a una c�lula.");
		JLabel p3 = new JLabel("   ");
		JLabel m10 = new JLabel("Botones: ");
		JLabel m11 = new JLabel("Play: Inicia el estado visualizado en la tabla de c�lulas.");
		JLabel m12 = new JLabel("Stop: Una vez iniciado, lo para.");
		JLabel m13 = new JLabel("Save: guarda el estado.");
		JLabel m14 = new JLabel("ScreenShot: Guarda la imagen de la tabla visualizada.");
		JLabel m15 = new JLabel("Reset: Mata todas las c�lulas de la pantalla, tiene que estar parado el proceso para optar a esta opci�n.");
		
		
		
		m.setFont(new Font("Comic Sans MS", Font.BOLD,13));
		m2.setFont(new Font("Comic Sans MS", Font.BOLD,13));
		m3.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m4.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m5.setFont(new Font("Comic Sans MS", Font.BOLD,13));
		m6.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m7.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m8.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m9.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m10.setFont(new Font("Comic Sans MS", Font.BOLD,13));
		m11.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m12.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m13.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m14.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		m15.setFont(new Font("Comic Sans MS", Font.ITALIC,13));
		
		a.add(m);
		a.add(p);
		a.add(m2);
		a.add(m3);
		a.add(m4);
		a.add(p2);
		a.add(m5);
		a.add(m6);
		a.add(m7);
		a.add(m8);
		a.add(m9);
		a.add(p3);
		a.add(m10);
		a.add(m11);
		a.add(m12);
		a.add(m13);
		a.add(m14);
		a.add(m15);
		
		cp.add(a);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Manual de Instrucciones");
		this.setResizable(false);
		this.pack();;
		this.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new YoTeExplico();
				
			}
		});
	}*/

}