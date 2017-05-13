public class Ocean extends Environment // class ocean extends environment
{
    public static double MIN_FOLIAGE = 30; // specs for the ocean environment
    public static double MAX_FOLIAGE = 60;
    public static double MIN_WATER =   100;
    public static double MAX_WATER =   100;

    public Ocean( double newMinFoliage, double newMaxFoliage, double newMinWater, double newMaxWater, int newPollution ) throws RangeMismatchException
    { // constructor from parent class and initializing new values to the vars
        super( newMinFoliage, newMaxFoliage, newMinWater, newMaxWater, newPollution );
    }
    // overriding methods from the parent class
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
    { // sets the name of this class to a String
	    return "Ocean";
    }
    public boolean canAccept( Animal animal )
    { // checks to see if the instance animal is an instanceOf the Swimmer Interface
	    if(animal instanceof Swimmer)
	    {
		    return true;
	    }
	    else
		    return false;
    }
}
