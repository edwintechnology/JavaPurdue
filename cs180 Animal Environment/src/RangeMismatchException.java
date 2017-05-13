
/* 
RangeMismatchException
    Thrown when the requested bounds for some property range are inconsistent. (e.g. maximum foliage < minimum foliage)
*/
    
@SuppressWarnings("serial")
public class RangeMismatchException extends Exception
{
	public RangeMismatchException()
	{
		super();
	}
	public RangeMismatchException(String message)
	{
		super(message);
	}
}
