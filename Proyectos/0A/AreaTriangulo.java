/*
 *Con este programa podemos calcular
 *el área de un triángulo necesitando
 *para ello sólo tres puntos pertenecientes
 *a los números reales.
 */

/**
 *Obtiene el area de un triangulo dada 3 coordenadas
 *@author Rodriguez Abreu Jose Ricardo y Mendez Juarez Rocio
 *@version 1.0
 */

public class AreaTriangulo{
    
    //Atributos
    private double x; //Coordenada X
    private double y; //Coordenada Y
    
    /**
     *Constructor de un punto a partir de las coordenadas
     *@param x - coordenada x del nuevo punto
     *@param y - coordenada y del nuevo punto
     */
    
    public AreaTriangulo(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    
    /**
     *Metodo para determinar si tres puntos estan alineados
     *@param vertice1 - Punto que con vertice2 y el que llama verifica si estan alineados
     *@param vertice2 - Punto que con vertice1 y el que llama verifica si estan alineados
     *@return true si estan alineados, false en el otro caso
     */
    
    public boolean esColineal(AreaTriangulo vertice1, AreaTriangulo vertice2){
	return (y-vertice1.y) * (vertice2.x-vertice1.x) == (vertice2.y-vertice1.y) * (x-vertice1.x);
    } 
    
    /**
     *Metodo para calcular el area de un triangulo
     *@param v1 - punto vertice del triangulo que junto con v2 y v3 nos ayuda a calcula el area
     *@param v2 - punto vertice del triangulo que junto con v1 y v3 nos ayuda a calcular el area
     *@param v3 - punto vertice del triangulo que junto con v1 y v2 nos ayuda a calcular el area
     */
    
    public static double areaFinal(AreaTriangulo v1, AreaTriangulo v2, AreaTriangulo v3){
	return (Math.abs ( ((v1.x * (v2.y-v3.y)) + (-v1.y * (v2.x-v3.x)) + ((v2.x * v3.y) - (v3.x * v2.y)) ) /2 ));
    }
    
    /**
     *El metodo main de este programa revisa que se le haya
     *dado 6 valores de la forma x1, y1, x2, y2, x3, y3, 
     *luego revisa que sean colineales y si no lo son calcula
     *su area y se la imprime al al usuario.
     */
    
    public static void main (String[] args){
	
	try{	
	    if(args.length != 6){
		System.out.println(" \n Favor de dar las 6 coordenadas de la siguiente manera:"
				   + " \n\t java AreaTriangulo # # # # # # \n\t Donde '#' son números reales. \n");
	    }else if (args.length == 6){ 
		double x1 = Double.parseDouble(args[0] );    // Asignación a la variable 1
		double y1 = Double.parseDouble(args[1] );    // Asignación a la variable 2
		double x2 = Double.parseDouble(args[2] );    // Asignación a la variable 3
		double y2 = Double.parseDouble(args[3] );    // Asignación a la variable 4
		double x3 = Double.parseDouble(args[4] );    // Asignación a la variable 5
		double y3 = Double.parseDouble(args[5] );    // Asignación a la variable 6
		
		AreaTriangulo vertice1 = new AreaTriangulo (x1, y1);     //Creación del objeto vertice 1
		AreaTriangulo vertice2 = new AreaTriangulo (x2, y2);     //Creación del objeto vertice 2
		AreaTriangulo vertice3 = new AreaTriangulo (x3, y3);	 //Creación del objeto vertice 3
		boolean esUnaLinea = vertice1.esColineal(vertice2, vertice3); 
		if (esUnaLinea) {
		    System.out.println(" \n Los puntos dados no corresponden a un triángulo. \n");
		    
		}else{
		    AreaTriangulo v1 = new AreaTriangulo (x1, y1); //Crea el objeto v1
		    AreaTriangulo v2 = new AreaTriangulo (x2, y2); //Crea el objeto v2
		    AreaTriangulo v3 = new AreaTriangulo (x3, y3); //Crea el objeto v3
		    double areaTrianguloEs = areaFinal(v1, v2, v3); //Obtiene el área del triángulo
		    
		    System.out.println(" \nEl área del triángulo que forman los"+
				       " puntos: \n"+"("+x1+"," +y1+")"+" (" +x2+"," +y2+")"+" ("+x3+"," +y3+")"+
				       " es: " +areaTrianguloEs +" unidades cuadradas. \n");
		}
	    }
	}
	catch(NumberFormatException e){ //En caso de encontrar alguna variable que no es letra informa del error
	    System.out.println("\n Revise que todos los valores dados sean números y vuelva a intentar. \n"); 
	}
    }
}