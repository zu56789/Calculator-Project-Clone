package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

public class StandardCalc implements Calculator {

  private OpStack values = new OpStack();
  private RevPolishCalc rpnCalc;
  private HashMap<Symbol, String> symbolMap = new HashMap<Symbol, String>();
  
    public String infixtoRpn(String expression) {
    
    symbolMap.put(Symbol.LEFT_BRACKET, "(");
    symbolMap.put(Symbol.RIGHT_BRACKET, ")");
    symbolMap.put(Symbol.PLUS, "+");
    symbolMap.put(Symbol.MINUS, "-");
    symbolMap.put(Symbol.TIMES, "*");
    symbolMap.put(Symbol.DIVIDE, "/");
    Scanner scan = new Scanner(expression);
    while (scan.hasNext()) {
      String value = scan.next();
      if (!symbolMap.containsValue(value) || value.matches("^[0-9]*$")) {
        throw new IllegalArgumentException("Invalid Expression");
      }
    }
    
    return "";
  }
  
  @Override
  public float evaluate(String expression) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

}
