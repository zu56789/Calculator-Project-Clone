package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

public class StandardCalc implements Calculator {

  private OpStack values = new OpStack();
  private RevPolishCalc rpnCalc = new RevPolishCalc();
  private HashMap<Symbol, String> operatorMap = new HashMap<Symbol, String>();
  private HashMap<Symbol, String> bracketsMap = new HashMap<Symbol, String>();
  private HashMap<String, Symbol> revoperatorMap = new HashMap<String, Symbol>();
  
  
  public int getPrecedence(String operator) {
    if (operator == "*" || operator == "/") {
      return 2;
    }   else {
      return 1;
    }
  }
  
  
    public String infixtoRpn(String expression) throws Exception {
    
      
    String output = new String("");
    int countdigits = 0;
      
    bracketsMap.put(Symbol.LEFT_BRACKET, "(");
    bracketsMap.put(Symbol.RIGHT_BRACKET, ")");
    
    operatorMap.put(Symbol.PLUS, "+");
    operatorMap.put(Symbol.MINUS, "-");
    operatorMap.put(Symbol.TIMES, "*");
    operatorMap.put(Symbol.DIVIDE, "/");
    
    revoperatorMap.put("+", Symbol.PLUS);
    revoperatorMap.put("-", Symbol.MINUS);
    revoperatorMap.put("*", Symbol.TIMES);
    revoperatorMap.put("/", Symbol.DIVIDE);
    
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
              countdigits++;
            }
            bracketsMap.get(values.pop());
          }
        }   else {
          while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET 
              &&  getPrecedence(value) <= getPrecedence(operatorMap.get(values.top()))) {
            output = output + " " +  operatorMap.get(values.pop());
            countdigits++; 
          }
          values.push(revoperatorMap.get(value));
        }
      } else {
        throw new IllegalArgumentException("Invalid Expression");
      }
    }
    
    while (!values.isEmpty()) {
      if (values.top() == Symbol.LEFT_BRACKET) {
        throw new IllegalArgumentException("Invalid Expression");
      }
      output = output + " " + operatorMap.get(values.pop());
      countdigits++;
    }
    
    if (countdigits <= 1) {
      throw new IllegalArgumentException("Invalid Expression");
    }
    scan.close();
    return output.trim();
  }
  
  @Override
  public float evaluate(String expression) throws Exception {
    return rpnCalc.evaluate(expression);
  }

}

