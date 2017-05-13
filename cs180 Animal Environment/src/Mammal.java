public class Mammal extends Animal implements Crawler // Mammal extends Animal and implements crawler interface
{
	public Mammal(double waterRequired, double foliageRequired, double meatRequired, double meatValue, boolean hasNeocortex)
	{ // constructor from parent class... and initializing new values for the following
		super(waterRequired, foliageRequired, meatRequired, meatValue, hasNeocortex);
	}
	public String crawl()
	{ // since the creature can crawl.. the following is printed to the screen
		String classType = this.toString();
		return "This " + classType + " crawls forward";
	}
}