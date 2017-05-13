import java.util.*;

public class EnvironmentSimulator
{
    private Environment[] world;
    private int width;
    private int height;

    public void simulateTime()
    {
        for ( Environment cell : world )
        {
            cell.update();
        }
    }

    public void report()
    {
        for ( int col = 0; col < width; ++col )
        {
            for ( int row = 0; row < height; ++row )
            {
                if ( world[envIndex(col,row)].getAnimalCount() > 0 )
                {
                    System.out.println( "Cell " + col + "," + row
                            + " " + world[envIndex(col,row)].getReport() );
                }
            }
        }
    }

    public void fill( int width, int height,
        List<Record<String>> environmentData,
        List<Record<Animal>> animalData )
            throws RangeMismatchException, RangeBoundException,
                PropertyFormatException, InvalidDataException
    {
        setLand( width, height, environmentData );
        setAnimals( animalData );
    }

    private void setAnimals( List<Record<Animal>> animalData )
        throws InvalidDataException, PropertyFormatException
    {
        for ( Record<Animal> rec : animalData )
        {
            Animal a  = rec.getData();
            int index = envIndex( rec.getX(), rec.getY() );
            if ( !world[index].canAccept( a ) )
            {
                throw new InvalidDataException
                    ("Can't put " + a + " in " + world[index] );
            }
            world[index].accept( a );
        }
    }

    private void setLand( int width, int height,
        List<Record<String>> environmentData )
            throws RangeMismatchException, RangeBoundException,
                    PropertyFormatException, InvalidDataException
    {
        this.width = width;
        this.height = height;
        world = new Environment[width*height];

        for ( Record<String> rec : environmentData )
        {
            String env   = rec.getData();
            int index    = envIndex( rec.getX(), rec.getY() );
            world[index] = Environment.parseEnvironment( env );
        }
        for ( int col = 0; col < width; ++col )
        {
            for ( int row = 0; row < height; ++row )
            {
                setNeighbors( col, row );
            }
        }
    }

    private void setNeighbors( int col, int row )
    {
        int current = envIndex( col, row );
        if ( row - 1 >= 0 )
            world[current].addNeighbor( world[envIndex(col,row-1)] );
        if ( col + 1 < width )
            world[current].addNeighbor( world[envIndex(col+1,row)] );
        if ( row + 1 < height )
            world[current].addNeighbor( world[envIndex(col,row+1)] );
        if ( col - 1 >= 0 )
            world[current].addNeighbor( world[envIndex(col-1,row)] );
    }

    private int envIndex( int col, int row )
    {
        return col*height + row;
    }
}
