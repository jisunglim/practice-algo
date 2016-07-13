package com.estsoft.practice_algo.binarytree.huffman;

/**
 * A Huffman Coding Tree
 */
public class HuffTree<E> implements Comparable<HuffTree<E>> {

  private HuffBaseNode<E> root; // Root of the tree

  /**
   * Constructor
   */
  public HuffTree(E el, int wt) {
    root = new HuffLeafNode<E>(el, wt);
  }

  public HuffTree(HuffBaseNode<E> l, HuffBaseNode<E> r, int wt) {
    root = new HuffIntlNode<E>(l, r, wt);
  }

  /**
   * @return The root node.
   */
  public HuffBaseNode<E> root() {
    return root;
  }

  /**
   * @return The weight of the root node
   */
  public int weight() {
    return root.weight();
  }

  @Override
  public int compareTo(HuffTree<E> that) {
    if (root.weight() < that.weight())
      return -1;
    else if (root.weight() > that.weight())
      return 1;
    else
      return 0;
  }
}
