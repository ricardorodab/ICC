/**
 * Nos da la informacion de dos canciones
 * @author Jose Ricardo Rodriguez Abreu
 * @verions 0.1
 */

public class Cancion{

    private String nombre;
    private String artista;
    private String album;
    private String genero;
    private int numCancion;
    private int año;
    private int numReproduccion;
    private int tamaño;
    private int duracionM;
    private int duracionS;
    private int calificacion;

 /**
     * Este constructor crea una instancia generica.
     */

    public Cancion(){
	nombre ="generico";
	artista ="generico";
	album ="generico";
	genero ="generico";
	numCancion =0;
	año =0;
	numReproduccion =0;
	tamaño =0;
	duracionM = 0;
	duracionS = 0;
	calificacion =0;
    }

  /**
     * @return El nombre de la cancion.
     */
      
    public String getNombre(){
	return nombre; 
    }
  /**
     * @return El nombre del artista.
     */
      
    public String getArtista(){
	return artista;
    }
  /**
     * @return El nombre del album.
     */
      
    public String getAlbum(){
	return album;
    }
  /**
     * @return El nombre del genero.
     */
      
    public String getGenero(){
	return genero;
    }
  /**
     * @return El numero de la cancion.
     */
      
    public int getNumCancion(){
	return numCancion;
    }
  /**
     * @return El año de la cancion.
     */
      
    public int getAño(){
	return año;
    }
  /**
     * @return El numero de reproduccion de la cancion.
     */
      
    public int getNumReproduccion(){
	return numReproduccion;
    }
  /**
     * @return El tamaño de la cancion.
     */
      
    public int getTamaño(){
	return tamaño;
    }
  /**
     * @return La duracion de la cancion.
     */
      
    public int getDuracionM(){
	return duracionM;
    }
  /**
     * @return La duracion de la cancion.
     */
      
    public int getDuracionS(){
	return duracionS;
    }
  /**
     * @return La calificacion de la cancion.
     */
      
    public int getCalificacion(){
	return calificacion;
    }

   /**
     * Modifica el parametro nombre
     * @param setNombre indica el nombre de la cancion.
     */
   
    public void setNombre(String nombre){
	this.nombre = nombre;
    }

 /**
     * Modifica el parametro artista
     * @param setArtista indica el artista de la cancion.
     */

    public void setArtista(String artista){
	this.artista = artista;
    }

 /**
     * Modifica el parametro album
     * @param setAlbum indica el album de la cancion.
     */

    public void setAlbum(String album){
	this.album = album;
    }

 /**
     * Modifica el parametro genero
     * @param setFenero indica el genero de la cancion.
     */

    public void setGenero(String genero){
	this.genero = genero;
    }

 /**
     * Modifica el parametro numCancion
     * @param setNumCancion indica el numero de la cancion.
     */

    public void setNumCancion(int numCancion){
	this.numCancion = numCancion;
    }

 /**
     * Modifica el parametro año
     * @param setAño indica el año de la cancion.
     */

    public void setAño(int año){
	this.año = año;
    }

 /**
     * Modifica el parametro numReproduccion
     * @param setNumReproduccion indica el numero de reproduccion de la cancion.
     */

    private void setNumReproduccion(int numReproduccion){
	this.numReproduccion = numReproduccion;
    }
 /**
     * Modifica el parametro tamaño
     * @param tamaño indica el tamaño de la cancion.
     */

	private void setTamaño(int tamaño){
	    this.tamaño = tamaño;
	}
 /**
     * Modifica el parametro duracionM
     * @param setDuracionM indica la duracion en minutos de la cancion.
     */


	private void setDuracionM(int duracionM){
	    this.duracionM = duracionM;
	}

 /**
     * Modifica el parametro duracionS
     * @param setDuracionS indica la duracion en segundos de la cancion.
     */

    private void setDuracionS(int duracionS){
	this.duracionS = duracionS;
    }

 /**
     * Modifica el parametro calificacion
     * @param setCalificacion indica la calificacion de la cancion.
     */

	public void setCalificacion(int calificacion){
	    this.calificacion = calificacion;
	}

	public static void main(String[] args){

  /**
     * Se crean 2 instancias

     */
	    Cancion cancion1 = new Cancion();

	    cancion1.setNombre("Move In The Right Direction");
	    cancion1.setArtista("Gossip");
	    cancion1.setAlbum("A Joyful Noise");
	    cancion1.setGenero("Pop");
	    cancion1.setAño(2012);
	    cancion1.setNumCancion(04);
	    cancion1.setNumReproduccion(141);
	    cancion1.setTamaño(6);
	    cancion1.setDuracionM(3);
	    cancion1.setDuracionS(31);
	    cancion1.setCalificacion(5);

	    Cancion cancion2 = new Cancion();

	    cancion2.setNombre("Don't Stop Me Now");
	    cancion2.setArtista("Queen");
	    cancion2.setAlbum("Absolute");
	    cancion2.setGenero("Pop/Rock");
	    cancion2.setAño(2009);
	    cancion2.setNumCancion(11);
	    cancion2.setNumReproduccion(91);
	    cancion2.setTamaño(5);
	    cancion2.setDuracionM(3);
	    cancion2.setDuracionS(32);
	    cancion2.setCalificacion(4);

 /**
     * Esto hace que se impriman en pantalla las canciones

     */	
				   
    System.out.println("Canción 1");
    System.out.println("Canción: " + cancion1.getNombre() );
    System.out.println("Artista: " + cancion1.getArtista() );
    System.out.println("Album: " + cancion1.getAlbum() );
    System.out.println("Género: " + cancion1.getGenero() );
    System.out.println("Número de canción: " + cancion1.getNumCancion() );


    System.out.println("Año: " + cancion1.getAño() );
    System.out.println("Número de reproducción: " + cancion1.getNumReproduccion() );
    System.out.println("Tamaño: " + cancion1.getTamaño() + " MB" );
    System.out.println("Duración: " +cancion1.getDuracionM() +":" +cancion1.getDuracionS() );
    System.out.println("Calificación: " +cancion1.getCalificacion() + "/5");

    System.out.println();

    System.out.println("Canción 2");
    System.out.println("Canción: " + cancion2.getNombre() );
    System.out.println("Artista: " +cancion2.getArtista() );
    System.out.println("Album: " + cancion2.getAlbum() );
    System.out.println("Género: " + cancion2.getGenero() );
    System.out.println("Número de canción: " + cancion2.getNumCancion() );
    System.out.println("Año: " + cancion2.getAño() );
    System.out.println("Número de reproducción: " + cancion2.getNumReproduccion() );
    System.out.println("Tamaño: " + cancion2.getTamaño() + " MB" );
    System.out.println("Duración: " + cancion2.getDuracionM() + ":" +cancion2.getDuracionS() );
    System.out.println("Calificación:" + cancion2.getCalificacion() + "/5");
	}
}
