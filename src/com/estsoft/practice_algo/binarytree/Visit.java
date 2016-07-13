package com.estsoft.practice_algo.binarytree;

import com.estsoft.practice_algo.binarytree.traverse.composite.CompIntlNode;
import com.estsoft.practice_algo.binarytree.traverse.composite.CompLeafNode;
import com.estsoft.practice_algo.binarytree.traverse.var.VarIntlNode;
import com.estsoft.practice_algo.binarytree.traverse.var.VarLeafNode;

public class Visit {
  public static void visitLeafNode(VarLeafNode leaf) {
    System.out.println("leaf node" + leaf.value());
  }

  public static void visitIntlNode(VarIntlNode intl) {
    System.out.println("Internal node" + intl.value());
  }


  public static void visitLeafNode(CompLeafNode leaf) {
    System.out.println("leaf node" + leaf.value());
  }

  public static void visitIntlNode(CompIntlNode intl) {
    System.out.println("Internal node" + intl.value());
  }
}
