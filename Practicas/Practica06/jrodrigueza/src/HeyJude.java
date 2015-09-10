/*Este programa es un ejercicio para practicas
 * los "for", "while", "if", "switch"
 *Hecho por José Ricardo Rodríguez Abreu
 */

/**
 *Programa que reproduce la letra de la canción "Hey Jude" sin repetir el mismo "System.out.println();"
 *@author Rodríguez Abreu José Ricardo
 *@version 1.0
 */

public class HeyJude{
    /**
     *Método main para imprimir la canción
     */   
 
    public static void main(String [] args){
	System.out.println("\n");
	for(int i = 0; i< 27; i++){ 
	    if(i == 0 || i == 1 || i == 4 || i == 7){ //Versos que empiezan con "Hey Jude"
		System.out.print("Hey Jude");
	    }
	    switch(i)
		{
		case 0:
		case 7:
		    System.out.println(", don't make it bad. \n" 
				       +"Take a sad song and make it better.");
		}
	    if(i == 1){
		
		
		System.out.print(", don't be afraid. \n"
				 +"You were made to go out");
	    }
	    
	    while(i == 2){
		
		System.out.println("\nAnd anytime you feel the pain, hey Jude, refrain, \n"
				   +"Don't carry the world upon your shoulders. \n"
				   +"For well you know that it's a fool who plays it cool \n"
				   +"By making his world a little colder. \n");
		i++;
	    }  
	    
	    if(i == 4){
		
		System.out.print(", don't let me down. \n"
				 +"You have found her, now go");
	    }
	    
	    switch(i)
		{
		case 5:
		    System.out.println("So let it out and let it in, hey Jude, begin, \n"
				       + "You're waiting for someone to perform with. \n"
				       + "And don't you know that it's just you, hey Jude, you'll do, \n"
				       +"The movement you need is on your shoulder. \n");
		}
	    
	    switch(i)
		{
		case 1:
		case 4:
		    System.out.print(" and get her. \n");
		}
	    
	    switch(i)
		{
		case 0:
		case 4:
		case 7:
		    System.out.print("Remember to let her");
		}
	    
	    switch(i)
		{
		case 0:
		case 4:
		    System.out.print( " into you heart, \n"
				      +"Then you can start to make it better. \n \n");
		}			
	    if(i == 1){
		System.out.print("The minute you");
	    }
	    
	    switch(i)
		{
		case 1:
		case 7: 
		    System.out.print(" under your skin, \n");
		}

	    switch(i)
		{
		case 1:
		case 7:
		    System.out.println("Then you'll begin to make it better.");
		}
	    if(i == 7){
		for(int k = 0; k < 6 ; k++){
		    System.out.print("better, ");
		    if(k == 5){
			System.out.print("oh. \n \n");
		    }
		}
	    } 
	    if(i == 3 || i == 6 || i > 7){
		for(int j = 0 ; j < 10 ; j++){
		    
		    System.out. print("na, ");
		}
		if( i == 3 || i == 6){
		    System.out.println("\n ");
		    
		}else{
		    System.out.println("hey Jude");
		}
	    }
	}
    }
}