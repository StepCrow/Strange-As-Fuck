package proyecto;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class BlueRose extends JFrame{

	
		private JPanel pre;
		
		private JPanel ab;
	
	
	
	public BlueRose(Ei z) {
		
		Container cp = this.getContentPane();
		
		JPanel a = new JPanel(new GridLayout(50,50,1,1));
		ab = new JPanel();
		
		
		
		Tablero.imprimeEi(z);
		System.out.println();
		pre = BlackLotus.darkIvy(a, z);
		
		pre.setPreferredSize(new Dimension(400,400));
		ab.add(pre);
		
		
		
		
		
		cp.add(ab);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Previsualizacion");
		this.pack();;
		this.setVisible(true);
		
		
		
		
	}






	
	
	
	
	
}
