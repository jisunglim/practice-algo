package io.jaylim.study.dsa.list;

public class FreeLinkedList<E> implements List<E> {
  private FreeLink<E> head;
  private FreeLink<E> tail;
  private FreeLink<E> curr;

  private int count;

  public FreeLinkedList() {
    head = tail = curr = new FreeLink<E>(null);
    count = 0;
  }

  public FreeLinkedList(int size) {
    this();
  }

  public void clear() {
    head.setNext(null);
    tail = curr = head;
    count = 0;
  }

  public void moveToStart() {
    this.curr = this.head;
  }

  public void moveToEnd() {
    this.curr = this.tail;
  }

  public void prev() {
    if (this.curr == this.head) return;
    FreeLink<E> temp = this.head;
    while (temp != this.curr) {
      temp = temp.next();
    }
    this.curr = temp;
  }

  public void next() {
    if (this.curr == this.tail) return;
    this.curr = this.curr.next();
  }

  public void moveToPos(int pos) {
    assert 0 <= pos && pos <= this.count : "Position index is out of bound";
    this.curr = this.head;
    for (int i = 0; i < pos; i++) {
      this.curr = this.curr.next();
    }
  }

  public int currPos() {
    FreeLink<E> temp = this.head;
    int i;
    for (i = 0; temp != this.curr; i++) {
      temp = temp.next();
    }
    return i;
  }

  public void insert(E item) {
    this.curr.setNext(FreeLink.get(item, this.curr.next()));
    if (this.curr == this.tail) this.tail = this.curr.next();
  }

  public void append(E item) {
    this.tail.setNext(FreeLink.get(item, this.tail.next()));
    this.tail = this.tail.next();
  }

  public E remove() {
    if (this.curr == this.tail) return null;
    E tempEl = this.curr.next().element();
    FreeLink<E> tempLink = this.curr.next();
    this.curr.setNext(this.curr.next().next());
    tempLink.release();
    return tempEl;
  }

  public E getValue() {
    if (this.curr == this.tail) return null;
    return this.curr.next().element();
  }

  public int length() {
    return 0;
  }
}