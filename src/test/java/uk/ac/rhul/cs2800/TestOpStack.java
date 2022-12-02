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
    assertEquals(newOpStack.size(), 1);
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newOpStack.pop());
  }
  
  @Test
  void testPushandPop() throws Exception {
    newOpStack.push(Symbol.LEFT_BRACKET);
    assertEquals(newOpStack.pop(), Symbol.LEFT_BRACKET);
    assertEquals(newOpStack.size(), 0);
    
  }
  
  @Test
  void testEmptyTop()  {
    assertThrows(EmptyStackException.class, () -> newOpStack.top());
  }
  
  @Test
  void testPushandTop() throws Exception {
    newOpStack.push(Symbol.MINUS);
    assertEquals(newOpStack.top(), Symbol.MINUS);
    
  }
  
  @Test
  void testPushPopandTop() throws Exception {
    newOpStack.push(Symbol.INVALID);
    newOpStack.pop();
    assertThrows(EmptyStackException.class, () -> newOpStack.top());
  }
  
  @Test
  void testisEmpty() {
    assertEquals(newOpStack.isEmpty(), true);
  }
  
  @Test
  void testPushandisEmpty() throws Exception {
    newOpStack.push(Symbol.TIMES);
    assertEquals(newOpStack.isEmpty(), false);
    newOpStack.pop();
    assertEquals(newOpStack.isEmpty(), true);
  }
  
  

}
