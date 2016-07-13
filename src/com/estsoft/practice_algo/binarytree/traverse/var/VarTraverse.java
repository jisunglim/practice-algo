package com.estsoft.practice_algo.binarytree.traverse.var;

import com.estsoft.practice_algo.binarytree.Visit;

public class VarTraverse {

  public static void Preorder(VarBinNode rt) {
    if (rt == null) return;
    if (rt.isLeaf()) {
      Visit.visitLeafNode((VarLeafNode) rt);
    } else {
      Visit.visitIntlNode((VarIntlNode) rt);
      Preorder(((VarIntlNode) rt).leftchild());
      Preorder(((VarIntlNode) rt).rightchild());
    }
  }

  public static void Postorder(VarBinNode rt) {
    if (rt == null) return;
    if (rt.isLeaf()) {
      Visit.visitLeafNode((VarLeafNode) rt);
    } else {
      Postorder(((VarIntlNode) rt).leftchild());
      Postorder(((VarIntlNode) rt).rightchild());
      Visit.visitIntlNode((VarIntlNode) rt);
    }
  }

  public static void Inorder(VarBinNode rt) {
    if (rt == null) return;
    if (rt.isLeaf()) {
      Visit.visitLeafNode((VarLeafNode) rt);
    } else {
      Inorder(((VarIntlNode) rt).leftchild());
      Visit.visitIntlNode((VarIntlNode) rt);
      Inorder(((VarIntlNode) rt).rightchild());
    }
  }
}
