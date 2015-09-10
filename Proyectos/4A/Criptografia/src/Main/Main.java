/*
 * Autores de la clase Main.java:
 * José Ricardo Rodríguez Abreu.
 * Clase hecha con la finalidad de crear imagenes y ejecutar la clase Criptografía.
 * Esta clase fue terminada el 10 de Noviembre del 2013.
 */
package Main;

import static Criptografia.Criptografia.*;
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * @author Jose Ricardo Rodriguez Abreu
 * @version 4.0
 * @since Noviembre, 10.
 */
public class Main extends Application {

    /**
     * Metodo start de la clase.
     *
     * @param primaryStage - es el Stage de la clase.
     * @throws java.io.IOException
     */
    @Override
    public void start(final Stage primaryStage)
            throws IOException {
        final Stage stage = primaryStage;

        Button btn1 = new Button(" Cifrar  ");
        Button btn2 = new Button("Descifrar");
        Button btn3 = new Button("Salir");
        HBox hbox = new HBox(150);
        hbox.getChildren().addAll(btn3, btn2, btn1);

        Text tx1 = new Text("CIFRADO Y DESCIFRADO DE IMAGENES, \n"
                + "\nPara ejecutar el programa siga las siguientes instrucciones: \n"
                + "Seleccione una imagen en blanco y negro para cifrar. \n"
                + "Seleccione dos imagenes cifradas del mismo tipo para descifrar.");
        tx1.setFont(Font.font("verdana", 15));
        //Image port = new Image("File:src/Main/ImagenPortada.jpg");
        Image port = new Image(Main.class.getResourceAsStream("ImagenPortada.jpg"));
        ImageView port1 = new ImageView(port);

        final BorderPane border1 = new BorderPane();
        border1.setAlignment(tx1, Pos.CENTER);
        border1.setAlignment(port1, Pos.CENTER);
        border1.setAlignment(hbox, Pos.BOTTOM_CENTER);

        border1.setTop(port1);
        border1.setCenter(tx1);
        border1.setBottom(hbox);
        border1.setMargin(hbox, new Insets(30));

        final Scene scene = new Scene(border1, 600, 550, Color.rgb(100, 6, 200));
        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                stage.close();
            }
        });
        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                FileChooser ventana = new FileChooser();
                File archivo = ventana.showOpenDialog(stage);
                ventana.setTitle("Abrir");
                if (archivo != null) {
                    final Image imagen1;
                    try {
                        final Image imagenEntrada = new Image(new FileInputStream(archivo));
                        ImageView view = new ImageView(imagenEntrada);
                        view.setImage(imagenEntrada);
                        BorderPane border2 = new BorderPane();
                        HBox hbox1 = new HBox(150);
                        Text tx2 = new Text("\t\t    ¿Desea cifrar esta imagen?\n\n"
                                + "Nota: La imagen debe tener SÓLO pixeles en blanco y negro.");
                        tx2.setFont(Font.font("verdana", 18));
                        Button accion = new Button("Aceptar");
                        Button cancelar = new Button("Cancelar");
                        hbox1.getChildren().addAll(cancelar, accion);
                        border2.setAlignment(view, Pos.CENTER);
                        border2.setTop(view);
                        border2.setAlignment(tx2, Pos.CENTER);
                        border2.setCenter(tx2);
                        border2.setAlignment(hbox1, Pos.CENTER);
                        border2.setBottom(hbox1);
                        border2.setMargin(hbox1, new Insets(30, 30, 50, 150));
                        border2.setMargin(view, new Insets(50));
                        
                        scene.setRoot(border2);

                        accion.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent t) {
                                try {
                                    cifra(imagenEntrada);
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        });
                        cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent t) {
                                scene.setRoot(border1);
                            }

                        });
                    } catch (IOException ex) {

                    }
                } else if (archivo == null) {
                }
            }
        });
btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                FileChooser ventana = new FileChooser();
                File archivo = ventana.showOpenDialog(stage);
                FileChooser ventana2 = new FileChooser();
                File archivo2 = ventana2.showOpenDialog(stage);
               
               
                
                ventana.setTitle("Abrir archivo 1");
                ventana2.setTitle("Abrir archivo 2");
                if (archivo != null) {
                    final Image imagen1;
                    final Image imagen2;
                    try {
                        final Image imagenEntrada = new Image(new FileInputStream(archivo));
                        final Image imagenEntrada2 = new Image(new FileInputStream(archivo2));
                        ImageView view = new ImageView(imagenEntrada);
                        ImageView view2 = new ImageView(imagenEntrada2);
                        view.setImage(imagenEntrada);
                        view2.setImage(imagenEntrada2);
                        BorderPane border3 = new BorderPane();
                        HBox hbox0 = new HBox(30);
                        hbox0.getChildren().addAll(view, view2);
                        HBox hbox2 = new HBox(150);
                        Text tx2 = new Text("\t\t    ¿Desea descifrar estas imagenes?\n\n"
                                + "Nota: Asegurese que ambas imagenes sean parte de la misma original.");
                        tx2.setFont(Font.font("verdana", 16));
                        Button accion = new Button("Aceptar");
                        Button cancelar = new Button("Cancelar");
                        hbox2.getChildren().addAll(cancelar, accion);
                        border3.setAlignment(hbox0, Pos.TOP_CENTER);
                        border3.setTop(hbox0);
                        border3.setAlignment(tx2, Pos.CENTER);
                        border3.setCenter(tx2);
                        border3.setMargin(tx2, new Insets(30, 0, 0, 0));
                        border3.setAlignment(hbox2, Pos.CENTER);
                        border3.setBottom(hbox2);
                        border3.setMargin(hbox2, new Insets(0, 30, 50, 150));
                        border3.setMargin(view, new Insets(20));
                        primaryStage.setMaxHeight(750);
                        primaryStage.setMinHeight(750);
                        primaryStage.setMaxWidth(600);
                        primaryStage.setMinWidth(600);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        
                        scene.setRoot(border3);

                        accion.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent t) {
                                try {
                                    descifrar(imagenEntrada, imagenEntrada2);
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        });
                        cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent t) {
                                scene.setRoot(border1);
                            }

                        });
                    } catch (IOException ex) {

                    }
                } else if (archivo == null) {
                }
            }
        });

        primaryStage.setTitle("Encriptación Gráfica");
        primaryStage.setMaxHeight(550);
        primaryStage.setMinHeight(550);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinWidth(600);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*
         ImageView pro = new ImageView();
         ImageView noob = new ImageView();
         pro.setImage(imagen1);
         noob.setImage(imagen2);
         Image resultado1= imagen1;
         Image resultado2 = imagen2;
         final Stage secondaryStage = new Stage(StageStyle.DECORATED);
         StackPane pictur = new StackPane();   
         Scene escenareio = new Scene(pictur, 300, 250, Color.rgb(100, 6, 200));
         pictur.getChildren().add(pro);
         secondaryStage.setScene(escenareio);
         secondaryStage.show();
         */
        /*try{
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
         Platform.exit();
         }*/
    }

    /**
     * Metodo principal de la clase.
     *
     * @param args son los argumentos de la clase.
     */
    public static void main(String[] args) {
        launch(args);
    }
} //Fin de Main.java
