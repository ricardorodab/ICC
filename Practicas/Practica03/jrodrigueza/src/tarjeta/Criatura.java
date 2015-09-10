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

    public class Criatura{
    private String nombre;
    private String edicion;
    private int costo;
    private String tipo;
    private String efecto;
    private String leyenda;
    private static final String compañia ="Wizards of the Coast";
    private int ataque;
    private int defensa;
    private int numCarta;
    private String ilustrador;
    
/** 
*@param public Criatura
*este parametro nos da los nombres de los atributos
*/
	public Criatura(String nombre, String edicion, int costo, String tipo, String efecto, String leyenda, String compañia, int ataque, int defensa, int numCarta, String ilustrador){
       	this.nombre = "Mirran Crusader";
	this.edicion = "1999";
	this.costo = 1;
	this.tipo = "Creature - Human Knight";
	this.efecto = "Double Strike";
	this.leyenda = "A symbol of tohat Mirrodin once was and hope for what it will be again";
	this.ataque = 2;
	this.defensa = 2;
	this.numCarta = 11;
	this.ilustrador = "Karl Hoglinsky";
	}

/**
*Este metodo imprime de regreso los elementos de los atributos que se les asignó en el parametro
*/
	public void imprime(){
	    
	    System.out.println("Criatura");
	    System.out.println("Nombre: " + this.nombre );
	    System.out.println("Edición: " + this.edicion );
	    System.out.println("Costo: " + this.costo );
	    System.out.println("Tipo: " + this.tipo );
	    System.out.println("Efecto: " + this.efecto );
	    System.out.println("Leyenda: " + this.leyenda );
	    System.out.println("Compañía: " + compañia );
	    System.out.println("Ataque: " + this.ataque );
	    System.out.println("Defensa: " + this.defensa );
	    System.out.println("Número de carta: " + this.numCarta );
	    System.out.println("Ilustrador: " + this.ilustrador );
	
	}
    }
