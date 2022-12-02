package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
  
  private Stack numStack = new Stack();
  private int size;
  
  
  public void push(float i) {
    numStack.push(new Entry((float) (i)));
    size += 1;
  }
  
  public int size() {
    return size;
  }
  
  public float pop() throws  Exception {
    size -= 1;
    return numStack.pop().getValue();
    
    
  }
    
}

