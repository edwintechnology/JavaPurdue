/*
 * TODO 1:
 * Declare a public class that is compatible with the name of this file
 * that is a subclass of Exception. 
 */
public class ElementNotFoundException extends Exception
{
	 /*
	 * TODO 2:
	 * Create a default constructor for this class.
	 */
	 public ElementNotFoundException()
	 {
		 super();
	 }
 
	/*
	* TODO 3:
	* Create a constructor that takes an int called element.  Invoke the
	* single argument constructor for the superclass that takes a String.
	* Pass element as this argument.  Note that you'll have to convert
	* the type of element.  There are a variety of ways to do this.
	* Pick your favorite. 
	*/
	public ElementNotFoundException(int element)
	{
		super("" + element);
	}
 }
