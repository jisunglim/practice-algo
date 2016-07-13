package com.estsoft.practice_algo.list;

public class DoubleLink<E> {
  private E element;
  private DoubleLink<E> next;
  private DoubleLink<E> prev;

  public DoubleLink(E el, DoubleLink<E> nextLink, DoubleLink<E> prevLink) {
    this.element = el;
    this.next = nextLink;
    this.prev = prevLink;
  }

  public DoubleLink(DoubleLink<E> nextLink, DoubleLink<E> prevLink) {
    this(null, nextLink, prevLink);
  }

  public E element() {
    return this.element;
  }

  public E setElement(E el) {
    return this.element = el;
  }

  public DoubleLink<E> next() {
    return this.next;
  }

  public DoubleLink<E> setNext(DoubleLink<E> nextLink) {
    return this.next = nextLink;
  }

  public DoubleLink<E> prev() {
    return this.prev;
  }

  public DoubleLink<E> setPrev(DoubleLink<E> prevLink) {
    return this.prev = prevLink;
  }
}
