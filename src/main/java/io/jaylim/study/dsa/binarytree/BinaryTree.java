package io.jaylim.study.dsa.binarytree;

public interface BinaryTree<E> {

  /**
   * Re-initialize the tree
   */
  public void clear();

  public boolean isEmpty();

  /**
   * @return The root of the tree
   */
  public BinNode<E> root();

  /**
   * Make the tree have a new root
   */
  public void newroot(E value, BinNode<E> left, BinNode<E> right);

  /**
   * Add left subtree
   */
  public void setLeft(BinNode<E> left);

  /**
   * Add right subtree
   */
  public void setRight(BinNode<E> right);
}
