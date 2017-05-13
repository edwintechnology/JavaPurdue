/* TODO 13:
 * Yet one more time; add the import necessary to use the Random class.
 */
 import java.util.*;
public class Lab08
{
	int NUM_OF_TESTS = 100;
	/* TODO 14:
	 * Declare a constant int called NUM_OF_TESTS and initialize it to 100.
	 */
	 private IntGradeVector vector;
	 private Random rand;
	/* TODO 15:
	 * Declare an IntGradeVector called vector and a Random called rand.
	 * Both should have the strictest access level.
	 */

	public Lab08()
	{
		/* TODO 16:
		 * Initialize vector to be a new instance of IntGradeVector and
		 * rand to be a new instance of Random.
		 * If you're feeling especially industrious then seed your
		 * Random instance with System.currentTimeMillis()
		 */
		 vector = new IntGradeVector();
		 rand = new Random();
	}
	
	/**
	* This method does some simple testing of the add method for IntVector.
	* It adds NUM_OF_TESTS elements to the IntVector, prints it out,
	* and checks to make sure that the size is correct after the inserts.
	* If it is not then the test fails otherwise it succeeds.
	*/
	public boolean testAdd()
	{
		for (int i = 0; i < NUM_OF_TESTS; i++)
		{
			try
			{
				vector.add(rand.nextInt(101));
			}
			catch (ElementOutOfRangeException e)
			{
				System.out.println(e);
				return false;
			}
		}
		
		try
		{
			vector.add(101);
			return false;
		}
		catch (ElementOutOfRangeException e)
		{			
		}

		System.out.println(vector);		

		if (vector.size() != NUM_OF_TESTS)
		{
			return false;
		}		
		return true;
	}
	
	/**
	* This method is similar but tests remove.  It tries to remove every
	* element in the vector (if it cannot remove one of the elements in
	* the vector then the test fails), prints it, it checks to make sure
	* the size is 0 (otherwise the test fails).  It then tries to
	* remove a value from the empty vector which should return false, it
	* fails if this does not happen.  Finally it adds an element for
	* good measure and makes sure that it worked.
	*/
	public boolean testRemove()
	{
		for (int i = 0; i < NUM_OF_TESTS; i++)
		{
			int element = vector.elementAt(0);
			if (vector.remove(element) == false)
			{
				return false;
			}
		}

		System.out.println(vector);

		if (vector.size() != 0)
		{
			return false;
		}		
				
		if (vector.remove(121212) == true)
		{
			return false;
		}
		
		try
		{
			vector.add(42);
		}
		catch (ElementOutOfRangeException e)
		{
			System.out.println(e);
			return false;
		}
		
		if ((vector.elementAt(0) != 42) || (vector.size() != 1))
		{
			return false;
		}
		
		return true;
	}
	
	/**
	* Main simply creates a new Lab08 and runs the two test methods
	* listed above.  If they passed it prints that they succeeded,
	* otherwise it prints that they failed.
	*/
	public static void main(String[] args)
	{
		Lab08 lab = new Lab08();
		
		System.out.println("Testing IntGradeVector Add: ");
		if (lab.testAdd())
		{
			System.out.println("Succeeded\n");
		}
		else
		{
			System.out.println("Failed\n");
		}

		System.out.println("Testing IntGradeVector Remove: ");
		if (lab.testRemove())
		{
			System.out.println("Succeeded");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}
