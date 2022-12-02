package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  
  private NumStack newNumStack;

  @BeforeEach
  public void setup() {
    
    newNumStack = new NumStack();
  }
  
  @Test
  void testPush() {
    newNumStack.push((float) 2.0);
    assertEquals(newNumStack.size(), 1);
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newNumStack.pop(), 
        "An empty stack can not be popped");
    
  }
  
  @Test
  void testPushandPop() throws Exception {
    newNumStack.push((float) 3.0);
    assertEquals(newNumStack.pop(), 3.0);
    assertEquals(newNumStack.size(), 0);
    
  }

}
