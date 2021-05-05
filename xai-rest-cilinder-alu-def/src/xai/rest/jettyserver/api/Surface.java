package xai.rest.jettyserver.api;

import java.io.Serializable;

public class Surface implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final double PI = 3.1416;

	int rad;
	int alt;
	double sur;
	
	public Surface()
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



	public double getSur() {
		return sur;
	}



	public void setSur(double sur) {
		this.sur = sur;
	}


	public Surface (int rad, int alt){
		this.rad = rad;
		this.alt = alt;
		this.sur = 2 * PI * rad * (rad + alt);
	}
	

	@Override
	public String toString() {
		return "{rad=" + rad + ", alt=" + alt + ", surface="+ sur + "}";
	}
}