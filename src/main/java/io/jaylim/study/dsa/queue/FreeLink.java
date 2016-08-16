package io.jaylim.study.dsa.queue;

public class FreeLink<E> {
  private E element;
  private FreeLink<E> next;

  public FreeLink(E el, FreeLink<E> nextLink) {
    this.element = el;
    this.next = nextLink;
  }

  public FreeLink(FreeLink<E> nextLink) {
    this(null, nextLink);
  }

  public E element() {
    return this.element;
  }

  public E setElement(E item) {
    return this.element = item;
  }

  public FreeLink<E> next() {
    return this.next;
  }

  public FreeLink<E> setNext(FreeLink<E> nextLink) {
    return this.next = nextLink;
  }

  //
  @SuppressWarnings("rawtypes")
  private static FreeLink freeQueue = null;

  @SuppressWarnings("unchecked")
  public static <E> FreeLink<E> get(E el, FreeLink<E> nextLink) {
    if (freeQueue == null) return new FreeLink<E>(el, nextLink);
    FreeLink<E> tempLink = freeQueue;
    freeQueue = freeQueue.next();
    tempLink.element = el;
    tempLink.next = nextLink;
    return tempLink;
  }

  @SuppressWarnings("unchecked")
  public void release() {
    this.element = null;
    this.next = freeQueue;
    freeQueue = this;
  }
}