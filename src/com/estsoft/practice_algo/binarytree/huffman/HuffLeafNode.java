package com.estsoft.practice_algo.binarytree.huffman;

/**
 * Huffman tree node : Leaf class
 *
 * @param <E> Element for node
 */
public class HuffLeafNode<E> implements HuffBaseNode<E> {
  private E element;                //Element for this node
  private int weight;        //Weight for this node

  /**
   * Constructor
   */
  public HuffLeafNode(E el, int wt) {
    element = el;
    weight = wt;
  }

  /**
   * @return The element value
   */
  public E element() {
    return element;
  }

  @Override
  /** @return The weight */
  public int weight() {
    return weight;
  }

  @Override
  /** @return true */
  public boolean isLeaf() {
    return true;
  }


}
