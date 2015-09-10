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
    public class Hechizo{
    private String nombre;
    private String edicion;
    private int costo;
    private String efecto;
    private String leyenda;
    private static final String compañia ="c";
    private int numCarta;
    private String ilustrador;
/** 
*@param public Hechizo
*este parametro nos da los nombres de los atributos
*/

    public Hechizo(String nombre, String edicion, int costo, String efecto, String leyenda, String compañia, int numCarta, String ilustrador){
	this.nombre = "Bituminous Blast";
	this.edicion = "2003";
	this.costo = 3;
	this.efecto = "Bituminous Blast deals 4 damage to target creature.";
	this.leyenda = "Remove cards from the top of your library from the game until you remove a nonland card that cost less.";
	this.numCarta = 34;
	this.ilustrador = "Raymond Swanland";
    }
/**
*Este metodo imprime de regreso los elementos de los atributos que se les asignó en el parametro
*/
	public void imprime(){
	
	    System.out.println("Hechizo");
	    System.out.println("Nombre: " + this.nombre );
	    System.out.println("Edición: " + this.edicion );
	    System.out.println("Costo: " + this.costo );
	    System.out.println("Efecto: " + this.efecto );
	    System.out.println("Leyenda: " + this.leyenda );
	    System.out.println("Compañía: " + compañia );
	    System.out.println("Número de carta: " + this.numCarta );
	    System.out.println("Ilustrador: " + this.ilustrador );
	}    
    }
