package services;
import java.util.List;
import java.util.ArrayList;

import entities.Expenses;

public class ExepensesServices {
	
	// Adiciona um gasto /
	public static void adicioanarGastos(List<Expenses> list, double valor, String description) {
		list.add(new Expenses(valor, description));
		System.out.println("==========================");
	}
	
	// Lista todos gastos adicionados / 
	public static void listarGastos(List<Expenses> list) {
		System.out.println("Lista de Gastos");
		for (Expenses e: list) {
			System.out.println(e);
		}
		System.out.println("==========================");
		
	}
	
	// Mostra todos gastos adicionados e a soma dos valores / 
	public static void somaGastos(List<Expenses> list) {
		double soma = 0;
		for (Expenses e: list) {
			soma += e.getValor();
		}
		System.out.println("==========================");
		
		for (Expenses e: list) {
			System.out.println(e);
		}
		System.out.println("==========================");
		System.out.println("Valor gasto: " + "R$"+ soma);
		System.out.println("==========================");
		
		
		
	}
	

}
