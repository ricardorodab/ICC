/*
* Autores de la clase Main.java:
* José Ricardo Rodríguez Abreu.
* Víctor Zamora Gutiérrez.
* Clase hecha con la finalidad de crear imagenes y ejecutar la clase Criptografía.
* Esta clase fue terminada el 10 de Noviembre del 2013.
*/
package Main;

import static Criptografia.Criptografia.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Platform;

/**
 * @author Jose Ricardo Rodriguez Abreu and Victor Zamora Gutierrez
 * @version 3.0
 * @since Noviembre, 10.
 */
public class Main extends Application {
    
    /**
     * Metodo que imprime la forma de usar esta clase.
     */
    public static void msjeUso(){
        System.out.println("Para utilizar este programa, escriba en la "
                + "linea de comandos: java -jar "
                + "<archivo1> <archivo2> \nNota: Utilice dos archivos"
                + " para descifrar y uno para cifrar.");
    }
    
    /**
     * Metodo que imprime el mensaje de error al manejar archivos.
     */
    public static void msjeError(){
        System.err.println("Error en el manejo de archivos: \n "
                + "favor de revisar el contenido y localización de la imagen.");
    }
    
    /**
     * Metodo start de la clase.
     * @param primaryStage - es el Stage de la clase.
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage primaryStage) 
            throws IOException{
        try{
            Parameters argumentos = getParameters();
            if(((argumentos.getUnnamed().size()) == 1) && (argumentos.getUnnamed().get(0).endsWith(".png"))) {
                Image img = new Image(new FileInputStream(argumentos.getUnnamed().get(0)));
                cifra(img);
            }else if(((argumentos.getUnnamed().size()) == 2 && (argumentos.getUnnamed().get(0).endsWith(".png")))){ 
                Image img1 = new Image(new FileInputStream(argumentos.getUnnamed().get(0)));
                Image img2 = new Image(new FileInputStream(argumentos.getUnnamed().get(1)));
                descifrar(img1, img2);
                Platform.exit();
            }else{ 
                msjeUso();
                Platform.exit();
            }
        }catch(IOException io){
            msjeError();
            msjeUso();
        }
    }
    
    /**
     * Metodo principal de la clase.
     * @param args son los argumentos de la clase.
     */
    public static void main(String[] args){    
        launch(args);
    }
} //Fin de Main.java
