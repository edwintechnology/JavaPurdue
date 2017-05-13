public interface EnvironmentControl // interface with methods =] //
	{
		public double getMinPossibleFoliage();
		public double getMaxPossibleFoliage();
		public double getMinFoliage();
		public double getMaxFoliage();
		public double getCurrentFoliage();
		public void setCurrentFoliage( double newFoliage ) throws ValueOutOfRangeException;

		public double getMinPossibleWater();
		public double getMaxPossibleWater();
		public double getMinWater();
		public double getMaxWater();
		public double getCurrentWater();
		public void setCurrentWater( double newWater ) throws ValueOutOfRangeException;

		public boolean canAccept( Animal animal );
	}
