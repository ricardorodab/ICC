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

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @since Nov 24, 2013.
 * @version 1.0
 * @author Jose Ricardo Rodriguez Abreu y Zamora Gutierrez Victor.
 */
public abstract class Celda {

    private int estado;
    private final Rectangle rect;
    private int estadoAnt;

    /**
     * Metodo que construye una celda
     *
     * @param panel - es el panel donde pertenece la celda.
     * @param i - es la posicion en el eje de las x de las celdas.
     * @param j - es la posicion en el eje de las y de las celdas.
     * @param estadoIn - es el estado inicial que recibe cada celda.
     */
    public Celda(GridPane panel, int i, int j, int estadoIn) {
        this.rect = new Rectangle(10, 10, Color.BLACK);
        this.estado = estadoIn;
        this.estadoAnt = estadoIn;
        panel.add(rect, i, j);
    }

    /**
     * Metodo que nos regresa el triangulo de una celda.
     *
     * @return rect - es el rectangulo de cada celda.
     */
    public Rectangle getRectangulo() {
        return this.rect;
    }

    /**
     * Metodo que nos regresa el estado actual de cada celda.
     *
     * @return estado - es el estado de cada celda.
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Metodo que nos regresa el estado anterior de cada celda.
     *
     * @return estadoAnt - es el estado anterior de cada celda.
     */
    public int getEstadoAnterior() {
        return estadoAnt;
    }

    /**
     * Metodo que nos permite cambiar el estado actual de cada celda.
     *
     * @param nuevoEstado es el futuro nuevo estado de la celda.
     */
    public void setEstado(int nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Metodo que nos permite cambiar el estado anterior por el actual de cada
     * celda.
     */
    public void setEstadoAnterior() {
        this.estadoAnt = this.estado;
    }

    /**
     * Metodo con el que calculamos cada futuro estado de una celda de tipo
     * terremoto.
     *
     * @param estado - son los estados de las celdas vecinas.
     * @param delta - es un entero que simula la energía liberada.
     */
    public synchronized void calculaEstadoTerremoto(int[] estado, int delta) {
        int x = 0;
        if (this.getEstado() >= 4) {
            this.setEstado(0);
        } else {
            for (int i = 0; i < estado.length; i++) {
                if (estado[i] >= 4) {
                    x++;
                }
            }
            this.setEstado(this.getEstado() + x + delta);
        }
    }

    /**
     * Metodo con el que calculamos cada futuro estado de una celda de tipo
     * epidemia.
     *
     * @param estado - son los estados de las celdas vecinas.
     * @param probabilidad - es un entero que simula la energía liberada.
     */
    public synchronized void calculaEstadoEpidemia(int[] estado, double probabilidad) {
        int x = 0;
        if (this.getEstado() != 0) {
            this.setEstado((this.getEstado() + 1) % 17);
        } else {
            for (int i = 0; i < estado.length; i++) {
                if (estado[i] == 0 || estado[i] > 8) {
                    x++;
                }

            }
            if (x != estado.length) {
                double proba = Math.random();
                if (proba < probabilidad) {
                    this.setEstado(1);

                }
            }
        }
    }

    /**
     * Metodo con el que calculamos cada futuro estado de una celda de tipo
     * incendio.
     *
     * @param estado - es el estado de cada celda vecina.
     * @param p - simula la probabilidad de que se cree un árbol.
     * @param g - simula la probabilidad de que un arbol se incendie.
     * @param f - simula la probabilidad de que haya fuego espontaneo.
     */
    public synchronized void calculaEstadoIncendio(int[] estado, double p, double g, double f) {
        if (this.getEstado() == 0) {
            double surgeArbol = Math.random();
            if (surgeArbol < p) {
                this.setEstado(1);
            }
        } else if (this.getEstado() == 1) {
            int x = 0;
            for (int i = 0; i < estado.length; i++) {
                if (estado[i] == 2) {
                    x++;
                }
            }
            if (x == 0) {
                double espontanea = Math.random();
                if (espontanea < (f * (1 - g))) {
                    this.setEstado(2);
                }
            } else {
                double enLlamas = Math.random();
                if (enLlamas > (1 - g)) {
                    this.setEstado(2);
                }
            }
        } else {
            this.setEstado(0);
        }
    }
} //Fin de Celda.java
