package xai.rest.jettyserver.api;

import java.io.Serializable;

/**
 * @author Joan-Manuel Marques
 *
 */
public class Division implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dividend;
	private int divisor;
	private int quotient;
	private int remainder;

	public Division(int dividend, int divisor){
		this.dividend=dividend;
		this.divisor=divisor;
		this.quotient = dividend/divisor;
		this.remainder = dividend%divisor;			
	}
	
	public Division() 
	{
	}

	public int getDividend() {
		return dividend;
	}



	public void setDividend(int dividend) {
		this.dividend = dividend;
	}



	public int getDivisor() {
		return divisor;
	}



	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}



	public int getQuotient() {
		return quotient;
	}



	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}



	public int getRemainder() {
		return remainder;
	}



	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}



	@Override
	public String toString() {
		return "El resultado de la división es "+this.quotient;
	}
}