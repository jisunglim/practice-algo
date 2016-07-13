package com.estsoft.practice_algo.list;

public class Link<E> {
  private E element;
  private Link<E> next;

  public Link(Link<E> nextLink) {
    this(null, nextLink);
  }

  public Link(E el, Link<E> nextLink) {
    this.element = el;
    this.next = nextLink;
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
