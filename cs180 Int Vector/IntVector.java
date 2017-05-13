/** Dustin Wolf Lab06 february 21
*
*/

public class IntVector
{
    /*
     * TODO: DECLARE all of the private variables that you'll need:
     *   1.  An integer array called "elements"
     *   2.  An integer that keeps track of the size of the VECTOR
     */
     private int[] elements;
     private int sizeOfVector;
     public int[] sentinel;
     public static final int CAPACITY_INCREMENT = 10;
     public int element;
    
    /*
     * TODO: INITIALIZE the private variables you've declared.  The array
     *       should be of size CAPACITY_INCREMENT.
     */
     
    public IntVector()
    {
	 elements = new int[CAPACITY_INCREMENT];
	 sizeOfVector = elements.length;   
    }
    
    /*
     * TODO: Add "element" to the "index" position.  Be sure you do the following:
     *   1.  Grow the array if necessary (increase the size by CAPACITY_INCREMENT)
     *   2.  Shift all of the elements to the right of the position over
     *       to avoid overwriting an element
     *   3.  Make sure that the size (not the capacity!) is updated.
     */
    public void addAt(int index, int element)
    { 
	    for(int i = 0; i < elements.length; i++)
	    {
			    int[] newElement = new int[CAPACITY_INCREMENT + sizeOfVector];
			    elements = newElement;
		    for(int j = 0; j < sizeOfVector; j++)
		    {
			    elements[j+1] = elements[j];
		    }
	    }
	    elements[index] = element;
    }
    
    /*
     * TODO: Add an element to the end of the vector.  This can be done in one line;
     *       think of the add() method as a specific case of the addAt() method!
     */
    
    public void add(int element)
    {
	    addAt((elements.length-1), element);
    }
    
    /*
     * TODO: Remove the element at the "index" position.  Be sure to:
     *   1.  Make sure that the size is updated.
     *   2.  Shift all of the elements over.
     *   3.  Return the element of the index being removed.
     */
    public int removeAt(int index)
    {
	    sentinel = new int[sizeOfVector];
	    for(int i = 0; i < elements.length; i++)
	    {
		    sentinel = elements;
		    if(sentinel.equals(elements))
		    {
			    int[] newElement = new int[CAPACITY_INCREMENT];
			    elements = newElement;
		    }
		    elements[i-1] = elements[i];
	    }
	    return sentinel[element];
    }
    
    /*
     * TODO: Remove an element, if it exists.
     *   1.  Find the element
     *     a.  If it doesn't exist, return false.
     *     b.  If it does, then remove it (hint:  the removal process is, again,
     *         a specific case of removeAt!) and return true.
     */
    public boolean remove(int element)
    {
	    for(int i = 0; i < sentinel.length; i++)
	    {
		    if(sentinel[i] == 0)
		    {
			    return false;
		    }
		    else
		    {
			    return true;
		    }
	    }
	    return true;
    }
    
    /*
     * TODO: Return the element at the "index" position.  No error checking is
     *       necessary; this is a one line method!
     */
    public int elementAt(int index)
    {
	    return element;
    }
    
    /*
     * TODO: Set the "index" position's element to "value".  No error checking is
     *       necessary; this is a one line method!
     */
    public void setElementAt(int index, int value)
    {
	    elements[element] = value;
    }
    
    /*
     * TODO: Return the capacity of the vector.
     */
    public int capacity()
    {
	    return elements.length;
    }
    
    /*
     * Return the size of the vector.
     */
    public int size()
    {
	    return CAPACITY_INCREMENT;
    }
    
    /*
     * TODO: Return a String with a meaningful information about the vector.
     *       Namely, a String that has all of the elements in it.  This is more 
     *       for debugging purposes, so it's up to you how you want to format it.
     */
    public String toString()
    {
	    /** for(int s=0; s<sentinel.length; s++)
	    {
		    System.out.println(sentinel[s]);
	    }*/
	    String elemental = "Elements: ";
	    for(int i = 0; i < elements.length; i++)
	    {
		    elemental += sentinel;
	    }
	    System.out.println(elemental);
	    return elemental;
    }
}
