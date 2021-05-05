package xai.rest.jettyserver.api;

import java.io.Serializable;

public class Perimeter implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final double PI = 3.1416;

	int rad;
	int alt;
	double per;
	
	public Perimeter()
	{
	}
	
	
	public int getRad() {
		return rad;
	}



	public void setRad(int rad) {
		this.rad = rad;
	}



	public int getAlt() {
		return alt;
	}



	public void setAlt(int alt) {
		this.alt = alt;
	}



	public double getPer() {
		return per;
	}



	public void setPer(double per) {
		this.per = per;
	}


	public Perimeter (int rad, int alt){
		this.rad = rad;
		this.alt = alt;
		this.per = 2 * (alt+4) * PI * rad;
	}
	

	@Override
	public String toString() {
		return "{rad=" + rad + ", alt=" + alt + ", perimeter="+ per + "}";
	}
}