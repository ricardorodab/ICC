/**
 *Esta clase tiene el método main y dado 2 coordenadas (X, Y) te desplaza
 *un punto, los suma y te da la distancia de los puntos.
 *@author Rodríguez Abreu José Ricardo
 *@version 1.0
*/

public class Main{
    
    public static void main(String[] args){ //Método main
	
	try{ 
	if(args.length != 4){
	    System.out.println(" \n Favor de dar 2 puntos de la siguiente manera:" +
				   "\n \t java Main X1 Y1 X2 Y2 \n");
		
	}else if (args.length == 4){
	    double x1 = Double.parseDouble(args[0] ); //Asignación a la variable 1
	    double y1 = Double.parseDouble(args[1] ); //Asignación a la variable 2
	    double x2 = Double.parseDouble(args[2] ); //Asignación a la variable 3
	    double y2 = Double.parseDouble(args[3] ); //Asignación a la variable 4
	    
	    Punto puntoP = new Punto (x1, y1); //Constructor del punto P
	    Punto puntoQ = new Punto (x2, y2); //Constructor del punto Q
	    double distancia = puntoP.distancia (puntoQ); //Calcula la distancia
	    boolean igualdad = puntoP.igualar (puntoQ); //Da el valor la igualdad
	    
	    
	    System.out.println("\n Punto 1: (" + x1 + "," + y1 + ")" ); 
	    System.out.println(" Punto 2: (" + x2 + "," + y2 + ")" ); 
	    
	    System.out.println("\n La distancia del Punto 1 al Punto 2 es de " +  distancia +" unidades.");
	    
	    if (igualdad){
		System.out.println("\n Los puntos son iguales. \n");
	    }else{ 
		System.out.println("\n Los puntos no son iguales. \n");
	    }
	    
	    if  (args.length == 4){
		puntoP.desplazar(x2, y2); //Desplaza el valor
		System.out.println(" El nuevo punto dado por la fórmula Punto 1 + Punto 2 es: \n" +
				   " Punto 3 = (" +puntoP.getX() +"," +puntoP.getY() +") \n");
	    }
	}
	}
	catch(NumberFormatException e){
	    System.out.println( "\n Revise que todos los valores dados sean números y vuelva a intentar. \n");
	}	   
    }
}