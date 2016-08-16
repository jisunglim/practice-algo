package io.jaylim.study.dsa.dictionary;

public class KVpair<Key, E> {
  private Key k;
  private E e;

  public KVpair() {
    k = null;
    e = null;
  }

  public KVpair(Key kval, E eval) {
    k = kval;
    e = eval;
  }

  /**
   * Data member access functions
   */
  public Key key() {
    return k;
  }

  public E value() {
    return e;
  }
}
