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
    assertEquals(newStandardCalc.infixtoRpn(""), "");
  }

}
