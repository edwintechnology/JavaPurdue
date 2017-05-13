public class WordNode implements Comparable<WordNode>
{
	int wordCount = 1;
	String nextString = "";
	WordNode nextNode;
	public WordNode(WordNode node, String s)
	{
		nextNode = node;
		nextString = s;
	}
	public WordNode()
	{
	}
	public WordNode getNext()
	{
		return nextNode;
	}
	public void setNext( WordNode node )
	{
		nextNode = node;
	}
	public String getWord()
	{
		return nextString;
	}
	public int getCount()
	{
		return wordCount;
	}
	public void incrementCount()
	{
		wordCount++;
	}
	public int compareTo( WordNode node )
	{
		return nextString.compareTo( node.getWord() );
	}
	
}
