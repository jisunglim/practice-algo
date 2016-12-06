package io.jaylim.study.dsa.queue;

public class FreeLinkedQueue<E> implements Queue<E> {
  private FreeLink<E> front;
  private FreeLink<E> rear;
  private int size;

  public FreeLinkedQueue() {
    init();
  }

  public FreeLinkedQueue(int size) {
    init();
  }

  public void clear() {
    init();
  }

  public void init() {
    front = rear = FreeLink.get(null, null);
    size = 0;
  }

  public void enqueue(E item) {
    rear = rear.setNext(FreeLink.get(item, null));
    size++;
  }

  public E dequeue() {
    assert size != 0 : "io.jaylim.study.dsa.queue is empty";
    FreeLink<E> tempLink = front.next();
    E tempEl = front.next().element();
    front.setNext(front.next().next());
    if (front.next() == null) rear = front;
    tempLink.release();
    size--;
    return tempEl;
  }

  public E frontValue() {
    assert size != 0 : "io.jaylim.study.dsa.queue is empty";
    return front.next().element();
  }

  public int length() {
    return size;
  }
}
