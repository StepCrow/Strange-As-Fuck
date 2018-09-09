package proyecto;


import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.net.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tablero extends Ei{
	
	//imprime el tablero (en la terminal)
	protected static void imprimeEi(Ei a) {
		
		for (int i24 = 0; i24 < a.getA().length; i24++) { //imprime en pantalla el tablero
			for (int j24 = 0; j24 < a.getA()[i24].length; j24++) {
				System.out.print(a.getA()[i24][j24].getState());
			}
			System.out.println();
		}
		
		
	}
	//generacion aleatoria
	protected static Ei gen0Al () {
		
		
		int x = 50;    /*(int)(Math.random()*5+3)*/
		int y = x;
		Cell [][] lel = new Cell[x][y];
		String o = "";
		String e = "";
		for (int i = 0; i < lel.length; i++) {
			for (int j = 0; j < lel[i].length; j++) {
				lel [i][j] = new Cell (0,0);
				lel[i][j].setState((int)(Math.random()*2));
			}
		}
		
		Ei z = new Ei(x,y,lel,o,e);
		return z;
		
	}

	//normativas
	protected static Cell[][] lawsC (Ei z){             //Conway 23/3
		
		
		
		Cell[][]a =new Cell[z.getX()][z.getY()];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a [i][j] = new Cell (0,0);
			}
		}
		
		for (int i = 0; i < z.getA().length; i++) {
			for (int j = 0; j < z.getA()[i].length; j++) {
				
				
		
				int la=0; //contador
				int federico = i-1; //x
				int garcia = j-1;	//y
		
				for (int i1 = 0; i1 < 3; i1++) {
					for (int j1 = 0; j1 < 3; j1++) {
						if (!(federico<0||garcia<0||federico>z.getA().length-1||garcia>z.getA()[i].length-1))  {
							
							if (z.getA()[federico][garcia].getState()==1) {
								la++;
							}

						}
						garcia++;
					}
					federico ++;
					garcia=j-1;
					
				}
				
				//a[i][j].setState(la-lel[i][j].getState());
				la = la-z.getA()[i][j].getState();
				
				if(la==3) {
					a[i][j].setState(1); //nace
				}else if (la<=1|| la>=3) {
					a[i][j].setState(0); //muere
				}else if (la==2&&z.getA()[i][j].getState()==1) {
					a[i][j].setState(1);
				}
			}
		}
		 
		return a;
		
	}
	protected static Cell[][] lawsA (Ei z){             //Amebas 1358/357
		

		Cell[][]a =new Cell[z.getX()][z.getY()];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a [i][j] = new Cell (0,0);
			}
		}
		
		for (int i = 0; i < z.getA().length; i++) {
			for (int j = 0; j < z.getA()[i].length; j++) {
				
				int la=0; //contador
				int federico = i-1; //x
				int garcia = j-1;	//y
		
				for (int i1 = 0; i1 < 3; i1++) {
					for (int j1 = 0; j1 < 3; j1++) {
						if (!(federico<0||garcia<0||federico>z.getA().length-1||garcia>z.getA()[i].length-1))  {
							
							if (z.getA()[federico][garcia].getState()==1) {
								la++;
							}

						}
						garcia++;
					}
					federico ++;
					garcia=j-1;
					
				}
				
				
				la = la-z.getA()[i][j].getState();
				
				if(la==3|| la==5 || la==7) {
					a[i][j].setState(1); //nace
				}else if (la<1|| la>8 || la==2|| la==4||la==6||la==7) {
					a[i][j].setState(0); //muere
				}else if ((la==1||la==3||la==5||la==8)&&z.getA()[i][j].getState()==1) {
					a[i][j].setState(1);
				}
			}
		}
		 
		return a;
		
		
		
		
		
	}
	protected static Cell[][] lawsH (Ei z){             //High Life 23/36
		
		
		Cell[][]a =new Cell[z.getX()][z.getY()];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a [i][j] = new Cell (0,0);
			}
		}
		
		for (int i = 0; i < z.getA().length; i++) {
			for (int j = 0; j < z.getA()[i].length; j++) {
				
				
		
				int la=0; //contador
				int federico = i-1; //x
				int garcia = j-1;	//y
		
				for (int i1 = 0; i1 < 3; i1++) {
					for (int j1 = 0; j1 < 3; j1++) {
						if (!(federico<0||garcia<0||federico>z.getA().length-1||garcia>z.getA()[i].length-1))  {
							
							if (z.getA()[federico][garcia].getState()==1) {
								la++;
							}

						}
						garcia++;
					}
					federico ++;
					garcia=j-1;
					
				}
				
				
				la = la-z.getA()[i][j].getState();
				
				if(la==3|| la ==6) {
					a[i][j].setState(1); //nace
				}else if (la<2|| la>3) {
					a[i][j].setState(0); //muere
				}else if ((la==2||la==3)&&z.getA()[i][j].getState()==1) {
					a[i][j].setState(1);
				}
			}
		}
		 
		return a;
		
	}
	public static void main(String[] args) {
		
	//main de pruebas
		
	}
	//generacion predefinida
	
	protected static void guardaFichero(ArrayList<Ei> y){
		
		FileOutputStream fich = null;
		ObjectOutputStream li = null;
		
		String name = System.getProperty("user.name");
	
		
		try {
			fich = new FileOutputStream("C:\\Users\\"+name+"\\Documents\\xd.txt");
			li = new ObjectOutputStream(fich);
			li.writeObject(y);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	           try {
	               
	               if (null != fich)
	                  fich.close();
	               } catch (Exception e2) {
	                  e2.printStackTrace();
	               }
	            }
	}
	protected static ArrayList<Ei> leeFichero () {
		
		
		FileInputStream fich = null;
		ObjectInputStream l = null;
		ArrayList<Ei> s = new ArrayList<Ei>();
		String name = System.getProperty("user.name");
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\"+name+"\\Documents\\xd.txt"));
			if (br.readLine()!=null) {
				
			fich = new FileInputStream ("C:\\Users\\"+name+"\\Documents\\xd.txt");
			
			l = new ObjectInputStream(fich);
			
			s = (ArrayList<Ei>) l.readObject();
			
			fich.close();
			}
			
		} catch ( ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "Ningún archivo de guardado encontrado, ¡se generara uno en cuanto guardes el primer Estado Inicial!");
			
			System.out.println("Ningún archivo de guardado encontrado, ¡se generara uno en cuanto guardes el primero!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
	}
	

	protected static void screenchot(JPanel u) {
		
		String name = (String) new SimpleDateFormat("yyyy-MM-dd").format(new Date ());
		
		String namef = System.getProperty("user.name");
	  
		String name2 = String.valueOf(System.currentTimeMillis());
		
		BufferedImage screenshotImage = new BufferedImage(
                u.getBounds().width, u.getBounds().height,
                BufferedImage.TYPE_INT_RGB);
        u.paint(screenshotImage.getGraphics());
        try {
            ImageIO.write(screenshotImage, "png", new File("C:\\Users\\"+namef+"\\Documents\\"+name+name2+".png"));
        } catch (IOException ex) {
            System.err.println("ImageIsuues");
        }
		
		
	}


	protected static void sonidito() {
		
		String name = System.getProperty("user.name");
			
			try {
				AudioClip s = Applet.newAudioClip(new URL("file:\\C:\\Users\\"+name+"\\Documents\\son2.wav"));
				s.play();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
