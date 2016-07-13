package com.estsoft.practice_algo.stack;

public class FreeLinkedStack<E> implements Stack<E> {
  private FreeLink<E> top;
  private int size;

  public FreeLinkedStack() {
    this.top = null;
    this.size = 0;
  }

  public FreeLinkedStack(int size) {
    this.top = null;
    this.size = 0;
  }

  public void clear() {
    this.top = null;
    this.size = 0;
  }

  public void push(E el) {
    this.top = FreeLink.get(el, this.top);
    this.size++;
  }

  public E pop() {
    assert this.size != 0 : "Stack is empty";
    FreeLink<E> tempLink = this.top;
    E tempEl = this.top.element();
    this.top = this.top.next();
    tempLink.release();
    this.size--;
    return tempEl;
  }

  public E topValue() {
    assert this.size != 0 : "Stack is empty";
    return this.top.element();
  }

  public int length() {
    return this.size;
  }
}
