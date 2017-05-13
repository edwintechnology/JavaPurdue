/*
 * TODO 4a: Declare Cyclops to be a subclass of the Being class and also
 * that implements the Monster interface
 */
public class Cyclops extends Being implements Monster
{
	public Cyclops()
	{
		super();
	}

	public Cyclops (String newName, int newHealth, int newDamage)
	{
		super(newName, newHealth, newDamage);
	}

	/*
	 * TODO 5a: This is the function that makes Mino implement the Monster
	 * interface. Write the function header to make this happen. You will need
	 * to do the same thing for the Mino class.
	 * 
	 * You will want to look in Monster.java to find the information about
	 * the method you need to implement.
	 *
	 * Keep in mind that all methods that implement an interface need to
	 * have a specific access level whether or not it is explicitly stated
	 * in the interface itself.
	 */
	public void taunt()
	{
		System.out.println(name + " taunts the Greeks: \"You cannot escape my gaze!\"");
		System.out.println(name + " regenerates.");
		/*
		 * TODO 7: Increment the Cyclops' health by two.
		 */
		this.health += 2;

	}

	public boolean attack (Being target)
	{
		System.out.println(name + " swats at " + target.getName() + ".");

		if (super.attack(target) == true)
		{
			System.out.println(name + " yells \"I got you!\".");
			return true;
		}
		return false;
	}
}
