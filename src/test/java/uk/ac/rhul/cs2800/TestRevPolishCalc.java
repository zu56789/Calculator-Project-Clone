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
  void testEvaluate() throws Exception {
    assertEquals(rpnCalc.evaluate(""), 0);
  }
  
  @Test
  void testInvalidExpression() throws Exception{
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("4+32+"));
  }
  
  

}
