package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc newStandardCalc;
  
  @BeforeEach
  public void test() {
    newStandardCalc = new StandardCalc();
  }
  
  @Test
  void testinfixtoRpn() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn(""));
  }
  
  @Test
  void testInvalidExpression1() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5+5"));
  }
  
  @Test
  void testInvalidExpression2() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5fg5"));
  }
  
  @Test
  void testInvalidExpression3() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5 + 5;"));
  }
  
  @Test
  void testInvalidExpression4() {
    assertThrows(IllegalArgumentException.class, () -> newStandardCalc.infixtoRpn("5"));
  }
  
  @Test
  void testoutput() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("5 5 5"), "5 5 5");
  }
  
  @Test
  void testoutput2() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("( 5  5 )"), "5 5");
  }
  
  @Test
  void testgetPrecedenceAddorSubtract() {
    assertEquals(newStandardCalc.getPrecedence("+"), 1);
    assertEquals(newStandardCalc.getPrecedence("-"), 1);
  }
  
  @Test
  void testgetPrecedenceTimesorDivide() {
    assertEquals(newStandardCalc.getPrecedence("*"), 2);
    assertEquals(newStandardCalc.getPrecedence("/"), 2);
  }
  
  @Test
  void testoutput3() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("( 5 * ( 6 + 7 ) ) - 2"), "5 6 7 + * 2 -");
  }
  
  @Test
  void testoutput4() throws Exception {
    assertEquals(newStandardCalc.infixtoRpn("( 5 + 6 ) + ( 7 * 4 )"), "5 6 + 7 4 * +");
  }
  
  @Test
  void testevaluate() throws Exception {
    String expression = newStandardCalc.infixtoRpn("( 5 + 6 ) + ( 7 * 4 )");
    assertEquals(newStandardCalc.evaluate(expression), 39);
  }

}
