package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertEquals(newNumStack.size(), 1, "Test push function to see if it increases the size");
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> newNumStack.pop(), 
        "An empty NumStack can not be popped");
    
  }
  
  @Test
  void testPushandPop() throws Exception {
    newNumStack.push((float) 3.0);
    assertEquals(newNumStack.pop(), 3.0, "If you push 3.0 then it should be popped");
    assertEquals(newNumStack.size(), 0, "NumStack should be empty after pop");
    
  }
  
  @Test
  void testifEmpty() {
    assertEquals(newNumStack.isEmpty(), true, "NumStack should start off empty.");
  }

}
