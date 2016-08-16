package io.jaylim.study.dsa.stack;

public class LinkedStack<E> implements Stack<E> {
  private Link<E> top;
  private int size;

  public LinkedStack() {
    this.top = null;
    this.size = 0;
  }

  public LinkedStack(int size) {
    this();
  }

  public void clear() {
    this.top = null;
    this.size = 0;
  }

  public void push(E el) {
    this.top = new Link<E>(el, this.top);
    size++;
  }

  public E pop() {
    assert size != 0 : "Stack is empty";
    E temp = this.top.element();
    this.top = this.top.next();
    size--;
    return temp;
  }

  public E topValue() {
    assert size != 0 : "Stack is empty";
    return this.top.element();
  }

  public int length() {
    return this.size;
  }
}
