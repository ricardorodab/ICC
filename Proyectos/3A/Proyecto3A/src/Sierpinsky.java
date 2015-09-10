/* -------------------------------------------------------------------
 * Sierpinsky.java
 * versión 2.0
 * Copyright (C) 2007  José Galaviz Casas,
 * José Ricardo Rodríguez Abreu.
 * Víctor Zamora Gutiérrez.
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México, Mexico.
 *
 * Este programa es software libre; se puede redistribuir
 * y/o modificar en los términos establecidos por la
 * Licencia Pública General de GNU tal como fue publicada
 * por la Free Software Foundation en la versión 2 o
 * superior.
 *
 * Este programa es distribuido con la esperanza de que
 * resulte de utilidad, pero SIN GARANTÍA ALGUNA; de hecho
 * sin la garantía implícita de COMERCIALIZACIÓN o
 * ADECUACIÓN PARA PROPÓSITOS PARTICULARES. Véase la
 * Licencia Pública General de GNU para mayores detalles.
 *
 * Con este programa se debe haber recibido una copia de la
 * Licencia Pública General de GNU, de no ser así, visite el
 * siguiente URL:
 * http://www.gnu.org/licenses/gpl.html
 * o escriba a la Free Software Foundation Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * -------------------------------------------------------------------
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Esquema general para generar el fractal
 * conocido como el triangulo de Sierpinsky.
 * @author Rodriguez Abreu, Jose Ricardo y Zamora Gutierrez Victor.
 * @version 2.0
 * @since Noviembre 2013
 */
public class Sierpinsky extends JPanel {

   /*
    Nivel de recusión requerido.
   */
   int nivel;


   /**
    * Construye una instancia de la clase encargada del trazado.
    * Sólo establece el tamaño preferido de la ventana de trazado.
    * @param n es el nivel de construcción requerido para
    */
   public Sierpinsky(int n) {
      nivel = n;
      setPreferredSize(new Dimension(400, 350));
   }

   /**
    * Pinta el objeto en la ventana de trazado.
    * @param g es el objeto gráfico usado para la operación de trazado.
    */
   public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D)g;
      Dimension  tam = getSize();
      g2d.setColor(Color.BLACK);
      g2d.fill(new Rectangle(0, 0, tam.width, tam.height));
      g2d.setColor(Color.YELLOW);

      double ladov  = Math.min((double)tam.width, (double)tam.height);
      int x1, y1, x2, y2, x3, y3;
      int xy = (int)ladov;
      x1 = 5;
      y1 = y2 = x2 = xy - 5;
      x3 = (xy - 10)/2;
      y3 = x2 -(int)Math.sqrt((3 * ((xy -10) * (xy-10))) / 4);
      trazaTriangulo(g2d,
                     new Point(x1, y1), new Point(x2, y2), new Point(x3, y3),
                     nivel);
}

   /**
    * Traza el triángulo de Sierpinsky del nivel especificado.
    * @param g2 es el objeto gráfico con el que se trazará la curva.
    * @param v1 primer vértice del triángulo.
    * @param v2 segundo vértice del triángulo.
    * @param v3 tercer vértice del triángulo.
    * @param n es el nivel de recursión requerido.
    */
   public static void trazaTriangulo(Graphics2D g2,
                                     Point v1,
                                     Point v2,
                                     Point v3,
                                     int   n) {
      if (n == 0) {
	  int[] cX = {v1.x, v2.x, v3.x};
   int[] cY = {v1.y, v2.y, v3.y};
	  g2.drawPolygon(cX ,cY , 3);
      }else{
	  Point pM1 = new Point((v1.x + v2.x)/2, (v1.y + v2.y)/2);
	  Point pM2 = new Point((v3.x + v2.x)/2, (v3.y + v2.y)/2);  
	  Point pM3 = new Point((v1.x + v3.x)/2, (v1.y + v3.y)/2);
	  trazaTriangulo(g2, v1, pM1, pM3, n-1);
	  trazaTriangulo(g2, pM1, v2, pM2, n-1);
	  trazaTriangulo(g2, pM2, pM3, v3, n-1);
      }
   }

   /**
    * Despliega el mensaje de uso del programa.
    */
   public static void uso() {
      System.err.println("Programa para trazar el triangulo de Sierpinsky");
      System.err.println("Uso: java Sierpinsky <nivel>");
      System.err.println("nivel es un entero no negativo,");
      System.err.println ("indica el nivel de construccion.");
   }

   /**
    * Programa principal, recibe el nivel de iteración de la curva.
    * @param args son los argumentos dados en la línea de llamada al programa.
    * En este caso el argumento debe ser sólo el nivel de iteración de
    * la curva.
    */
   public static void main(String[] args){
      if (args.length == 1) {
         try {
         int niv = Integer.parseInt(args[0]);
         JFrame frame = new JFrame("Triángulo de Sierpinsky");
         frame.getContentPane().add(new Sierpinsky(niv), BorderLayout.CENTER);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         }
         catch (NumberFormatException nfe) {
            uso();
         }
      }
      else {
         uso();
      }
   }
} // Fin de Sierpinsky.java