package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

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

}
