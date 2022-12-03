package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  
  private StrStack newStrStack;

  @BeforeEach
  public void setup() {
    newStrStack = new StrStack(); 
  }
  
  @Test
  void testPush() {
    newStrStack.push("Hello");
    assertEquals(newStrStack.size(), 1);
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newStrStack.pop());
  }
  
  @Test
  void testPushandPop() throws Exception {
    newStrStack.push("Hello mate");
    assertEquals(newStrStack.pop(), "Hello mate");
    assertEquals(newStrStack.size(), 0);
  }
  
  @Test
  void testisEmpty() {
    assertEquals(newStrStack.isEmpty(), true);
  }
  
  @Test
  void testPushandisEmpty() {
    newStrStack.push("Hello");
    assertEquals(newStrStack.isEmpty(), false);
  }

}
