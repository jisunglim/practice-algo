package com.estsoft.practice_algo.list;

public class FreeLink<E> {
  private E element;
  private FreeLink<E> next;

  public FreeLink(FreeLink<E> nextLink) {
    this(null, nextLink);
  }

  public FreeLink(E el, FreeLink<E> nextLink) {
    this.element = el;
    this.next = nextLink;
  }

  public E element() {
    return this.element;
  }

  public E setElement(E el) {
    return this.element = el;
  }

  public FreeLink<E> next() {
    return this.next;
  }

  public FreeLink<E> setNext(FreeLink<E> nextLink) {
    return this.next = nextLink;
  }

  //
  @SuppressWarnings("rawtypes")
  private static FreeLink freeList = null;

  @SuppressWarnings("unchecked")
  public static <E> FreeLink<E> get(E el, FreeLink<E> nextLink) {
    if (freeList == null) return new FreeLink<E>(el, nextLink);
    FreeLink<E> temp = freeList;
    freeList = freeList.next;
    temp.element = el;
    temp.next = nextLink;
    return temp;
  }

  @SuppressWarnings("unchecked")
  public void release() {
    this.element = null;
    this.next = freeList;
    freeList = this;
  }
}
