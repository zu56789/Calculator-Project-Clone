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
  
  public float pop() throws  Exception {
    size -= 1;
    return numStack.pop().getValue();
  }
  
  public boolean isEmpty() {
    return (numStack.size() == 0);
  }
    
}

