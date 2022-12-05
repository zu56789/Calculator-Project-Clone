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
  void testoutput() {
    assertEquals(newStandardCalc.infixtoRpn("5 5 5"), "5 5 5");
  }

}
