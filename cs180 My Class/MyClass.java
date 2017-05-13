public class MyClass
{
	public static int doubleNumber ( int number )
	{
		int result = number * 2;
		return result;
	}
	
	public static String repeatStr ( String phrase )
	{
		String result = phrase + phrase;
		return result;
	}
	
	public static void assignFunction ()
	{
		int digit = doubleNumber(2);
		String word = repeatStr("Me");
		System.out.println(digit);
		System.out.println(word);
	}
	
	public static void main(String[] args)
	{
		assignFunction();
	}
}
