package io.jaylim.study.dsa.dictionary;


import io.jaylim.study.dsa.list.ArrayList;

/**
 * Unsorted Array-based List Implementation
 */
public class UALdictionary<Key, E> implements Dictionary<Key, E> {
  private static final int DEFAULT_SIZE = 20;
  private ArrayList<KVpair<Key, E>> list;

  public UALdictionary() {
    this(DEFAULT_SIZE);
  }

  public UALdictionary(int size) {
    list = new ArrayList<KVpair<Key, E>>(size);
  }

  public void clear() {
    list.clear();
  }

  public void insert(Key key, E el) {
    KVpair<Key, E> temp = new KVpair<Key, E>(key, el);
    list.append(temp);
  }

  public E remove(Key key) {
    E temp = find(key);
    if (temp != null) list.remove();
    return temp;
  }

  public E removeAny() {
    if (size() != 0) {
      list.moveToEnd();
      list.prev();
      KVpair<Key, E> e = list.remove();
      return e.value();
    } else return null;
  }

  public E find(Key key) {
    for (list.moveToStart(); list.currPos() < list.length(); list.next()) {
      KVpair<Key, E> temp = list.getValue();
      if (key == temp.key()) {
        return temp.value();
      }
    }
    return null;
  }

  public int size() {
    return list.length();
  }
}
