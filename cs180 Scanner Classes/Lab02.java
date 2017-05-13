/* 
 * CS 180 Lab02 Spring 2007
 *
 * Variables, Console I/O, BAC
 *
 * created by Jairav Desai 
 * edited by Zach Tatlock
 * and further so by Daniel Tang
 *
 */

import java.util.*;


public class Lab02
{
	
    public static void main(String args[])
    {       double bodyWater_Index = 240.4;
	    double corona_Index = 1016;
	    double waterVolume = 0.00;
	    double bac = 0.00;
	     
	    Scanner keyboard = new Scanner(System.in);
        
	    System.out.println("Welcome to Brother's (est 1885).");
	    System.out.print("\nWhat is your name? ");
	    String name = keyboard.next();
        
	    System.out.print("Hi " + name);
	    System.out.print(", how much do you weigh? [whole number, lbs]: ");
	    int weight = keyboard.nextInt();
	
	    waterVolume = weight * bodyWater_Index;
        
	    System.out.print("\nYour total body water volume is ");
	    System.out.println(waterVolume +  " millilitres.");
	    int drinksConsumed = 1;
	   
	
        while(drinksConsumed != 0)
        {
		
            if(bac > 0.08)
            {
		   System.out.println("You cannot drive legally.");
		   System.out.println("FRIEND: hey man, ill give you a ride.");
            }
            
            if(bac > 0.35)
            {
		    System.out.println("You are currently dead. R.I.P");
		    System.exit(0);
            }

            System.out.println("You have had " + (drinksConsumed - 1) + " drinks.");
            System.out.print("Would you like a Corona? ");
            String response = keyboard.next(); 
	    
            if(response.equalsIgnoreCase("no"))
            {
		    System.out.println("BOUNCER: Alright " + name + ", its time to go");
		    drinksConsumed = 0;
            }
            else if(response.equalsIgnoreCase("yes"))
            {
		    drinksConsumed++;
		    bac = (drinksConsumed * corona_Index) / waterVolume;
            }
            System.out.println("Your BAC is " + bac);
            System.out.println("\n");
        }
    }
}
