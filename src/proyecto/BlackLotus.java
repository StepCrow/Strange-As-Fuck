package proyecto;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class BlackLotus extends JFrame{

	
	private JMenuBar r;
	private JMenu mode;
	private JMenu laws,opc;
	private JMenuItem al,pre,cellA,cellH,cellC, ayuda;
	private JButton play;
	private JButton stop;
	private JButton guardar;
	private JButton reset;
	private JButton screenShot;
	private boolean parar;
	private ArrayList<Ei> alma;
	private Ei z;
	private JPanel az;
	private Thread jesus;
	private JPanel lel;
	private Ei guardable;
	
	//hace un reset
	public static Ei reset() {
		
		int x = 50;    
		int y = x;
		Cell [][] lel = new Cell[x][y];
		String o = "";
		String e = "";
		for (int i = 0; i < lel.length; i++) {
			for (int j = 0; j < lel[i].length; j++) {
				lel [i][j] = new Cell (0,0);
				lel[i][j].setState(0);
			}
		}
		
		Ei z = new Ei(x,y,lel,o,e);
		return z;
		
		
		
	}

	//pinta la matriz en la pantalla
	public static JPanel darkIvy (JPanel u, Ei z) {
		
		ArrayList<JLabel> y = new ArrayList<JLabel>();
		ArrayList<ArrayList<JLabel>> x = new ArrayList<ArrayList<JLabel>>();
		
		Ei blackLotus = z;
		
		u.removeAll();
		
		
		for (int i = 0; i < blackLotus.getA().length; i++) {
			
			for (int j = 0; j < blackLotus.getA()[i].length; j++) {
				
				
				
				JLabel a = new JLabel("");
				a.setOpaque(true);
				if(blackLotus.getA()[i][j].getState() == 1) {
					
					
					a.setBackground(Color.black);
					
				}else {
					
					a.setBackground(Color.white);
					
				}
				
				y.add(a);
			}
			x.add(y);
		}
		
		for (ArrayList<JLabel> arrayList : x) {
			for (JLabel jLabel : arrayList) {
				u.add(jLabel);
			}
		}
		
		return u;
		
		
		
		
	}
	

	
	public BlackLotus() {
		
		
		
		
		parar = false;
		
		r = new JMenuBar();
		
		
		mode = new JMenu("Modo");
		laws = new JMenu("Tipo de Célula");
		opc = new JMenu("Opciones");
		al = new JMenuItem("Aleatorio");
		pre = new JMenuItem("Predefinido");
		cellA = new JRadioButtonMenuItem("Mundo de las Amebas");
		cellC = new JRadioButtonMenuItem("Conway");
		cellH = new JRadioButtonMenuItem("High Life");
		ayuda = new JMenuItem("Ayuda");
		opc.add(ayuda);
		lel = new JPanel(new GridLayout(50,50,1,1));
		alma = new ArrayList<Ei>(Tablero.leeFichero());
	
		
		
		

		r.add(mode);
		r.add(laws);
		r.add(opc);
	
		
		mode.add(al);
		mode.add(pre);
		ButtonGroup a = new ButtonGroup();
		
		a.add(cellA);
		a.add(cellH);
		a.add(cellC);
	
		laws.add(cellA);
		laws.add(cellH);
		laws.add(cellC);
		
		
		Container cp = this.getContentPane();
		
		JPanel arriba = new JPanel();
		JPanel abajo = new JPanel(new GridLayout(1,2));
		
		
		
		play =new JButton("Play");
	
		stop =new JButton("Stop");
		guardar =new JButton("Save");
		screenShot =new JButton("ScreenShot");
		reset =new JButton("Reset");
		arriba.add(play);
		arriba.add(stop);
		arriba.add(guardar);
		arriba.add(screenShot);
		arriba.add(reset);
		
		stop.setEnabled(false);
		reset.setEnabled(false);
		
		JPanel juego = new JPanel(new GridLayout(50,50,1,1));
		
		z = reset();
		
		
		
		
		
		
		
		MouseAdapter aloha = new MouseAdapter() {
			
			
			public void mouseClicked(MouseEvent e) {
				if(play.isEnabled()) {
				int a = e.getX();
				int conor = a/15;
				
				int b = e.getY();
				int cloude = b/15;
				Cell[][] p = z.getA();
				
				if(p[cloude][conor].getState()==0) {
				p[cloude][conor].setState(1);
				System.out.println("sd");
				}else {
					
					p[cloude][conor].setState(0);
					
				}
				z.setA(p);
				
				jesus = new Thread (new Runnable() {
					
					public void run() {
						
						abajo.removeAll();;
						az =darkIvy(juego,z);
						abajo.add(az);
						abajo.validate();
						guardable = new Ei(z.getX(),z.getY(),z.getA(),"guardable","tipo");
						System.out.println("term");
						
					}
				});
				
				jesus.start();
				
				Tablero.sonidito();
				reset.setEnabled(true);
			}
			
			
			
			
			}
			
		};
		
		
		
		
		
		
		
		
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			//pinta la pantalla
				
					parar=false;
					Tablero.imprimeEi(z);
					System.out.println();
					
					Thread lavirgen = new Thread(new Runnable() {
						
						
						public void run() {
							
							
								
							do {
								
							
							
								
							abajo.removeAll();
							//abajo.repaint();
							
							
							
							
							
							if(cellA.isSelected()) {
								
								z.setA(Tablero.lawsA(z));
								
							} else if (cellH.isSelected()) {
								
								
								z.setA(Tablero.lawsH(z));
								
								
							}else {
								
								z.setA(Tablero.lawsC(z));
								
							}
							
							lel =darkIvy(juego,z);
							abajo.add(lel);
							abajo.validate();
							
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							 ;
							
						}while (parar==false);
						}
						
						
						
					});
					if (cellA.isSelected()) {
				
					cellC.setEnabled(false);
					cellH.setEnabled(false);
					
					
					
					lavirgen.start();
					
				
					} else if (cellH.isSelected()) {
						
						cellA.setEnabled(false);
						cellC.setEnabled(false);
	
						lavirgen.start();
						
						
					}else {
						cellC.setSelected(true);
						cellH.setEnabled(false);
						cellA.setEnabled(false);
						
						
						
						lavirgen.start();
						
					}
					play.setEnabled(false);
					reset.setEnabled(false);
					stop.setEnabled(true);
					al.setEnabled(false);
					pre.setEnabled(false);
					
					
			}
			
		});
		
		
		guardar.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(guardable!=null) {
				
				guardable.setDes(JOptionPane.showInputDialog(cp, "Elige un nombre para tu Estado Inicial", "Guardar", 1));
				alma.add(guardable);
				Tablero.guardaFichero(alma);
				
				} else {
					
					guardable = new Ei();
					guardable.setDes(JOptionPane.showInputDialog(cp, "Elige un nombre para tu Estado Inicial", "Guardar", 1));
					alma.add(guardable);
					Tablero.guardaFichero(alma);
				}
				
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				parar=true;
				cellC.setEnabled(true);
				cellA.setEnabled(true);
				cellH.setEnabled(true);
				play.setEnabled(true);
				stop.setEnabled(false);
				reset.setEnabled(true);
				al.setEnabled(true);
				pre.setEnabled(true);
			}
		});
		
		
		reset.addActionListener(new ActionListener() {
		
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				z = reset();
				
				Thread jesus = new Thread (new Runnable() {
					
					
					public void run() {
						
						abajo.remove(az);
						az =darkIvy(juego,z);
						abajo.add(az);
						abajo.validate();
						
					}
				});
				jesus.start();
				reset.setEnabled(false);
				
			}
			
			
			
			
			
		});
		
		
		screenShot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tablero.screenchot(abajo);
				
			}
		});
		
		pre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				alma = new ArrayList<Ei>(Tablero.leeFichero());
				ArrayList<String> ele = new ArrayList<String>();
				
				for (Ei ei : alma) {
					ele.add(ei.getDes());
				}
				
				
				String [] olo =  ele.toArray(new String[ele.size()]);
				
				
				Object df = JOptionPane.showInputDialog(cp, "Elige estado Inicial :D", "Selector!" ,JOptionPane.QUESTION_MESSAGE, null, olo, null);
				
				if (df!=null) {
				String ojala = (String) df ;
				
				
				for (Ei s : alma) {
					
					if (s.getDes()==ojala) {
						
						
						
						Thread prev = new Thread(new Runnable() {
							
							@Override
							public void run() {
								
								new BlueRose(s);
								
							}
						});
						
						prev.start();
						int aber =  JOptionPane.showConfirmDialog(cp, "¿Desea cargar este Estado Inicial?", "?", 1);
						if (aber == 0) {
							
							z=s;
							reset.setEnabled(true);
							Thread jesus = new Thread (new Runnable() {
								
								
								public void run() {
									
									abajo.remove(az);
									az =darkIvy(juego,z);
									abajo.add(az);
									abajo.validate();
									
								}
							});
							jesus.start();
							
						}
						break;
					}
					
				}
				
				}
			}
		});
		

		al.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				z = Tablero.gen0Al();
				reset.setEnabled(true);
				guardable = new Ei(z.getX(),z.getY(),z.getA(),"guardable","tipo");
				Thread jesus = new Thread (new Runnable() {
					
					
					public void run() {
						
						abajo.remove(az);
						az =darkIvy(juego,z);
						abajo.add(az);
						abajo.validate();
						
					}
				});
				jesus.start();
			}
		});
		
	
		ayuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new YoTeExplico();
			}
		});
		
		
		
		
		
		az = darkIvy(new JPanel(new GridLayout(50,50,1,1)),z);
		
		
		juego.setPreferredSize(new Dimension(750, 750));
		az.setPreferredSize(new Dimension(750, 750));
		
	
		abajo.addMouseListener(aloha);
		
		
		
		abajo.add(az);
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		int xxx= (int) size.getHeight();
		int yyy= (int) size.getWidth();
		
		cp.add(arriba, BorderLayout.NORTH);
		cp.add(abajo, BorderLayout.SOUTH);
		this.setLocation(xxx/2,yyy/10);
		this.setJMenuBar(r);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("El juego de la vida");
		this.pack();;
		this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BlackLotus();
				
			}
		});
		
		
	}

}
