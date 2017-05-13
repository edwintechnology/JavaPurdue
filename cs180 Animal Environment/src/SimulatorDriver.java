import java.util.*;

public class SimulatorDriver
{
    @SuppressWarnings("unused")
	private final static int MAX_TEST = 2;

    private final static String TEST_GRASS = "GrASsLand,15,30,30,35,3";
    private final static String TEST_WET = "WeTLand,45,65,65,75,53";
    private final static String TEST_FOR = "ForeSt,35,65,40,45,22";
    private final static String TEST_OCE = "oCeAn,35,55,100,100,66";

    public void simulate( int testNum )
    {
        try
        {
            switch ( testNum )
            {
                case 0: runMilestone();     break;
                case 1: basicTest();        break;
                case 2: exceptionChecker();    break;
            }
        }
        catch ( Exception e )
        {   // It is generally *bad* practice to catch "Exception."
            // Do not do this at home, we are trained professionals.
            e.printStackTrace();
            System.out.println( "\n\nDid not pass test" );
        }
    }

    private void basicTest()
    {
        List<Record<String>> env = new LinkedList<Record<String>>();
        env.add( new Record<String>( 0,0, TEST_GRASS ) );
        env.add( new Record<String>( 0,1, TEST_WET ) );
        env.add( new Record<String>( 1,0, TEST_FOR ) );
        env.add( new Record<String>( 1,1, TEST_OCE ) );
        List<Record<Animal>> animal = new LinkedList<Record<Animal>>();
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Surgeonfish() ) );
        animal.add(  new Record<Animal>( 1,1,new Salmon() ) );
        animal.add(  new Record<Animal>( 1,1,new Salmon() ) );
        animal.add(  new Record<Animal>( 0,0,new Elephant() ) );
        animal.add(  new Record<Animal>( 0,0,new Elephant() ) );
        animal.add(  new Record<Animal>( 0,1,new Seal() ) );
        animal.add(  new Record<Animal>( 0,1,new Elephant() ) );
        runEnvironment( 2,2,env,animal );
    }
    private void exceptionChecker()
    {
        try
        {
            String envName =
                "At first I was afraid; I was petrified, 30, 40, 50, 60, 70";
            @SuppressWarnings("unused")
			Environment e = Environment.parseEnvironment( envName );
            System.out.println
                ( "Test failed: should throw InvalidDataException" );
        }
        catch( InvalidDataException ide )
        {
            System.out.println( "Test passed!" );
        }
        catch ( Exception e )
        {
            System.out.println( "Test failed, "+e+" thrown." );
        }
    }
    private void runEnvironment( int width, int height,
        List<Record<String>> env, List<Record<Animal>> animals )
    {
        try
        {
            EnvironmentSimulator es = new EnvironmentSimulator();
            es.fill( width, height, env, animals );
            System.out.println( "Starting as:" );
            es.report();
            Scanner keyboard = new Scanner( System.in );
            do
            {
                es.simulateTime();
                System.out.println( "\nRound finished:" );
                es.report();
                System.out.println( "Run another round? y/n" );
            }
            while( keyboard.next().toLowerCase().charAt(0) == 'y' );
        }
        catch( Exception e )
        {
            System.out.println( "Error encountered! ! !" );
            e.printStackTrace();
        }
    }
    private void runMilestone()
        throws RangeBoundException, RangeMismatchException,
            PropertyFormatException, InvalidDataException
    {   // 5 Points for compilation with this test.
        // This examines your inheritance hierarchy.
        // If you examine the assignments, you can derive an appropriate
        // hierarchy.
        System.out.println( "\nExamining inheritance hierarchy" );
        Environment grassland = new Grassland(10,40,20,40,0);
        Environment wetland = new Wetland(40,70,60,80,100);
        Environment forest = new Forest(30,80,30,50,100);
        Environment ocean = new Ocean(30,60,100,100,0);

        Mammal elephant = new Elephant();
        Mammal lion = new Lion();
        Mammal seal = new Seal();
        Fish salmon = new Salmon();
        Fish surgeon = new Surgeonfish();
        @SuppressWarnings("unused")
		Animal animal1 = elephant;
        @SuppressWarnings("unused")
		Animal animal2 = salmon;
        Crawler crawl1 = elephant;
        Swimmer swim1 = salmon;
        @SuppressWarnings("unused")
		Swimmer swim2 = new Seal();
        // Swim swim3 = seal; // This *must cause* a compilation error!
        // Crawl crawl2 = salmon; // Likewise, this fails to compile!
        // The next two lines can check this during runtime
        System.out.print( !Swimmer.class.isAssignableFrom( Mammal.class ) );
        System.out.println( !Crawler.class.isAssignableFrom( Fish.class ) );

        // 5 Points for correct polymorphic functionality
        System.out.println( "\n==========\nExamining Animal behavior" );
        System.out.print( elephant.hasNeocortex() );
        System.out.println( !salmon.hasNeocortex() );
        swim1.swim();
        crawl1.crawl();
        System.out.print( elephant + "\t" );
        System.out.print(   5   == elephant.waterRequired() );
        System.out.print(  20   == elephant.foliageRequired() );
        System.out.print(   0   == elephant.meatRequired() );
        System.out.println(20   == elephant.meatValue() );
        System.out.print( lion + "\t\t" );
        System.out.print(   5   == lion.waterRequired() );
        System.out.print(   0   == lion.foliageRequired() );
        System.out.print(  10   == lion.meatRequired() );
        System.out.println( 5   == lion.meatValue() );
        System.out.print( seal + "\t\t" );
        System.out.print(  30   == seal.waterRequired() );
        System.out.print(  20   == seal.foliageRequired() );
        System.out.print(   5   == seal.meatRequired() );
        System.out.println( 2.5 == seal.meatValue() );
        System.out.print( surgeon + "\t" );
        System.out.print(  10   == surgeon.waterRequired() );
        System.out.print(  10   == surgeon.foliageRequired() );
        System.out.print(   0   == surgeon.meatRequired() );
        System.out.println( 2.5 == surgeon.meatValue() );
        System.out.print( salmon + "\t\t" );
        System.out.print(  15   == salmon.waterRequired() );
        System.out.print(   0   == salmon.foliageRequired() );
        System.out.print(   5   == salmon.meatRequired() );
        System.out.println( 2.5 == salmon.meatValue() );

        System.out.println( "\nExamining Environment behavior" );
        System.out.print( grassland + "\t" );
        System.out.print(   10 == grassland.getMinPossibleFoliage() );
        System.out.print(   40 == grassland.getMaxPossibleFoliage() );
        System.out.print(   20 == grassland.getMinPossibleWater() );
        System.out.println( 40 == grassland.getMaxPossibleWater() );
        System.out.print( wetland + "\t\t" );
        System.out.print(   40 == wetland.getMinPossibleFoliage() );
        System.out.print(   70 == wetland.getMaxPossibleFoliage() );
        System.out.print(   60 == wetland.getMinPossibleWater() );
        System.out.println( 80 == wetland.getMaxPossibleWater() );
        System.out.print( forest + "\t\t" );
        System.out.print(   30 == forest.getMinPossibleFoliage() );
        System.out.print(   80 == forest.getMaxPossibleFoliage() );
        System.out.print(   30 == forest.getMinPossibleWater() );
        System.out.println( 50 == forest.getMaxPossibleWater() );
        System.out.print( ocean + "\t\t" );
        System.out.print(   30 == ocean.getMinPossibleFoliage() );
        System.out.print(   60 == ocean.getMaxPossibleFoliage() );
        System.out.print(  100 == ocean.getMinPossibleWater() );
        System.out.println(100 == ocean.getMaxPossibleWater() );

        // 5 Points for relationships between classes and Object parsing
        System.out.println( "\n==============\nMore advanced testing" );
        System.out.print( forest.canAccept( seal ) );
        System.out.print( ocean.canAccept( seal ) );
        System.out.print( forest.canAccept( elephant ) );
        System.out.print( !ocean.canAccept( elephant ) );
        System.out.print( !forest.canAccept( salmon ) );
        System.out.println( ocean.canAccept( salmon ) );

        System.out.print( Environment.parseEnvironment( TEST_GRASS ) instanceof Grassland );
        System.out.print( Environment.parseEnvironment( TEST_WET ) instanceof Wetland );
        System.out.print( Environment.parseEnvironment( TEST_FOR ) instanceof Forest );
        System.out.print( Environment.parseEnvironment( TEST_OCE ) instanceof Ocean );
    }
    public static void main( String[] args )
    {
        SimulatorDriver driver = new SimulatorDriver();
        driver.simulate( Integer.parseInt( args[0] ) );
    }
}
