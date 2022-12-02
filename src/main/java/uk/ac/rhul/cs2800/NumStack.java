package uk.ac.rhul.cs2800;


/**
 * this class represents a specific stack of numbers. It is a facade of the Stack class.

 * @author Zuhayr
 */
public class NumStack {
  
  /**
   * the Stack representing the NumStack.
   */
  private Stack numStack = new Stack();
  /**
   * the size of this specific NumStack.
   */
  private int size;
  
  
  /**
   * this method adds a new float value to the NumStack.

   * @param i the float value to add.
   */
  public void push(float i) {
    numStack.push(new Entry((float) (i)));
    size += 1;
  }
  
  /**
   * this method returns the size of the NumStack.

   * @return returns the size of the stack.
   */
  public int size() {
    return size;
  }
  
  /**
   * this method removes the value at the top of the NumStack and returns it.

   * @return returns the removed value in the NumStack.

   * @throws when there is an empty stack exception.
   */
  public float pop() throws  Exception {
    size -= 1;
    return numStack.pop().getValue();
  }
  
  /**
   * this method is used to determine if the NumStack is empty or not.

   * @return returns a true/false of if the NumStack is empty or not.
   */
  public boolean isEmpty() {
    return (size == 0);
  }
    
}

