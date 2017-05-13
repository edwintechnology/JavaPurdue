/*
 * TODO 7:
 * Declare a public class that is compatible with the name of this file
 * that is a subclass of BadIntVector. 
 */
 public class IntGradeVector extends BadIntVector
 {

	 /*
	 * TODO 8:
	 * Override the add method from the superclass.  Look at the supplied
	 * javadoc page for detailed information about the method signatures
	 * of the superclass.  All of the information you need is there.
	 */
	 @Override public void add(int element) throws ElementOutOfRangeException
 	{
		/*
		* TODO 9:
		* Check to make sure that the element is in the range 
		* from 0 to 100 inclusive.  If it is not throw an
		* ElementOutOfBoundsException using the three argument
		* constructor you wrote passing in the appropriate values.
		*/
		if((element < 0) || (element > 100))
			throw new ElementOutOfRangeException(0, 100, element);
		/*
		* TODO 10:
		* Try to add an element to the vector using the superclass's
		* add method.  It will fail the first time throwing an
		* ArrayIndexOutOfBoundsException.  Handle this exception
		* by trying to add the same element again.  It will succeed the
		* second time you try to add it.
		*/
		try
		{
			super.add(element);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			super.add(element);
		}
	}
	
	/*
	 * TODO 11:
	 * Override the remove method from the superclass except this time
	 * DON'T have it declare that it throws ElementNotFoundException.
	 * Again, the provided javadoc for BadIntVector has all the information
	 * you need.
	 */
	 @Override public boolean remove(int element)
	{
		/*
		* TODO 12:
		* Now, since this method doesn't throw ElementNotFoundException
		* and the superclass's remove does we need to handle it and
		* deal with it appropriately.
		*
		* So, here is the idea:  Try to remove the requested element from
		* this vector.  If it succeeds then return true.  If it fails
		* then the call to the superclass's remove method will throw
		* an exception.  In this case we want to handle the exception
		* and return false rather than having the exception propagate
		* upward.
		*
		* Your task is to make this method return true if element
		* is successfully removed from this vector and false if it
		* is not.
		*/
		try
		{
			super.remove(element);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
 }


