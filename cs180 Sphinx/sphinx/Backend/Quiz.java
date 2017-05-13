// Declare that this object is in the Backend package.
package Backend;

import java.util.*;
// We import the Categories package so we can use objects
// defined in files in ../Categories/*
import Categories.*;

public class Quiz
{
    // Each Quiz object will have one member:
    //  qs - a Question array representing the 
    //       questions in the Quiz
    //
    //  (Don't worry, you'll learn more about objects 
    //   and arrays later.)
	Question[] qs;

    // This special function is called a constructor.
    // It creates Quiz objects. You'll work more with
    // objects in the weeks to come.
	public Quiz(Category c, int nQs)
	{
        // This line creates space for a list of up
        // to nQs Question objects. You'll learn more
        // about arrays soon.
		qs = new Question[nQs];
		for(int i = 0; i < nQs; i++)
		{
            // This sets the ith entry in the array qs to
            // the next question from the Category object
            // c. Although this line is cryptic now, it will
            // make perfect sense once you understand arrays
            // and objects (which is soon!).
			qs[i] = c.nextQuestion();
		}
	}

    	public void run()
	{
		int correct = 0;
		int num = 1;
		int i;
		Scanner in = new Scanner(System.in);

		long start = System.currentTimeMillis();

		for(i = 0; i < qs.length; i++)
		{
			System.out.print(num + ":\t" + qs[i].q());			
			String answer = in.nextLine();		
			boolean right = qs[i].check(answer);

		if(right == true)
		{
			System.out.println("\t\tCorrect.\n");
			correct++;
		}

		else
		{
			System.out.println("\t\tIncorrect. Should be " + qs[i].a() + ".\n");
		}

		num++;

		long finish = System.currentTimeMillis();

		System.out.println();
		System.out.println("Correct:   " + correct);
		System.out.println("Incorrect: " + (qs.length - correct));
		System.out.println("Time:      " + ((finish - start)/1000) + " seconds\n\n");
		}
	}
}

