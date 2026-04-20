package services;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Expenses;

public class ExpensesServices {
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static String caminho = "C:\\Vnx Gastos\\dados.csv";
	
	public static void adicionarGasto(List<Expenses> list, double valor, String description, LocalDate date) {
		list.add(new Expenses(valor, description, date));
		System.out.println("Gasto adicionado com sucesso!");
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
	
	public static void criarArquivos() {
		Path pasta = Path.of("C:\\Vnx Gastos");
		Path arquivo = pasta.resolve("dados.csv");
		try {
			Files.createDirectories(pasta);
		}
		catch (IOException e) {
			System.out.println("Erro ao criar pasta: " + e.getMessage());
		}
		
		
		try {
			if (!Files.exists(arquivo)) {
			    Files.createFile(arquivo);
			}
		}
		catch (IOException e) {
			System.out.println("Erro ao criar pasta ou arquivo: " + e.getMessage());
		}
	}
	
	public static void lerDados(List<Expenses> list) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
		    String linha;

		    while ((linha = br.readLine()) != null) {

		        try {
		            String[] info = linha.split(",");

		            if (info.length < 3) {
		                System.out.println("Linha inválida ignorada: " + linha);
		                continue;
		            }

		            double price = Double.parseDouble(info[0].trim());
		            String description = info[1].trim();
		            LocalDate date = LocalDate.parse(info[2].trim(), fmt);

		            list.add(new Expenses(price, description, date));

		        } catch (Exception e) {
		            System.out.println("Linha inválida ignorada: " + linha);
		        }
		    }

		} catch (IOException e) {
		    System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}	
	}
	
	public static void atualizar(List<Expenses> list) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
			
			for (Expenses e: list) {
				String valor = String.format(java.util.Locale.US, "%.2f", e.getValor());
				String data = e.getDate().format(fmt);
				
				bw.write(valor);
				bw.write(",");
				bw.write(e.getDescription());
				bw.write(",");
				bw.write(data);
				bw.write("\n");
			}
			System.out.println("Dados salvos!");
	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
