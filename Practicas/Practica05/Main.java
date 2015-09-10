public class Main{
    
    public static void main(String cadena[]){
	MyString cadena1 = new MyString("José_Ricardo");
	MyString cadena3 = new MyString("       José Ricardo       ");
	
	MyString cadena2 = new MyString("José_Ricardo");
	cadena2.imprimir();
	System.out.println("¿Está vacía la cadena? = "+cadena2.isEmpty());
	cadena2.imprimir();    
	System.out.println(cadena2.length()); 
	System.out.println(cadena2.charAt(10));   
	System.out.println(cadena2.equals(cadena1));
	cadena1.concat(cadena2).imprimir();
	cadena3.trim().imprimir();
	//System.out.println(cadena3.trim());
	System.out.println(cadena2.indexOf('o', 2));
	System.out.println(cadena2.endsWith(cadena1));
	//cadena2 = cadena2.subString(5);
	//cadena2.imprimir();


}
}
