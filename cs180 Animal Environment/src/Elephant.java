public class Elephant extends Mammal // elephant class extended to the mammal and receives from mammal
{
	public Elephant()// constructor
	{     // Doubles of waterRequired, foliageRequired, meatRequired, MeatValue and Boolean of Neocortex... in respect
		super(5.0, 20.0, 0.0, 20.0, true);
	}
	public String toString()
	{
		return "Elephant"; // returns the Class name to a String
	}
}