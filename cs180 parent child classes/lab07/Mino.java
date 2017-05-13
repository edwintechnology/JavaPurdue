/*
 * TODO 4b: Declare Mino to be a subclass of the Being class that
 * implements the Monster interface
 */
public class Mino extends Being implements Monster
{
	public Mino()
	{
		super();
	}

	public Mino (String newName, int newHealth, int newDamage)
	{
		super(newName, newHealth, newDamage);
	}

	/*
	 * TODO 5b: This is the function that makes Mino implement the Monster
	 * interface. Write the function header to make this happen. You will need
	 * to do the same thing for the Cyclops class. For more hints see
	 * TODO 5a in Cyclops.java.
	 */
	public void taunt()
	{
		System.out.println(name + " taunts the Greeks: \"You don\'t stand a chance!!\"");
		System.out.println(name + " seems to grow even larger.");
		/*
		 * TODO 6: Increment the Minotaur's damage by one.
		 */
		this.health++;

	}

	public boolean attack (Being target)
	{
		System.out.println(name + " gores " + target.getName() + ".");
		return super.attack(target);
	}
}

