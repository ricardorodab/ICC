/*
 * Main.java
 * Versión 1.0
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México, México, DF.
 * Rodríguez Abreu, José Ricardo.
 * Zamora Gutierrez Victor.
 *
 * Este programa llama e importa a Vifenere.java para
 * poder realizar una codificación polialfabético.
 *
 */

import java.io.IOException;
import Vigenere.*;

/**
 * @author Rodríguez Abreu, José Ricardo y Zamora Gutierrez, Victor.
 * @version 1.0
 * @since Octubre 17, 2013
 */
public class Main{
    
    /**
     * Metodo que imprime el mensaje de uso de el programa.
     */
    public static void msgUso(){
	System.err.println("Para iniciar el cifrado/descifrado del texto, se"
			   +" debe invocar el programa de la siguiente manera:"
			   +"\njava Main <cifra/descifra> <palabra clave> <archivo de entrada> <archivo de salida>");
    }
    
    /**
     * El metodo principal de el programa.
     * @param args - son los argumentos de el programa.
     */
    public static void main(String[] args)
	throws IOException{
	if(args.length!= 4){
	    msgUso();
	}else{
	    if(Vigenere.verificaClave(args[1])){
	    }else if(args[0].equals("cifra")){
		Vigenere.cifra(args[1],args[2],args[3]);	    
	    }else if(args[0].equals("descifra")){
		Vigenere.descifra(args[1],args[2],args[3]);
	    }else{ 
		msgUso();
	    }
	}
    }    
} //Fin de Main.java
