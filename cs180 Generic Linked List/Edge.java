// TODO 5: Declare a class Edge that takes a type parameter named "T".
public class Edge<T>
{
  /* TODO 6: Declare fields "source" and "dest" that are Nodes holding data of
   *  type T. */
   Node<T> source;
   Node<T> dest;

   int weight;

  public Edge(Node<T> first, Node<T> sec, int weight)
  {
    source = first;
    dest = sec;
    this.weight = weight;
  }

  public String toString()
  {
    return source + "->" + "(" + weight + ")" + dest;
  }
}

