package com.estsoft.practice_algo.list;

/**
 * The type Double linked list.
 *
 * @param <E> the type parameter
 */
public class DoubleLinkedList<E> implements List<E> {
  private DoubleLink<E> tail;
  private DoubleLink<E> head;
  private DoubleLink<E> curr;
  private int count;

  /**
   * Instantiates a new Double linked list.
   */
  public DoubleLinkedList() {
    this.curr = this.head = new DoubleLink<>(this.tail = new DoubleLink<>(null, null), null);
    this.tail.setPrev(this.head);
    this.count = 0;
  }

  /**
   * Instantiates a new Double linked list.
   *
   * @param size the size
   */
  public DoubleLinkedList(int size) {
    this();
  }

  /**
   * Re-initializes Double  linked list.
   */
  public void clear() {
    this.curr = this.head;
    this.head.setNext(this.tail);
    this.tail.setPrev(this.head);
    this.count = 0;
  }

  /**
   * Moves current position to the beginning of the list.
   */
  public void moveToStart() {
    this.curr = this.head;
  }

  /**
   * Moves current position to the end of the list.
   */
  public void moveToEnd() {
    this.curr = this.tail;
  }

  /**
   * Moves current position to the left.
   */
  public void prev() {
    if (this.curr != this.head) {
      this.curr = this.curr.prev();
    }
  }

  /**
   * Moves current position to the right.
   */
  public void next() {
    if (this.curr != this.tail) {
      this.curr = this.curr.next();
    }
  }

  /**
   * Moves current position to {@code pos}.
   */
  public void moveToPos(int pos) {
    this.curr = this.head;
    for (int i = 0; i < pos; i++) {
      this.curr = this.curr.next();
    }
  }

  /**
   * Return the index of the current position on the list.
   * @return index Index of the current position
   */
  public int currPos() {
    DoubleLink<E> temp = this.head;
    int idx;
    for (idx = 0; temp != this.curr; idx++) {
      temp = temp.next();
    }
    return idx;
  }

  /**
   * Inserts an item between two element in the list.
   * @param item The item <strong>to be inserted</strong> between two element in the list.
   */
  public void insert(E item) {
    if (this.curr == this.tail) {
      return;
    }
    this.curr.setNext(new DoubleLink<>(item, this.curr, this.curr.next()));
    this.curr.next().next().setPrev(this.curr.next());
    this.count++;
  }

  /**
   * Appends an item into the list after the list end.
   * @param item The item <strong>to be appended</strong> into the list after the list end.
   */
  public void append(E item) {
    this.tail.setPrev(new DoubleLink<>(item, this.tail, this.tail.prev()));
    this.tail.prev().prev().setNext(this.tail.prev());
    this.count++;
  }

  /**
   * Removes an element from the list, and return it.
   *
   * @return el The element removed from the list.
   */
  public E remove() {
    if (this.curr.next() == this.tail || this.curr == this.tail) {
      return null;
    }
    final E tempEl = this.curr.next().element();

    this.curr.setNext(this.curr.next().next());
    this.curr.next().setPrev(this.curr);
    count--;
    return tempEl;
  }

  /**
   * Return the value of the element on the current position in the list.
   *
   * @return value The value of the element on the current position.
   */
  public E getValue() {
    return this.curr.next().element();
  }

  /**
   * Return the length (or size) of the list.
   *
   * @return length The length of the list.
   */
  public int length() {
    return this.count;
  }

}
