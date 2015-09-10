/*
 * Tarjeta de tipo Tierra.
 */

package tarjeta;

/**
 *Esta clase crea atributos y metodos para ejecutarlo desde *un main exterior
 *@author Jose Ricardo Rodriguez Abreu
 *@version 2.0
 *@since Octubre 6, 2013.
 */ 

public class Tierra extends Tarjeta{
    
    /** 
     * Metodo constructor para crear la tarjeta tierra.
     * @param nombre - Es el nombre de la tarjeta.
     * @param edicion - Es la edicion de la tarjeta.
     * @param color - Es el color de la tarjeta.
     * @param numCarta - Es el numero de carta de la tarjeta.
     * @param costoGenerico - Es el costo generico de la tarjeta.
     * @param costoColor - Es el costo de color de la tarjeta.
     */
    public Tierra(String nombre, String edicion, String color, int numCarta, int costoGenerico, int costoColor){
	super(nombre, edicion, color, numCarta, costoGenerico, costoColor);
    }
} //Fin de Tierra.java
