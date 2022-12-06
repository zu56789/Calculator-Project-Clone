package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;


/** 
 * this program represents a stack data structure using an arraylist.

 * @author Zuhayr
 */
public class Stack {

  private int size = 0;
  private ArrayList<Entry> entries = new ArrayList<Entry>();

  /**
   * this method returns the size of the stack.

   * @return returns the size of the stack.
   */
  public int size() {
    return size;
  }

  /**
   * this method adds a new value to the stack.

   * @param i the value to add.
   */
  public void push(Entry i) {
    entries.add(i);
    size += 1; // size increases by one because value is added

  }

  /**
   * this method removes the value at the top of the stack and returns it.

   * @return returns the removed value in the stack.
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException(); // throw an exception if the stack is empty
    }
    size -= 1; // size decreases when a value is popped
    Entry topvalue = entries.get(size); 
    entries.remove(size); 
    return topvalue;

  }

  /**
   * this method returns the value at the top of the stack.

   * @return returns the top value of the stack.
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException(); // throw an exception if the stack is empty
    }
    return entries.get(size - 1);
  }

}
