/* -------------------------------------------------------------------
 * Koch.java
 * versión 3.0
 * Copyright (C) 2007 
 * José Ricardo Rodríguez Abreu,
 * Víctor Zamora Gutíerrez.
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
 * Este programa genera el fractal
 * mejor conocido como la curva de Koch.
 * @author Jose Ricardo Rodriguez Abreu, Victor Zamora Guttierez
 * @version 3.0
 * @since Noviembre, 2013
 */
public class Koch extends JPanel {

   /*
    Nivel de recusión requerido.
   */
   int nivel;



   /**
    * Construye una instancia de la clase encargada del trazado.
    * Sólo establece el tamaño preferido de la ventana de trazado.
    * @param n es el nivel de construcción requerido para
    */
   public Koch(int n) {
      nivel = n;
      setPreferredSize(new Dimension(400, 600));
   }

   /**
    * Pinta el objeto en la ventana de trazado.
    * @param g es el objeto gráfico usado para la operación de trazado.
    */
   public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D)g;
      Dimension  tam = getSize();
      g2d.setColor(Color.BLUE);
      g2d.fill(new Rectangle(0, 0, tam.width, tam.height));
      g2d.setColor(Color.WHITE);

      double ladov  = Math.min((double)tam.width, (double)tam.height);
      int x1, y1, x2, y2, x3, y3;
      int xy = (int)ladov;
      x1 = 0;
      y1 = y2 = x2 = xy;
      x3 = (xy)/2;
      y3 = x2 -(int)Math.sqrt((3 * ((xy) * (xy))) / 4);
      trazaCurva(g2d,
		 new Point(x1, y1), new Point(x3, y3),
		 nivel);      
    		 trazaCurva(g2d,
		 new Point(x3, y3), new Point(x2, y2),
		 nivel);
      trazaCurva(g2d,
		 new Point(x2, y2), new Point(x1, y1),
		 nivel);
       
}

   /**
    * Traza la curva de Koch del nivel especificado.
    * @param g2 es el objeto gráfico con el que se trazará la curva.
    * @param v1 primer vértice de la linea.
    * @param v5 segundo vértice de la linea.
    * @param n es el nivel de recursión requerido.
    */
    public static void trazaCurva(Graphics2D g2,
				  Point v1,
				  Point v5,
				  int   n) {
	double d = (v1.distance(v5));
	double pi = 3.14159265359;
	double dy = (v5.y - v1.y);
	double dx = (v5.x - v1.x);
	double pendiente =  Math.toRadians(dy/dx);
	double angulo = Math.atan(Math.toRadians(dy/dx));
	Point v2, v3, v4;
	int x2, y2, x3, y3, x4, y4;
	if (n == 0) {
	    g2.drawLine(v1.x, v1.y, v5.x, v5.y);
	}else{
	    if (pendiente < 0){
		x2 = (int)(v1.x + (dx/3));
		y2 = (int)(v1.y + (dy/3));
		if(dy < 0){
		    x3 = (int)(v1.x + (dx/2) - (d/4));
		    y3 = (int)(v1.y + (dy/2) - (Math.sqrt(3)*d)/12);
		}else {
		    x3 = (int)(v1.x + (dx/2) + (d/4));
		    y3 = (int)(v1.y + (dy/2) + (Math.sqrt(3)*d)/12);
		} 	    
		x4 = (int)(v1.x + (2*dx/3));
		y4 = (int)(v1.y + (2*dy/3));
	    }else if(pendiente > 0){
		x2 = (int)(v1.x + (dx/3));
		y2 = (int)(v1.y + (dy/3));
		if(dy > 0){
		    x3 = (int)(v1.x + (dx/2) + (d/4));
		    y3 = (int)(v1.y + (dy/2) - (Math.sqrt(3)*d)/12);
		}else {
		    x3 = (int)(v1.x + (dx/2) - (d/4));
		    y3 = (int)(v1.y + (dy/2) + (Math.sqrt(3)*d)/12);		
		}
		x4 = (int)(v1.x + (2*dx/3));
		y4 = (int)(v1.y + (2*dy/3));	
	    }else{
		x2 = (int)(v1.x + (dx/3));
		y2 = (int)(v1.y);
		x3 = (int)(v1.x + (dx/2));
		if(dx < 0){
		    y3 = (int)(v1.y + (dy/2) + (Math.sqrt(3)*d)/6);
		}else{
		    y3 = (int)(v1.y + (dy/2) - (Math.sqrt(3)*d)/6);		
		}
		x4 = (int)(v1.x + (2*dx/3));
		y4 = (int)(v1.y);
	    }
	    v2 = new Point(x2,y2);
	    v3 = new Point(x3,y3);
	    v4 = new Point(x4,y4);
	    trazaCurva(g2, v1, v2, n-1);
	    trazaCurva(g2, v2, v3, n-1);
	    trazaCurva(g2, v3, v4, n-1);
	    trazaCurva(g2, v4, v5, n-1);
	}
    }
    
   /**
    * Despliega el mensaje de uso del programa.
    */
   public static void uso() {
      System.err.println("Programa para trazar la curva de Koch");
      System.err.println("Uso: java Koch <nivel>");
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
         JFrame frame = new JFrame("Curva Triadica de Koch");
         frame.getContentPane().add(new Koch(niv), BorderLayout.CENTER);
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
} // Fin de Koch.java