package com.easysystems.consola;

import java.util.Scanner;

public class Consola_Tareas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Boolean salir = false;
		String comando = "";
		
		do {
			System.out.print("> ");
			
			comando = scanner.nextLine().trim();
            
			if (comando.equalsIgnoreCase("salir")) {
                salir = true;
            }
			
		} while (!salir);
		
	    scanner.close();
	    System.out.println("Saliendo...");
	}
}
