package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc rpnCalc;
  
  @BeforeEach
  public void test() {
    rpnCalc = new RevPolishCalc();
  }
  
  @Test
  void testInvalidExpression1() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("4+32+"), 
        "Tests that inputting 1 string throws an exception");
  }
  
  @Test
  void testInvalidExpression2() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("2f 4 +"), 
        "Tests that an expression with a letter throws an exception");
  }
  
  @Test
  void testInvalidExpression3() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("6 5 ;"), 
        "Tests that an expression without a random symbol throws an exception");
  }
  
  @Test
  void testInvalidExpression4() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("5 +"), 
        "Tests that an expression with not enough operands throws an exception");
  }
  
  @Test
  void testInvalidExpression5() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("5 5 + +"), 
        "Tests that an expression with too many operators throws an exception");
  }
  
  @Test
  void testAdd() throws Exception {
    assertEquals(rpnCalc.evaluate("5 5 +"), 10, 
        "Tests that an addition expression is correctly evaluated");
  }
  
  @Test
  void testMinus() throws Exception {
    assertEquals(rpnCalc.evaluate("5 5 -"), 0, 
        "Tests that a subtraction expression is correctly evaluated");
  }
  
  @Test
  void testMultiply() throws Exception {
    assertEquals(rpnCalc.evaluate("5 5 *"), 25,
        "Tests that a multiplication expression is correctly evaluated");
  }
  
  @Test
  void testDivide() throws Exception {
    assertEquals(rpnCalc.evaluate("10 5 /"), 2, 
        "Tests that a division expression is correctly evaluated");
  }
  
  @Test
  void testDivideZero() throws Exception {
    assertThrows(ArithmeticException.class, () -> rpnCalc.evaluate("0 9 /"),
        "Tests that diving by zero throws an exception");
  }
  
}
