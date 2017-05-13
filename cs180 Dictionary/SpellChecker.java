// Dustin Wolf March 22 2007
import java.io.*;
import java.util.*;

public class SpellChecker
{
	public static WordList words = new WordList();
	public static WordList dictionaryList = new WordList();
	public static WordList misSpelledList = new WordList();
	public static WordNode wordN;
	public static WordNode temporaryNode;
	public static WordNode newNode;
	public static String dumbyString = "";
	public static int count = 0;
	public static String dumbyString1 = "";
	public static int count1 = 0;
	public static String dumbyString2 = "";
	public static int count2 = 0;
	public static int distance;
	public static String temp = "";
	
	public static void main( String args[] )
	{
		if(args.length == 2)
		{
			BufferedReader input = null;
			BufferedReader input1 = null;
			BufferedReader input2 = null;
			PrintWriter output = null;
			PrintWriter output1 = null;
			PrintWriter output2 = null;

			try
			{
				input = new BufferedReader(new FileReader(args[0]));
				output = new PrintWriter(new FileOutputStream(args[1]));
				input1 = new BufferedReader(new FileReader("Dictionary.txt"));
				output1 = new PrintWriter(new FileOutputStream("Misspelled.txt"));
				output2 = new PrintWriter(new FileOutputStream("Suggestion.txt"));
				input2 = new BufferedReader(new FileReader("Misspelled.txt"));

////////////////////////////////////////////////////////////////////////// input of args[0] //////////////////////////////////////////////////////////////////////////
				String line = input.readLine();
				while(line != null)
				{
					StringTokenizer st = new StringTokenizer(line, "\\/?.><,;:\"|}]{[~`!@#$%^&*()1234567890-_+= \n\t");
					while(st.hasMoreTokens())
					{
						dumbyString = st.nextToken();
						words.add(dumbyString);
						count++;
					}
					line = input.readLine();
				}
				input.close();
////////////////////////////////////////////////////////////////////////// input of Dictionary ///////////////////////////////////////////////////////////////////////
				String line1 = input1.readLine();
				while(line1 != null)
				{
						StringTokenizer st1 = new StringTokenizer(line1, "\\/?.><,;:\"|}]{[~`!@#$%^&*()1234567890-_+= \n\t");
						while(st1.hasMoreTokens())
						{
							dumbyString1 = st1.nextToken();
							dictionaryList.add(dumbyString1);
							count1++;
						}
						line1 = input1.readLine();
				}
				input1.close();
/////////////////////////////////////////////////////////////////////////// input of mispelled /////////////////////////////////////////////////////////////
				String line2 = input2.readLine();
				while(line2 != null)
				{
						StringTokenizer st2 = new StringTokenizer(line2, "\\/?.><,;:\"|}]{[~`!@#$%^&*()1234567890-_+= \n\t");
						while(st2.hasMoreTokens())
						{
							dumbyString2 = st2.nextToken();
							misSpelledList.add(dumbyString2);
							count2++;
						}
						line2 = input2.readLine();
				}
				input2.close();
//////////////////////////////////////////////////////////////////////////// output time //////////////////////////////////////////////////////////////////////////////
				wordN = words.getNext();
				for(int hopefulCount = 0; hopefulCount < count; hopefulCount++)
				{
					if(wordN != null)
					{
						String wordString = wordN.getWord();
						int wordCount = wordN.getCount();
						output.println("" + wordString + " " + wordCount);
						if(!dictionaryList.find(wordString))
						{
							String wordString1 = wordN.getWord();
							output1.println("" + wordString1);
							
							// trying to find out the misspelled suggestion
							dictionaryList.reset();
							int start = 1;
							temporaryNode = words.getNext();
							String wordString2 = temporaryNode.getWord();
							distance = Distance.LD(wordString1, wordString2);
							if(start < distance)
							{
								newNode = temporaryNode;
								temp = temporaryNode.getWord();								
							}
							else
							{
								newNode = wordN;
								temp = temporaryNode.getWord();
							}
							output2.println(wordString1 + " - " + temp);
							temporaryNode = words.getNext();
						}
						wordN = words.getNext();
					}
				}
			}
			catch(FileNotFoundException e)
			{
				String message = e.getMessage();
				System.out.println(message);
			}
			catch(IOException e)
			{
				String message = e.getMessage();
				System.out.println(message);
			}
			finally
			{
				output.close();
				output1.close();
				output2.close();
			}
		}
		
	}
}
