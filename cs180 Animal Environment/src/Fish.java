public class Fish extends Animal implements Swimmer // fish extends Animal and implements Swimmer
{
	public Fish(double waterRequired, double foliageRequired, double meatRequired, double meatValue, boolean hasNeocortex)
	{ // super up to Animal Class to use the methods
		super(waterRequired, foliageRequired, meatRequired, meatValue, hasNeocortex);
	}
	public String swim()
	{ // determines if the Animal can Swim. since its fish it can.. the output is Printed
		String classType = this.toString();
		return "This " + classType + " swims around";
	}
}