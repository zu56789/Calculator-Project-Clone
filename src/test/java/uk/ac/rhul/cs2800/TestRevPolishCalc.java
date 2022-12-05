package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

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
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("4+32+"));
  }
  
  @Test
  void testInvalidExpression2() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("2f 4 +"));
  }
  
  @Test
  void testInvalidExpression3() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("6 5 ;"));
  }
  
  @Test
  void testInvalidExpression4() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("5 +"));
  }
  
  @Test
  void testInvalidExpression5() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("5 5 + +"));
  }
  
  @Test
  void testAdd() throws Exception {
    assertEquals(rpnCalc.evaluate("5 5 +"), 10);
  }
  
  @Test
  void testMinus() throws Exception {
    assertEquals(rpnCalc.evaluate("5 5 -"), 0);
  }
  

}
