package uk.ac.rhul.cs2800;

/**
 * this class represents the different values stored in a stack.

 * @author Zuhayr
 */
public class Entry {

  private float number;
  private Symbol other;
  private String str;
  
  /**
   * constructor for a float entry.

   * @param value the float value. 
   */
  public Entry(float value) {
    number = value;
    
  }
  
  /**
   * constructor for symbol entry.

   * @param which the symbol value.
   */
  public Entry(Symbol which) {
    other = which;
  }
  
  /**
   * constructor for string entry.

   * @param string the string value.
   */
  public Entry(String string) {
    str = string;
  }

  /**
   * this method returns the string passed into entry.

   * @return returns the string passed into the entry object.

   */
  public String getString() throws Exception {
    return str; 
  }
  
  /**
   * this method returns the symbol of the entry object.

   * @return returns the symbol passed into the entry.

   */
  public Symbol getSymbol() throws Exception {
    return other;
  }
  
  /**
   * this method returns the float value of the entry object.

   * @return returns the float value passed into the entry.

   */
  public float getValue() throws Exception {
    return number;
  }
}
