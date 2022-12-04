package uk.ac.rhul.cs2800;

/**
 * this interface provides the functionality needed for the infix and postfix calculator.

 * @author Zuhayr
 *
 */
public interface Calculator {
  
  /**
   * this method calculates the value of an expression passed into it.

   * @param expression the string containing the expression.

   * @return returns a float representing the answer to the expression.
   */
  public float evaluate(String expression);
}
