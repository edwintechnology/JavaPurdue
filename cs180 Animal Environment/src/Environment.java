public class Environment implements EnvironmentControl
{
	// impressive amount of variables used in each of the environments
	@SuppressWarnings("unused")
	private double newMinFoliage;
	@SuppressWarnings("unused")
	private double newMaxFoliage;
	@SuppressWarnings("unused")
	private double newMinWater;
	@SuppressWarnings("unused")
	private double newMaxWater;
	private int newPollution;
	
	private double minPossibleFoliage;
	private double maxPossibleFoliage;
	private double minFoliage;
	private double maxFoliage;
	private double currentFoliage;
	private double minPossibleWater;
	private double maxPossibleWater;
	private double minWater;
	private double maxWater;
	private double currentWater;
	@SuppressWarnings("unused")
	private int environmentCount = 0;
	Animal[] animalList = new Animal[20];
	Environment[] environmentArray = new Environment[4];
	private String animalName = "";
	private double distributeWater = 0;
	private double distributeFoliage = 0;
	private double distributeMeat = 0;
	private int animalCount;
	
	public Environment(double newMinFoliage, double newMaxFoliage, double newMinWater, double newMaxWater, int newPollution) throws RangeMismatchException
	{ // constructor defining what variables are passed to thro this class
		if(maxFoliage < minFoliage)
			throw new RangeMismatchException("Mismatch");
	}
	// series of methods from the EnvironmentControl class
	public double getMinPossibleFoliage()
	{
		return minPossibleFoliage;
	}
	public double getMaxPossibleFoliage()
	{
		return maxPossibleFoliage;
	}
	public double getMinFoliage()
	{
		return minFoliage;
	}
	public double getMaxFoliage()
	{
		return maxFoliage;
	}	
	public double getCurrentFoliage()
	{
		return currentFoliage;
	}
	public void setCurrentFoliage( double newFoliage ) throws ValueOutOfRangeException
	{
		if(this.minFoliage < minFoliage || this.maxFoliage < maxFoliage) // checks to see if current is less then current in the environment called
		{
			throw new ValueOutOfRangeException(); // then this is thrown
		}
		this.currentFoliage = ((minFoliage + maxFoliage) / 2); 
	}
	public double getMinPossibleWater()
	{
		return minPossibleWater;
	}
	public double getMaxPossibleWater()
	{
		return maxPossibleWater;
	}
	public double getMinWater()
	{
		return minWater;
	}
	public double getMaxWater()
	{
		return maxWater;
	}
	public double getCurrentWater()
	{
		return currentWater;
	}
	public void setCurrentWater( double newWater ) throws ValueOutOfRangeException
	{
		if(this.minWater < minWater || this.maxWater < maxWater) // checks to see if current is less then current in the environment called
		{
			throw new ValueOutOfRangeException(); // if not the this is thrown
		}
		this.currentWater = ((minWater + maxWater) / 2);
	}
	public boolean canAccept(Animal animal)
	{
		return true;
	}
	// Parsing the Environment
	public static Environment parseEnvironment( String envString ) throws InvalidDataException, RangeMismatchException, PropertyFormatException, RangeBoundException  // String envString looks something like this new Environment(Wetlands,0,0,0,0,0)
	{
		String[] envArray = envString.split(","); // split command finds where the commas are and makes "tokens"
		envArray[5] = envArray[5].trim(); // trims around the number in the 5th index of the array\
		
		try // try block catches an exception NumberFormatException ... i hear its bad practice //
		{
		for(int i = 1; i < envArray.length; i++)
		{
			Double.parseDouble(envArray[i]);
		}
		}
		catch(NumberFormatException NFE) // if this expection is caught
		{
			throw new PropertyFormatException();// then this one is thrown
		}
		if(Double.parseDouble(envArray[1]) > Double.parseDouble(envArray[2]) || Double.parseDouble(envArray[3]) > Double.parseDouble(envArray[4])) // checks to see if min is more then max 
		{	
			throw new RangeMismatchException(); // if it is .. then it throws this exception
		}
		else
		{
			if(envArray[0].equalsIgnoreCase("Forest"))
			{ // if the index 0 is forest then create a new forest environment
				if(Forest.MIN_FOLIAGE > Double.parseDouble(envArray[1]) || Forest.MAX_FOLIAGE < Double.parseDouble(envArray[2]) || Forest.MIN_WATER > Double.parseDouble(envArray[3]) || Forest.MAX_WATER < Double.parseDouble(envArray[4]))
				{ // checks the bounds for the class in each class file
					throw new RangeBoundException(); // if it is out of bounds. it throws this.
				}
				return new Forest(Double.parseDouble(envArray[1]), Double.parseDouble(envArray[2]), Double.parseDouble(envArray[3]), Double.parseDouble(envArray[4]), Integer.parseInt(envArray[5]));
			}
			else if(envArray[0].equalsIgnoreCase("Grassland"))
			{ // if the index 0 is Grassland, then create a new Grassland environment
				if(Grassland.MIN_FOLIAGE > Double.parseDouble(envArray[1]) || Grassland.MAX_FOLIAGE < Double.parseDouble(envArray[2]) || Grassland.MIN_WATER > Double.parseDouble(envArray[3]) || Grassland.MAX_WATER < Double.parseDouble(envArray[4]))
				{
					throw new RangeBoundException();
				}
				return new Grassland(Double.parseDouble(envArray[1]), Double.parseDouble(envArray[2]), Double.parseDouble(envArray[3]), Double.parseDouble(envArray[4]), Integer.parseInt(envArray[5]));
			}
			else if(envArray[0].equalsIgnoreCase("Ocean"))
			{ // if the index 0 is Ocean then create a new Ocean environment
				if(Ocean.MIN_FOLIAGE > Double.parseDouble(envArray[1]) || Ocean.MAX_FOLIAGE < Double.parseDouble(envArray[2]) || Ocean.MIN_WATER > Double.parseDouble(envArray[3]) || Ocean.MAX_WATER < Double.parseDouble(envArray[4]))
				{
					throw new RangeBoundException();
				}
				return new Ocean(Double.parseDouble(envArray[1]), Double.parseDouble(envArray[2]), Double.parseDouble(envArray[3]), Double.parseDouble(envArray[4]), Integer.parseInt(envArray[5]));
			}
			else if(envArray[0].equalsIgnoreCase("Wetland"))
			{ // if the index is Wetland, then create a new Wetland environment
				if(Wetland.MIN_FOLIAGE > Double.parseDouble(envArray[1]) || Wetland.MAX_FOLIAGE < Double.parseDouble(envArray[2]) || Wetland.MIN_WATER > Double.parseDouble(envArray[3]) || Wetland.MAX_WATER < Double.parseDouble(envArray[4]))
				{
					throw new RangeBoundException();
				}
				return new Wetland(Double.parseDouble(envArray[1]), Double.parseDouble(envArray[2]), Double.parseDouble(envArray[3]), Double.parseDouble(envArray[4]), Integer.parseInt(envArray[5]));
			}
			else
			{
				throw new InvalidDataException(); // if the object is not correct then this is thrown
			}
		}
	}
	public void addNeighbor( Environment neighbor ) 
	{
		for(int i = 0; i < environmentArray.length; i++)
		{
			environmentArray[i] = neighbor; // each spot in the array pending on the environment count it is set to a neighbor
		}
	}
	public int getAnimalCount() 
	{
		 animalCount = 0; // sets animalCount to 0
		 for(int i = 0; i < animalList.length; i++)
		 {
			 if(animalList[i] != null) // then if its not null it adds a counter to it
			 {
				 animalCount++;
			 }
		 }
		 return animalCount;
	}
	public void accept( Animal animal )
	{
		for(int i = 0; i < animalList.length; i++)
		{
			if(animalList[i] == null) // if there is a null 
			{
				animalList[i] = animal; // adds  animal that position
				break;
			}
		}
	}
	public void update() 
	{
		distributeWater();
		distributeFoliage();
		distributeMeat();
	}
	public double distributeWater()
	{
		double waterRequirements = 0;
		double sumOfWaterRequirements = 0;
		/*available = Current Water - pollution - ? water requirements of Animals in region*/
		for(int i = 0; i < animalList.length; i++)
		{
			if(animalList[i] == null)
			{
				continue;
			}
			waterRequirements = animalList[i].waterRequired(); // adds each water together
			sumOfWaterRequirements += waterRequirements;
		}
		distributeWater = currentWater - newPollution - sumOfWaterRequirements;	 //  water is = to current water and pollution and sum of all water
		if(distributeWater < 0)
		{
			for(int j = 0; j < animalList.length; j++)
			{
				for(int i = 0; i < environmentArray.length; i++)
				{
					if((environmentArray[i] == null) || (animalList[j] == null))
					{
						continue;
					}
					animalList[j].thirsty++; // adds one to thirsty
					if(animalList[j].thirsty == 2)
					{
						animalList[j] = null; // if too thirsty then it is removed
					}
					if(environmentArray[i].canAccept(animalList[j]));
					{
						environmentArray[i].accept(animalList[j]);
						animalList[j] = null;
						animalCount--;
					}
				}
			}
			currentWater = (currentWater + distributeWater * (1 - currentWater/ maxWater));
		}
		return distributeWater;
	}
	public double distributeFoliage()
	{
		double foliageRequirements = 0;
		double sumOfFoliageRequirements = 0;
		// available = Current foliage - pollution - ? foliage requirements of Animals in region 
		for(int i = 0; i < animalList.length; i++)
		{
			if(animalList[i] == null)
			{
				continue;
			}
			foliageRequirements = animalList[i].foliageRequired(); // adds all the foliage together
			sumOfFoliageRequirements += foliageRequirements;
		}
		distributeFoliage = currentFoliage - newPollution - sumOfFoliageRequirements; //  distribute Foliage is set by the current foliage with the pollution and the sum of all foliage
		if(distributeFoliage < 0)
		{
			for(int i = 0; i < animalList.length; i++)
			{
				for(int j = 0; j < environmentArray.length; j++)
				{
					if((environmentArray[j] == null) || (animalList[i] == null))
					{
						continue;
					}
					animalList[i].hunger++; // adds one to hunger
					if(animalList[i].hunger == 2)
					{
						animalList[i] = null; // removes animal if hungry for 2 ticks
					}
					if(environmentArray[j].canAccept(animalList[i]));
					{
						environmentArray[j].accept(animalList[i]);
						animalList[i] = null;
						animalCount--;
					}
				}
			}
			currentFoliage = (currentFoliage + distributeFoliage * (1 - currentFoliage/ maxFoliage));;
		}
		return distributeFoliage;
	}
	public double distributeMeat()
	{
		double sumOfMeatValue = 0;
		double meatValueReq = 0;
		double sumOfMeatRequired = 0;
		double meatRequirements = 0;
		// available = (? Meat value of Animals in region as specified in the table)- pollution - ? meat requirements of Animals in region.
		for(int i = 0; i < animalList.length; i++)
		{
			if(animalList[i] == null)
			{
				continue;
			}
			meatRequirements = animalList[i].meatRequired(); // adds all the meat requirements together 
			sumOfMeatRequired += meatRequirements;
		}
		for(int j = 0; j < animalList.length; j++)
		{
			if(animalList[j] == null)
			{
				continue;
			}
			meatValueReq = animalList[j].meatValue();
			sumOfMeatValue += meatValueReq;
		}
		distributeMeat = sumOfMeatValue - newPollution - sumOfMeatRequired; // sets distributeMeat to the sum of meats minus pollution and the sum of meat required
		if(distributeMeat < 0)
		{
			for(int i = 0; i < animalList.length; i++)
			{
				for(int j = 0; j < environmentArray.length; j++)
				{
					if((environmentArray[j] == null) || (animalList[i] == null))
					{
						continue;
					}
					animalList[i].hunger++; // adds hunger 
					if(animalList[i].hunger == 2)
					{
						animalList[i] = null; // removes if its too hungry
					}
					if(environmentArray[j].canAccept(animalList[i]));
					{
						environmentArray[j].accept(animalList[i]);
						animalList[i] = null;
						animalCount--;
					}
				}
			}
		}
		
		return distributeMeat;
	}
	public String getReport() // adds name to a string list and prints them out.
	{
		for(int i = 0; i < animalList.length; i++)
		{
			if(animalList[i] == null)
			{
				continue;
			}
			animalName += "" + animalList[i] + "\n\t";
		}
		return this.toString() + " Contents \n\t" + animalName;
	}
}
