/**
   File: iMap.java
   Author: Alex Brodsky
   Date: November 10, 2015
   Purpose: CSCI 1110, Assignment 8 Interface

   Description: This interface specifies Map ADT that students need to
                implement.
*/


/**
   This is the iQueue interface 
*/
public interface iMap<K,V> { 
  /* Looks up the value associated with the key and returns it.  If no value
     is associated with key, return null.
     Parameter: key : the key on which to search
     Returns: the value associated with the key or null
   */
  public V get( K key );

  /* Add the (key,value) pair to the map and returns the old value if
     one was associated with the key.
     Parameters: key: key assoicated with the value
                 value: to which the key maps
     Returns: old value associated with key or null if none was.
   */
  public V put( K key, V val );
}
