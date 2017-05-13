/*import java.util.*;
public class MyLinkedList
{
	private LinkedList<WordNode> list;
	private String word;
	private WordNode node;
	public MyLinkedList()
	{
		list = new LinkedList<WordNode>();
		word = null;
		node = null;
	}
	public MyLinkedList(WordNode newNode, String newWord)
	{
		word = newWord;
		node = newNode;
	}
	public void add(String word)
	{
		WordNode newNode = new WordNode(null, word);
		list.add(newNode);
	}
	public WordNode findItem(String item)
	{
		for(int i = 0; i < list.size(); i++){
			if(item.equalsIgnoreCase(list.get(i).getWord())){
				return list.get(i);
			}
		}
		return null;
	}
	public int size()
	{
		return list.size();
	}
	public WordNode get(int index)
	{
		if(index < list.size()){
			return list.get(index);
		}
		else{
			return null;
		}
	}
	// public WordNode getHead()
}*/

import java.util.*;

public class MyLinkedList
{
	private LinkedList<WordNode> list;

	public MyLinkedList(){
		list = new LinkedList<WordNode>();
	}

	//insert an item into the list alphabetically
	public void add(String word){
		WordNode newNode = new WordNode(null, word);
		list.add(newNode);
		java.util.Collections.sort(list);
	}

	//find the node containing the appropriate item in the list
	public WordNode findItem(String item){
		for(int i = 0; i < list.size(); i++){
			if(item.equalsIgnoreCase(list.get(i).getWord())){
				return list.get(i);
			}
		}
		return null;
	}

	//return the number of elements in the list
	public int size(){
		return list.size();
	}

	//get the node at the specified index.  If there is no element, return null
	public WordNode get(int index){
		if(index < list.size()){
			return list.get(index);
		}
		else{
			return null;
		}
	}

	//get the first element of the list.  Return null if there are no elements in the list yet
	public WordNode getHead(){
		if(list.size() == 0){
			return null;
		}
		else{
			return list.get(0);
		}
	}
}
