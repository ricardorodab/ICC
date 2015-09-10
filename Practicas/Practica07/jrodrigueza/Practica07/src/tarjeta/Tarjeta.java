/*
 * Este programa fue hecho para probar la herencia de clases.
 * Hecho para la clase de Introducción a la 
 * ciencias de la computación. Generación 2014.
 */
package tarjeta;

/**
 *@author Jose Ricardo Rodriguez Abreu
 *@version 1.5
 *@since Octubre 3, 2013.
 */

public class Tarjeta{
    
    protected String nombre;
    protected String edicion;
    protected int numCarta;
    protected String color;
    protected int costoGenerico;
    protected int costoColor;
    
    /**
     *Metodo constructor para crear una terjeta default.
     *@param nombre - es el nombre de tarjeta.
     *@param edicion - es la edicio de la tarjeta.
     *@param color - es el color de la tarjeta.
     *@param numCarta - es el numero de carta de la tarjeta.
     *@param costoGenerico - es el costo de la tarjeta.
     *@param costoColor - es el costo de la tarjeta.
     */
    
    public Tarjeta(String nombre, String edicion, String color, int numCarta, int costoGenerico, int costoColor){
	this.nombre = nombre;
	this.edicion = edicion;
	this.color = color;
	this.numCarta = numCarta;
	this.costoGenerico = costoGenerico;
	this.costoColor = costoColor;
    }
    
    /**
     *Metodo que nos dice si una tarjeta es igual a otra.
     *@param obj - es la otra tarjeta.
     */    
    @Override
	public boolean equals(Object obj){
	if(obj instanceof Tarjeta){
	    Tarjeta t = (Tarjeta) obj;
	}
	return edicion.equals(this.edicion) && numCarta == this.numCarta;
	
    }
    
    /**
     *Metodo para organizar cada elemento de la tarjeta.
     */
    @Override
	public String toString(){ 
	String rt;
	rt = ("Nombre: " + this.nombre + "\n"
	      + "Edición: " + this.edicion +"\n"
	      + "Color: " + this.color +"\n"
	      + "Número de Carta: " + this.numCarta +"\n"
	      + "Costo Genérico: " + this.costoGenerico +"\n"
	      + "Costo Color: " + this.costoColor +"\n");
	return rt;
    }
} //Fin de Tarjeta.java
