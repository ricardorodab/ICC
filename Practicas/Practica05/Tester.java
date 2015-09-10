/*
 * Copyright (C) 2013 Roberto Monroy Argumedo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Clase para realizar prueba de métodos de clases. A través de un ojeto dado
 * de la clase, se realizan pruebas de los métodos con ciertas entradas y con la
 * salida esperada. Esta clase es útil cuando los métodos pueden no estar 
 * implementados.
 * @author Roberto Monroy Argumedo
 * @version 0.1
 */
public class Tester {
    
    /*
    TODO: La clase debe de ser mejorada haciendo uso de genéricos!!
    */

    private final Class<?> cl;
    private static Object ins;

    /**
     * Crea un probador para la clase e instancia de clase dados.
     * @param clase Clase de la cuál se desean probar los métodos.
     * @param instancia Con la que se probaran los métodos.
     */
    public Tester(Class<?> clase, Object instancia) {
        cl = clase;
        ins = instancia;
    }

    /**
     * Evalua si el método entrega la salida esperada.
     * @param retorno Valor de retorno esperado.
     * @param metodo Método a probar.
     * @param tiposArgs Tipos de los parámetros.
     * @param args Parámetros del método.
     * @return <code>true<code/> si el método entregó la salida esperada, 
     * <code>false<code/> en otro caso.
     */
    public boolean evalua(Object retorno, String metodo, Class[] tiposArgs, Object... args) {
        try {
            Method m = cl.getDeclaredMethod(metodo, tiposArgs);
            Object r = m.invoke(ins, args);
            if (retorno.equals(r)) {
                System.out.println("Método " + metodo + "() OK");
                return true;
            } else {
                System.out.println("Método " + metodo + "() X");
                return false;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println("Método " + metodo + "() No implementado");
            return false;
        }
    }

    /**
     * Evalua si el método con tipo de retorno void está presente. No se 
     * verifican los efectos secundarios en el objeto.
     * @param metodo 
     * @param tiposArgs
     * @param args
     * @return <code>true<code/> si el método entregó la salida esperada, 
     * <code>false<code/> en otro caso.
     */
    public boolean evaluaVoid(String metodo, Class[] tiposArgs, Object... args) {
        /*
        TODO: No se verifican los side effects de la ejecución del método. 
        */
        try {
            Method m = cl.getDeclaredMethod(metodo, tiposArgs);
            m.invoke(ins, args);
            System.out.println("Método " + metodo + "() OK");
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println("Método " + metodo + "() No implementado");
            return false;
        }
    }

    /**
     * Evalua si el método entrega la salida esperada cuando el tipo de retorno
     * es el mismo de la clase.
     * @param retorno Valor de retorno esperado.
     * @param metodo Método a evaluar.
     * @param tiposArgs Tipo de los parámetros.
     * @param args Parámetros.
     * @return <code>true<code/> si el método entregó la salida esperada, 
     * <code>false<code/> en otro caso.
     */
    public boolean evaluaEquals(Object retorno, String metodo, Class[] tiposArgs, Object... args) {
        try {
            Method m = cl.getDeclaredMethod(metodo, tiposArgs);
            Object r = m.invoke(ins, args);
            Method eq = cl.getDeclaredMethod("equals", cl);
            if ((boolean) eq.invoke(retorno, r)) {
                System.out.println("Método " + metodo + "() OK");
                return true;
            } else {
                System.out.println("Método " + metodo + "() X");
                return false;
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println("Método " + metodo + "() No implementado");
            return false;
        }
    }

    /**
     * Método main que califica la clase MyString.
     * @param args No se usa.
     */
    public static void main(String[] args) {

        float cal = 0;
        MyString cadena = new MyString("   Cadena 1 ");
        MyString otraCad = new MyString("123");

        Tester t = new Tester(MyString.class, cadena);

        Class[] ic = {int.class};
        Class[] msc = {MyString.class};
        Class[] cic = {char.class, int.class};

        cal += t.evalua('1', "charAt", ic, 10) ? 0.5 : 0;
        cal += t.evalua('\0', "charAt", ic, -1) ? 0.5 : 0;

        cal += t.evalua(true, "equals", msc, cadena) ? 0.5 : 0;
        cal += t.evalua(false, "equals", msc, otraCad) ? 0.5 : 0;

        cal += t.evalua(4, "indexOf", cic, 'a', 0) ? 0.5 : 0;
        cal += t.evalua(8, "indexOf", cic, 'a', 5) ? 0.5 : 0;

        cal += t.evalua(true, "endsWith", msc, new MyString("ena 1 ")) ? 0.5 : 0;
        cal += t.evalua(false, "endsWith", msc, new MyString("ena")) ? 0.5 : 0;

        cal += t.evalua(false, "isEmpty", null) ? 1 : 0;

        cal += t.evalua(12, "length", null) ? 1 : 0;

        cal += t.evaluaEquals(new MyString("   Cadena 1 123"), "concat", msc, otraCad) ? 1 : 0;

        cal += t.evaluaEquals(new MyString("dena 1 "), "subString", ic, 5) ? 1 : 0;

        cal += t.evaluaEquals(new MyString("Cadena 1"), "trim", null) ? 1 : 0;

        cal += t.evaluaVoid("imprimir", null) ? 1 : 0;

        System.out.println("Calificación :" + cal);

    }

}
