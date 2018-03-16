/**
 * File: MyMap.java
 * Author: Li Jingwei
 * Date: November 18, 2015
 * 
 * Description: This class implements the iMap interface.
 */

/**
 * This is the MyMap class of the program containing all the program code.
 * It instantiates the iMap interface.
 */
public class MyMap<K,V> implements iMap<K,V>
{
	private class Node
	{
		// Create the variables.
		V value;
		K key;
		Node next;
		
		Node(V val, K k, Node n)
		{
			value = val;
			key = k;
			next = n;
		}
	}
		
	// Define the node variables.
	private Node head = null;
	private Node tail = null;
		
	/**
	 * Look up the value associated with the key and return it.  If no value
	 * is associated with key, return null.
	 * Parameter: key : the key on which to search
	 */
	public V get( K key )
	{
		// Judge if the head node is null
		if ( head == null )
		{
			return null;
		}
		else 
		{
			// Define one variable to record the node.
			Node n = head;
			
			// Loop unless the keys are the same.
			while ( !(n.key.equals(key)) )
			{
				if ( n.next == null )
				{
					return null;
				}
				else 
				{
					n = n.next;
				}
			}
			
			// Return the value.
			return n.value;
		}
	}
	
	/**
	 * Add the (key,value) pair to the map and return the old value if
	 * one was associated with the key.
	 */
	public V put( K key, V val )
	{
		// Judge if the head node is null.
		if ( head == null )
		{
			// Add the pair into the empty map.
			head = new Node(val, key, null);
			tail = head;
			
			// Return the old value which is null.
			return null;
		}
		else 
		{
			Node n = head;
			
			while ( !(n.key.equals(key)) )
			{
				// Judge if Node n is the tail.
				if ( n.next == null )
				{
					// Add the pair to the tail.
					tail = new Node(val, key, null);
					n.next = tail;
					
					// Return the old value which is null.
					return null;
				}
				else 
				{
					n = n.next;
				}
			}
			
			// Define a variable to store the old value.
			V old = n.value;
			
			// Get the new value in the node.
			n.value = val;
			
			// Return the old value.
			return old;		
		}
	}
}
