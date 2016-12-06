package io.jaylim.study.dsa.binarytree;


import io.jaylim.study.dsa.binarytree.traverse.composite.CompIntlNode;
import io.jaylim.study.dsa.binarytree.traverse.composite.CompLeafNode;
import io.jaylim.study.dsa.binarytree.traverse.var.VarIntlNode;
import io.jaylim.study.dsa.binarytree.traverse.var.VarLeafNode;

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
