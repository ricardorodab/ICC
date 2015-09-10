/*
  Vector2D.java
*/

package mx.unam.fciencias.geom;

/**
 * Clase para manipular vectores en el plano euclidiano.
 *
 * @author José Galaviz jgc@fciencias.unam.mx
 * @version 1.0 <br>
 * febrero 2007
 */
public class Vector2D {

/*
 * El estado de un vector en el plano euclidiano está
 * determinado por los valores de sus
 * coordenadas. Representadas por números reales de 
 * doble precisión 
 */
   /**
    * Coordenada X (abscisa) del vector.
    */
   private double x;

   /**
    * Coordenada Y (ordenada) del vector.
    */
   private double y;

   /**
    * Constructora. Inicializa las coordenadas del vector en cero.
    */
   public Vector2D() {
      x = 0.0;
      y = 0.0;
   }

   /**
    * Constructora. Un vector puede ser inicializado
    * proporcionando los valores de sus coordenadas.
    * @param abscisa coordenada x.
    * @param ordenada coordenada y.
    */
   public Vector2D(double abscisa, double ordenada) {
      x = abscisa;
      y = ordenada;
   }

   /**
    * Extrae el valor de la coordenada x de la instancia que
    * llama. <br><b>Observadora</b>.
    * @return double, coordenada x, abscisa.
    */
   public double getX() {
      return x;
   }

   /**
    * Extrae el valor de la coordenada y de la instancia que
    * llama. <br><b>Observadora</b>.
    * @return double, coordenada y, ordenada.
    */
   public double getY() {
      return y;
   }

   /**
    * Establece el valor de la coordenada x de la instancia que
    * llama. 
    * @param abscisa valor de la nueva abscisa del vector.
    */
   public void setX(double abscisa) {
      x = abscisa;
   }

   /**
    * Establece el valor de la coordenada y de la instancia que
    * llama. 
    * @param ordenada valor de la nueva ordenada del vector.
    */
   public void setY(double ordenada) {
      y = ordenada;
   }

   /**
    * Establece el valor de ambas coordenadas en la instancia
    * que llama. 
    * @param abscisa valor de la nueva abscisa del vector.
    * @param ordenada valor de la nueva ordenada del vector.
    */
   public void setXY(double abscisa, double ordenada) {
      x = abscisa;
      y = ordenada;
   }

   /**
    * Anula el vector que la llama.
    */
   public void anula() {
      x = 0.0;
      y = 0.0;
   }

   /**
    * Regresa el tamaño del vector.
    * @return double, la magnitud de la instancia que llama.
    */
   public double magnitud() {
      return Math.sqrt(x * x + y * y);
   }

   /** 
    * Regresa el ángulo de la expresión del
    * vector en forma polar. El valor del ángulo
    * está en radianes y está entre 0 y 2(pi). Es
    * el ángulo que forma el vector con el subeje x
    * positivo. No modifica la instancia que llama.
    * @return double, ángulo entre 0 y 2*pi
    */
   public double arg() {
      double  ang;

      // si x es distinto de cero...
      if (x != 0) {
         ang = Math.abs(y / x);
         // atan regresa normalmente un valor entre -pi/2 y pi/2,
         // como usamos arriba el valor absoluto, 
         // realmente está entre 0 y pi/2
         ang = Math.atan(ang);

         // cuadrante superior izquierdo
         if ((x < 0) && (y >= 0)) {
            ang = Math.PI - ang;
         }
         // cuandrante inferior izq1uierdo
         if ((x < 0) && (y < 0)) {
            ang = Math.PI + ang;
         }
         // cuadrante inferior derecho
         if ((x > 0) && (y < 0)) {
            ang = (2.0 * Math.PI) - ang;
         }
      }
      // si x es cero, entonces el ángulo es pi/2 cuando y es no negativo
      // o (3pi)/2 si no es así
      else {
         if (y >= 0) {
            ang = Math.PI / 2.0;
         }
         else {
            ang = (3.0 * Math.PI) / 2.0;
         }
      }
      return ang;
   }

   /**
    * Obtiene la expresion rectangular del vector a partir de
    * sus parametros  polares. Las coordenadas rectangulares
    * son puestas como las coordenadas de la instancia
    * que llamó a la función. 
    * @param angulo angulo entre 0 y 2(pi) que forma el
    * vector con la parte positiva del eje X.
    * @param mgntd magnitud del vector.
    */
   public void polarRec(double angulo, double mgntd) {
      if (mgntd >= 0) {
         x = (mgntd) * Math.cos(angulo);
         y = (mgntd) * Math.sin(angulo);
      }
      else {
         anula();
      }
   }

   /**
    * Suma la instancia que llama con el argumento. Regresa un
    * nuevo número vector con la suma. No modifica la
    * instancia que llama.
    * @param v Segundo sumando.
    * @return Vector2D con el resultado de sumar la instancia que llama y
    * el argumento.
    */
   public Vector2D suma(Vector2D v) {
      return new Vector2D(x + v.x, y + v.y); 
   }

   /**
    * Resta el argumento de la instancia que llama. Regresa un
    * nuevo número vector con la diferencia. No
    * modifica la instancia que llama.
    * @param v vector que se resta <b>a la
    * instancia que llama al método</b>. 
    * @return Vector2D con el resultado de restar, a la instancia que
    * llama, el vector argumento.
    */
   public Vector2D resta(Vector2D v) {
      return new Vector2D(x - v.x, y - v.y);
   }

