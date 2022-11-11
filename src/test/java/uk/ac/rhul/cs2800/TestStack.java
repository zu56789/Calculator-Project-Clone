package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private Stack newstack;


  @BeforeEach
  public void setup() { // Test 1. Testing a new stack can be created. I created an empty Stack
    // class to ensure this test passed.
    newstack = new Stack();
  }

  @Test
  void testSize() { // Test 2. Testing a newly created stack has a size of 0. I added a size method
    // to the stack to return an integer variable which contained the size of the
    // stack.
    Stack newstack = new Stack();
    assertEquals(newstack.size(), 0, "Test a new Stack to make sure it is empty");
  }


  @Test
  void testPush() { // Test 3. Testing that pushing to an empty stack makes the size increase to 1.
    // I added a push method that increased the size variable by one.
    newstack.push(8);
    assertEquals(newstack.size(), 1, "Test that pushing increases the size of the stack");
  }

  @Test
  void testEmptyPop() { // Test 4. Testing that popping an empty stack throws an exception. I added
    // a pop method that checks if the size is zero and throws an exception if
    // it is. I made the temporary return value zero.
    assertThrows(EmptyStackException.class, () -> newstack.pop(),
        "An empty stack can not be popped");
  }

  @Test
  void testPushandPop() { // Test 5. Testing that pushing and then popping should return the value
    // pushed. Popping a further time should throw an empty stack exception. I
    // added a value integer variable which contained the current value in the
    // stack and then returned that value. I also changed the push method to
    // make the pushed value the current value.
    newstack.push(8);
    assertEquals(newstack.pop(), 8, "Pushing an 8 and then popping should return an 8");
    assertEquals(newstack.size(), 0,
        "Pushing an 8 and then popping the 8 should make the stack empty");
    assertThrows(EmptyStackException.class, () -> newstack.pop(),
        "Popping the now empty stack will throw an exception");
  }

  @Test
  void testDoublePush() { // Test 6. Testing that pushing two times and then popping both will
    // return the values in the correct order. I had to convert the value
    // integer variable into an integer arraylist to allow both values to be
    // popped correctly. I had to slightly change the push and pop methods to
    // suit the syntax for an arraylist.
    newstack.push(10);
    newstack.push(11);
    assertEquals(newstack.pop(), 11,
        "Pushing two times and then popping will return the second thing pushed");
    assertEquals(newstack.pop(), 10,
        "Pushing two times and then popping twice will return the first thing pushed");
    assertEquals(newstack.size(), 0,
        "Pushing two times and then popping two times should empty the stack");
    assertThrows(EmptyStackException.class, () -> newstack.pop(),
        "Popping the now empty stack will throw an exception");
  }

  @Test
  void testMultiplePush() { // Test 7. Testing that pushing multiple values onto the stack will
    // correctly increase the size of the stack. The stack should allow an
    // infinite amount of entries.
    for (int i = 0; i < 5000; i++) {
      newstack.push(i + 10);
      assertEquals(newstack.size, i + 1, "Pushing should increase the size");
    }
  }

  @Test
  void testMultiplePushAndPop() { // Test 7. Testing that pushing multiple values and then popping
    // multiple values will correctly display the stack size.
    int size = 100;
    for (int i = 0; i < size; i++) {
      newstack.push(i + 23);
    }
    for (int i = 1; i < 100; i++) {
      newstack.pop();
      size -= 1;
      assertEquals(newstack.size, (size + 1) - 1, "Popping will reduce the size by one");
    }
  }

  @Test
  void testEmptyTop() { // Test 8. Testing that the top function will produce an exception if tried
    // on an empty stack. I added a top method to the stack which checks if the
    // stack is empty or not. If it is empty an exception is thrown. My
    // temporary return integer was 0.
    assertThrows(EmptyStackException.class, () -> newstack.top(),
        "There is no top value of an empty stack");
  }

  @Test
  void testPushAndTop() { // Test 9. Testing that push will work when a value is pushed onto the
    // stack. I changed the return integer from 0 to the value at the top of
    // the stack.
    newstack.push(12);
    assertEquals(newstack.top(), 12,
        "Pushing and then getting the top value should return the pushed value");
  }

  @Test
  void testPushPopandTop() { // Test 10. Testing that pushing, popping and then trying to use the
    // top function will throw an exception.
    newstack.push(12);
    newstack.pop();
    assertThrows(EmptyStackException.class, () -> newstack.top(),
        "Push and then pop will empty the stack so there should be an empty stack exception");
  }


}
