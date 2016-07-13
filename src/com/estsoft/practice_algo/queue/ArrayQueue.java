package com.estsoft.practice_algo.queue;

public class ArrayQueue<E> implements Queue<E> {
  private static final int DEFAULT_SIZE = 20;
  private int maxSize;
  private int front;
  private int rear;
  private E[] listArray;

  public ArrayQueue() {
    this(DEFAULT_SIZE);
  }

  @SuppressWarnings("unchecked")
  public ArrayQueue(int size) {
    this.maxSize = size + 1;
    this.front = 1;
    this.rear = 0;
    this.listArray = (E[]) new Object[maxSize];
  }

  public void clear() {
    this.front = 1;
    this.rear = 0;
  }

  public void enqueue(E item) {
    assert (this.rear + 2) % this.maxSize != this.front % this.maxSize : "queue is full";
    this.rear = (this.rear + 1) % this.maxSize;
    this.listArray[rear] = item;
  }

  public E dequeue() {
    assert this.length() != 0 : "queue is empty";
    E tempEl = this.listArray[this.front];
    this.front = (this.front + 1) % this.maxSize;
    return tempEl;
  }

  public E frontValue() {
    assert this.length() != 0 : "queue is empty";
    return this.listArray[this.front];
  }

  public int length() {
    return ((this.rear + this.maxSize) - this.front + 1) % this.maxSize;
  }
}
