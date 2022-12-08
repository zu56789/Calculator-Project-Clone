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
    
    String output = new String(""); 
    String tempexpression = expression.replaceAll("\\s", "");
    String[] expressionArray = expression.trim().split(" ");
    
    //Expression with less than 3 values cannot be a legal expression.
    if (expressionArray.length < 3) {
      throw new IllegalArgumentException("Invalid Expression");
    }
    
    //checking if the expression contains a bracket at the end.
    boolean islastbracket = bracketsMap.containsValue(
        String.valueOf(tempexpression.charAt(tempexpression.length() - 1)));
    
    boolean lastisnum = expressionArray[expressionArray.length - 1].matches("^[0-9]*$");
    
    boolean secondlastisnum = expressionArray[expressionArray.length - 2].matches("^[0-9]*$");
    
    //inifx expressions only end in a number or a bracket.
    if (!lastisnum &&  !islastbracket) {
      throw new IllegalArgumentException("Invalid Expression");
      //if the last value isnt a bracket then the second last value should be an operator.
    }   else if  (lastisnum && secondlastisnum) {
      throw new IllegalArgumentException("Invalid Expression");
    }
    
    

    Scanner scan = new Scanner(expression); // reads contents of the expression.
    
    while (scan.hasNext()) {
      String value = scan.next();
      //checks if the next string value is a number, operator or bracket.
      if (operatorMap.containsValue(value) || value.matches("^[0-9]*$")
          || bracketsMap.containsValue(value)) {
        // if the string value is a number, add the value to the output string.
        if (value.matches("^[0-9]*$")) {
          output = output + " " + value;
        }   else if (bracketsMap.containsValue(value)) {
          //if the string value is a left bracket, push the associated symbol to a stack.
          if (value.equals(bracketsMap.get(Symbol.LEFT_BRACKET))) {
            values.push(Symbol.LEFT_BRACKET);
          } else {
            // right brackets are not added to the stack.
            while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET) {
              output = output + " " + operatorMap.get(values.pop());
            }
            bracketsMap.get(values.pop());
          }
        }   else {
          // operators are added to output based on precedence.
          while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET 
              &&  getPrecedence(value) <= getPrecedence(operatorMap.get(values.top()))) {
            output = output + " " +  operatorMap.get(values.pop());
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
