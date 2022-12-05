package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

/**
 * this class evaluates RPN string expressions.

 * @author Zuhayr
 *
 */
public class RevPolishCalc implements Calculator {

  private NumStack values = new NumStack();
  private HashMap<Symbol, String> operatorMap = new HashMap<Symbol, String>();
  //Hashmap is used so I can implement the Symbol enum and assign each a value.

  /**
   * this method calculates the solution to the rpn expression passed in to it.
   */
  @Override
  public float evaluate(String expression) throws Exception {
    operatorMap.put(Symbol.PLUS, "+");
    operatorMap.put(Symbol.MINUS, "-");
    operatorMap.put(Symbol.TIMES, "*");
    operatorMap.put(Symbol.DIVIDE, "/");
    Scanner scan = new Scanner(expression); // reads contents of expression. 
    while (scan.hasNext()) {
      String value = scan.next();
      //check if the next string value is an operator or a number.
      if (operatorMap.containsValue(value) || value.matches("^[0-9]*$")) { 
        //when value is a number, push it to the stack and continue the while loop.
        if (!operatorMap.containsValue(value)) {
          values.push(Float.valueOf(value));
          continue;
        }
        // when value is an operator but there arent 2 numbers in the stack, throw exception.
        if (values.size() < 2) {
          throw new IllegalArgumentException("Invalid Expression");
        }
      } else { // anything other than an operator/number is invalid.
        throw new IllegalArgumentException("Invalid Expression"); 
      }
      
      float a = values.pop();
      float b = values.pop();
      
      if (value.equals(operatorMap.get(Symbol.PLUS))) {
        values.push(a + b); 
      } else if (value.equals(operatorMap.get(Symbol.MINUS))) {
        values.push(b - a);
      } else if (value.equals(operatorMap.get(Symbol.TIMES))) {
        values.push(a * b);
      } else if (value.equals(operatorMap.get(Symbol.DIVIDE))) {
        //do not want division by zero to generate infinity.
        if (a == 0 || b == 0) {
          throw new ArithmeticException("Cannot Divide by 0");
        }
        values.push(b / a);
      }
    }
    scan.close();
    return values.pop();
  }
}
