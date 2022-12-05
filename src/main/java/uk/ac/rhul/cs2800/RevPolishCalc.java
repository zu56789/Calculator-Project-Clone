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
      if (!operatorMap.containsValue(value) || value.matches("^[0-9]*$")) {
        throw new IllegalArgumentException("Invalid Expression");
      }
     
    }
    scan.close();
    return 0;
   
    
    
  }
  
  
  


}
