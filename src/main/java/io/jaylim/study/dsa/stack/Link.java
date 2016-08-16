package io.jaylim.study.dsa.stack;

public class Link<E> {
  private E element;
  private Link<E> next;

  public Link(E el, Link<E> nextLink) {
    this.element = el;
    this.next = nextLink;
  }

  public Link(Link<E> nextLink) {
    this(null, nextLink);
  }

  public E element() {
    return this.element;
  }

  public E setElement(E el) {
    return this.element = el;
  }

  public Link<E> next() {
    return this.next;
  }

  public Link<E> setNext(Link<E> nextLink) {
    return this.next = nextLink;
  }
}
