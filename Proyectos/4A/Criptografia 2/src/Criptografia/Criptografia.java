/*
* Autores de la clase Criptografia.java:
* José Ricardo Rodríguez Abreu.
* Víctor Zamora Gutiérrez.
* Clase hecha con la finalidad de cifrar y descifrar una imagen.
* Esta clase fue terminada el 10 de Noviembre del 2013.
*/

package Criptografia;

import java.awt.image.BufferedImage;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javax.imageio.ImageIO;

/**
 * @author Jose Ricardo Rodriguez Abreu and Victor Zamora Gutierrez
 * @version 2.0
 * @since Noviembre, 10.
 */

public class Criptografia{

/**
 * Metodo que cifra una imagen en otras 2.
 * @param img - es la imagen a cifrar.
 * @throws java.io.IOException
 */
    public static void cifra(Image img) 
            throws IOException{
        try{
            int y = (int)(img.getHeight());
            int x = (int)(img.getWidth());
            int k = 0;
            int l = 0;
            WritableImage imagen1 = new WritableImage((int)(x*2), (int)(y*2));
            WritableImage imagen2 = new WritableImage((int)(x*2), (int)(y*2));
            PixelReader pixel = img.getPixelReader();            
            PixelWriter pixel1 = imagen1.getPixelWriter();
            PixelWriter pixel2 = imagen2.getPixelWriter();
            for(int i = 0; i < y; i++){
                for( int j = 0; j < x; j++){
                    Color c = pixel.getColor(j, i);
                    if(c.equals(Color.WHITE)){
                        int a = (int)((Math.random()*10) % 6);   
                        switch(a){
                            case(0):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                                break;
                            case(1):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                                break;
                            case(2):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                                break;
                            case(3):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                                break;
                            case(4):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                                break;
                            case(5):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                                break;
                        }
                    }else{
                        int a = (int)((Math.random()*10) % 6);   
                        switch(a){
                            case(0):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                                break;
                            case(1):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                                break;
                            case(2):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.WHITE);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.BLACK);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                                break;
                            case(3):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.BLACK);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.WHITE);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                                break; 
                            case(4):
                                pixel1.setColor(k, l, Color.WHITE);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel1.setColor(k+1, l+1, Color.BLACK);
                                pixel2.setColor(k, l, Color.BLACK);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.WHITE);
                            case(5):
                                pixel1.setColor(k, l, Color.BLACK);
                                pixel1.setColor(k+1, l, Color.BLACK);
                                pixel1.setColor(k, l+1, Color.WHITE);
                                pixel1.setColor(k+1, l+1, Color.WHITE);
                                pixel2.setColor(k, l, Color.WHITE);
                                pixel2.setColor(k+1, l, Color.WHITE);
                                pixel2.setColor(k, l+1, Color.BLACK);
                                pixel2.setColor(k+1, l+1, Color.BLACK);
                        }  
                    }
                    k += 2;
                }
                k=0;
                l+=2;
            }
            ImageView img1 = new ImageView();
            ImageView img2 = new ImageView();
            img1.setImage(imagen1);
            img2.setImage(imagen2);
            final Stage secondaryStage = new Stage(StageStyle.DECORATED);
            StackPane picture1 = new StackPane();   
            Scene escenario = new Scene(picture1, 400, 500, Color.rgb(100, 6, 200));
            picture1.getChildren().add(img1);
            secondaryStage.setScene(escenario);
            secondaryStage.setOpacity(.7);
            secondaryStage.show();
            final Stage thirdStage = new Stage(StageStyle.DECORATED);
            StackPane picture = new StackPane();   
            Scene escenareios = new Scene(picture, 400, 500, Color.rgb(100, 6, 200));
            picture.getChildren().add(img2);
            thirdStage.setScene(escenareios);
            thirdStage.setOpacity(.7);
            thirdStage.show();
            ImageIO.write(SwingFXUtils.fromFXImage(imagen1, null),
                    "png", new File("Cifrado_1.png"));
            ImageIO.write(SwingFXUtils.fromFXImage(imagen2, null),
                    "png", new File("Cifrado_2.png"));
        } catch (IOException ex){
            System.err.println("Revise que el archivo de entrada sea "
                    + "valido y esté correcto.");
        }
    } 
    
    /*
    * Metodo que descifra 2 imagenes y las convierte en una sola sin ruido.
    * @param img1 - es la primera imagen a descifrar.
    * @param img2 - es la segunda imagen a descifrar.
    */
    public static void descifrar(Image img1, Image img2)
    throws IOException{
        double y1 = img1.getHeight();
        double x1 = img1.getWidth();
        double y2 = img2.getHeight();
        double x2 = img2.getWidth();
        if(y1 != y2 || x1 != x2){
            System.err.println("Los archivos no son iguales, "
                    + "favor de descifrar archivos válidos.");
        }else{
            PixelReader pixel1 = img1.getPixelReader();
            PixelReader pixel2 = img2.getPixelReader();
            WritableImage original;
            original = new WritableImage((int)img1.getWidth()/2, (int)img2.getHeight()/2);
            PixelWriter escritor = original.getPixelWriter();
            for(int i = 0; i < img1.getHeight(); i+=2){
                for(int j = 0; j< img2.getWidth(); j+=2){
                    Color c1 = pixel1.getColor(j, i);
                    Color c2 = pixel2.getColor(j, i);
                    if (c1.equals(c2)){
                        escritor.setColor(j/2, i/2, Color.WHITE);
                    }else{
                        escritor.setColor(j/2, i/2, Color.BLACK); 
                    }      
                }
            }        
            BufferedImage buffe = SwingFXUtils.fromFXImage(original, null);
            File descifrada = new File("Original.png");
            try {
                ImageIO.write(buffe, "png", descifrada);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }    
        }
    }
} //Fin de la clase Criptografia.java
