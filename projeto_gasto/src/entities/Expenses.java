package entities;

public class Expenses {

	private double valor;
	private String description;
	
	public Expenses() {
	}
	public Expenses(double valor, String description) {
		this.valor = valor;
		this.description = description;
	}
	public double getValor() {
		return valor;
	}
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "R$" + valor + " | " + description;
	}
	
}
