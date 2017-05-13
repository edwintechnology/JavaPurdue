public class Hero extends Greek
{
	public Hero()
	{
		super();
	}

	public Hero(String newName, int newHealth, int newDamage)
	{
		/*
		 * TODO 11a: Use the superclass constructor (in Greek) to create the
		 * character with the parameters passed in, plus making
		 * the hero's home city "Sparta"
		 */
		 super(newName, newHealth, newDamage, "Sparta");
		 // String newCity = "Sparta";
	}

	/*
	 * TODO 12: Override the attack function so that the console
	 * displays "<this hero's name> stabs at <the target's name>."
	 * Don't forget that attack must return whether the target died or not.
	 *
	 * For full credit you must employ the attack method that was
	 * inherited from Being.  If you do so you can write the entire
	 * method with just a few lines.
	 */
	 public boolean attack(Being target)
	 {
		 System.out.println(name + " stabs " + target.getName() + ".");
		 return super.attack(target);
	 }

}
