/* Dustin Wolf
* January 31, 2007
* Lab03
* Sphinx Quiz
*/

// Import the packages Backend.* and Categories.*
// so that we can use the objects defined in files
// in those directories.
import Backend.*;
import Categories.*;

public class Sphinx
{
 		public static void main(String args[])
		{
		System.out.println("Sphinx Quiz Engine\n\n");

		Quiz q;
		MultipleChoice multi;
		Mixer mix;

		/* Categories */
		Arithmetic arith = new Arithmetic(50,15);
		Vocab vocab = new Vocab();
        USCapitals usc = new USCapitals();

		/* Quizzes */
		multi = new MultipleChoice(vocab, 5);
		q = new Quiz(multi, 10);
		q.run();

		q = new Quiz(arith, 10);
		q.run();

		q = new Quiz(usc, 10);
		q.run();
		}
}
