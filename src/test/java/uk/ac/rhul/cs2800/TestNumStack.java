package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNumStack {
  
  private NumStack newNumStack;

  @Test
  public void setup() {
    
    newNumStack = new NumStack();
  }
  
  @Test
  void testPush() {
    NumStack newNumStack = new NumStack();
    newNumStack.push(2.0);
    assertEquals(newNumStack.size(), 1);
  }

}
