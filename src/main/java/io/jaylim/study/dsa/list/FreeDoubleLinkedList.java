package io.jaylim.study.dsa.list;

public class FreeDoubleLinkedList<E> implements List<E> {

  private FreeDoubleLink<E> head;
  private FreeDoubleLink<E> tail;
  private FreeDoubleLink<E> curr;

  private int count;

  public FreeDoubleLinkedList() {
    this.curr = this.head = new FreeDoubleLink<E>(this.tail = new FreeDoubleLink<E>(null, null), null);
    this.tail.setPrev(this.head);
    this.count = 0;
  }

  public FreeDoubleLinkedList(int size) {
    this();
  }

  public void clear() {
    this.head.setNext(this.tail);
    this.curr = this.head;
    this.tail.setPrev(this.head);
  }

  public void moveToStart() {
    this.curr = this.head;
  }

  public void moveToEnd() {
    this.curr = this.tail;
  }

  public void prev() {
    if (this.curr == this.head) return;
    this.curr = this.curr.prev();
  }

  public void next() {
    if (this.curr == this.tail) return;
    this.curr = this.curr.next();
  }

  public void moveToPos(int pos) {
    assert 0 <= pos && pos <= this.count : "Position idex is out of bound";
    this.curr = this.head;
    for (int i = 0; i < pos; i++) {
      this.curr = this.curr.next();
    }
  }

  public int currPos() {
    FreeDoubleLink<E> temp = this.head;
    int i;
    for (i = 0; temp != this.curr; i++) {
      temp = temp.next();
    }
    return i;
  }

  public void insert(E item) {
    if (this.curr == this.tail) {
      return;
    }
    this.curr.setNext(FreeDoubleLink.get(item, this.curr.next(), this.curr));
    this.curr.next().next().setPrev(this.curr.next());
    this.count++;
  }

  public void append(E item) {
    this.tail.setPrev(FreeDoubleLink.get(item, this.tail, this.tail.prev()));
    this.tail.prev().prev().setNext(this.tail.prev());
    this.count++;
  }

  public E remove() {
    if (this.curr.next() == this.tail || this.curr == this.tail) {
      return null;
    }

    final E tempEl = this.curr.next().element();

    FreeDoubleLink<E> tempLink = this.curr.next();
    this.curr.setNext(this.curr.next().next());
    this.curr.next().setPrev(this.curr);
    tempLink.release();
    this.count--;

    return tempEl;
  }

  public E getValue() {
    return this.curr.next().element();
  }

  public int length() {
    return this.count;
  }
}
