package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expenses {

	private double valor;
	private String description;
	private LocalDate date;
	
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Expenses() {
	}
	
	
	public Expenses(double valor, String description, LocalDate date) {
		this.valor = valor;
		this.description = description;
		this.date = date;
	}


	public double getValor() {
		return valor;
	}


	public String getDescription() {
		return description;
	}


	public LocalDate getDate() {
		return date;
	}


	@Override
	public String toString() {
		return String.format("R$ %-10.2f | %-20s | %s",
			    valor,
			    description,
			    date.format(fmt)
			);
	}
	
}
