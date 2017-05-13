package Categories;

import java.util.Random;
import Backend.*;

public class MultipleChoice extends Category
{
	Random rand;
	Category cat;
	int nOpt;

	public MultipleChoice(Category c, int n)
	{
		rand = new Random();
		cat = c;
		nOpt = n;
		if(nOpt < 2) nOpt = 2;
		if(nOpt > 8) nOpt = 8;
	}

	public Question nextQuestion()
	{
		String[] opts = {"A","B","C","D","E","F","G","H"};

		Question q = cat.nextQuestion();
		String prompt = q.q() + "\n";
		String a = q.a();
		String answer = "";

		int correctIndex = rand.nextInt(nOpt);

		for(int i = 0; i < nOpt; i++)
		{
			if(i == correctIndex)
			{
				prompt += "\t\t" + opts[i] + ". " + a + "\n";
				answer = opts[i];
			}
			else
			{
				String opt = a;

		while(opt.equals(a))
				{
					Question oQ = cat.nextQuestion();
					opt = oQ.a();
				}

				prompt += "\t\t" + opts[i] + ". " + opt + "\n";
			}
		}

		prompt += "\t\tAnswer: ";
		
		return new Question(prompt,answer);
	}
}
