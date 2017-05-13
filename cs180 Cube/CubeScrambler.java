import java.util.Random;

public class CubeScrambler
{
    public static String scrambleStr = "";
        
    public static void scramble(Cube c, int n)
    {
        Random rand = new Random();

        for(int i=0; i<n; i++)
        {
            switch(rand.nextInt(3))
            {
                case 0:
                    scrambleStr += " Ft ";
                    c.Ft();
                    break;

                case 1:
                    scrambleStr += " Rt ";
                    c.Rt();
                    break;

                case 2:
                    scrambleStr += " Lt ";
                    c.Lt();
                    break;
            }
        }
    }

    public static String getScramble()
    {
        return scrambleStr;
    }
}
