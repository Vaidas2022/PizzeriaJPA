package javau9.pizzeria.exceptions;

public class PizzaNotFoundException extends Exception{
	private static final long serialVersionUID = 7855775332492727418L;
	
	
	
	public PizzaNotFoundException(String msg) {
		super(msg);
	}
}
