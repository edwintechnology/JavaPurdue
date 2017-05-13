import java.util.*;

// NOTE: as in all of our classes, the type parameter is "T"
public class Graph<T>
{
  // NOTE: these are the graph's list of nodes and edges
  LinkedList<Node<T>> nodes;
  LinkedList<Edge<T>> edges;

  public Graph()
  {
    nodes = new LinkedList<Node<T>>();
    edges = new LinkedList<Edge<T>>();
  }

  // return the node that we've just created
  public Node<T> addNode(T newGuy)
  {
    /* TODO 7: make a new Node holding data of type T by using the "newGuy" data
     *  when calling the constructor.  Then add this node to the LinkedList of 
     *  nodes and return the node. */
     Node<T> newNode = new Node<T>(newGuy);
     nodes.add(newNode);
     return newNode;
  }

  public void addEdge(Node<T> first, Node<T> sec, int weight)
  {
    Edge<T> newGuy = new Edge<T>(first, sec, weight);
    edges.add(newGuy);
    first.adjList.add(newGuy);
  }

  public LinkedList<Edge<T>> minSpanning()
  {
    /* TODO 8: create a LinkedList holding LinkedLists which hold Nodes which 
     *  hold data of type T.  The name of the LinkedList is "modules". */
     LinkedList<LinkedList<Node<T>>> modules = new LinkedList<LinkedList<Node<T>>>();
    /* TODO 9: create two LinkedLists that hold Edges that hold data of type T.
     *  Name one "worklist" and the other one "soln".  worklist should initially
     *  contain all of the edges in the graph; check the LinkedList JavaDoc for
     *  a constructor that will help with this. */
     LinkedList<Edge<T>> worklist = new LinkedList<Edge<T>>(edges);
     LinkedList<Edge<T>> soln = new LinkedList<Edge<T>>();
    /*  Initialize the modules list so that each entry is a new LinkedList of 
     *  Nodes.  Each such list will contain exactly one Node from the list of
     *  nodes in the graph. */
    for (Node<T> n : nodes)
    {
      LinkedList<Node<T>> ll = new LinkedList<Node<T>>();
      ll.add(n);
      modules.add(ll);
    }

    /*  TODO 10: write a loop header that will loop as long as there are edges 
     *  in the worklist. */
    while (worklist.size() > 0)
    {
      Edge<T> cand = findMin(worklist);

      int found = 0;
      LinkedList<Node<T>> firstFound = null;

      /*  setup a for-each loop that iterates over the set of modules.
       *  The iteration variable should be of type "LinkedList<Node<T>>" and
       *  should be named "g". */
      for (LinkedList<Node<T>> g : modules)
      {
        int curFound = 0;
        if (g.contains(cand.source))
        {
          curFound++;
        }

        if (g.contains(cand.dest))
        {
          curFound++;
        }

        if (found == 0 && curFound > 0)
        {
          firstFound = g;
        }

        if (found + curFound == 2)
        {
          if (found == 1)
          {
            /* TODO 11: add "cand" to the list "soln", add all of the elements
             *  in "g" to the list "firstFound", and remove "g" from the list
             *  "modules". */
	     soln.add(cand);
	     firstFound.addAll(g);
	     modules.remove(g);
          }

          worklist.remove(cand);
          break;
        }

        found += curFound;
      }
    }

    return soln;
  }

  private Edge<T> findMin(LinkedList<Edge<T>> l)
  {
	  int newWeight;
	  Edge<T> lowest = l.getFirst();
	  int low = lowest.weight;
	  Edge<T> newEdge;
	  for(int i = 0; i < l.size(); i++)
	  {
		  newEdge = l.get(i);
		  newWeight = newEdge.weight;
		  if(newWeight < low)
		  {
			  lowest = newEdge;
		  }
	  }
	  return lowest;
    // TODO 12: find the edge with the smallest weight in a given list of edges

  }

  // no TODO's beyond this point in the file

  public int[] djikstra(Node<T> source)
  {
    if (source == null)
    {
      System.err.println("Djikstra's Algo: source is null");
      return null;
    }

    /* Initialize the adjacency array.  Each element in the array will be the
     *  distance from the source node to that node in the graph. */
    int[] res = new int[nodes.size()];

    for (int i = 0; i < nodes.size(); i++)
    {
      res[i] = -1;
    }

    res[nodes.indexOf(source)] = 0;

    /* Create a new worklist (called "worklist") that is a LinkedList
     *  containing Edges that contain data of type T.  Use the LinkedList 
     *  constructor that takes another LinkedList; pass into this constructor 
     *  the source's adjList. */
    LinkedList<Edge<T>> worklist = new LinkedList<Edge<T>>(source.adjList);

    /*  Setup the loop to loop while there are still edges in the 
     *  worklist. */
    while(!worklist.isEmpty())
    {
      Edge<T> min = findMin(worklist); // find the minimum edge in the worklist

      /*  sum the distance from the source node to the beginning of the edge
       *  with the weight of the edge */
      int minLen = res[nodes.indexOf(min.source)] + min.weight;

      // check if this is the shortest way to get to the node
      int update = nodes.indexOf(min.dest);

      // first check if we have not yet reached the node at the end of the edge
      if (res[update] == -1)
      {
        res[update] = minLen;
        worklist.addAll(min.dest.adjList);
      }
      else if (minLen < res[update])
      {
        res[update] = minLen;
      }

      // remove "min" from the worklist
      worklist.remove(min);
    }

    return res;
  }


  public boolean reachable(Node<T> s, Node<T> d)
  {
    /* determine if we can reach node d starting at node s.
     *  NOTE: You should make use of one of the other algorithms to implement
     *  this; a correct solution should not be much more than 3 lines. */

    return ((djikstra(s))[nodes.indexOf(d)] != -1);
  }

}
