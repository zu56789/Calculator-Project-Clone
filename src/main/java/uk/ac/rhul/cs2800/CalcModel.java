package uk.ac.rhul.cs2800;

public class CalcModel {
  
  private RevPolishCalc revPolishCalc = new RevPolishCalc();
  private StandardCalc standardCalc = new StandardCalc();
  
  public float evaluate(String expression, boolean infix) throws Exception {
    
    if (infix == true) {
      String infixexpression = standardCalc.infixtoRpn(expression);
      return standardCalc.evaluate(infixexpression);
    }   else {
      return revPolishCalc.evaluate(expression);
    }
    
     
  }
}
