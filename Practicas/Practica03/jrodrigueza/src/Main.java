import tarjeta.*; //Se importan las clases anteriores

/**
*Esta clase tiene el metodo main e imprime en pantalla la *carta que eligas, siendo las opciones las cartas 1, 2 o 3.
*@author Jose Ricardo Rodriguez Abreu
*@version 0.1
*/
public class Main{


    
    public static void main(String[] args){
       
	try{
	    double n1 = Double.parseDouble(args[0]);
	    if (n1 == 1){
		System.out.println();
		Criatura criatura = new Criatura("", "", 0, "", "", "", "", 0, 0, 0, "");
		criatura.imprime();
	    } else if (n1 == 2){
		System.out.println();
		Tierra tierra = new Tierra("", "", "", "", 0, "");
		tierra.imprime();
	    } else if (n1 == 3){
		System.out.println();
		Hechizo hechizo = new Hechizo("", "", 0, "", "", "", 0, "");
		hechizo.imprime();
	    }  else if (n1 > 3){
		System.out.println("El número dado no es válido. Favor de dar " + 
				   "el número de carta con el siguiente formato y entre los valores 1 y 3: java Main #");
	    }
	    else if (n1 < 1){
		System.out.println("El número dado no es válido. Favor de dar" +" el número de carta con el siguiente formato y entre los valores 1 y 3: java Main #");
	    }
	} catch(NumberFormatException e){
	    System.out.println("Ese no es un número, favor de dar el valor 1, 2 o 3");
	}
    }
}