/*
 * Autores de la clase Criptografia.java:
 * José Ricardo Rodríguez Abreu.
 * Clase hecha con la finalidad de cifrar y descifrar una imagen.
 * Esta clase fue terminada el 10 de Noviembre del 2013.
 */
package Criptografia;

import java.awt.image.BufferedImage;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javax.imageio.ImageIO;

/**
 * @author Jose Ricardo Rodriguez Abreu
 * @version 3.0
 * @since Noviembre, 10.
 */
public class Criptografia {

    /**
     * Metodo que cifra una imagen en otras 2.
     *
     * @param img - es la imagen a cifrar.
     * @throws java.io.IOException
     */
    public static void cifra(Image img)
            throws IOException {
//        try {
        int y = (int) (img.getHeight());
        int x = (int) (img.getWidth());
        int k = 0;
        int l = 0;
        final WritableImage imagen1 = new WritableImage((int) (x * 2), (int) (y * 2));
        final WritableImage imagen2 = new WritableImage((int) (x * 2), (int) (y * 2));
        PixelReader pixel = img.getPixelReader();
        PixelWriter pixel1 = imagen1.getPixelWriter();
        PixelWriter pixel2 = imagen2.getPixelWriter();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Color c = pixel.getColor(j, i);
                if (c.equals(Color.WHITE)) {
                    int a = (int) ((Math.random() * 10) % 6);
                    switch (a) {
                        case (0):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                            break;
                        case (1):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                            break;
                        case (2):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                            break;
                        case (3):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                            break;
                        case (4):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                            break;
                        case (5):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                            break;
                    }
                } else {
                    int a = (int) ((Math.random() * 10) % 6);
                    switch (a) {
                        case (0):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                            break;
                        case (1):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                            break;
                        case (2):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.WHITE);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.BLACK);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                            break;
                        case (3):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.BLACK);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.WHITE);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                            break;
                        case (4):
                            pixel1.setColor(k, l, Color.WHITE);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel1.setColor(k + 1, l + 1, Color.BLACK);
                            pixel2.setColor(k, l, Color.BLACK);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.WHITE);
                        case (5):
                            pixel1.setColor(k, l, Color.BLACK);
                            pixel1.setColor(k + 1, l, Color.BLACK);
                            pixel1.setColor(k, l + 1, Color.WHITE);
                            pixel1.setColor(k + 1, l + 1, Color.WHITE);
                            pixel2.setColor(k, l, Color.WHITE);
                            pixel2.setColor(k + 1, l, Color.WHITE);
                            pixel2.setColor(k, l + 1, Color.BLACK);
                            pixel2.setColor(k + 1, l + 1, Color.BLACK);
                    }
                }
                k += 2;
            }
            k = 0;
            l += 2;
        }
        ImageView img1 = new ImageView();
        ImageView img2 = new ImageView();
        img1.setImage(imagen1);
        img2.setImage(imagen2);
        Button btn1 = new Button("Guardar");
        Button btn3 = new Button("Guardar");
        Button btn2 = new Button("Salir");
        Button btn4 = new Button("Salir");
        final Stage secondaryStage = new Stage(StageStyle.DECORATED);
        StackPane picture1 = new StackPane();
        Scene escenario = new Scene(picture1, 600, 550, Color.rgb(100, 6, 200));
        picture1.getChildren().add(img1);
        secondaryStage.setScene(escenario);
        secondaryStage.setOpacity(.7);
        final Stage thirdStage = new Stage(StageStyle.DECORATED);
        StackPane picture = new StackPane();
        Scene escenareios = new Scene(picture, 600, 550, Color.rgb(100, 6, 200));
        picture.getChildren().add(img2);
        thirdStage.setScene(escenareios);
        thirdStage.setOpacity(.7);
        picture1.getChildren().addAll(btn2, btn1);
        picture1.setAlignment(btn2, Pos.BOTTOM_LEFT);
        picture1.setAlignment(btn1, Pos.BOTTOM_RIGHT);
        picture1.setMargin(btn2, new Insets(30));
        picture1.setMargin(btn1, new Insets(30));
        picture.getChildren().addAll(btn4, btn3);
        picture.setAlignment(btn4, Pos.BOTTOM_LEFT);
        picture.setAlignment(btn3, Pos.BOTTOM_RIGHT);
        picture.setMargin(btn4, new Insets(30));
        picture.setMargin(btn3, new Insets(30));
        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(secondaryStage);
                try {

                    ImageIO.write(SwingFXUtils.fromFXImage(imagen1, null),
                            "png", file);
                    secondaryStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        });
        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(thirdStage);
                try {

                    ImageIO.write(SwingFXUtils.fromFXImage(imagen2, null),
                            "png", file);
                    thirdStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);

                }
            }

        });

        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                //thirdStage.close();
                secondaryStage.close();

            }
        });
        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                //secondaryStage.close();
                thirdStage.close();
            }
        });

        secondaryStage.show();
        thirdStage.show();

    }

    /*
     * Metodo que descifra 2 imagenes y las convierte en una sola sin ruido.
     * @param img1 - es la primera imagen a descifrar.
     * @param img2 - es la segunda imagen a descifrar.
     */
    public static void descifrar(Image img1, Image img2)
            throws IOException {
        double y1 = img1.getHeight();
        double x1 = img1.getWidth();
        double y2 = img2.getHeight();
        double x2 = img2.getWidth();
        if (y1 != y2 || x1 != x2) {
            System.err.println("Los archivos no son iguales, "
                    + "favor de descifrar archivos válidos.");
        } else {
            PixelReader pixel1 = img1.getPixelReader();
            PixelReader pixel2 = img2.getPixelReader();
            WritableImage original;
            original = new WritableImage((int) img1.getWidth() / 2, (int) img2.getHeight() / 2);
            PixelWriter escritor = original.getPixelWriter();
            for (int i = 0; i < img1.getHeight(); i += 2) {
                for (int j = 0; j < img2.getWidth(); j += 2) {
                    Color c1 = pixel1.getColor(j, i);
                    Color c2 = pixel2.getColor(j, i);
                    if (c1.equals(c2)) {
                        escritor.setColor(j / 2, i / 2, Color.WHITE);
                    } else {
                        escritor.setColor(j / 2, i / 2, Color.BLACK);
                    }
                }
            }
            final BufferedImage buffe = SwingFXUtils.fromFXImage(original, null);
            File descifrada = new File("Original.png");
            final Stage secondaryStage = new Stage(StageStyle.DECORATED);
            BorderPane picture1 = new BorderPane();
            Button btn1 = new Button("Guardar");
            Button btn2 = new Button("Salir");
            ImageView img = new ImageView();
            img.setImage(original);
            picture1.setAlignment(btn1, Pos.CENTER_RIGHT);
            picture1.setAlignment(btn2, Pos.CENTER_LEFT);
            picture1.setAlignment(img, Pos.CENTER);
            picture1.setLeft(btn2);
            picture1.setRight(btn1);
            picture1.setCenter(img);
            picture1.setMargin(btn2, new Insets(30));
            picture1.setMargin(btn1, new Insets(30));
            Scene escenario = new Scene(picture1, 600, 550, Color.rgb(100, 6, 200));
            secondaryStage.setScene(escenario);
            btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    secondaryStage.close();
                }
            });
            btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    FileChooser fileChooser = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showSaveDialog(secondaryStage);
                    try {
                        ImageIO.write(buffe, "png", file);
                        secondaryStage.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            secondaryStage.show();
        }
    }
} //Fin de la clase Criptografia.java
