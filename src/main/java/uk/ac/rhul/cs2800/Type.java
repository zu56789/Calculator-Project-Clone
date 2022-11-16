package uk.ac.rhul.cs2800;

/**
 * this enum shows the different types an entry can represent.

 * @author Zuhayr
 */
public enum Type {
  /**
   * represents a float value.
   */
  NUMBER,
  /**
   * represents a symbol value.
   */
  SYMBOL,
  /**
   * represents a string value.
   */
  STRING,
  /**
   * represents any other value.
   */
  INVALID;
  
  /**
   * this method returns the name of the type.

   * @return returns the enum name
   */
  public String toString() {
    return name();
  }
}
