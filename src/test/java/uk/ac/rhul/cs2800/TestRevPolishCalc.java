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
  void testValidEvaluate() throws Exception {
    assertEquals(rpnCalc.evaluate(""), 0);
  }

}
