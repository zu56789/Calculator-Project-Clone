package uk.ac.rhul.cs2800;

/**
 * this class allows any type of expression to be evaluated.

 * @author Zuhayr
 */
public class CalcModel {
  
  private RevPolishCalc revPolishCalc = new RevPolishCalc();
  private StandardCalc standardCalc = new StandardCalc();
  
  /**
   * this method evaluates the given infix/postfix expression.

   * @param expression String value representing the infix/postfix expression.
   * @param infix boolean value of if the expression is infix or not.
   * @return returns the float answer to the given expression.
   */
  public float evaluate(String expression, boolean infix) throws Exception {
    
    if (infix == true) {
      // infix needs to be converted to postfix before evaluating.
      String infixexpression = standardCalc.infixtoRpn(expression);
      return standardCalc.evaluate(infixexpression);
    }   else {
      return revPolishCalc.evaluate(expression);
    }
  }
}
