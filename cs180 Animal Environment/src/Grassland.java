public class Grassland extends Environment // Class Grassland extends to Environment
{
    public static double MIN_FOLIAGE = 10; // specs for the grassland
    public static double MAX_FOLIAGE = 40;
    public static double MIN_WATER =   20;
    public static double MAX_WATER =   40;

    public Grassland( double newMinFoliage, double newMaxFoliage, double newMinWater, double newMaxWater, int newPollution ) throws RangeMismatchException
    { // contructor getting variables from the parent class and initializing new variables
        super( newMinFoliage, newMaxFoliage, newMinWater, newMaxWater, newPollution );
    }
    // overriding methods from parent class
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
    { // returns the name of this Class to a String
	    return "Grassland";
    }
    public boolean canAccept( Animal animal )
    { // checks to see if the instances Animal is an instanceof Crawler
	    if(animal instanceof Crawler)
	    { 
		    return true;
	    }
	    else
	    {
		    return false;
	    }
    }
}
