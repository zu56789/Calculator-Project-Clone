package uk.ac.rhul.cs2800;

/**
 * this class represents a specific stack of String values. It is a facade of the Stack class.

 * @author Zuhayr
 */
public class StrStack {
  
  private Stack strStack = new Stack();
  private int size;
  
  /**
   * this method adds a string value to the strStack.

   * @param i the string value to add to the strStack.
   */
  public void push(String i) {
    strStack.push(new Entry(i));
    size += 1;
  }
  
  /**
   * this method checks how many values are in the strStack.

   * @return returns an int representing the number of values in the strStack.
   */
  public int size() {
    return size;
  }
  
  /**
   * this method removes the top value of the strStack and return it.

   * @return returns the removed value of the strStack.

   */
  public String pop() throws Exception {
    size -= 1;
    return strStack.pop().getString();
  }
  
  /**
   * this method checks if the strStack is empty or not.

   * @return returns a boolean valued at true if the strStack is empty.
   */
  public boolean isEmpty() {
    return (size == 0);
  }
  
}
