package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestOpStack {
  
  private OpStack newOpStack;

  @BeforeEach
  public void setup() {
    newOpStack = new OpStack();
  }
  
  @Test
  void testPush() {
    newOpStack.push(Symbol.DIVIDE);
    assertEquals(newOpStack.size(), 1, "Tests if pushing increases the size.");
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newOpStack.pop(),
        "An empty OpStack that is popped should throw an EmptyStackException.");
  }
  
  @Test
  void testPushandPop() throws Exception {
    newOpStack.push(Symbol.LEFT_BRACKET);
    assertEquals(newOpStack.pop(), Symbol.LEFT_BRACKET,
        "if you push a symbol onto Opstack, the same one should be popped.");
    assertEquals(newOpStack.size(), 0, "Popping should also decrease size.");
    
  }
  
  @Test
  void testEmptyTop()  {
    assertThrows(EmptyStackException.class, () -> newOpStack.top(),
        "Calling top on an empty OpStack should throw an EmptyStackException.");
  }
  
  @Test
  void testPushandTop() throws Exception {
    newOpStack.push(Symbol.MINUS);
    assertEquals(newOpStack.top(), Symbol.MINUS,
        "Symbol.MINUS is at the top of the OpStack so it should be returned by top.");
    
  }
  
  @Test
  void testPushPopandTop() throws Exception {
    newOpStack.push(Symbol.INVALID);
    newOpStack.pop();
    assertThrows(EmptyStackException.class, () -> newOpStack.top(),
        "Calling top after pushing and popping should throw an EmptyStackException.");
  }
  
  @Test
  void testisEmpty() {
    assertEquals(newOpStack.isEmpty(), true, 
        "Testing an Empty OpStack returns true when isEmpty is called.");
  }
  
  @Test
  void testPushandisEmpty() throws Exception {
    newOpStack.push(Symbol.TIMES);
    assertEquals(newOpStack.isEmpty(), false, 
        "Testing a non empty stack returns false when isEmpty is called.");
    newOpStack.pop();
    assertEquals(newOpStack.isEmpty(), true, 
        "After popping the value, the OpStack should be empty.");
  }
  
  

}
