import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Lab10
{
  public static void main(String[] argv)
  {
    /*  TODO 13: One possible use of a graph is to let every node hold the name 
     *  of a city.  Then, each edge can represent a one-way road from one city 
     *  to another and the weight of the edge can represent the length of the 
     *  road.
     *
     *  Instantiate a Graph object that holds data of type String.  Let the 
     *  object be called "gi". */
     Graph<String> gi = new Graph<String>();

    Vector<Node<String>> nodes = new Vector<Node<String>>();
    Node<String> tmp;
    tmp = gi.addNode("New York");
    nodes.add(tmp);
    tmp = gi.addNode("Chicago");
    nodes.add(tmp);
    tmp = gi.addNode("Los Angeles");
    nodes.add(tmp);
    tmp = gi.addNode("Seattle");
    nodes.add(tmp);
    tmp = gi.addNode("Dallas");
    nodes.add(tmp);

    gi.addEdge(nodes.get(0), nodes.get(1), 50);
    gi.addEdge(nodes.get(0), nodes.get(4), 75);
    gi.addEdge(nodes.get(1), nodes.get(4), 30);
    gi.addEdge(nodes.get(1), nodes.get(3), 70);
    gi.addEdge(nodes.get(4), nodes.get(2), 60);
    gi.addEdge(nodes.get(2), nodes.get(3), 25);


    LinkedList<Edge<String>> res2 = gi.minSpanning();

    System.out.println("The minimum spanning tree of all of the cities: ");

    for (Edge<String> it : res2)
    {
      System.out.println("\t" + it);
    }

    int[] res = gi.djikstra(nodes.get(1));
    System.out.println("Distances from Chicago to: ");
    for (int i = 0; i < res.length; i++)
    {
      System.out.println("\t" + nodes.get(i) + ": " + res[i]);
    }

    System.out.println("Cities reachable from Chicago:");

    for (int i = 0; i < nodes.size(); i++)
    {
      System.out.println("\t" + nodes.get(i) + ": " 
        + gi.reachable(nodes.get(1), nodes.get(i)));
    }
  }
}
