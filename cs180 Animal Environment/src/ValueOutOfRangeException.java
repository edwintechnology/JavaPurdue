
/* 
ValueOutOfRangeException
    Thrown when the argument to setCurrentFoliage or setCurrentWater is outside of the valid range for a given Environment */
    
public class ValueOutOfRangeException extends Exception
{
	private static final long serialVersionUID = 1L;
	public ValueOutOfRangeException()
	{
		super();
	}
	public ValueOutOfRangeException(String message)
	{
		super(message);
	}
}