   /**
    * Obtiene el producto interior del vector instancia, que
    * llama al método y el que es pasado como
    * parámetro. 
    * @param v segundo operado del producto interior.
    * @return double, valor del producto punto.
    */
   public double punto(Vector2D v) {
      return (x * v.x + y * v.y);
   }

   /**
    * Obtiene la magnitud del producto vectorial (cruz)  del
    * vector instancia que llama a la función y el que es pasado como
    * parámetro.  
    * @param v vector, segundo operado del producto cruz.
    * @return double, magnitud del vector producto.
    */
   public double cruzMg(Vector2D v) {
      return Math.abs(x * v.y - v.x * y);
   }

   /**
    * Compara dos vectores para determinar si son iguales.
    * La relación establecida por este método es:
    * <UL>
    * <LI> Reflexiva: <code>v.equals(v)</code> es <code>true</code></LI>
    * <LI> Simétrica: <code>v1.equals(v2)</code> entrega lo mismo que 
    * <code>v2.equals(v1)</code></LI>
    * <LI> Transitiva: si <code>v1.equals(v2)</code> es <code>true</code> y 
    * <code>v2.equals(v3)</code> también, entonces <code>v1.equals(v3)</code>
    * es <code>true</code></LI>
    * <LI>Consistente: El resultado entregado por <code>v1.equals(v2)</code> 
    * es el mismo siempre que no cambien ni <code>v1</code> ni 
    * <code>v2</code></LI>
    * <LI>Preve la nulidad del argumento: Si el argumento es <code>null</code>
    * regresa <code>false</code>.</LI>
    * <LI>Verifica el tipo del argumento: Se verifica que el argumento sea un
    * ejemplar (instancia) de <code>Vector2D</code>.</LI>
    * <LI>Verifica si el argumento es una referencia a la instancia que llama: 
    * Por eficiencia, si <code>this</code> es una referencia al objeto pasado 
    * como parámetro no se hace mayor verificación y se regresa 
    * <code>true</code>.</LI>
    * <LI>Cumple con la firma de <code>Object.equals(Object)</code>: El
    * argumento es recibido como referencia a <code>Object</code> y no se 
    * lanzan excepciones. Es una sobrecarga y no una sobreescritura de 
    * <code>equals</code></LI>
    * </UL>
    * @param v es el vector con el que se compara la instancia que
    * llama.
    * @return verdadero si el argumento es un vector igual a la instancia
    * que llama, falso en otro caso.
    */
   public boolean equals(Object v) {
      // Se verifica que el argumento sea del tipo correcto.
      // Como efecto colateral se verifica la no-nulidad del argumento
      // ya que instanceof regresa false si el operando izquierdo es null
      if (!(v instanceof Vector2D)) {
         return false;
      }
      // Por eficiencia, si el argumento y la instancia que llama se 
      // refieren al mismo objeto, se regresa true
      else if (v == this) {
         return true;
      }
      // Si no ocurre nada de lo anterior, se hace la comparación.
      // El cast tiene éxito garantizado porque ya verificamos que
      // el argumento sea instancia de Vector2D
      else {
         Vector2D vec = (Vector2D) v;
         return ((x == vec.x) && (y == vec.y));
      }
   }

   /**
    * Regresa una cadena que representa el 
    * vector que llama a la función.
    * <br><b>Observadora</b> 
    * @return String con formato "(a,b)"
    */
   public String toString() {
      return ("(" + x + ", " + y + ")");
   }

   /**
    * Regresa la distancia euclidiana entre dos vectores.
    * @param v vector cuya distancia a la instancia que llama es
    * calculada.
    * @return un real no negativo con la distancia entre la instancia
    * que llama y el vector pasado como argumento.
    */
   public double distanciaA(Vector2D v) {
      return Math.sqrt((v.x - x) * (v.x - x) + (v.y - y) * (v.y - y));
   }

   /**
    * Regresa la distancia euclidiana entre dos vectores.
    * @param v1 primer vector
    * @param v2 segundo vector
    * @return un real no negativo con la distancia entre los vectores
    * dados como argumento.
    */
   public static double distanciaA(Vector2D v1, Vector2D v2) {
      return Math.sqrt((v1.x - v2.x) * (v1.x - v2.x) +
                       (v1.y - v2.y) * (v1.y - v2.y));
   }
   
   /**
    * Programa de prueba.
    */
   public static void main(String args[]) {
      Vector2D  v1, v2, v3;

      System.out.print("Prueba de constructor sin argumento y get's: ");
      v1 = new Vector2D();
      if ((v1.getX() == 0) &&
          (v1.getY() == 0)) {
         System.out.println("Ok");
      }
      else {
         System.out.println("¡Error!");
      }
      v2 = new Vector2D(1, 0);
      v3 = new Vector2D(0, 1);
      Vector2D v4 = v2.suma(v3);
      System.out.print("Prueba de suma: ");
      if ((v4.getX() == 1) &&
          (v4.getY() == 1)) {
         System.out.println("Ok");
      }
      else {
         System.out.println("¡Error!");
      }
      Vector2D v5 = new Vector2D(1, 1);
      System.out.print("Prueba de equals: ");
      if (v4.equals(v5) && !v4.equals(v2)) {
         System.out.println("Ok");
      }
      else {
         System.out.println("¡Error!");
      }
   }
} // Fin de Vector2D.java
