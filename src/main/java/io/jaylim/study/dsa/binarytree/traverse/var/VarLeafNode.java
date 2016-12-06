package io.jaylim.study.dsa.binarytree.traverse.var;

public class VarLeafNode implements VarBinNode {

  // 1.
  private String operand;

  // 2.
  public VarLeafNode(String val) {
    operand = val;
  }

  // 3.
  @Override
  public boolean isLeaf() {
    return true;
  }

  public String value() {
    return operand;
  }
}
