package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

public class StandardCalc implements Calculator {

  private OpStack values = new OpStack();
  private RevPolishCalc rpnCalc = new RevPolishCalc();
  private HashMap<Symbol, String> operatorMap = new HashMap<Symbol, String>();
  private HashMap<Symbol, String> bracketsMap = new HashMap<Symbol, String>();
  
  
    public String infixtoRpn(String expression) throws Exception {
    
      
    String output = new String("");
    int countdigits = 0;
      
    bracketsMap.put(Symbol.LEFT_BRACKET, "(");
    bracketsMap.put(Symbol.RIGHT_BRACKET, ")");
    
    operatorMap.put(Symbol.PLUS, "+");
    operatorMap.put(Symbol.MINUS, "-");
    operatorMap.put(Symbol.TIMES, "*");
    operatorMap.put(Symbol.DIVIDE, "/");
    Scanner scan = new Scanner(expression);
    while (scan.hasNext()) {
      String value = scan.next();
      if (operatorMap.containsValue(value) || value.matches("^[0-9]*$")
          || bracketsMap.containsValue(value)) {
        if (value.matches("^[0-9]*$")) {
          output = output + " " + value;
          countdigits++;
        }   else if (bracketsMap.containsValue(value)) {
          if (value.equals(bracketsMap.get(Symbol.LEFT_BRACKET))) {
            values.push(Symbol.LEFT_BRACKET);
          } else {
            while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET) {
              output = output + " " + operatorMap.get(values.pop());
              countdigits += 1;
            }
            bracketsMap.get(values.pop());
          }
        }
      } else {
        throw new IllegalArgumentException("Invalid Expression");
      }
    }
    
    if (countdigits <= 1) {
      throw new IllegalArgumentException("Invalid Expression");
    }
    scan.close();
    return output.trim();
  }
  
  @Override
  public float evaluate(String expression) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

}

