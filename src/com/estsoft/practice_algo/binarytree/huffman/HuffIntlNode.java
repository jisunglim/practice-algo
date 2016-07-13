package com.estsoft.practice_algo.binarytree.huffman;

/**
 * Huffman tree node : Internal class
 *
 * @param <E> Element for node
 */
public class HuffIntlNode<E> implements HuffBaseNode<E> {
  private int weight;      // Weight (sum of children)
  private HuffBaseNode<E> left;  // Pointer to left child
  private HuffBaseNode<E> right;  // Pointer to right child

  /**
   * Constructor
   */
  public HuffIntlNode(HuffBaseNode<E> l, HuffBaseNode<E> r, int wt) {
    left = l;
    right = r;
    weight = wt;
  }

  /**
   * @return The left child node
   */
  public HuffBaseNode<E> left() {
    return left;
  }

  /**
   * @return The right child node
   */
  public HuffBaseNode<E> right() {
    return right;
  }

  @Override
  /** @return The weight */
  public int weight() {
    return weight;
  }

  @Override
  /** @return false */
  public boolean isLeaf() {
    return false;
  }

}
