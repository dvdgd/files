package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.println("Enter file path (.csv): ");
		String pathFileStr = sc.nextLine();
		
		File file = new File(pathFileStr);
		try (BufferedReader br = new BufferedReader(new FileReader(file))){

			String line = br.readLine();
			while (line != null) {
				String[] str = line.split(",");
				String name = str[0];
				Double price = Double.parseDouble(str[1]);
				Integer quantity = Integer.parseInt(str[2]);
				products.add(new Product(name, price, quantity));
				line = br.readLine();
			}

			String pathOut = file.getParent() + "\\out";
			new File(pathOut).mkdir();
			String fileCsv = pathOut + "\\summary.csv";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileCsv))) {
				for (Product p : products) {
					bw.write(p.getName() + ";" + String.format("%.2f", p.totalValue()));
					bw.newLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}