/** 	SortedListModel .. Compliments to.. 
	http://www.jguru.com/faq/view.jsp?EID=15245
	with my own added section in TreeSort(String.CASE_INSENSITIVE_ORDER)*/
import javax.swing.*;
import java.util.*;

public class SortedListModel extends AbstractListModel {

	private static final long serialVersionUID = 1L;
// Define a SortedSet
  SortedSet<Object> model;

  @SuppressWarnings("unchecked")
public SortedListModel() {
    // Create a TreeSet
    // Store it in SortedSet variable
    model = new TreeSet(String.CASE_INSENSITIVE_ORDER);
  }

  // ListModel methods
  public int getSize() {
    // Return the model size
    return model.size();
  }

  public Object getElementAt(int index) {
    // Return the appropriate element
    return model.toArray()[index];
  }

  // Other methods
  public void add(Object element) {
    if (model.add(element)) {
      fireContentsChanged(this, 0, getSize());
    }
  }

  public void addAll(Object elements[]) {
    Collection<Object> c = Arrays.asList(elements);
    model.addAll(c);
    fireContentsChanged(this, 0, getSize());
  }

  public void clear() {
    model.clear();
    fireContentsChanged(this, 0, getSize());
  }

  public boolean contains(Object element) {
    return model.contains(element);
  }

  public Object firstElement() {
    // Return the appropriate element
    return model.first();
  }

  public Iterator<Object> iterator() {
    return model.iterator();
  }

  public Object lastElement() {
    // Return the appropriate element
    return model.last();
  }

  public boolean removeElement(Object element) {
    boolean removed = model.remove(element);
    if (removed) {
      fireContentsChanged(this, 0, getSize());
    }
    return removed;   
  }
}

