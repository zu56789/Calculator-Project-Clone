package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel calcModel;
  
  @BeforeEach
  public void test() {
    calcModel = new CalcModel();
  }
  
  @Test
  void testEvaluate() {
    assertEquals(calcModel.evaluate("", false), 0);
  }

}
