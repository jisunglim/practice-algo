package io.jaylim.study.dsa.list;

public class FreeDoubleLink<E> {
  private E element;
  private FreeDoubleLink<E> next;
  private FreeDoubleLink<E> prev;

  public FreeDoubleLink(E el, FreeDoubleLink<E> nextLink, FreeDoubleLink<E> prevLink) {
    this.element = el;
    this.next = nextLink;
    this.prev = prevLink;
  }

  public FreeDoubleLink(FreeDoubleLink<E> nextLink, FreeDoubleLink<E> prevLink) {
    this(null, nextLink, prevLink);
  }

  public E element() {
    return this.element;
  }

  public E setElement(E el) {
    return this.element = el;
  }

  public FreeDoubleLink<E> next() {
    return this.next;
  }

  public FreeDoubleLink<E> setNext(FreeDoubleLink<E> nextLink) {
    return this.next = nextLink;
  }

  public FreeDoubleLink<E> prev() {
    return this.prev;
  }

  public FreeDoubleLink<E> setPrev(FreeDoubleLink<E> prevLink) {
    return this.prev = prevLink;
  }

  //
  @SuppressWarnings("rawtypes")
  private static FreeDoubleLink freeList = null;

  @SuppressWarnings("unchecked")
  public static <E> FreeDoubleLink<E> get(E el, FreeDoubleLink<E> nextLink, FreeDoubleLink<E> prevLink) {
    if (freeList == null) return new FreeDoubleLink<E>(el, nextLink, prevLink);
    FreeDoubleLink<E> temp = freeList;
    freeList = freeList.next;
    temp.element = el;
    temp.next = nextLink;
    temp.prev = prevLink;
    return temp;
  }

  @SuppressWarnings("unchecked")
  public void release() {
    this.element = null;
    this.prev = null;

    this.next = freeList;
    freeList = this;
  }
}
