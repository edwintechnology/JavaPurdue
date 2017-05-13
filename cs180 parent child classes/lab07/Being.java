import java.util.Random;

public abstract class Being
{
	/*
	 * TODO 1: Create the following 3 properties for the Being:
	 *          1. A String called name
	 *          2. An integer called health
	 *          3. An integer called damage
	 * Make sure these variables are accessible to child classes,
	 * but not to any outside class
	 */
	 protected String name;
	 protected int health;
	 protected int damage;
	 
	public Being()
	{
		this("Iphicles", 10, 10);
	}

	public Being(String newName, int newHealth, int newDamage)
	{
		name = newName;
		health = newHealth;
		damage = newDamage;
	}

	public String getName()
	{
		return this.name;
	}

	/*
	 * This method returns true if this instance is killed.
	 */
	public boolean calcHit(int dealtdamage)
	{
		System.out.println(name + " is hit for " + dealtdamage + " damage!");
		/*
		 * TODO 2: reduce this instance's health by the parameter passed in. If
		 * the instance dies (health 0 or less), call the die() function and
		 * return true. If the instance doesn't die, return false.
		 */
			 int newHealth = health - dealtdamage;
			 if(newHealth > 0)
			 {
				 health = newHealth;
				 return false;
			 }
			 else
			 { 	
				 health = newHealth;
				 die();
				 return true;
				
			 }

	}

	/*
	 * Calling this method means we want this Being to attack the Being
	 * given to us as "target".
	 * This method returns true if the target is killed.
	 */
	public boolean attack(Being target)
	{
		Random generator = new Random();
		int dealtdamage = generator.nextInt(this.damage);

		/*
		 * TODO 3: Damage the target by dealtdamage and return true if
		 * the target was killed.
		 * HINT: CAREFULLY look at the calcHit method below.  It does
		 * all of the needed work for you.  Make sure you damage the
		 * right Being (e.g. don't hit yourself!)
		 */
		 return target.calcHit(dealtdamage);
	}

	public void die()
	{
		Random generator = new Random();
		switch (generator.nextInt(2))
		{
		case 0:
			System.out.println(name + " slumps to the ground.");
			break;
		case 1:
			System.out.println(name + " silently topples over.");
			break;
		case 2:
			System.out.println(name + " cries out one last time. ");

		}
	}
}
