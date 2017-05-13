import java.util.LinkedList;

// TODO 1: Declare a class Node that takes a type parameter named "T".
public class Node<T>
{
  /* TODO 2: Declare a field named "data" of type T and a field named "adjList" 
   *  that is a LinkedList that holds entries of type Edge<T>. */
   T data;
   LinkedList<Edge<T>> adjList;

  // TODO 3: Write the header of a constructor that takes a parameter of type T.
  public Node(T data)
  {
    /* TODO 4: Set "data" equal to the parameter and initialize "adjList" to a 
     *  new LinkedList.  Be sure to fully specify the type of the list using
     *  generics.  */
     this.data = data;
     adjList = new LinkedList<Edge<T>>();
  }

  public boolean equals(Node<T> other)
  {
    return this == other;
  }

  public String toString()
  {
    return "(" + data + ")";
  }
}
