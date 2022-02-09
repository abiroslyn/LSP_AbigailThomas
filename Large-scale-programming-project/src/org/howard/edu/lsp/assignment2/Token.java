package org.howard.edu.lsp.assignment2;

import java.util.Scanner;

public class Token {

	public static void main(String[] args) {
		Scanner scanner = null;
		while (true) {
			System.out.println("String?");
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			if(line.equals("goodbye")) {
				break;
			}
			String[] tokens = line.split(" ");

			int sum = 0;
			int product = 1;
			for(String token : tokens) {
				sum +=Integer.parseInt(token);
				product *=Integer.parseInt(token);
			}
			System.out.println("Sum" + sum);
			System.out.println("Product" + product);
			
		}
		scanner.close();
	}
}