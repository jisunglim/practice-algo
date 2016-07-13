package com.estsoft.practice_algo.generaltree.parptrtree;

/**
 * General Tree class implementation for UNION/FIND
 */
public class ParPtrTree {
  private Integer[] array;    //Node array

  /**
   * Constructor
   */
  public ParPtrTree(int size) {
    // Create array
    array = new Integer[size];
    // Initializing the array with NULL value.
    for (int i = 0; i < size; i++) {
      array[i] = null;
    }
  }

  public boolean differ(int a, int b) {
    Integer root1 = FIND(a);
    Integer root2 = FIND(b);
    return (root1 != root2);
  }

  public void UNION(int a, int b) {
    Integer root1 = FIND(a);
    Integer root2 = FIND(b);
    if (root1 != root2) {
      array[root2] = root1;
    }
  }

  public Integer FIND(Integer curr) {
    while (array[curr] != null) {
      curr = array[curr];
    }
    return curr;
  }
}
