/**
*Esta clase crea atributos y metodos para ejecutarlo desde *un main exterior
*@author Jose Ricardo Rodriguez Abreu
*@version 1.0
*/
package tarjeta;

/**
 *Se crean los atributos
 *
 */

    public class Tierra{
    private String nombre;
    private String tipo;
    private String edicion;
    private static final String compañia ="c";
    private int numCarta;
    private String ilustrador;

/** 
*@param public Tierra
*este parametro nos da los nombres de los atributos
*/
	public Tierra(String nombre, String tipo, String edicion, String compañia, int numCarta, String ilustrador){
	this.nombre = "Montaña";
	this.edicion = "1993";
	this.tipo = "Tierra básica";
	this.numCarta = 244;
	this.ilustrador = "Robh Ruppet";
    }
/**
*Este metodo imprime de regreso los elementos de los atributos que se les asignó en el parametro
*/	
	public void imprime(){
	
	    System.out.println("Tierra");
	    System.out.println("Nombre: " + this.nombre );
	    System.out.println("Edición: " + this.edicion );
	    System.out.println("Tipo: " + this.tipo );
	    System.out.println("Compañía: " + compañia );
	    System.out.println("Número de carta: " + this.numCarta );
	    System.out.println("Ilustrador: " + this.ilustrador );
	}
    }
