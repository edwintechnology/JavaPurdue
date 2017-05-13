package Categories;

import java.util.Random;
import java.util.LinkedList;
import Backend.*;

public class Mixer extends Category
{
	Random rand;
	LinkedList<Category> cats;

	public Mixer()
	{
		rand = new Random();
		cats = new LinkedList<Category>();
	}

	public void add(Category c)
	{
		this.add(c,1);
	}

	public void add(Category c, int f)
	{
		for(int i = 0; i < f; i++)
		{
			cats.add(c);
		}
	}

	public Question nextQuestion()
	{
		int index = rand.nextInt(cats.size());
		Category c = cats.get(index);
		return c.nextQuestion();
	}
}
