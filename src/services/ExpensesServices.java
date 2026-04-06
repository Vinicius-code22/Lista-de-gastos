package services;
import java.util.List;
import java.time.LocalDate;
import entities.Expenses;

public class ExpensesServices {
	
	public static void adicionarGasto(List<Expenses> list, double valor, String description, LocalDate date) {
		list.add(new Expenses(valor, description, date));
		System.out.println("==========================");
	}
	
	public static void listarGastos(List<Expenses> list) {
		if (list.isEmpty()) {
			System.out.println();
		    System.out.println("Nenhum gasto registrado.");
		    System.out.println();
		}
		else {
			System.out.println("Lista de Gastos");
			for (Expenses e: list) {
				System.out.println(e);
			}
			System.out.println("==========================");
		}
		
	}
	public static void somaGastos(List<Expenses> list) {
		double soma = 0;
		if (list.isEmpty()) {
			System.out.println();
		    System.out.println("Nenhum gasto registrado.");
		    System.out.println();
		}
		else {
			soma = 0;
		    for (Expenses e : list) {
		        System.out.println(e);
		        soma += e.getValor();
		        
		    }
		    System.out.printf("Total: R$%.2f%n", soma);
	    }
	    
		
		
		
	}
	

}
