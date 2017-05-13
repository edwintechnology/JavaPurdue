/*
 * TODO 4:
 * Declare a public class that is compatible with the name of this file
 * that is a subclass of Exception. 
 */
 public class ElementOutOfRangeException extends Exception
 {
	 /*
	 * TODO 5:
	 * Create a default constructor for this class.
	 */
	 public ElementOutOfRangeException()
 	{
		super();
	}
 
	/*
	* TODO 6:
	* Create a constructor that takes three int arguments lowerBound,
	* upperBound, and element.
	* Invoke the single argument constructor for the superclass that
	* takes a String.
	* Pass a string in the form "[lowerBound, upperBound], element"
	* In other words, if an element 16 is out of the bounds 7 and 13
	* the string would be "[7, 13], 16"
	*/
	public ElementOutOfRangeException(int lowerBound, int upperBound, int element)
	{
		super("[" + lowerBound + ", " + upperBound + "], " + element);
	}
 }
