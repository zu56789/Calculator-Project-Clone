package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc newStandardCalc;
  
  @BeforeEach
  public void test() {
    newStandardCalc = new StandardCalc();
  }
  
  @Test
  void testInvalidExpression() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn(""), 
        "Tests that an empty expression throws an exception.");
  }
  
  @Test
  void testInvalidExpression2() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5+5"), 
        "Tests that a single string expression throws an exception.");
  }
  
  @Test
  void testInvalidExpression3() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5fg5"), 
        "Tests that any non bracket, non number or non operator throws an expression");
  }
  
  
  @Test
  void testInvalidExpression4() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5"),
        "Tests that an incomplete expression throws an exception");
  }
  
  @Test
  void testgetPrecedenceAddorSubtract() {
    assertEquals(newStandardCalc.getPrecedence("+"), 1, 
        "Tests that the plus operator has a precedence of 1.");
    assertEquals(newStandardCalc.getPrecedence("-"), 1,
        "Tests that the minus operator has a precedence of 1.");
  }
  
  @Test
  void testgetPrecedenceTimesorDivide() {
    assertEquals(newStandardCalc.getPrecedence("*"), 2,
        "Tests that the multiply operator has a precedence of 2.");
    assertEquals(newStandardCalc.getPrecedence("/"), 2, 
        "Tests that the divide operator has a precedence of 2.");
  }
  
  @Test
  void testoutput3() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("5 + 5"), "5 5 +",
        "Tests that an infix expression is successfully converted to postfix.");
  }
  
  @Test
  void testoutput4() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("( 5 + 6 ) + ( 7 * 4 )"), "5 6 + 7 4 * +",
        "Tests a more complex infix expression is successfully converted to postfix.");
  }
  
  @Test
  void testevaluate() throws Exception {
    String expression = newStandardCalc.infixtoRpn("( 5 + 6 ) + ( 7 * 4 )");
    assertEquals(newStandardCalc.evaluate(expression), 39,
        "Tests that an infix expression is successfully evaluated.");
  }
  
 

}
