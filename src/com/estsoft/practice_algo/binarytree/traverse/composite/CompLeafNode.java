package com.estsoft.practice_algo.binarytree.traverse.composite;

import com.estsoft.practice_algo.binarytree.Visit;

public class CompLeafNode implements CompBinNode {
  private String operand;

  public CompLeafNode(String op) {
    operand = op;
  }

  @Override
  public boolean isLeaf() {
    return true;
  }

  public String value() {
    return operand;
  }

  @Override
  public void preorder() {
    Visit.visitLeafNode(this);
  }

  @Override
  public void postorder() {
    Visit.visitLeafNode(this);
  }

  @Override
  public void inorder() {
    Visit.visitLeafNode(this);
  }
}
