package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Expenses;
import services.ExepensesServices;

public class main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<Expenses> list = new ArrayList<>();
		
		
		
		int choice = 0;
		while (choice != 5) {
		
			
			System.out.println("[1] Adicionar");
			System.out.println("[2] Listar");
			System.out.println("[3] Extrato");
			System.out.println("[4] Sair");
			System.out.println();
			
			
			System.out.print("Escolha a operação: ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
					System.out.print("Qual foi o valor gasto?: ");
					double valor = scan.nextDouble();
					
					scan.nextLine();
					System.out.print("Como foi gasto?: ");
					String description = scan.nextLine();
					
					ExepensesServices.adicioanarGastos(list, valor, description);
					
				break;
			case 2:				
					ExepensesServices.listarGastos(list);
				
				break;
			case 3:				
					ExepensesServices.somaGastos(list);
				
				break;	
			case 4:
					System.out.println("Programa finalizado.");
				
			break;
			default:
					System.out.println("Escolha invalida! Escolha novamente.");
					
				break;
			}
		
		}

			
			
		scan.close();	
	}

}
