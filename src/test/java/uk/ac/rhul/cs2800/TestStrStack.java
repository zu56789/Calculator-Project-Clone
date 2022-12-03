package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertEquals(newStrStack.size(), 1, "Tests if pushing increases the size.");
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newStrStack.pop(),
        "An empty StrStack that is popped should throw an EmptyStackException.");
  }
  
  @Test
  void testPushandPop() throws Exception {
    newStrStack.push("Hello mate");
    assertEquals(newStrStack.pop(), "Hello mate",
        "if you push a String onto StrStack, the same one should be popped.");
    assertEquals(newStrStack.size(), 0, "popping should decrease size by 1.");
  }
  
  @Test
  void testisEmpty() {
    assertEquals(newStrStack.isEmpty(), true,
        "Testing an Empty StrStack returns true when isEmpty is called.");
  }
  
  @Test
  void testPushandisEmpty() throws Exception {
    newStrStack.push("Hello");
    assertEquals(newStrStack.isEmpty(), false,
        "Testing a non empty StrStack returns false when isEmpty is called.");
    newStrStack.pop();
    assertEquals(newStrStack.isEmpty(), true,
        "After popping the value, the StrStack should be empty.");
    
  }

}
