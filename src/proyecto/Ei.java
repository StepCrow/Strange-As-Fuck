package proyecto;

import java.io.Serializable;
import java.util.Arrays;

public class Ei implements Serializable{
private int x,y;
private Cell[][]a;
private String des;
private String type;

//Esta clase es la estructura de un estado inicial que formara lo que es el tablero cuando se junte con las normativas
//consArg
	public Ei(int x, int y, Cell[][] a,String des, String type) {
	super();
	this.x = x;
	this.y = y;
	this.a = a;
	this.des = des;
	this.type = type;
}
//ConsSinArgs
	public Ei() {
	super();
	this.x = 0;
	this.y = 0;
	this.a = new Cell[0][0];
	this.des = "";
	this.type = "";
}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Cell[][] getA() {
		return a;
	}
	public void setA(Cell[][] a) {
		this.a = a;
	}

	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "Ei [x=" + x + ", y=" + y + ", a=" + Arrays.toString(a) + "]";
	}
	
	
}
