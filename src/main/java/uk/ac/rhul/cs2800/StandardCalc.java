package uk.ac.rhul.cs2800;

import java.util.HashMap;
import java.util.Scanner;

/**
 * this class evaluates infix string expressions.

 * @author Zuhayr
 *
 */
public class StandardCalc implements Calculator {

  private OpStack values = new OpStack();
  private RevPolishCalc rpnCalc = new RevPolishCalc();
  private HashMap<Symbol, String> operatorMap = new HashMap<Symbol, String>();
  private HashMap<Symbol, String> bracketsMap = new HashMap<Symbol, String>();
  private HashMap<String, Symbol> revoperatorMap = new HashMap<String, Symbol>();
  
  /**
   * this method returns the precedence of a given operator.

   * @param operator the operator string.

   * @return returns the int value of the precedence.
   */
  public int getPrecedence(String operator) {
    if (operator == "*" || operator == "/") {
      return 2;
    }   else {
      return 1;
    }
  }
  
  /**
   * this method converts an infix expression into an rpn expression.

   * @param expression the infix expression

   * @return returns the rpn expression of the infix expression.
   */
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
    
    Scanner scan = new Scanner(expression); // reads contents of the expression.
    
    while (scan.hasNext()) {
      String value = scan.next();
      //checks if the next string value is a number, operator or bracket.
      if (operatorMap.containsValue(value) || value.matches("^[0-9]*$")
          || bracketsMap.containsValue(value)) {
        // if the string value is a number, add the value to the output string.
        if (value.matches("^[0-9]*$")) {
          output = output + " " + value;
          countdigits++;
        }   else if (bracketsMap.containsValue(value)) {
          //if the string value is a left bracket, push the associated symbol to a stack.
          if (value.equals(bracketsMap.get(Symbol.LEFT_BRACKET))) {
            values.push(Symbol.LEFT_BRACKET);
          } else {
            // right brackets are not added to the stack.
            while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET) {
              output = output + " " + operatorMap.get(values.pop());
              countdigits++;
            }
            bracketsMap.get(values.pop());
          }
        }   else {
          // operators are added to output based on precedence.
          while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET 
              &&  getPrecedence(value) <= getPrecedence(operatorMap.get(values.top()))) {
            output = output + " " +  operatorMap.get(values.pop());
            countdigits++; 
          }
          //in order to push a symbol object, I had to create and use a reverse operator map.
          values.push(revoperatorMap.get(value));
        }
      } else {
        //a non number, bracket or operator string value throws an exception.
        throw new IllegalArgumentException("Invalid Expression");
      }
    }
    while (!values.isEmpty()) {
      //expressions can not end in a left bracket.
      if (values.top() == Symbol.LEFT_BRACKET) {
        throw new IllegalArgumentException("Invalid Expression");
      }
      output = output + " " + operatorMap.get(values.pop());
      countdigits++;
    }
    
    //an output with less than 2 values is not valid.
    if (countdigits <= 2) {
      throw new IllegalArgumentException("Invalid Expression");
    }
    scan.close();
    //whitespace removed from output string.
    return output.trim();
  }
  
  /**
   *this method calculates the solution to the infix expression passed into it.
   */
  @Override
  public float evaluate(String expression) throws Exception {
    return rpnCalc.evaluate(expression);
  }
}