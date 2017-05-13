import java.util.Random;

/*
 * TODO 8: Declare the Greek an abstract class that inherits from the Being
 * class
 */
public class Greek extends Being
{
	// The home city of this greek.
	protected String city;

	public Greek()
	{
		/*
		 * TODO 9: The superclass of Greek, which is Being, already has
		 * a default constructor which will set the name, health, and
		 * damage for this Greek.  Invoke it 
		 * and then set the home city of this Greek to "Olympia".
		 */
		 super();
		 city = "Olympia";

	}

	public Greek(String newName, int newHealth, int newDamage, String newCity)
	{
		/*
		 * TODO 10: Set the name, health, and damage using 
		 * the other constructor for the superclass,
		 * and then set the home city of this Greek to newCity.
		 */
		 super(newName, newHealth, newDamage);
		 city = newCity;
		 

	}

	public boolean calcHit(int dealtdamage)
	{
		Random generator = new Random();
		if (super.calcHit(dealtdamage) == false)
		{
			if (generator.nextInt(5) == 1)
			{
				System.out.print(name + " says \"");
				if ("Delphi".equals(city))
				{
					System.out.print("Apollo");
				}
				else if ("Sparta".equals(city))
				{
					System.out.print("Artemis");
				}
				else
				{
					System.out.print("Zeus");
				}
				System.out.println(" protect me!");
				System.out.println(name + " shines with armor made of light.");
				health += 3;
			}
			return false;
		}
		return true;
	}
}
