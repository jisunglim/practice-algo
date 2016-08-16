package io.jaylim.study.dsa.binarytree.heap;


import io.jaylim.study.dsa.util.DSutil;

/**
 * Max-heap implementation.
 *
 * @author Jisung
 */
public class MaxHeap<E extends Comparable<? super E>> {

  // Three parameter
  private E[] heap;
  private int maxSize;
  private int currSize;


  /**
   * Constructor supporting preloading of heap contents.
   */
  public MaxHeap(E[] h, int curr, int max) {
    heap = h;
    currSize = curr;
    maxSize = max;
    buildheap();
  }

  /**
   * .
   * @return Current size of the heap
   */
  public int heapSize() {
    return currSize;
  }

  /**
   * .
   * @return <code><b>true</b></code> if <code><b>pos</b></code> a leaf position, <br>
   * <code><b>false</b></code> other wise
   */
  public boolean isLeaf(int pos) {
    return (pos >= currSize / 2) && (pos < currSize);
  }

  /**
   * .
   * @return Position for left child of <code>pos</code>
   */
  public int leftchild(int pos) {
    assert pos < currSize / 2 : "Position has no left child";
    return 2 * pos + 1;
  }

  /**
   * .
   * @return Position for right child of <code>pos</code>
   */
  public int rightchild(int pos) {
    assert pos < (currSize - 1) / 2 : "Position has no right child";
    return 2 * pos + 2;
  }

  /**
   * .
   * @return Position for parent
   */
  public int parent(int pos) {
    assert pos > 0 : "Position has no parent";
    return (pos - 1) / 2;
  }

	/*
   * Method insert will insert a new element V into the heap.
	 * 
	 * BST-like insert approach is not likely to work because the heap must
	 * maintain the shape of a complete binary tree.
	 * 
	 * Equivalently, if the heap takes up the first n positions of its array
	 * prior to the call to insert, it must take up the first n+1 position after.
	 * 
	 * To accomplish this, 
	 * 	[1st]	place V at position n of the array. (Put it into the last seat.)
	 * 	[2nd]	move V to the right place.
	 * 		[2-1] Compare the value of V with the one of its parent
	 * 		[2-2] if V  > parent : SWAP and go back to [2-1]
	 * 		[2-3] if V <= parent : Terminate the loop
	 */

  /**
   * Insert val into heap.
   */
  public void insert(E val) {
    assert currSize < maxSize : "heap is full";
    int curr = currSize++;
    heap[curr] = val;
    while ((curr != 0) && (heap[curr].compareTo(heap[parent(curr)]) > 0)) {
      DSutil.swap(heap, curr, parent(curr));
      curr = parent(curr);
    }
  }

  /**
   * Heapify cotents of heap.
   */
  public void buildheap() {
    for (int i = currSize / 2 - 1; i >= 0; i--) {
      siftdown(i);
    }
  }

  /**
   * Put element in its correct place.
   */
  private void siftdown(int pos) {
    assert (pos >= 0) && (pos < currSize) : "Illegal heap position";
    while (!isLeaf(pos)) {
      int j = leftchild(pos);
      if ((j < (currSize - 1)) && (heap[j].compareTo(heap[j + 1]) < 0)) {
        j++;
      }
      if (heap[pos].compareTo(heap[j]) >= 0) {
        return;
      }
      DSutil.swap(heap, pos, j);
      pos = j;
    }
  }

  /**
   * Remove and return maximum value.
   */
  public E removemax() {
    assert currSize > 0 : "Removing from empty heap";
    DSutil.swap(heap, 0, --currSize);
    if (currSize != 0) {
      siftdown(0);
    }
    return heap[currSize];
  }

  /**
   * Remove and return element at specified position.
   */
  public E remove(int pos) {
    assert (pos >= 0) && (pos < currSize) : "Illegal heap position";
    if (pos == (currSize - 1)) {
      currSize--;
    } else {
      DSutil.swap(heap, pos, --currSize);
      while ((pos > 0) && (heap[pos].compareTo(heap[parent(pos)]) > 0)) {
        DSutil.swap(heap, pos, parent(pos));
        pos = parent(pos);
      }
      if (currSize != 0) {
        siftdown(pos);
      }
    }
    return heap[currSize];
  }
}
