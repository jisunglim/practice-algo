package io.jaylim.study.dsa.binarytree.traverse.composite;


import io.jaylim.study.dsa.binarytree.Visit;

public class CompIntlNode implements CompBinNode {
  private CompBinNode left;
  private CompBinNode right;
  private Character operator;

  public CompIntlNode(Character op, CompBinNode l, CompBinNode r) {
    operator = op;
    left = l;
    right = r;
  }


  public CompBinNode leftchild() {
    return left;
  }

  public CompBinNode rightchild() {
    return right;
  }

  public Character value() {
    return operator;
  }

  @Override
  public boolean isLeaf() {
    return false;
  }


  @Override
  public void preorder() {
    Visit.visitIntlNode(this);
    if (left != null) left.preorder();
    if (right != null) right.preorder();
  }

  @Override
  public void postorder() {
    if (left != null) left.postorder();
    if (right != null) right.postorder();
    Visit.visitIntlNode(this);
  }

  @Override
  public void inorder() {
    if (left != null) left.inorder();
    Visit.visitIntlNode(this);
    if (right != null) right.inorder();
  }
}
