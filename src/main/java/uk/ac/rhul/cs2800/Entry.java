package uk.ac.rhul.cs2800;

/**
 * this class represents the different values stored in a stack.

 * @author Zuhayr
 */
public class Entry {
  /**
   * float entry.
   */
  private float number;
  /**
   * symbol entry.
   */
  private Symbol other;
  /**
   * string entry.
   */
  private String str;
  /**
   * type entry.
   */
  private Type type;
  
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
   * constructor for type entry.

   * @param type1 type value.
   */
  public Entry(Type type1) {
    type = type1;
  }
  
  /**
   * this method returns the type of the entry object.

   * @return returns the type of the entry.
 
   * @throws when the types do not match.
   */
  public Type getType() throws Exception {
    return type;
  }
  
  /**
   * this method returns the string passed into entry.

   * @return returns the string passed into the entry object.

   * @throws when the types do not match.
   */
  public String getString() throws Exception {
    return str; 
  }
  
  /**
   * this method returns the symbol of the entry object.

   * @return returns the symbol passed into the entry.

   * @throws when the types do not match.
   */
  public Symbol getSymbol() throws Exception {
    return other;
  }
  
  /**
   * this method returns the float value of the entry object.

   * @return returns the float value passed into the entry.

   * @throws when the types do not match.
   */
  public float getValue() throws Exception {
    return number;
  }
}
