/* Dustin Wolf dewolf@purdue.edu
*
* Cs180sec0201
* January 25,2007
* Assignment2
* Special Numbers and Mathematical Sequences 
* Written by Armand Navabi
*
*/
import java.util.*;

public class SpecialNumbers
{
	public static void main(String[] args)
	{
		int num; // Var that holds the Scanner integer       Dustin Wolf 01.25.07 //
		double thirds;												   
		int Fib0 = 0; // important first term for fibonacci       Dustin Wolf 01.25.07 //
		int Fib1 = 1; // important second term for fibonacci      Dustin Wolf 01.25.07 //
		int Fib2; // value of fibonaccis adding process       Dustin Wolf 01.25.07 //
		int tri = 1; // important first term for triangular      Dustin Wolf 01.25.07 //
		int triAdder = 2;
		String thirdSequence = "Powers of 3: ";                        
		String fibonacciSequence = "Fibonacci numbers: ";
		String triangleSequence = "Triangular numbers: ";
		String hailStone = "Hailstone sequence: ";

		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nEnter Number: " );
		num = keyboard.nextInt();
		if(num > 0) // If statement make sure num != 0          Dustin Wolf 01.25.07 //
		{
			for(int count = 0; count < num; count++) // For statement that runs power of 3       Dustin Wolf 01.25.07 //
			{
				thirds = Math.pow(3,count);	 // Math.pow(a,b) is the exponent method     Dustin Wolf 01.25.07 //
				thirdSequence += ((int)thirds + " ");				
			}
			for(int fibCount = 1; fibCount <= num; fibCount++) // For Statement that runs Fibonacci		   Dustin Wolf 01.25.07 //
			{
				Fib2 = Fib1;										   
				Fib1 = Fib0 + Fib1;
				fibonacciSequence += (Fib2 + " ");
				Fib0 = Fib2;
			}
			for(int triCount = 1; triCount <= num; triCount++) // For statement that runs Triangular       Dustin Wolf 01.25.07 //
			{
				triangleSequence += (tri + " ");
				tri = tri + triAdder;
				triAdder++;
			}														   
			while (num != 1) // While loop that aids with Hailstone      Dustin Wolf 01.25.07 //
			{
        		hailStone += (num + " ");
				if (num % 2 == 0) // If statement that determines even        Dustin Wolf 01.25.07 //
				{
         			num = (num / 2); 
     			}
       			else // else statement that determines if odd    Dustin Wolf 01.25.07 //
       			{
       	  		num = ((num * 3) + 1);
     			}
     			if(num == 1) // if that states if num = 1 then it will 
     			{            //  show the 1 in the code Dustin Wolf 01.25.07 //
	     			hailStone += (num + " ");
     			}
			}
			System.out.println(thirdSequence);
			System.out.println(fibonacciSequence);
			System.out.println(triangleSequence);
			System.out.println(hailStone);
		}
			
	}
}