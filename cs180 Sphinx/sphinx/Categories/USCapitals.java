package Categories;

import java.util.Random;
import Backend.*;

public class USCapitals extends Category
{
	static Random rand;
	boolean askCapital;

	public USCapitals()
	{
		rand = new Random();
		askCapital = true;
	}

	public USCapitals(boolean ac)
	{
		rand = new Random();
		askCapital = ac;
	}

	public static final String stateCapital[] = {
	       "Alabama","Montgomery",
	       "Alaska","Juneau",
	       "Arizona","Phoenix",
	       "Arkansas","Little Rock",
	       "California","Sacramento",
	       "Colorado","Denver",
	       "Connecticut","Hartford",
	       "Delaware","Dover",
	       "Florida","Tallahassee",
	       "Georgia","Atlanta",
	       "Hawaii","Honolulu",
	       "Idaho","Boise",
	       "Illinois","Springfield",
	       "Indiana","Indianapolis",
	       "Iowa","Des Moines",
	       "Kansas","Topeka",
	       "Kentucky","Frankfort",
	       "Louisiana","Baton Rouge",
	       "Maine","Augusta",
	       "Maryland","Annapolis",
	       "Massachusetts","Boston",
	       "Michigan","Lansing",
	       "Minnesota","Saint Paul",
	       "Mississippi","Jackson",
	       "Missouri","Jefferson City",
	       "Montana","Helena",
	       "Nebraska","Lincoln",
	       "Nevada","Carson City",
	       "New Hampshire","Concord",
	       "New Jersey","Trenton",
	       "New Mexico","Santa Fe",
	       "New York","Albany",
	       "North Carolina","Raleigh",
	       "North Dakota","Bismarck",
	       "Ohio","Columbus",
	       "Oklahoma","Oklahoma City",
	       "Oregon","Salem",
	       "Pennsylvania","Harrisburg",
	       "Rhode Island","Providence",
	       "South Carolina","Columbia",
	       "South Dakota","Pierre",
	       "Tennessee","Nashville",
	       "Texas","Austin",
	       "Utah","Salt Lake City",
	       "Vermont","Montpelier",
	       "Virginia","Richmond",
	       "Washington","Olympia",
	       "West Virginia","Charleston",
	       "Wisconsin","Madison",
	       "Wyoming","Cheyenne" };

	public Question nextQuestion()
	{
		int index = rand.nextInt(stateCapital.length/2);
		String state = stateCapital[2*index];
		String capital = stateCapital[2*index + 1];

		String q;
		String a;

		if(askCapital)
		{
			q = "What is the capital of " + state + "? ";
			a = capital;
		}
		else
		{
			q = capital + " is the capital of what state? ";
			a = state;
		}

		return new Question(q,a);
	}
}
