package com.estsoft.practice_algo.list;

/**
 * The type Linked list.
 *
 * @param <E> the type parameter
 */
public class LinkedList<E> implements List<E> {
  private Link<E> head;
  private Link<E> curr;
  private Link<E> tail;

  private int count;

  /**
   * Instantiates a new Linked list.
   */
  public LinkedList() {
    head = tail = curr = new Link<>(null);
    count = 0;
  }

  /**
   * Instantiates a new Linked list.
   * <p/>
   * Parameter size might be ignored.
   *
   * @param size the size
   */
  public LinkedList(int size) {
    this();
  }

  /**
   * <strong>Clear</strong> all the element in the list and <strong>re-initialize</strong> the
   * list.
   */
  public void clear() {
    head.setNext(null);
    tail = curr = head;
    count = 0;
  }

  /**
   * Move the <strong>current position</strong> to <strong>start</strong> point.
   */
  public void moveToStart() {
    this.curr = this.head;
  }

  /**
   * Move the <strong>current position</strong> to <strong>end</strong> point.
   */
  public void moveToEnd() {
    this.curr = this.tail;
  }

  /**
   * Move the <strong>current position</strong> to its <strong>previous</strong> one.
   */
  public void prev() {
    if (this.curr == this.head) {
      return;
    }
    Link<E> temp = this.head;

    while (temp.next() != this.curr) {
      temp = temp.next();
    }
    this.curr = temp;
  }

  /**
   * Move the <strong>current position</strong> to its <strong>next</strong> one.
   */
  public void next() {
    if (this.curr != this.tail) {
      this.curr = this.curr.next();
    }
  }

  /**
   * Move the <strong>current position</strong> to the position specified by its
   * <strong><code>pos</code></strong>.
   *
   * @param pos The position specified by index <code>pos</code>.
   */
  public void moveToPos(int pos) {
    assert 0 <= pos && pos <= this.count : "Position index is out of bound";
    Link<E> temp = this.head;
    for (int i = 0; i < pos; i++) {
      temp = temp.next();
    }
  }

  /**
   * Retrieve the index value of the current position.
   *
   * @return The index value of the <strong>current position</strong>.
   */
  public int currPos() {
    Link<E> temp = this.head;
    int idx;
    for (idx = 0; temp != this.curr; idx++) {
      temp = temp.next();
    }
    return idx;
  }

  /**
   * <strong>Add</strong> the new item into the array <strong>between current position and its next
   * position</strong>.
   *
   * @param item The item <strong>to be inserted</strong> between two element in the list.
   */
  public void insert(E item) {
    this.curr.setNext(new Link<>(item, this.curr.next()));
    if (this.curr == this.tail) {
      this.tail = this.curr.next();
    }
    count++;
  }

  /**
   * <strong>Add</strong> the new element after the <strong>end</strong> of the list.
   *
   * @param item The item <strong>to be appended</strong> into the list after the list end.
   */
  public void append(E item) {
    this.tail.setNext(new Link<>(item, this.tail.next()));
    this.tail = this.tail.next();
    count++;
  }

  /**
   * <strong>Delete</strong> the existing element which is <strong>on the current
   * position</strong>.
   *
   * @return The value of the element <strong>to be deleted</strong>
   */
  public E remove() {
    if (this.curr == this.tail) {
      return null;
    }
    E tempEl = this.curr.next().element();
    this.curr.setNext(this.curr.next().next());
    count--;
    return tempEl;
  }

  /**
   * Return the value of the element which is <strong>on the current position</strong>.
   *
   * @return The value of the element <strong>on the current position</strong>
   */
  public E getValue() {
    if (this.curr == this.tail) {
      return null;
    }
    return this.curr.next().element();
  }

  /**
   * Return <strong>the number of element</strong> contained in the list.
   */
  public int length() {
    return this.count;
  }
}
