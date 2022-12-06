package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestEntry {
  private Entry floatentry;
  private Entry symbolentry;
  private Entry stringentry;
  
  
  @Test
  void testFloat() throws Exception {
    Entry floatentry = new Entry((float) 1.5);
    assertEquals(1.5, floatentry.getValue(), "test a float entry to see if it works");
  }
  
  @Test
  void testSymbol() throws Exception {
    Entry symbolentry = new Entry(Symbol.DIVIDE);
    assertEquals(Symbol.DIVIDE, symbolentry.getSymbol(), "test a symbol entry to see if it works");
  }
  
  @Test
  void testString() throws Exception {
    Entry stringentry = new Entry("Hello");
    assertEquals("Hello", stringentry.getString(), "test a string entry to see it works");
  }
  
  
  @Test
  void testExceptions() {
    assertThrows(NullPointerException.class, () -> floatentry.getValue());
    assertThrows(NullPointerException.class, () -> symbolentry.getValue());
    assertThrows(NullPointerException.class, () -> stringentry.getValue());
  }
}
