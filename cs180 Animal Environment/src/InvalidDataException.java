
/* InvalidDataException
    This says that information representing data in a String is contextually inappropriate.
    Throw this if a String passed to parseEnvironment has some text for an environment type that is not case-insensitive equivalent to one of the given Environment classes. (e.g."Volcano,35,55,100,100,66") 
*/
    
public class InvalidDataException extends Exception
{
	private static final long serialVersionUID = 1L;
	public InvalidDataException()
	{
		super();
	}
	public InvalidDataException(String message)
	{
		super(message);
	}
}
