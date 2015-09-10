/**
 *Esta clase define lo que es un punto y te da la distancia de un
 *punto dado otro, los desplaza y los compara
 *@author Rodríguez Abreu José Ricardo
 *@version 1.0
*/

public class Punto{
    
    private double x; //Instancia de la coordenada X
    private double y; //Instancia de la coordenada Y
    
    /**
     *Método para construír un punto
     *@param x - coordenada del punto X
     *@param y - coordenada del punto y
     */

    public Punto(double x, double y){
	this.x = x;
	this.y = y;
    }  
    
    /**
     *Método que regresa el valor de la coordenada X
     *@return x - te regresa el valor x
     */
  
    public double getX(){
	return x;
    }
   
    /**
     *Método que regresa el vlor de la coordenada y
     *@return y - te regresa el valor y
     */
    
    public double getY(){
	return y;
    }
    
    /**
     *Método que sirve para sumarle a tu punto otro punto dado
     *@param x - le suma el valor de X prima a X
     *@param y - le suma el valor de Y prima a Y
     */    

    public void desplazar(double primoX, double primoY){
	x += primoX;
	y += primoY;
    }
    
    /**Método que te regresa la distancia de un puto a otro
     *@return sqrt(X-X2)²+(Y-Y2)²
     */ 
    
    public double distancia(Punto p){
	return (Math.abs (Math.sqrt((x - p.getX())*(x - p.getX()) +
				    (y - p.getY())*(y - p.getY())))); 
    }
    
    /**
     *Método que te regresa en TRUE o FALSE si los puntos dados son iguales
     *@return X=X2 y Y=Y2
     */

    public boolean igualar(Punto p){
	return ((this.x == p.x) && (this.y == p.y));
    }
    
}