import java.util.*;

class Lab07
{
	public static void main(String [] args)
	{
		int numevil;
		int numgood;
		Random generator = new Random();
		String[] cycnames = {"Arges", "Brontes", "Steropes", "Polyphemus"};
		String[] minonames = {"A brown minotaur", "A black minotaur",
		"A crazed minotaur"};
		String[] greeknames = {"Jason", "Hercules", "Bellerophon",
				"Theseus", "Odysseus", "Perseus",
				"Euryplylus", "Eurotas", "Leda",
				"Icarus", "Proetus"};

		numevil = cycnames.length + minonames.length;
		numgood = greeknames.length;

		List<Being> players = new ArrayList<Being>();

		for(String name : cycnames)
		{
			players.add(new Cyclops(name, generator.nextInt(20) + 10,
					generator.nextInt(3) + 10));
		}
		for(String name : minonames)
		{
			players.add(new Mino(name, generator.nextInt(10) + 5,
					generator.nextInt(10) + 20));
		}
		for(String name : greeknames)
		{
			if (generator.nextInt(2) == 0)
			{
				players.add(new Hero(name, generator.nextInt(10) + 15,
						generator.nextInt(10) + 10));
			}
			else
			{
				players.add(new Priest(name, generator.nextInt(10) + 5));
			}      
		}
		while (numevil > 0 && numgood >0)
		{
			Being player;
			for (int i = 0; i < players.size(); i++)
			{
				if (numevil > 0 && numgood > 0)
				{
					player = (Being)players.get(i);

					/*
					 * TODO 13: Create an if to check if the player is 
                     * an instance of the Monster type. If it is,
                     * enter the block.
					 */
					if(player instanceof Monster)
					{
						/*
						 * TODO 14: Write the call for the Monster to
						 * perform the special action only Monsters can.
						 *
						 * Note: You will need to cast player to type
						 * Monster before you can invoke this method on it
						 * because player is an instance of Being and not
						 * all beings have this method.  We know this
						 * instance is a Monster because we just checked
						 * therefore we know the cast won't fail and we'll
						 * be able to call this Method.
						 */
						((Monster)player).taunt();

						int victim = generator.nextInt(numgood) + numevil;
						if (player.attack((Being)players.get(victim)) == true)
						{
							players.remove(victim);
							if (victim < i)
								i -=1;
							numgood -= 1;
						}
					}
					else
					{ 
						int victim = generator.nextInt(numevil);  
						if (player.attack((Being)players.get(victim)) == true)
						{
							players.remove(victim);
							if (victim < i)
								i -=1;  
							numevil -=1;
						}
					}
				}
			}
		}
		if (numevil > 0)
		{
			System.out.println("Evil has triumped!");
		}
		else
		{
			System.out.println("The Greeks has triumped!");
		}    
	}
}
