public class Lab01
{
	public static int ageInMonths ( int age )
	{
		int result = age * 12;
		return result;
	}
	
	public static String addMr ( String name )
	{
		String result = "Mr. " + name;
		return result;
	}
	
	public static void doStuff ()
	{
		int months = ageInMonths(4);
		String fullName = addMr("Zach Tatlock");
		System.out.println(months);
		System.out.println(fullName);
	}
	
	public static void main(String[] args)
	{
		doStuff();
	}
}
