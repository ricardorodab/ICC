/*
 * Main.java
 * Versión 3.0
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México, México.
 * José Ricardo Rodríguez Abreu
 * 
 * Este programa toma una archivo e imprime en pantalla las tarjetas 
 * con un respectivo orden y colocando el indicador antes de cada dato
 *
 */

import tarjeta.*; //Se importan las clases creadas con anterioridad.
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 *@author Jose Ricardo Rodriguez Abreu
 *@version 3.0
 *@since Octubre 12, 2013
 */

public class Main{
    
    /**
     * Crea una lista ligada que contiene a las tarjetas.
     *@param nombreArchivo - es el archivo a ser leído.
     */
    public static LinkedList<Tarjeta> cargaMazo(String nombreArchivo)
	throws IOException{
	BufferedReader mazo = new BufferedReader (new FileReader(nombreArchivo));
	String l = mazo.readLine();
	int i = 0;
	LinkedList<Tarjeta> Tarjetas = new LinkedList<Tarjeta>();	
	do{
	    Scanner dato = new Scanner(l).useDelimiter(";");   
	    switch(dato.next()){
	    case "T":
		Tierra cartat = new Tierra(dato.next(),
					   dato.next(),
					   dato.next(),
					   dato.nextInt(),
					   dato.nextInt(),
					   dato.nextInt());
		Tarjetas.add(cartat);	    
		
		break;
	    case "H":
		Hechizo cartah = new Hechizo(dato.next(),
					     dato.next(),
					     dato.next(),
					     dato.nextInt(),
					     dato.nextInt(),
					     dato.nextInt(),
					     dato.next(),
					     dato.next());
		Tarjetas.add(cartah);
		break;
	    case "C":
		Criatura cartac = new Criatura(dato.next(),
					       dato.next(),
					       dato.next(),
					       dato.nextInt(),
					       dato.nextInt(),
					       dato.nextInt(),
					       dato.nextInt(),
					       dato.nextInt(),
					       dato.next(),
					       dato.next(),
					       dato.next());
		Tarjetas.add(cartac);
		
		break;
	    default: System.err.println("Esta no es una carta bien formada");
		break;
	    }
	    i++;
	} while((l = mazo.readLine()) != null);
	
	return Tarjetas;
	
    }	       
    
    /**
     * Imprime el mensaje de uso del programa.
     */
    public static void mensajeUso(){
	System.err.println("Para usar este programa se debe invocar de la siguiente manera: \n"
			   + "java Main <archivo> \n" 
			   + "Donde <archivo> es el archivo que debe contener las cartas.");
    }
    
    /**
     * Imprime el formato en el que debe de estar el documento a leer.
     */
    public static void mensajeError(){
	System.err.println("El formato del texto es incorrecto,"
			   +" favor de darlo de la siguiente manera:");
	System.err.println("Si es una carta tipo Tierra: \"T; <Nombre>; <Edición>; "
			   + "<Color>; <Número de carta>; <Costo genérico>; <Costo color>\"");
	System.err.println("Si es una carta tipo Hechizo: \"H; <Nombre>; <Edición>; "
			   + "<Color>; <Número de carta>; <Costo genérico>; "
			   + "<Costo color>; <Efecto>; <Leyenda>\"");
	System.err.println("Si es una carta tipo Criatura: \"C; <Nombre>; <Edición>; "
			   + "<Color>; <Número de carta>; <Costo genérico>; "
			   + "<Costo color>; <Ataque>; <Defensa>; <Efecto>; <Leyenda>; <Tipo>\"");
	System.err.println("Sin los \"\".");
    }
    
    /**
     *Metodo main de la clase.
     *@param args - Son los argumentos que recibe.
     */
    public static void main(String[] args)
	throws IOException{
	try {
	    
	    LinkedList<Tarjeta> deck = cargaMazo(args[0]);
	    for(int p = 0; p < deck.size() ; p++){
		System.out.println((deck.get(p)).toString());
	    }
	}   
	catch (ArrayIndexOutOfBoundsException e){
	    mensajeUso();
	}
	
	catch (NumberFormatException e){
	    mensajeError();
	} 
	
	catch (IOException e){
	    System.out.println("El archivo no fue encontrado.");
	    mensajeUso();	    	    	    
	}
	
	catch (NullPointerException e){
	    mensajeError();
	} 

	catch (NoSuchElementException e){
	    mensajeError();
	}
    }
} //Fin de Main.java
