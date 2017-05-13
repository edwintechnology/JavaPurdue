public class Forest extends Environment // class Forest extends Environment
{
    public static double MIN_FOLIAGE = 30; // specs for the Forest's environment
    public static double MAX_FOLIAGE = 80;
    public static double MIN_WATER =   30;
    public static double MAX_WATER =   50;

    public Forest( double newMinFoliage, double newMaxFoliage, double newMinWater, double newMaxWater, int newPollution ) throws RangeMismatchException
    { // constructor using the defined vars from the parent class.. and initializing the following variables 
        super( newMinFoliage, newMaxFoliage, newMinWater, newMaxWater, newPollution );
    }
    // overriding the methods from the parent class 
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
    { // returns the name of this Environment to name of Class
	    return "Forest";
    }
    public boolean canAccept( Animal animal )
    { // checks to see if the instances animal is an instanceof the Crawler Class
	    if(animal instanceof Crawler)
	    {
		    return true;
	    }
	    else
		    return false;
    }

}

