package com.estsoft.practice_algo.binarytree.traverse.composite;

public class CompTraverse {
  public static void preorder(CompBinNode rt) {
    if (rt != null) rt.preorder();
  }

  public static void postorder(CompBinNode rt) {
    if (rt != null) rt.postorder();
  }

  public static void inorder(CompBinNode rt) {
    if (rt != null) rt.inorder();
  }
}
