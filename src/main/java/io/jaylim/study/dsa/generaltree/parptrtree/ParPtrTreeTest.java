package io.jaylim.study.dsa.generaltree.parptrtree;

public class ParPtrTreeTest {
  public static void main(String[] args) {

    int size = 16;

    ParPtrTree ppTree = new ParPtrTree(size);

    for (int i = 0; i < size; i++) {
      System.out.println(i + ":" + ppTree.FIND(i));
    }

    ppTree.UNION(0, 2);
    ppTree.UNION(1, 2);
    ppTree.UNION(3, 4);
    ppTree.UNION(3, 1);
    ppTree.UNION(3, 5);
    ppTree.UNION(9, 11);
    ppTree.UNION(12, 14);
    ppTree.UNION(3, 9);
    ppTree.UNION(4, 14);
    ppTree.UNION(6, 7);
    ppTree.UNION(8, 10);
    ppTree.UNION(8, 7);
    ppTree.UNION(7, 0);
    ppTree.UNION(10, 15);
    ppTree.UNION(10, 13);

    for (int i = 0; i < size; i++) {
      System.out.println(i + ":" + ppTree.FIND(i));
    }
  }
}
