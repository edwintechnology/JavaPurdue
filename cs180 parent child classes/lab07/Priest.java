import java.util.Random;

public class Priest extends Greek
{
	public Priest()
	{
		super();
	}

	public Priest(String newName, int newHealth)
	{
		/*
		 * TODO 11b: Use a superclass constructor to create the character
		 * with the parameters passed in, the damage to 0, and make the
		 * priest's home city "Delphi"
		 */
		 super(newName, newHealth, 0, "Delphi");
		 // String newCity = "Delphi";
	}

	public boolean attack(Being target)
	{
		boolean dead;
		Random generator = new Random();
		System.out.println(name + " prays to the gods.");
		switch (generator.nextInt(20))
		{
		case (0):
			System.out.println(target.getName() + " is struck by lightning!");
			damage = 10000;
			dead = super.attack(target);
			damage = 0;
			break;
		case (1):
			System.out.println(target.getName() + " is engulfed in fire!");
			damage = 7500;
			dead = super.attack(target);
			damage = 0;
			break;
		default:
			System.out.println("The gods do not listen to " + name + ".");
			dead = false;
			break;
		}
		return dead;
	}
}
