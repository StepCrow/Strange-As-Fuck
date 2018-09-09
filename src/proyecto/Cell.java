package proyecto;

import java.io.Serializable;

public class Cell implements Serializable{
//private int tamx,tamy;
//private int color;
private int state;
private int tipe;
public Cell(int state, int tipe) {
	super();
	this.state = state;
	this.tipe = tipe;
}
public Cell() {
	super();
	this.state = 0;
	this.tipe = 0;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public int getTipe() {
	return tipe;
}
public void setTipe(int tipe) {
	this.tipe = tipe;
}
@Override
public String toString() {
	return "Cell [state=" + state + ", tipe=" + tipe + "]";
}

}
