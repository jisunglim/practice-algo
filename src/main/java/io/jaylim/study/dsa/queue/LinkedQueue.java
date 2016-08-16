package io.jaylim.study.dsa.queue;

public class LinkedQueue<E> implements Queue<E> {

  private Link<E> front;
  private Link<E> rear;
  private int size;

  public LinkedQueue() {
    init();
  }

  public LinkedQueue(int size) {
    init();
  }

  public void clear() {
    init();
  }

  public void init() {
    front = rear = new Link<E>(null);
    size = 0;
  }

  public void enqueue(E item) {
    rear = rear.setNext(new Link<E>(item, null));
    size++;
  }

  public E dequeue() {
    assert size != 0 : "io.jaylim.study.dsa.queue is empty";
    E temp = front.next().element();
    front.setNext(front.next().next());
    if (front.next() == null) rear = front;
    size--;
    return temp;
  }

  public E frontValue() {
    assert size != 0 : "io.jaylim.study.dsa.queue is empty";
    return front.next().element();
  }

  public int length() {
    return size;
  }
}
