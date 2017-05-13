package src;

import java.util.*;
import java.io.*;

public class Anagrammer
{
  public static int MAX_LEN = 5;
  private static Vector<String> dict;
  private static Stack<String> soln;

  // the original string passed in via the command line
  @SuppressWarnings("unused")
private static String org;  
  private static boolean written = false;

  public static void main(String argv[])
  {
    /* TODO 1: The user MUST specify on the command line a target phrase and 
     *  can optionally specify a maximum word length.  Check to make sure that 
     *  the correct number of parameters have been specified.  If not, execute
     *  the block of code directly below. */
    if (argv.length != 2)
    {
      System.out.println("Usage: java Anagrammer \"phrase\" [max word len]");
      return;
    }

    // if the user specifies a max. word length at run-time, honor that value
    if (argv.length == 2)
    {
      MAX_LEN = Integer.parseInt(argv[1]);
    }

    String target = argv[0];

    org = target.replaceAll("\\s", "_");
    target = target.replaceAll("\\s", "");

    soln = new Stack<String>();

    // read the dictionaries into our global array
    readDict(target);

    /*
     * solve the anagram starting with the given phrase and the start of the
     * dictionary
     */
    solveAnagram(target, 0);
  }

  /*
   * Method: readDict()
   * Description: read the dictionary files into the global dictionary, dict.
   *  Insert in order of largest to smallest.
   * Input: none
   * Returns: nothing
   * Side effects: modifies the dictionary
   */
  private static void readDict(String target) 
  {
    @SuppressWarnings("unused")
	int ind = 0;

    // initialize the dictionary
    dict = new Vector<String>();

    /* TODO 2: Write the head of a "for" loop.  In this header, create an
     *  iteration variable "i" initialized to the max word length (check this
     *  class's fields to see where this is stored) and have it iterate down
     *  to the smallest word length, 2. */
    for(int i = MAX_LEN; i > 2; i--)
    {

      BufferedReader bf = null;

       /* TODO 3: creating, using, and closing a BufferedReader can throw 
       * IOExceptions.  Wrap this bracketed code in a try block and catch an
       * IOException.  If such an exception is caught, print to System.err a
       * warning stating that there was an error reading from a dictionary file
       * and give the word length */
      try
      {

        /* TODO 4: Make bf a BufferedReader that will read words in from the 
         *  file holding all words of length "i".  Check the file names in the
         *  "dictionary" directory too see the names. */
	 bf = new BufferedReader(new FileReader("dictionaries/" + i + "_len_words.txt"));
        // TODO 5: Store the first line from your BufferedReader into "line".
	 String line = bf.readLine();
        /* TODO 6: Create a loop that will continue to loop as long as the
         *  the latest line of input is not null. */
	 while(line != null)
        {
          /* TODO 7: Declare and initialize a StringTokenizer that tokenizes
           *  the latest line of input. */
	   StringTokenizer st = new StringTokenizer(line);
          /*
           * TODO 8: Create a loop that loops as long as the tokenizer still 
           * contains tokens. */
	   while(st.hasMoreTokens())
          {
            /* TODO 9: Store the next token in the tokenizer in a String named
             *  "candidate."  Then make use of the checkNext() method to 
             *  determine if "target" contains all of the letters in
             *  "candidate".  The comments above checkNext() should tell you all
             *  that you need to know.  If target DOES contain all of the 
             *  letters, execute the statement in the block below.  */
	     String candidate = st.nextToken();
	     if(!checkNext(candidate, target).equals(target)) // Not sure on if this is correct
	     {
		     dict.add(candidate);
	     }
          }
	  line = bf.readLine();
          // TODO 10: Store the next line from your BufferedReader into "line".
        }
      }
      catch (IOException ioe)
      {
        System.err.println("Warning: dictionary file for word length " + i
          + " not found.");
      }
      finally
      {
	      try{
	      if(bf != null)
	      {
		      bf.close();
	      }} catch(Exception e)
	      {}
        // TODO 11: Close the BufferedReader if and only if bf is not null.
      }
    }

    return;
  }

  /*
   * Method: solveAnagram()
   * Description: solve an anagram using all words in the dictionary starting
   *  from index
   * Input: the string to solve and the starting index in the dictionary
   * Returns: nothing
   * Side effects: changes the solution stack, 
   *  prints all solutions to the console
   */
  private static void solveAnagram(String target, int index)
  {
    // check if the anagram is fully solved
    if (target.equals(""))
    {
      printSoln();
      return;
    }

    for (int i = index; i < dict.size(); i++)
    {
      String candidate = dict.get(i);

      //check if the next string in the dict could fit in the target string
      String isNice = checkNext(candidate, target);
      
      if (!isNice.equals(target))
      {
        // push the fitting string onto the solution stack
        soln.push(candidate);

        // solve the new, smaller anagram
        solveAnagram(isNice, i);

        /*
         * after the call to solveAnagram, we have exhausted all possible
         * solutions holding the candidate.  Remove it from the solution stack.
         */
        soln.pop();
      }
    }
  }

  /*
   * Method: checkNext()
   * Description: checks if the big string contains all of the characters in the
   *  small string
   * Input: a string and the string that may contain its characters
   * Return: if the big string contains the small string, then return the big
   *  string minus the characters that were in the small string.  Otherwise,
   *  just return the big string.
   * Side effects: none
   */
  private static String checkNext(String small, String big) 
  {
    // start with the big string
    String res = big;

    // iterate over all characters in the small string
    for (int i = 0; i < small.length(); i++)
    {
      /*
       * for a given character in the small string, find it's place in the big 
       * string
       */
      int found = res.indexOf(small.charAt(i));
      
      // if the character was not found, then big does not contain small
      if (found == -1)
      {
        return big;
      }

      // concatenate the part of the result before and after the character
      res = res.substring(0, found) + res.substring(found + 1, res.length());
    }

    return res;
  }

  /*
   * Method: printSoln()
   * Description: prints the current solution stack to the console
   * Input: nothing
   * Return: nothing
   * Side effects: prints solution to the solution file
   */
  private static void printSoln() 
  {
    PrintWriter pw = null;

    /* TODO 12: Wrap the following block of code in a structure that will catch
     *  the kind of exception that could be thrown when trying to create a 
     *  FileOutputStream for a file that does not exist. */
    try
    {
      /* TODO 13: Create a FileOutputStream that will print all possible
       *  solutions to a text file.  You may name the text file whatever you 
       *  wish, so long as it holds the original string given over the command
       *  line (the value is stored for you; check the class's fields).
       *  
       *  If we are printing a solution for the first
       *  in this program's execution, we will not want to open the file for
       *  appending; otherwise, we will.  The "written" field has been declared
       *  for you to check in making this decision. */
      pw = new PrintWriter(new FileOutputStream("output.txt", written));
      String solnString = soln.toString();

      /* TODO 14: Print the String representation of the stack (stored in 
       *  "solnString") to a line in the solution text file.  It is perfectly 
       *  acceptable to make use of the Stack's toString() method. 
       *
       *  Then close the PrintWriter and set the "written" field to note that
       *  this program has written a solution. */
       pw.println(solnString);
       pw.close();
       written = true;
    }
    
    // TODO 12: Head of catch block goes here.
    catch(FileNotFoundException e)
    {
      System.err.println("Warning: could not create a solution file.");
    }
  }
}

