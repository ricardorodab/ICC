/*
 * Esta clase incluye métodos para ejemplificar las operaciones con cadenas
 * no incluye método main.
 * José Ricardo Rodríguez Abreu
 */

/**
 *Esta clase hace operaciones con cadenas
 *@author José Ricardo Rodríguez Abreu
 *@version 2.0
 *@since Noviembre, 12.
 */
public class MyString{
    
    private char[] cadena; 
    
    /**
     * Inicializa una cadena MyString que representa a la cadena vacía.
     */
    public MyString(){
	cadena = new char[0];
    }
    
    /**
     * Inicializa una nueva cadena MyString que representa la misma cadena que el parámetro.
     * @param a Una cadena String.
     */
    public MyString(String a){
	cadena = new char[a.length()];
	for(int i = 0; i < a.length(); i++){
	    cadena[i] = a.charAt(i);
	}
    }
    
    /**
     * Busca un caracter en la cadena
     * @param index - Es la posicion.
     * @return cadena[index] - te regresa el char en la posición index.
     */ 
    public char charAt(int index){    
	if( (index >= 0) && (index < cadena.length) ){ 
	    return cadena[index]; 
	} else { 
	    System.err.println("El número es menor o más grande que el número de elementos de la cadena");
	}
	return 0;
    }
    
    /**
     * Compara dos cadenas y regresa su igualdad
     * @param a - cadena a comparar.
     * @return true en caso de ser iguales o false en caso contrario.
     */
    
    public boolean equals(MyString a){	
	boolean return1 = false;
	for( int i = 0; i < a.length() && cadena[i] == a.cadena[i]; i++){
	    if(cadena.length == a.cadena.length && cadena[i] == a.cadena[i]){
		return1 = true;
	    }else{
		return1 = false;
	    }
	}
	return return1;
    }
    
    /**
     * Junta dos cadenas y regresa sólo una
     * @param segunda - es la segunda cadena a concatenar.
     * @return cadenaFin - es la nueva cadena.
     */
    public MyString concat(MyString segunda){
    	String tercerMyString = new String();
	String c = new String(cadena);
	String b = new String(segunda.cadena);
	tercerMyString = c + b;
	MyString cadenaFin = new MyString(tercerMyString);
	return cadenaFin;
    }
    
    /**
     * Método que regresa verdadero o falso si la cadena tiene el término indicado
     * @param sufijo - es el sufijo a verificar la terminacion.
     * @return true si termina con el sufijo o false caso contrario.
     */
    public boolean endsWith(MyString sufijo){
	int tamañoMenosSufijo = Math.abs(sufijo.cadena.length - cadena.length);
	for(int i = Math.abs(sufijo.cadena.length - cadena.length); i< cadena.length; i++){
	    if(sufijo.cadena[i - tamañoMenosSufijo] != cadena[i]){
		return false;
	    }
	}
	return true;
    }
    
    /**
     * Regresa en valor verdadero o falso si la cadena es vacía
     * @return true si esta vacia y false caso contrario.
     */
    public boolean isEmpty(){
	if(cadena != null ){
	    return false;
	}else{ return true;
	}
    }
    
    /**
     * Método que regresa el número de caracteres que tiene la cadena
     * @return cadena.length que es el tamaño de la cadena.
     */
    public int length(){
	return cadena.length;
    }
    
    /**
     * Método para quitar los espacios del pricipio y del final
     * @return cadenaTrim - es la nueva cadena sin espacios.
     */
    public MyString trim(){
	int e = 0;
	int z = 0;
	MyString cadenaTrim = new MyString();
	for(int i = 0; i < cadena.length ; i++){
	    if(cadena[i] == ' '){
		e++;
	    }
	}
        int tamCadenaTrim = (cadena.length - e+1);
	char[] nuevaCadenaTrim = new char[tamCadenaTrim];
	for(int i = 0; cadena[i] == ' ' ; i++){
	    z++;
	}
	for(int i = 0 ; i < tamCadenaTrim ; i++){
	    nuevaCadenaTrim[i] = cadena[i + z];
	}
	cadenaTrim.cadena = nuevaCadenaTrim;
	return cadenaTrim;
    }
    
    /**
     * Método para buscar un elemento en la cadena
     * @param c - es el caracter a verificar.
     * @param indes - a partir de la posición index.
     * @return i - es la posición en la que se encuentra el caracter.
     */
    public int indexOf(char c, int index){    
	for(int i = index ; i < cadena.length ; i++){
	    if(c == cadena[i]){
		return i;
	    }		
	}
	return 0;
    }
    
    /**
     * Imprime la cadena en pantalla con un salto de linea al final.
     */
    public void imprimir(){
	for(int i = 0; i < cadena.length ; i++){
	    System.out.print(cadena[i]);
	}
	System.out.print('\n');                   
    }
    
    /**
     * Regresa una nueva cadena que es la subcadena de esta cadena. 
     * La subcadena comienza con el caracter del índice indicado y termina en el 
     * caracter al final de esta cadena.
     * @param indx El índice donde comienza la subcadena.
     * @return nuevoMyString - es la nueva cadena.
     */
    public MyString subString(int indx){
	MyString nuevoMyString = new MyString();  
	if((indx < cadena.length) && (indx > -1)){
	    int tamSubcad = (cadena.length - indx);   
	    char[] nuevaCadena = new char[tamSubcad];       
	    for(int i = indx; i < cadena.length; i++){   
		nuevaCadena[i-indx] = cadena[i];        
	    } 
	    nuevoMyString.cadena = nuevaCadena;
	} else {
	    System.err.println("El índice "+ indx +" no es válido");
	}
	return nuevoMyString;
    }
    
}