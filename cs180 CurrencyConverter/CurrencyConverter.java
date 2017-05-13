/* Dustin Wolf  dewolf@purdue.edu
*
*  Cs180 Sec 0201
*  January 19 2007
*  Assignment 1
*  Currency Converter
*  Written by Elizabeth Blythe
*  
*/

import java.text.DecimalFormat; // pulls the decimal format from java library  Dustin Wolf 01.19.07 //
import java.util.*;             // library in which keyboard scanner is found  Dustin Wolf 01.19.07 //

public class CurrencyConverter  // names the project                           Dustin Wolf 01.19.07 //
{
	public static void main(String[] args)
	{                       // Calling of the variables                    Dustin Wolf 01.19.07 //
		String itemToBuy; 
		double priceOfItem; 
		int numberWillBuy; 
		double usDollar;
		double pounds; 
		double euros; 
		double yens; 
		
		Scanner keyboard = new Scanner(System.in);             // Scanner function to read from keyboard  Dustin Wolf 01.19.07 //
		DecimalFormat twoDigits = new DecimalFormat("0.00");   // function to give two decimal places     Dustin Wolf 01.19.07 //
		// System.out.println displays whats on the Monitor  Dustin Wolf 01.19.07 //
		System.out.println("Welcome to the Currency Converter");
		System.out.println("\nWhat is the name of the item you want to buy?");
		itemToBuy = keyboard.nextLine(); // pulls the string thats on the line  Dustin Wolf 01.19.07 //
		System.out.println("\nEnter the amount of money a " + itemToBuy + " costs in US dollars:");
		priceOfItem = keyboard.nextDouble(); // pulls the real number on the line  Dustin Wolf 01.19.07 //
		System.out.println("\nEnter the number of " + itemToBuy + "s you will buy:");
		numberWillBuy = keyboard.nextInt(); // pulls the integer from the line  Dustin Wolf 01.19.07 //
		
		// sets the values of each currency  Dustin Wolf 01.19.07 //
		usDollar = priceOfItem * numberWillBuy;
		pounds =  usDollar * .54299;
		euros = usDollar * .79632;
		yens = usDollar * 116.17174;
		// displays the final line shown with the currencies displayed  Dustin Wolf 01.19.07 //
		if(numberWillBuy <= 1) // if statement determining if item is plural or not  Dustin Wolf 01.19.07
			System.out.println("\n" + numberWillBuy + " " + itemToBuy + " will cost " + twoDigits.format(usDollar) + " US Dollars, " + twoDigits.format(pounds) + " British Pounds, " + twoDigits.format(euros) + " Euros, " + twoDigits.format(yens) + " Japanese Yen");
		else
			System.out.println("\n" + numberWillBuy + " " + itemToBuy + "s will cost " + twoDigits.format(usDollar) + " US Dollars, " + twoDigits.format(pounds) + " British Pounds, " + twoDigits.format(euros) + " Euros, " + twoDigits.format(yens) + " Japanese Yen");
	}
}
		
	