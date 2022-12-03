package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

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

}
