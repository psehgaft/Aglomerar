/**
 * @(#)Libro.java
 *
 * Libro application
 *
 * @author 
 * @version 1.00 2011/4/3
 */
 import java.io.*;
 import java.util.*;
 
 class Aglomerar {
    
    public static void main(String[] args) {
    	  
  Scanner sc = new Scanner(System.in);
  System.out.println("\t OPCIONES\n");
  System.out.println("1 Aglomerar documentos xml");
  System.out.println("2 Visualiar documento xml");
 
  System.out.println("Ingresa opcion");
  while (true){
  
  int opcion = sc.nextInt(); 
  
 switch (opcion) {
 	case 1:
 		 directorio dir = new directorio();
 		 dir.adjuntar();
 		  break;
 	case 2: 
 			VisualizarLibro visualiza = new VisualizarLibro();
 		visualiza.leer();
 		break;
 
 }
  }
    
    
    }
}
