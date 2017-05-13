import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        IntVector v = new IntVector();
        System.out.println("Empty v size:  " + v.size());
        System.out.println("Empty v capcity:  " + v.capacity());
        System.out.println();
        System.out.println("Adding 11 random elements:");
        for (int i = 0; i < 11; i++)
        {
            int randNum = rand.nextInt(100);
            System.out.println("Element " + i + ":  " + randNum);
            v.add(randNum);
        }
        printVector(v);
        System.out.println();
        System.out.println("Adding 7777 at the 5th position:");
        v.addAt(5, 7777);
        printVector(v);
        System.out.println();
        System.out.println("Removing 7777:");
        v.remove(7777);
        printVector(v);
    }
    public static void printVector(IntVector v)
    {
        System.out.println("Vector:  " + v.toString() + "  Capacity:  " + v.capacity() + "  Size:  " + v.size());
    }
}
