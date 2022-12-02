package uk.ac.rhul.cs2800;


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
    
}

