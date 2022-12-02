package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

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

}
