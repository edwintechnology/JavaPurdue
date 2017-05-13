package Categories;

import java.util.Random;
import Backend.*;

public class Arithmetic extends Category
{
	int aMax;
	int mMax;
	Random rand;

	public Arithmetic()
	{
		aMax = 20;
		mMax = 10;
		rand = new Random();
	}

	public Arithmetic(int a, int m)
	{
		aMax = a;
		mMax = m;
		rand = new Random();
	}

	public Question nextQuestion()
	{
		String q = "";
		String a = "";

		int op1;
		int op2;
		int op3;
		int power;

        int magic = rand.nextInt(11);

        // TODO 1
        //
        // Write a switch statement that uses 
        // the integer variable named magic
        // to match against cases.
	switch(magic)
		{
			case 0:
			case 1:
				op1 = rand.nextInt(this.aMax) + 1;
				op2 = rand.nextInt(this.aMax) + 1;
				q = op1 + " + " + op2 + " = ";
				a = "" + (op1 + op2);
				break; /* NOTE THE BREAK! */
			case 2:
			case 3:
				op1 = rand.nextInt(this.aMax) + 1;
				op2 = rand.nextInt(this.aMax) + 1;
				if(op1 < op2){ int t = op1; op1 = op2; op2 = t; }
				q = op1 + " - " + op2 + " = ";
				a = "" + (op1 - op2);
				break;
			case 4:
				op1 = rand.nextInt(this.mMax) + 1;
				op2 = rand.nextInt(this.mMax) + 1;
				q = op1 + " * " + op2 + " = ";
				a = "" + (op1 * op2);
				break;
			case 5:
				op1 = rand.nextInt(this.mMax) + 1;
				op2 = rand.nextInt(this.mMax) + 1;
				if(op1 < op2){ int t = op1; op1 = op2; op2 = t; }
				q = op1 + " % " + op2 + " = ";
				a = "" + (op1 % op2);
				break;
			case 6:
				power = rand.nextInt(14);
				q = "2 ^ " + power + " = ";
				a = "" + ((long)Math.pow(2,power));
				break;

			case 7:
				op1 = rand.nextInt(this.mMax) + 1;
				op2 = rand.nextInt(this.mMax) + 1;
				op3 = rand.nextInt(this.aMax) + 1;
				q = op1 + " * " + op2 + " + " + op3 + " = ";
				a = "" + (op1 * op2 + op3);
				break;
			
			case 8:
				op1 = rand.nextInt(this.aMax) + 1;
				op2 = rand.nextInt(this.aMax) + 1;
				if(rand.nextInt(2) == 0)
				{
					q = "? + " + op2 + " = " + (op1 + op2) + " : ";
				}
				else
				{
					q = op2 + " + ? = " + (op1 + op2) + " : ";
				}
				a = "" + op1;
				break;

			case 9:
				op1 = rand.nextInt(this.aMax) + 1;
				op2 = rand.nextInt(this.aMax) + 1;
				if(op1 < op2){ int t = op1; op1 = op2; op2 = t; }
				if(rand.nextInt(2) == 0)
				{
					q = op1 + " - ? = " + (op1 - op2) + " : ";
					a = "" + op2;
				}
				else
				{
					q = "? - " + op2 + " = " + (op1 - op2) + " : ";
					a = "" + op1;
				}
				break;

			case 10:
				power = rand.nextInt(7);
				q = "3 ^ " + power + " = ";
				a = "" + ((long)Math.pow(3,power));
				break;

			case 11:
				if(rand.nextInt(2) == 0)
				{
					q = "b ^ x = y  -->  log_b y = ?";
					a = "x";
				}
				else
				{
					q = "b ^ x = y  -->  log_b ? = x";
					a = "y";
				}
				break;

		}	

        // QUESTION : for the first two case TODOs we
        // had you have one "fall through". Given that
        // the variable we're switching on is randomly
        // generated, why would we do this?
	// ANSWER: because the 0 and 1 have the same output values
		
		return new Question(q,a);
	}
}
