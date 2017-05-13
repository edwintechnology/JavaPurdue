// Dustin Wolf March 22 2007
public class WordList
{
	private MyLinkedList[] wordList;
	private int indexCount; // down the array
	private int arrayIndex; // size of array
	public static int nodeCounter; // across the array
	private WordNode newNode;
	
	public WordList()
	{
		wordList = new MyLinkedList[26];
		for(int i = 0; i < wordList.length; i++)
		{
			wordList[i] = new MyLinkedList(); // establishes each section of the array a linkedList 
		}
		nodeCounter = 0;
		indexCount = 0;
		arrayIndex = 0;
		newNode = null;
	}
	public void add( String s )
	{
		s = s.toLowerCase(); // lower case the string 
		int c = s.charAt(0) - 'a'; // sets the letter value of a-z as 0,1,2 respectively for indices
		WordNode newItem = wordList[c].findItem(s); // checks to see if the word already exists in the array..
		if(newItem == null)
		{
			wordList[c].add(s); // if not then it adds it
		}
		else
		{
			newItem.incrementCount(); // if it does it increments the count.
		}
	}
	public boolean find( String s )
	{
		s = s.toLowerCase(); // lower the case of the string
		int c = s.charAt(0) - 'a';
		if(wordList[c].findItem(s) == null) // does a find item 
		{
			return false; // if its there you guessed it.. its true
		}
		else
		{
			return true; // if not then its false.
		}
	}
	public WordNode getNext() // causing me the most problem.... i need help
	{
		for(int i = 0; i < wordList.length; i++)
		{
			if( arrayIndex == 26 )
			{
				return null;
			}
			newNode = wordList[arrayIndex].get(indexCount);
			if( newNode == null)
			{
				arrayIndex++;
				reset();
				continue;
			}
			else
			{
				indexCount++;
				return newNode;
			}
		}
		return null;
	}
	public void reset() // resets
	{
		newNode = null;
		indexCount = 0;
		// arrayIndex = 0;
	}
}
/* i dunno if you actually read comments.. but i have worked all week for this project and i cannot seem to figure away to display 
the correct output.. i know its there because the different ways i have tried to display have shown different words 
but i cannot seem to get them all.. maybe if you have a chance to read over my code and explain to me what i am missing that would
be must appreciated. thank you... Dustin Wolf */