package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Expenses;
import services.ExpensesServices;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<Expenses> list = new ArrayList<>();
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		int choice = 0;
		
		while (choice != 4) {
		
			
			System.out.println("[1] Adicionar");
			System.out.println("[2] Listar");
			System.out.println("[3] Extrato");
			System.out.println("[4] Sair");
			System.out.println();
			
			
			System.out.print("Escolha a operação: ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
					try {
						System.out.print("Qual foi o valor gasto?: ");
						double valor = scan.nextDouble();
					
						scan.nextLine();
						System.out.print("Como foi gasto?: ");
						String description = scan.nextLine();
				
					
						System.out.print("Digite uma data (dd/MM/yyyy): ");
						String entrada = scan.nextLine();
						LocalDate date = LocalDate.parse(entrada, fmt);
					
						ExpensesServices.adicionarGasto(list, valor, description, date);
					}
					catch (InputMismatchException a) {
						System.out.println("Valor invalido!");
						scan.nextLine();
					}
					catch (DateTimeParseException a) {
						System.out.println("Data invalida!");
					}
					
				break;
			case 2:				
					ExpensesServices.listarGastos(list);
				
				break;
			case 3:				
					ExpensesServices.somaGastos(list);
				
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
