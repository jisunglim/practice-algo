package io.jaylim.study.dsa.binarytree.bst;

import io.jaylim.study.dsa.binarytree.BSTNode;
import io.jaylim.study.dsa.dictionary.Dictionary;

public class BST<Key extends Comparable<? super Key>, E> implements Dictionary<Key, E> {

  private BSTNode<Key, E> root;
  private int nodeCount;

  /**
   * Constructor
   */
  public BST() {
    root = null;
    nodeCount = 0;
  }

  /**
   * Re-initializer
   */
  @Override
  public void clear() {
    root = null;
    nodeCount = 0;
  }

  @Override
  /**Insert a record into the tree.
   * @param k Key value of the record.
   * @param e The record to insert. */
  public void insert(Key k, E e) {
    root = insertHelp(root, k, e);
    nodeCount++;
  }

  @Override
  /**Remove a record from the tree.
   * @param k Key value of record to remove.
   * @return The record removed, null if there is none.
   */
  public E remove(Key k) {
    E temp = findHelp(root, k);
    if (temp != null) {
      root = removeHelp(root, k);
      nodeCount--;
    }
    return temp;
  }

  @Override
  /**Remove and return the root node from the io.jaylim.study.dsa.dictionary.
   * @return The record removed, null if tree is empty.
   */
  public E removeAny() {
    if (root == null) return null;
    E temp = root.element();
    root = removeHelp(root, root.key());
    nodeCount--;
    return temp;
  }

  @Override
  /**@return Record with key value k, null if none exist.
   * @param k The key value to find. */
  public E find(Key k) {
    return findHelp(root, k);
  }

  @Override
  /** @return The number of records in the io.jaylim.study.dsa.dictionary. */
  public int size() {
    return nodeCount;
  }


  private E findHelp(BSTNode<Key, E> rt, Key k) {
    if (rt == null) return null;
    if (rt.key().compareTo(k) > 0)
      return findHelp(rt.left(), k);
    else if (rt.key().compareTo(k) == 0)
      return rt.element();
    else
      return findHelp(rt.right(), k);
  }

  private BSTNode<Key, E> insertHelp(BSTNode<Key, E> rt, Key k, E e) {
    if (rt == null)
      return new BSTNode<Key, E>(k, e);
    if (rt.key().compareTo(k) > 0)
      rt.setLeft(insertHelp(rt.left(), k, e));
    else
      rt.setRight(insertHelp(rt.right(), k, e));

    return rt;
  }

  private BSTNode<Key, E> removeHelp(BSTNode<Key, E> rt, Key k) {

    if (rt == null) return null;

    if (rt.key().compareTo(k) > 0)
      rt.setLeft(removeHelp(rt.left(), k));
    else if (rt.key().compareTo(k) < 0)
      rt.setRight(removeHelp(rt.right(), k));
    else {

      if (rt.left() == null)
        return rt.right();
      else if (rt.right() == null)
        return rt.left();
      else {
        BSTNode<Key, E> temp = getMin(rt.right());
        rt.setElement(temp.element());
        rt.setKet(temp.key());
        rt.setRight(deleteMin(rt.right()));

      }
    }
    return rt;
  }

  private BSTNode<Key, E> deleteMin(BSTNode<Key, E> rt) {
    if (rt.left() == null) return rt.right();
    rt.setLeft(deleteMin(rt.left()));
    return rt;
  }

  private BSTNode<Key, E> getMin(BSTNode<Key, E> rt) {
    if (rt.left() == null) return rt;
    return getMin(rt.left());
  }
}
