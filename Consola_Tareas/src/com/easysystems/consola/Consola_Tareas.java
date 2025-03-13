package com.easysystems.consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.easysystems.modelo.Tarea;

public class Consola_Tareas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Boolean salir = false;
		String input;
		String comando;
		List<Tarea> tareas = new ArrayList<Tarea>();
		
        String regex = "^(crear\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"(?:\\s+\"([^\"]+)\")?)$"
                + "|(listar(\\s+-c\\s+\"([^\"]+)\")?)"
                + "|(completar\\s+(\\d+))$"
                + "|(eliminar\\s+(\\d+))$"
                + "|(salir)";

        Pattern pattern = Pattern.compile(regex);

        
		do {
			System.out.print("> ");
			
			input = scanner.nextLine().trim();
	        Matcher matcher = pattern.matcher(input);
	        
	        if(!matcher.matches()) {
    			System.out.println("El comando introducido no existe");
	        } else {
	        	comando = matcher.group(0).split(" ")[0];
				// Comprobamos si se ha introducido el comando salir
				if (comando.equalsIgnoreCase("salir")) {
	                salir = true;
	            } else {
	            	for(int i=0;i<matcher.groupCount();i++) {
            			System.out.println("Grupo " + i + ": " + matcher.group(i));
	            	}
	            	
	            	switch (comando) {
	            		case "crear":
	            			Tarea tarea;

	            			if(matcher.group(4) != null) {
	            				tarea = new Tarea(matcher.group(2), matcher.group(3), matcher.group(4));
	            			} else {
	            				tarea = new Tarea(matcher.group(2), matcher.group(3));
	            			}		

	            			tareas.add(tarea);
	            			
	            			System.out.println("Tarea creada");
	            			break;
	            		case "listar":
	            			System.out.println(matcher.group(7));
	            			String categoria = matcher.group(7) == null ? "" : matcher.group(7);
	            			
	            			if(tareas.size() != 0) {
		            			for(int i=0;i<tareas.size();i++) {
			            			System.out.println(categoria);
		            				if(categoria == "" ) {
		            					System.out.println("ID: " + i + " -> " + tareas.get(i));
		    	            			System.out.println("hola");
		            				} else if(tareas.get(i).getCategoria() == categoria) {
		            					System.out.println("ID: " + i + " -> " + tareas.get(i));
		    	            			System.out.println("adios");
		            				}
		            			}
	            			} else {
		            			System.out.println("No hay tareas en la lista");
		            		}
	            			break;
	            		case "completar":
	            			tareas.get(Integer.parseInt(matcher.group(9))).completar();;
	            			System.out.println("Tarea " + matcher.group(9) + " completada.");
	            			break;
	            		case "eliminar":
	            			tareas.remove(Integer.parseInt(matcher.group(11)));
	            			System.out.println("Tarea " + matcher.group(11) + " eliminada.");
	            			break;
	            		default:
	            			System.out.println("El comando introducido no existe");
	            	}
	            }
	        }
			
		} while (!salir);
		
	    scanner.close();
	    System.out.println("Saliendo...");
	}
}
