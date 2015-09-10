/*
 * Copyright (C) 2013 Rodríguez Abreu José Ricardo
 *                    Zamora Gutiérrez Víctor.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package automatacelular;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @since Nov 24, 2013.
 * @version 1.0
 * @author Jose Ricardo Rodriguez Abreu y Zamora Gutierrez Victor.
 */
public class AutomataCelular extends Application {

    boolean valor = true;

    /**
     * Metodo para saber si un String es un numero o no.
     *
     * @param str - es el String a verificar si puede ser disfrazado.
     * @return verdadero si se puede disfrazar o falso de lo contrario.
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Metodo start de la clase.
     *
     * @param primaryStage - es el Stage principal de el programa.
     */
    @Override
    public void start(final Stage primaryStage) {
        final GridPane nodo = new GridPane();
        final BorderPane border1 = new BorderPane();
        nodo.setVgap(1);
        nodo.setHgap(1);

        primaryStage.setTitle("Automata Celular");
        final Scene scene = new Scene(border1, 400, 400, Color.rgb(100, 6, 200));
        final Celda[][] malla = new Celda[110][60];
        Text creditos = new Text("\t\t Creador: \t\t\n"
                + "Rodríguez Abreu José Ricardo.\n");

        Button incendio = new Button("Incendio");
        Button terremoto = new Button("Terremoto");
        Button epidemia = new Button("Epidemia");

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(incendio, epidemia);
        hbox1.setMinHeight(100);
        hbox1.setSpacing(147);
        hbox1.setMargin(incendio, new Insets(0, 30, 0, 30));

        HBox hbox2 = new HBox();
        hbox2.getChildren().add(terremoto);
        hbox2.setMargin(terremoto, new Insets(270, 0, 0, 150));

        BorderPane.setAlignment(hbox1, Pos.CENTER);
        BorderPane.setAlignment(hbox2, Pos.BOTTOM_CENTER);
        border1.setLeft(hbox2);
        border1.setBottom(hbox1);
        BorderPane.setAlignment(creditos, Pos.TOP_RIGHT);
        border1.setRight(creditos);

        final Stage errorVentana = new Stage();
        errorVentana.setMinWidth(120);
        errorVentana.setMinHeight(100);
        Text textoWarning1 = new Text("Revise que todos los campos "
                + "sean válidos: \n"
                + "1. Los porcentajes de incendio se dan entre el 0 y 100.\n"
                + "2. La fuerza delta debe estar dada entre los valores 0 y 4.\n"
                + "3. La taza de contagio debe de estar dada entre los valores 0 y 100");

        Button acept = new Button("Aceptar");
        StackPane r = new StackPane();
        r.setMinSize(400, 200);
        r.getChildren().addAll(textoWarning1, acept);
        StackPane.setAlignment(acept, Pos.BOTTOM_RIGHT);
        r.setMargin(acept, new Insets(5));
        Scene warning = new Scene(r, 525, 120, Color.RED);
        errorVentana.setScene(warning);
        errorVentana.setTitle("¡ERROR!");
        acept.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                errorVentana.close();
            }

        });
        incendio.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                final TextField texto1 = new TextField();
                final TextField texto2 = new TextField();
                final TextField texto3 = new TextField();
                final TextField texto4 = new TextField();

                Text tx1 = new Text("% de nacimiento de nuevo árbol");
                Text tx2 = new Text("% de combustión espontanea");
                Text tx3 = new Text("% de incendio");
                Text tx4 = new Text("Caso de inicio");
                Text tx5 = new Text("CASOS DE INICIO: \n"
                        + "Nota: Para comenzar con un caso aleatorio\n "
                        + "coloque la letra \"A\", "
                        + "para comenzar  con un"
                        + "\n caso donde todos sean árbol coloque "
                        + "la \n letra \"B\". Si desea empezar el caso "
                        + "donde \n todo es tierra coloque la letra \"C\".");

                final BorderPane border2 = new BorderPane();
                Button aceptar = new Button("Aceptar");
                Button cancelar = new Button("Cancelar");

                HBox hbox3 = new HBox();
                hbox3.getChildren().addAll(cancelar, aceptar);
                hbox3.setSpacing(50);

                VBox vbox1 = new VBox();
                vbox1.getChildren().addAll(texto1, texto2, texto3, texto4);
                vbox1.setSpacing(30);
                VBox hbox2 = new VBox();

                hbox2.getChildren().addAll(tx1, tx3, tx2, tx4);
                hbox2.setSpacing(35);
                BorderPane.setAlignment(tx5, Pos.CENTER);
                border2.setLeft(tx5);
                border2.setMargin(tx5, new Insets(50, 30, 35, 30));
                BorderPane.setAlignment(vbox1, Pos.CENTER_LEFT);
                border2.setTop(vbox1);
                border2.setMargin(vbox1, new Insets(50, 250, 0, 30));
                BorderPane.setAlignment(hbox2, Pos.CENTER_RIGHT);
                border2.setRight(hbox2);
                border2.setMargin(hbox2, new Insets(0, 30, 275, 30));
                BorderPane.setAlignment(hbox3, Pos.BOTTOM_RIGHT);
                border2.setBottom(hbox3);
                border2.setMargin(hbox3, new Insets(15, 1, 10, 180));
                scene.setRoot(border2);
                cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        scene.setRoot(border1);
                    }

                });
                aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        BorderPane border3 = new BorderPane();

                        final Button play = new Button("Play");
                        play.setTextFill(Color.RED);
                        final Button pause = new Button("Pause");
                        pause.setTextFill(Color.BLUE);
                        Button atras = new Button("Regresar");
                        Button inicio = new Button("Inicio");

                        HBox hbox2 = new HBox();
                        hbox2.getChildren().addAll(inicio, atras, play, pause);
                        hbox2.setSpacing(70);
                        if ((texto1.getText().isEmpty()) || (texto2.getText().isEmpty()) || (texto3.getText().isEmpty())
                                || texto4.getText().isEmpty()) {
                            errorVentana.show();
                        } else {
                            if (!(isNumeric(texto1.getText())
                                    && isNumeric(texto2.getText())
                                    && isNumeric(texto3.getText()))) {
                                errorVentana.show();
                            } else {
                                final double par1 = (Double.parseDouble(texto1.getText()));
                                final double par2 = (Double.parseDouble(texto2.getText()));
                                final double par3 = (Double.parseDouble(texto3.getText()));

                                if ((par1 > 100 || par1 < 0)
                                        || (par2 > 100 || par2 < 0)
                                        || (par3 > 100 || par3 < 0)
                                        || ((texto4.getText().startsWith("a"))
                                        && (texto4.getText().startsWith("b"))
                                        && (texto4.getText().startsWith("c")))) {
                                    errorVentana.show();
                                } else {
                                    if (texto4.getText().equalsIgnoreCase("a")) {
                                        for (int i = 0; i < 110; i++) {
                                            for (int j = 0; j < 60; j++) {
                                                double r = Math.random() * 5;
                                                malla[i][j] = new Celda(nodo, i, j, (int) r) {
                                                };
                                            }
                                        }
                                    } else if (texto4.getText().equalsIgnoreCase("c")) {
                                        for (int i = 0; i < 110; i++) {
                                            for (int j = 0; j < 60; j++) {
                                                malla[i][j] = new Celda(nodo, i, j, 0) {
                                                };

                                            }
                                        }
                                        malla[55][30] = new Celda(nodo, 55, 30, 2) {
                                        };
                                    } else if (texto4.getText().equalsIgnoreCase("b")) {
                                        for (int i = 0; i < 110; i++) {
                                            for (int j = 0; j < 60; j++) {
                                                malla[i][j] = new Celda(nodo, i, j, 1) {
                                                };
                                            }
                                        }
                                        malla[55][30] = new Celda(nodo, 55, 30, 2) {
                                        };
                                    }
                                    final Thread th = new Thread(new Task() {
                                        @Override
                                        protected Void call() throws InterruptedException {
                                            valor = true;
                                            while (true) {
                                                boolean valor2 = valor;
                                                if (valor2) {
                                                    cambiaMalla(malla, "incendio", par1 / 100, par2 / 100, par3 / 100);
                                                    if (isCancelled()) {
                                                        break;
                                                    }
                                                    Thread.sleep(200);
                                                }
                                                pause.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                                    @Override
                                                    public void handle(MouseEvent t) {
                                                        valor = false;
                                                    }
                                                });

                                            }
                                            return null;
                                        }
                                    });
                                    play.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                        @Override
                                        public void handle(MouseEvent t) {
                                            valor = true;
                                        }
                                    });
                                    BorderPane.setAlignment(nodo, Pos.CENTER);
                                    BorderPane.setAlignment(hbox2, Pos.BOTTOM_RIGHT);

                                    border3.setBottom(hbox2);
                                    border3.setCenter(nodo);
                                    border3.setMargin(hbox2, new Insets(15, 10, 10, 600));

                                    th.setDaemon(true);
                                    th.start();
                                    scene.setRoot(border3);

                                    primaryStage.setScene(scene);
                                    primaryStage.setResizable(false);
                                    primaryStage.setMaxWidth(1100);
                                    primaryStage.setMaxHeight(730);
                                    primaryStage.setMinWidth(1100);
                                    primaryStage.setMinHeight(730);

                                    inicio.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                        @Override
                                        public void handle(MouseEvent t) {
                                            th.interrupt();
                                            scene.setRoot(border1);
                                            primaryStage.setScene(scene);
                                            primaryStage.setResizable(false);
                                            primaryStage.setMaxWidth(400);
                                            primaryStage.setMaxHeight(400);
                                            primaryStage.setMinWidth(400);
                                            primaryStage.setMinHeight(400);
                                        }
                                    });

                                    atras.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                        @Override
                                        public void handle(MouseEvent t) {
                                            th.interrupt();
                                            scene.setRoot(border2);
                                            primaryStage.setScene(scene);
                                            primaryStage.setResizable(false);
                                            primaryStage.setMaxWidth(400);
                                            primaryStage.setMaxHeight(400);
                                            primaryStage.setMinWidth(400);
                                            primaryStage.setMinHeight(400);
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
            }
        });

        terremoto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                final TextField texto1 = new TextField();
                final TextField texto2 = new TextField();
                Text tx1 = new Text("Fuerza delta");
                Text tx2 = new Text("Caso de inicio");
                Text tx3 = new Text("\t\t CASOS DE INICIO: \n"
                        + " Nota: Para comenzar con un caso aleatorio\n "
                        + "coloque la letra \"A\" y "
                        + "para comenzar  con un"
                        + "\n caso donde todos la onda empieze en el centro, \n "
                        + "coloque la letra \"B\".");

                final BorderPane border2 = new BorderPane();

                Button aceptar = new Button("Aceptar");
                Button cancelar = new Button("Cancelar");

                HBox hbox3 = new HBox();
                hbox3.getChildren().addAll(cancelar, aceptar);
                hbox3.setSpacing(50);

                VBox vbox1 = new VBox();
                vbox1.getChildren().addAll(texto1, texto2);
                vbox1.setSpacing(30);
                VBox hbox2 = new VBox();

                hbox2.getChildren().addAll(tx1, tx2);
                hbox2.setSpacing(35);

                BorderPane.setAlignment(vbox1, Pos.BOTTOM_LEFT);
                border2.setTop(vbox1);
                border2.setMargin(vbox1, new Insets(50, 250, 0, 50));
                BorderPane.setAlignment(hbox2, Pos.CENTER_RIGHT);
                border2.setRight(hbox2);
                border2.setMargin(hbox2, new Insets(55, 50, 330, 50));
                BorderPane.setAlignment(hbox3, Pos.BOTTOM_RIGHT);
                border2.setBottom(hbox3);
                border2.setMargin(hbox3, new Insets(15, 1, 10, 180));
                scene.setRoot(border2);
                BorderPane.setAlignment(tx3, Pos.CENTER_RIGHT);
                border2.setLeft(tx3);
                border2.setMargin(tx3, new Insets(0, 0, 0, 50));
                cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        scene.setRoot(border1);
                    }

                });

                aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        BorderPane border3 = new BorderPane();
                        Button play = new Button("Play");
                        play.setTextFill(Color.RED);
                        Button pause = new Button("Pause");
                        pause.setTextFill(Color.BLUE);
                        Button atras = new Button("Regresar");
                        Button inicio = new Button("Inicio");
                        HBox hbox2 = new HBox();
                        hbox2.getChildren().addAll(inicio, atras, play, pause);
                        hbox2.setSpacing(50);
                        if (!(isNumeric(texto1.getText())) || (texto1.getText().isEmpty())
                                || isNumeric(texto2.getText()) || texto2.getText().isEmpty()) {
                            errorVentana.show();
                        } else {
                            final double par1 = (Double.parseDouble(texto1.getText()));
                            if ((par1 > 4) || (par1 < 0) || !((texto2.getText().startsWith("a"))
                                    || (texto2.getText().startsWith("b"))
                                    || (texto2.getText().startsWith("A"))
                                    || (texto2.getText().startsWith("B")))) {

                                errorVentana.show();
                            } else {
                                if (texto2.getText().equalsIgnoreCase("a")) {
                                    for (int i = 0; i < 110; i++) {
                                        for (int j = 0; j < 60; j++) {
                                            double r = Math.random() * 5;
                                            malla[i][j] = new Celda(nodo, i, j, (int) r) {
                                            };
                                        }
                                    }
                                } else if (texto2.getText().equalsIgnoreCase("b")) {
                                    for (int i = 0; i < 110; i++) {
                                        for (int j = 0; j < 60; j++) {
                                            double r = Math.random() * 4;
                                            malla[i][j] = new Celda(nodo, i, j, 0) {
                                            };
                                        }
                                    }
                                    malla[55][33] = new Celda(nodo, 55, 33, 4) {
                                    };
                                } else {
                                    errorVentana.show();
                                }
                                final Thread th = new Thread(new Task() {
                                    @Override
                                    protected Void call() throws InterruptedException {
                                        valor = true;
                                        while (true) {
                                            boolean valor2 = valor;
                                            if (valor2) {
                                                cambiaMalla(malla, "terremoto", par1);
                                                if (isCancelled()) {
                                                    break;
                                                }
                                                Thread.sleep(200);
                                            }
                                        }
                                        return null;
                                    }
                                });
                                BorderPane.setAlignment(nodo, Pos.CENTER);
                                BorderPane.setAlignment(hbox2, Pos.BOTTOM_RIGHT);

                                border3.setBottom(hbox2);
                                border3.setCenter(nodo);
                                border3.setMargin(hbox2, new Insets(15, 10, 10, 600));

                                th.setDaemon(true);
                                th.start();
                                scene.setRoot(border3);

                                primaryStage.setScene(scene);
                                primaryStage.setResizable(false);
                                primaryStage.setMaxWidth(1100);
                                primaryStage.setMaxHeight(730);
                                primaryStage.setMinWidth(1100);
                                primaryStage.setMinHeight(730);
                                inicio.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        th.interrupt();
                                        scene.setRoot(border1);
                                        primaryStage.setScene(scene);
                                        primaryStage.setResizable(false);
                                        primaryStage.setMaxWidth(400);
                                        primaryStage.setMaxHeight(400);
                                        primaryStage.setMinWidth(400);
                                        primaryStage.setMinHeight(400);
                                    }
                                });
                                atras.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        th.interrupt();
                                        scene.setRoot(border2);
                                        primaryStage.setScene(scene);
                                        primaryStage.setResizable(false);
                                        primaryStage.setMaxWidth(400);
                                        primaryStage.setMaxHeight(400);
                                        primaryStage.setMinWidth(400);
                                        primaryStage.setMinHeight(400);
                                    }
                                });
                                pause.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        valor = false;
                                    }
                                });
                                play.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        valor = true;
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });

        epidemia.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                final TextField texto1 = new TextField();
                final TextField texto2 = new TextField();
                Text tx1 = new Text("Taza de contagio");
                Text tx2 = new Text("Caso de inicio");
                Text tx3 = new Text("\t\t CASOS DE INICIO: \n"
                        + " Nota: Para comenzar con un caso aleatorio\n "
                        + "coloque la letra \"A\" y "
                        + "para comenzar  con un"
                        + "\n caso donde la infección empieze en el centro, \n "
                        + "coloque la letra \"B\".");

                final BorderPane border2 = new BorderPane();

                Button aceptar = new Button("Aceptar");
                Button cancelar = new Button("Cancelar");

                HBox hbox3 = new HBox();
                hbox3.getChildren().addAll(cancelar, aceptar);
                hbox3.setSpacing(50);

                VBox vbox1 = new VBox();
                vbox1.getChildren().addAll(texto1, texto2);
                vbox1.setSpacing(30);
                VBox hbox2 = new VBox();

                hbox2.getChildren().addAll(tx1, tx2);
                hbox2.setSpacing(35);

                BorderPane.setAlignment(vbox1, Pos.BOTTOM_LEFT);
                border2.setTop(vbox1);
                border2.setMargin(vbox1, new Insets(50, 250, 0, 50));
                BorderPane.setAlignment(hbox2, Pos.CENTER_RIGHT);
                border2.setRight(hbox2);
                border2.setMargin(hbox2, new Insets(55, 50, 330, 50));
                BorderPane.setAlignment(hbox3, Pos.BOTTOM_RIGHT);
                border2.setBottom(hbox3);
                border2.setMargin(hbox3, new Insets(15, 1, 10, 180));
                scene.setRoot(border2);
                BorderPane.setAlignment(tx3, Pos.CENTER_RIGHT);
                border2.setLeft(tx3);
                border2.setMargin(tx3, new Insets(0, 0, 0, 50));

                cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        scene.setRoot(border1);
                    }

                });

                aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        BorderPane border3 = new BorderPane();
                        Button play = new Button("Play");
                        play.setTextFill(Color.RED);
                        Button pause = new Button("Pause");
                        pause.setTextFill(Color.BLUE);
                        Button atras = new Button("Regresar");
                        Button inicio = new Button("Inicio");
                        HBox hbox2 = new HBox();
                        hbox2.getChildren().addAll(inicio, atras, play, pause);
                        hbox2.setSpacing(50);

                        if ((isNumeric(texto1.getText()) == false) || (texto1.getText().isEmpty())
                                || isNumeric(texto2.getText()) || texto2.getText().isEmpty()) {
                            errorVentana.show();
                        } else {
                            final double par = (Double.parseDouble(texto1.getText()));
                            if ((par > 100) || (par < 0) || !((texto2.getText().startsWith("a")
                                    || texto2.getText().startsWith("b"))
                                    || (texto2.getText().startsWith("A"))
                                    || (texto2.getText().startsWith("B")))) {
                                errorVentana.show();
                            } else {

                                if (texto2.getText().equalsIgnoreCase("a")) {
                                    for (int i = 0; i < 110; i++) {
                                        for (int j = 0; j < 60; j++) {
                                            double r = Math.random() * 16;
                                            malla[i][j] = new Celda(nodo, i, j, (int) r) {
                                            };
                                        }
                                    }
                                } else if (texto2.getText().equalsIgnoreCase("b")) {
                                    for (int i = 0; i < 110; i++) {
                                        for (int j = 0; j < 60; j++) {
                                            malla[i][j] = new Celda(nodo, i, j, 0) {
                                            };
                                        }
                                    }
                                    malla[55][33] = new Celda(nodo, 55, 33, 1) {
                                    };
                                } else {
                                    errorVentana.show();
                                }

                                final Thread th = new Thread(new Task() {
                                    @Override
                                    protected Void call() throws InterruptedException {
                                        valor = true;
                                        while (true) {
                                            boolean valor2 = valor;
                                            if (valor2) {
                                                cambiaMalla(malla, "epidemia", par / 100);
                                                if (isCancelled()) {
                                                    break;
                                                }
                                                Thread.sleep(200);
                                            }
                                        }
                                        return null;
                                    }
                                });
                                BorderPane.setAlignment(nodo, Pos.CENTER);
                                BorderPane.setAlignment(hbox2, Pos.BOTTOM_RIGHT);
                                border3.setBottom(hbox2);
                                border3.setCenter(nodo);

                                border3.setMargin(hbox2, new Insets(15, 10, 10, 600));
                                th.setDaemon(true);
                                th.start();
                                scene.setRoot(border3);
                                primaryStage.setScene(scene);
                                primaryStage.setResizable(false);
                                primaryStage.setMaxWidth(1100);
                                primaryStage.setMaxHeight(730);
                                primaryStage.setMinWidth(1100);
                                primaryStage.setMinHeight(730);
                                inicio.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        th.interrupt();
                                        scene.setRoot(border1);
                                        primaryStage.setScene(scene);
                                        primaryStage.setResizable(false);
                                        primaryStage.setMaxWidth(400);
                                        primaryStage.setMaxHeight(400);
                                        primaryStage.setMinWidth(400);
                                        primaryStage.setMinHeight(400);
                                    }
                                });
                                atras.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        th.interrupt();
                                        scene.setRoot(border2);
                                        primaryStage.setScene(scene);
                                        primaryStage.setResizable(false);
                                        primaryStage.setMaxWidth(400);
                                        primaryStage.setMaxHeight(400);
                                        primaryStage.setMinWidth(400);
                                        primaryStage.setMinHeight(400);
                                    }
                                });
                                pause.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        valor = false;
                                    }
                                });
                                play.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        valor = true;
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);

        primaryStage.show();
          }

    public static synchronized void cambiaMalla(Celda[][] malla, String queEs, double... prob) {
        int k = malla[0].length;
        int l = malla.length;
        //int p = 1;
        if (queEs.equalsIgnoreCase("incendio")) {
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    if (i == 0 && j != 0) {
                        int[] incendiario
                                = {malla[(malla.length - 1) % l][(j - 1) % k].getEstadoAnterior(),
                                    malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoIncendio(incendiario, prob[0], prob[1], prob[2]);

                    } else if (i != 0 && j == 0) {
                        int[] incendiario
                                = {malla[(i - 1) % l][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoIncendio(incendiario, prob[0], prob[1], prob[2]);

                    } else if (i == 0 && j == 0) {
                        int[] incendiario
                                = {malla[(malla.length - 1) % l][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoIncendio(incendiario, prob[0], prob[1], prob[2]);

                    } else {
                        int[] incendiario
                                = {malla[(i - 1) % l][(j - 1) % k].getEstadoAnterior(),
                                    malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior(),
                                    malla[(i + 1) % l][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoIncendio(incendiario, prob[0], prob[1], prob[2]);
                    }
                    if (malla[i][j].getEstado() == 0) {
                        malla[i][j].getRectangulo().setFill(Color.SADDLEBROWN);
                    } else if (malla[i][j].getEstado() == 1) {
                        malla[i][j].getRectangulo().setFill(Color.GREEN);
                    } else {
                        malla[i][j].getRectangulo().setFill(Color.RED);
                    }
                }
            }
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    malla[i][j].setEstadoAnterior();
                }
            }
        } else if (queEs.equalsIgnoreCase("terremoto")) {
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    if (i == 0 && j != 0) {
                        int[] earthquake
                                = {malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoTerremoto(earthquake, (int) prob[0]);

                    } else if (i != 0 && j == 0) {
                        int[] earthquake
                                = {malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoTerremoto(earthquake, (int) prob[0]);

                    } else if (i == 0 && j == 0) {
                        int[] earthquake
                                = {malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoTerremoto(earthquake, (int) prob[0]);

                    } else {
                        int[] earthquake
                                = {malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoTerremoto(earthquake, (int) prob[0]);
                    }
                    if (malla[i][j].getEstado() >= 4) {
                        malla[i][j].getRectangulo().setFill(Color.RED);
                    } else {
                        malla[i][j].getRectangulo().setFill(Color.BLACK);
                    }
                }
            }
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    malla[i][j].setEstadoAnterior();
                }
            }
        } else if (queEs.equalsIgnoreCase("epidemia")) {
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    if (i == 0 && j != 0) {
                        int[] enfermedad
                                = {malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoEpidemia(enfermedad, prob[0]);

                    } else if (i != 0 && j == 0) {
                        int[] enfermedad
                                = {malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoEpidemia(enfermedad, prob[0]);

                    } else if (i == 0 && j == 0) {
                        int[] enfermedad
                                = {malla[i][(malla[0].length - 1) % k].getEstadoAnterior(),
                                    malla[(malla.length - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoEpidemia(enfermedad, prob[0]);

                    } else {
                        int[] enfermedad
                                = {malla[i][(j - 1) % k].getEstadoAnterior(),
                                    malla[(i - 1) % l][j].getEstadoAnterior(),
                                    malla[(i + 1) % l][j].getEstadoAnterior(),
                                    malla[i][(j + 1) % k].getEstadoAnterior()};
                        malla[i][j].calculaEstadoEpidemia(enfermedad, prob[0]);
                    }
                    if (malla[i][j].getEstado() == 0) {
                        malla[i][j].getRectangulo().setFill(Color.PEACHPUFF);
                    } else if (malla[i][j].getEstado() > 0 && malla[i][j].getEstado() < 8) {
                        malla[i][j].getRectangulo().setFill(Color.GRAY);
                    } else {
                        malla[i][j].getRectangulo().setFill(Color.GOLD);
                    }
                }
            }
            for (int i = 0; i < malla.length; i++) {
                for (int j = 0; j < malla[i].length; j++) {
                    malla[i][j].setEstadoAnterior();
                }
            }
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
