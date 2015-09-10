/*
 * Tarjeta de tipo Hechizo.
 */

package tarjeta;

/**
 *Esta clase crea atributos y metodos para ejecutarlo desde *un main exterior
 *@author Jose Ricardo Rodriguez Abreu
 *@version 2.0
 *@since Octubre 6, 2013.
 */ 

public class Hechizo extends Tarjeta{
    private String efecto;
    private String leyenda;
    
    /** 
     * Metodo constructor para crear la tarjeta tierra.
     * @param nombre - Es el nombre de la tarjeta.
     * @param edicion - Es la edicion de la tarjeta.
     * @param color - Es el color de la tarjeta.
     * @param numCarta - Es el numero de carta de la tarjeta.
     * @param costoGenerico - Es el costo generico de la tarjeta.
     * @param costoColor - Es el costo de color de la tarjeta.
     * @param efecto - Es el efecto de la tarjeta.
     * @param leyenda - Es la leyenda de la tarjeta.
     */
    public Hechizo(String nombre, String edicion, String color, int numCarta, int costoGenerico, int costoColor, String efecto, String leyenda){
	super(nombre, edicion, color, numCarta, costoGenerico, costoColor);
	this.efecto = efecto;
	this.leyenda = leyenda;
    }
    
    /**
     * Metodo para colocar los datos de la tarjeta con su etiqueta.
     */
    @Override
	public String toString(){
	String r = super.toString();
	return (r
		+"Efecto: " + this.efecto +"\n"
		+ "Leyenda: " + this.leyenda + "\n"
		);
    }
} //Fin de Hechizo.java
