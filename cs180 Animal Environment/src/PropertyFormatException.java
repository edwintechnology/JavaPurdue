
/*  PropertyFormatException
    Thrown when the entry for some property in a String representing an Environment is not a valid number. (e.g. "oCeAn,hi,how,are,you,today") */
    
public class PropertyFormatException extends Exception
{
	private static final long serialVersionUID = 1L;
	public PropertyFormatException()
	{
		super();
	}
	public PropertyFormatException(String message)
	{
		super(message);
	}
}
