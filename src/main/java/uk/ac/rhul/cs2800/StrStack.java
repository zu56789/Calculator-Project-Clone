package uk.ac.rhul.cs2800;

public class StrStack {
  
  private Stack strStack = new Stack();
  private int size;
  
  public void push(String i) {
    strStack.push(new Entry(i));
    size += 1;
  }
  
  public int size() {
    return size;
  }
  
}
