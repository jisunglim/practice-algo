package io.jaylim.study.dsa.binarytree.traverse.var;

public class VarIntlNode implements VarBinNode {

  // 1.
  private VarBinNode left;
  private VarBinNode right;
  private Character operator;

  // 2.
  public VarIntlNode(Character op, VarBinNode l, VarBinNode r) {
    left = l;
    right = r;
    operator = op;
  }

  // 3.
  public VarBinNode leftchild() {
    return left;
  }

  public VarBinNode rightchild() {
    return right;
  }

  public Character value() {
    return operator;
  }

  @Override
  public boolean isLeaf() {
    // TODO Auto-generated method stub
    return false;
  }
}
