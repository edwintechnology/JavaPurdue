import java.util.Scanner;

public class CubeExample
{
    public static void main(String args[])
    {
        // this is how we make a new cube
        Cube c = new Cube();

        System.out.println("\nInitial cube (solved):");
        // this is how we print out the state of a cube
        c.print();

        promptAndPause();

        // if we want to turn the cube Right (Rt) we simply call Rt()
        c.Rt();

        System.out.println("Cube after a Right turn (Rt):");
        // to see the effects of this move, we print the cube out
        c.print();

        promptAndPause();

        // to undo a move, we simply call the inverse
        // in this case it is Right Inverse (Rti)
        c.Rti();

        System.out.println("Cube after  Right Inverse turn (Rti):");
        // to check that we're back to the start position we can print
        c.print();
        System.out.println("Notice that cube is solved once again.");
            
        promptAndPause();

        // or we can create a new cube (which is initially solved)
        Cube solved = new Cube();
        // and then compare our own cube with the solved cube
        if(c.equals(solved))
        {
            System.out.println("c is equal to solved");
        }
        else
        {
            System.out.println("c is not equal to solved");
        }

        promptAndPause();

        // to see a case where they are not equal, we can:
        c.Lt(); // turn c left
        if(c.equals(solved))
        {
            System.out.println("c is equal to solved");
        }
        else
        {
            System.out.println("c is not equal to solved");

            System.out.println("c:\n");
            c.print();

            System.out.println("solved:\n");
            solved.print();
        }

        // undo the Lt() turn
        c.Lti();

        promptAndPause();

        // now let's scramble the cube with a sequence of moves
        c.Lt();
        c.Rt();
        c.Tp();
        c.Rt();
        c.Tp();
        c.Lt();

        System.out.println("State of the cube after: Lt Rt Tp Rt Tp Lt");
        c.print();

        promptAndPause();

        // now let's unscrable the cube USING THE INVERSE OF EACH
        // MOVE IN THE REVERSE ORDER
        c.Lti();
        c.Tpi();
        c.Rti();
        c.Tpi();
        c.Rti();
        c.Lti();

        System.out.println("Cube solved again after: Lti Tpi Rti Tpi Rti Lti");
        c.print();

        promptAndPause();

        // So we would say that the scrambling
        //
        //    Lt Rt Tp Rt Tp Lt
        //
        // has the solution
        //
        //    Lti Tpi Rti Tpi Rti Lti
        // 
        // Your job in this lab will be to find the solution
        // for a cube when you do not know the scrambling! 
        
        System.out.println( 
        "So we would say that the scrambling\n" +
        "\n" +
        "    Lt Rt Tp Rt Tp Lt\n" +
        "\n" +
        "has the solution\n" +
        "\n" +
        "    Lti Tpi Rti Tpi Rti Lti\n" +
        "\n" +
        "Your job in this lab will be to find the solution\n" +
        "for a cube when you do not know the scrambling!\n"); 
    }

    public static void promptAndPause()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\nPress Enter.\n");
        in.nextLine();
    }

}
