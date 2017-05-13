public class Animal implements AnimalControl // implements the interface AnimalControl to include the methods below //
{	
	protected double waterRequired;
	protected double foliageRequired;
	protected double meatRequired;
	protected double meatValue;
	protected boolean hasNeocortex;
	protected int hunger = 0;
	protected int thirsty = 0;
	
	public Animal(double waterRequired, double foliageRequired, double meatRequired, double meatValue, boolean hasNeocortex)
	{
		this.waterRequired = waterRequired;     // sets variables from above
		this.foliageRequired = foliageRequired; // to the variables 
		this.meatRequired = meatRequired;       // from each class
		this.meatValue = meatValue;
		this.hasNeocortex = hasNeocortex;
	}
	public double waterRequired() // methods from interface
	{ 
		return waterRequired;
	}
	public double foliageRequired() 
	{ 
		return foliageRequired; 
	}
	public double meatRequired() 
	{ 
		return meatRequired; 
	}
	public double meatValue() 
	{ 
		return meatValue; 
	}
	public boolean hasNeocortex() 
	{ 
		return hasNeocortex;
	}
}