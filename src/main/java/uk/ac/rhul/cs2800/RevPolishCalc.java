package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

public class RevPolishCalc implements Calculator {

  private NumStack values = new NumStack();
  private HashMap<Symbol, String> operatorMap = new HashMap<Symbol, String>();
  

      
  @Override
  public float evaluate(String expression) throws Exception {
    operatorMap.put(Symbol.PLUS, "+");
    operatorMap.put(Symbol.MINUS, "-");
    operatorMap.put(Symbol.TIMES, "*");
    operatorMap.put(Symbol.DIVIDE, "/");
    Scanner scan = new Scanner(expression);
    while (scan.hasNext()) {
      String value = scan.next();
      if (operatorMap.containsValue(value) || value.matches("^[0-9]*$")) {
        
        if (!operatorMap.containsValue(value)) {
          values.push(Float.valueOf(value));
          continue;
        }
        
        if (values.size() < 2) {
          throw new IllegalArgumentException("Invalid Expression");
        }
        
      } else {
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
      }
     
    }
    scan.close();
    return values.pop();
   
    
    
  }
  
  
  


}
