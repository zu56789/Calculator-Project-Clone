package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel calcModel;
  
  @BeforeEach
  public void test() {
    calcModel = new CalcModel();
  }
  
  @Test
  void testEvaluate() throws Exception {
    assertEquals(calcModel.evaluate("5 + 5", true), 10, 
        "Tests that an infix expression returns the correct value");
  }
  
  @Test
  void testEvaluate2() throws Exception {
    assertEquals(calcModel.evaluate("5 6 +", false), 11, 
        "Tests that a postfix expression returns the correct value.");
  }
  
  @Test
  void testEvaluate3() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calcModel.evaluate("5 5 +", true),
        "Tests that a rpn expression pretending to be an infix expression throws an exception.");
  }
  
  @Test
  void testEvaluate4() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> calcModel.evaluate("5 + 5", false),
        "Tests that an infix expression pretending to be an rpn expression throws an eception.");
  }

}
