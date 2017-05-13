public class Seal extends Mammal implements Swimmer // class Seal extended to Mammal and implements Swimmer
{	
	public Seal()
	{ // Doubles of waterRequired, foliageRequired, meatRequired, MeatValue and Boolean of Neocortex... in respect
		super(30.0, 20.0, 5.0, 2.5, true);
	}
	public String toString()
	{ // Name of class is set to String
		return "Seal";
	}
	public String swim()
	{ // since Seal can swim and crawl this call to the method is necessary .. it just states he can do both.. yay
		String classType = toString();
		return "This " + classType + " swims around";
	}
}