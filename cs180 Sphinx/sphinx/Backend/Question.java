// Declare that this object is in the Backend package.
package Backend;

public class Question
{
    // Each Question object will have two members: 
    //  question - a String representing a quiz question
    //  answer - a String representing the answer to question
	String question;
	String answer;
	String ans;

    // This special function is called a constructor.
    // It creates Question objects. You'll work more with
    // objects in the weeks to come.
	public Question(String q, String a)
	{
		question = q;
		answer = a;
	}

	public String q()
	{
		return question;
	}

	public String a()
	{
		return answer;
	}

	public boolean check(String ans)
	{
		String answer = this.answer;

		if(ans.equals(answer))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
