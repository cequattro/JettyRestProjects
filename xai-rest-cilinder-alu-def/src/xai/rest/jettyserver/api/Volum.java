package xai.rest.jettyserver.api;

import java.io.Serializable;

/**
 * @author Joan-Manuel Marques
 *
 */
public class Volum implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final double PI = 3.1416;

	int rad;
	int alt;
	double vol;
	
	public Volum()
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



	public double getVol() {
		return vol;
	}



	public void setVol(double vol) {
		this.vol = vol;
	}


	public Volum (int rad, int alt){
		this.rad = rad;
		this.alt = alt;
		this.vol = PI * rad * rad * alt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alt;
		result = prime * result + rad;
		long temp;
		temp = Double.doubleToLongBits(vol);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volum other = (Volum) obj;
		if (alt != other.alt)
			return false;
		if (rad != other.rad)
			return false;
		if (vol != other.vol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{rad=" + rad + ", alt=" + alt + ", volume="+ vol + "}";
	}
}