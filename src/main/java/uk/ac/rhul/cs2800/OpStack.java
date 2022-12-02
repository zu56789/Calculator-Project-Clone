package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class OpStack {
  
  private Stack opStack = new Stack();
  
  private int size;
  
  public void push(Symbol i) {
    opStack.push(new Entry(i));
    size += 1;
  }
  
  public int size() {
    return size;
  }
  
  public Symbol pop() throws Exception {
    size -= 1;
    return opStack.pop().getSymbol();
  }
  
  public Symbol top() throws Exception  {
    if (size == 0) {
      throw new EmptyStackException();
    }
    
    return opStack.top().getSymbol();
  }
}
