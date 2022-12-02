package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * this class represents a specific stack of symbols. It is a facade of the Stack class.

 * @author Zuhayr
 *
 */
public class OpStack {
  
  private Stack opStack = new Stack();
  
  private int size;
  
  /**
   * this method adds a new symbol to the opStack.

   * @param i the symbol being added to the opStack.
   */
  public void push(Symbol i) {
    opStack.push(new Entry(i));
    size += 1;
  }
  
  /**
   * this method returns how many values are in the opStack.

   * @return returns the size of the opStack.
   */
  public int size() {
    return size;
  }
  
  /**
   * this method removes the top value of the opStack and returns it.

   * @return returns the removed value of the opStack.
   */
  public Symbol pop() throws Exception {
    size -= 1;
    return opStack.pop().getSymbol();
  }
  
  /**
   * this method is used to return the top value of the opStack.

   * @return returns the Symbol most recently added to the opStack.
   */
  public Symbol top() throws Exception  {
    if (size == 0) {
      throw new EmptyStackException();
      //throws when the stack is empty.
    }
    
    return opStack.top().getSymbol();
  }
  
  /**
   * this method is used to determine if the opStack is empty.

   * @return returns a boolean of if the opStack is empty or not.
   */
  public boolean isEmpty() {
    return (size == 0);
  }
}
