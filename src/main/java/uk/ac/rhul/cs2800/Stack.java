package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;


/** 
 * this program represents a stack data structure using an arraylist.

 * @author Zuhayr
 */
public class Stack {

  /**
   * the size of the stack.
   */
  int size = 0;
  /**
   * The list representing the stack.
   */
  ArrayList<Integer> value = new ArrayList<Integer>();

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
  public void push(int i) {
    value.add(i); // adds the i value to the stack
    size += 1; // size increases by one when one value is added

  }

  /**
   * this method removes the value at the top of the stack and returns it.

   * @return returns the removed value in the stack.
   */
  public int pop() {
    if (size == 0) {
      throw new EmptyStackException(); // throw an exception if the stack is empty
    }
    size -= 1; // size decreases when a value is popped
    int topvalue = value.get(size); // represents the popped value
    value.remove(size); // removes the value at the top of the stack
    return topvalue;

  }

  /**
   * this method returns the value at the top of the stack.

   * @return returns the top value of the stack.
   */
  public int top() {
    if (size == 0) {
      throw new EmptyStackException(); // throw an exception if the stack is empty
    }
    return value.get(size - 1);
  }

}
