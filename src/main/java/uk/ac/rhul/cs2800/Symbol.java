package uk.ac.rhul.cs2800;

/**
 * this is the enum showing the different non number tokens possible in an expression.

 * @author Zuhayr
 */
public enum Symbol {
  /**
   * represents a "(" symbol.
   */
  LEFT_BRACKET,
  /**
   * represents a "(" symbol.
   */
  RIGHT_BRACKET,
  /**
   * represents a "*" symbol.
   */
  TIMES,
  /**
   * represents a "/" symbol.
   */
  DIVIDE,
  /**
   * represents a "+" symbol.
   */
  PLUS,
  /**
   * represents a "-" symbol.
   */
  MINUS;
  
  /**
   * this method returns the name of the symbol.

   * @return returns the enum name.
   */
  public String toString() {
    return name();
  }
}
