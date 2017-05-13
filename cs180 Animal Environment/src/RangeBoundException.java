
/*
RangeBoundException
    Thrown when the requested range for some particular Environment are not within the possible range values for that Environment type. (e.g. new Ocean(0,50,100,100,5) )
*/
    
public class RangeBoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public RangeBoundException()
	{
		super();
	}
	public RangeBoundException(String message)
	{
		super(message);
	}
}
