package io.jaylim.study.dsa.stack;

public class ArrayStack<E> implements Stack<E> {
  private static final int DEFAULT_SIZE = 20;

  private int maxSize;
  private int top;
  private E[] listArray;

  /**
   * Constructors
   */
  @SuppressWarnings("unchecked")
  public ArrayStack(int size) {
    this.maxSize = size;
    this.listArray = (E[]) new Object[size];
    this.top = 0;
  }

  public ArrayStack() {
    this(DEFAULT_SIZE);
  }

  public void clear() {
    this.top = 0;
  }

  public void push(E item) {
    assert this.top != maxSize : "Stack is full";
    listArray[top++] = item;
  }

  public E pop() {
    assert this.top != 0 : "Stack is empty";
    return listArray[--top];
  }

  public E topValue() {
    assert this.top != 0 : "Stack is empty";
    return listArray[top - 1];
  }

  public int length() {
    return this.top;
  }


}
