package com.estsoft.practice_algo.generaltree.loc;

import com.estsoft.practice_algo.generaltree.GTNode;
import com.estsoft.practice_algo.generaltree.GenTree;
import com.estsoft.practice_algo.list.ArrayList;
import com.estsoft.practice_algo.list.LinkedList;


//This comments stands for testing intellij commit.

public class ListOfChildGenTree<E> implements GenTree<E> {

  private static final Integer DEFAULT_SIZE = 15;

  //Field variables
  private ArrayList<E> value;
  private ArrayList<Integer> parent;
  private ArrayList<LinkedList<E>> children;

  public ListOfChildGenTree() {
    value = new ArrayList<>(DEFAULT_SIZE);
    parent = new ArrayList<>(DEFAULT_SIZE);
    children = new ArrayList<>(DEFAULT_SIZE);
  }

  public ListOfChildGenTree(int size) {
    value = new ArrayList<>(size);
    parent = new ArrayList<>(size);
    children = new ArrayList<>(size);
  }

  @Override
  public void clear() {

  }

  @Override
  public GTNode<E> root() {

    return null;
  }

  @Override
  public void newroot(E value, GTNode<E> first, GTNode<E> sib) {
    // TODO Auto-generated method stub

  }

  @Override
  public void newleftchild(E value) {
    // TODO Auto-generated method stub
  }
}
