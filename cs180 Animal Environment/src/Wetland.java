public class Wetland extends Environment // Wetland that extends Environment class
{
    public static double MIN_FOLIAGE = 40; // Specs for the wetland
    public static double MAX_FOLIAGE = 70;
    public static double MIN_WATER =   60;
    public static double MAX_WATER =   80;

    public Wetland( double newMinFoliage, double newMaxFoliage, double newMinWater, double newMaxWater, int newPollution ) throws RangeMismatchException
    { // the constructor that pulls values from parent class and initializes the following variables
        super( newMinFoliage, newMaxFoliage, newMinWater, newMaxWater, newPollution );
    }
    // overriding methods from Parent class
    @Override public double getMinPossibleFoliage()
    { 
	    return MIN_FOLIAGE; 
    }
    @Override public double getMaxPossibleFoliage()
    { 
	    return MAX_FOLIAGE; 
    }
    @Override public double getMinPossibleWater()     
    { 
	    return MIN_WATER; 
    }
    @Override public double getMaxPossibleWater()     
    { 
	    return MAX_WATER; 
    }
    public String toString()
    { // sets class name to a String
	    return "Wetland";
    }
    public boolean canAccept( Animal animal )
    { // since both swimmers and crawlers can be in wetlands, we check if either/or
	    if(animal instanceof Swimmer || animal instanceof Crawler)
	    {
		    return true;
	    }
	    return false;
    }
}
