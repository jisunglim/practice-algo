package io.jaylim.study.dsa.binarytree.heap;


/*
 * List implementation for heap structure
 * 
 * Indexing : 0, 1, 2, ..., k-1, k , k+1, ..., n-1 : maxSize = n;
 * items	: 0, 1, 2, ..., k-1 :currSize = k;
 * 
 * Position : p
 * 
 * isLeaf :		( k/2+1 <= p+1 <= k ) IMPLIES ( k/2 <= p <= k-1 )
 * 
 * isLeft :		( 1 <= p+1 <= k/2 ) IMPLIES ( 0 <= p <= (k/2)-1 )
 * isRight:		( 1 <= p+1 <= (k-1)/2) IMPLIES ( 0 <= p <= (k-1)/2 -1 )
 * 
 * Left:		q = (p+1)*2 = p*2 + 2
 * Right:		q = (p+1)*2 + 1 = p*2 + 3
 * 
 * isParent:	( 1 <= p+1 <= k ) IMPLIES ( 0 <= pos <= k-1 )
 * parent		q + 1 = p/2 ==> q = p/2 -1
 */

import io.jaylim.study.dsa.util.DSutil;

/**
 * Min-heap implementation.
 *
 * @param <E> Items in a heap structure
 * @author Jisung
 */
public class MinHeap<E extends Comparable<? super E>> {

  private E[] heap;                // Pointer to the heap array
  private int maxSize;        // Maximum size of the heap
  private int currSize;        // Number of things in heap

  /**
   * Constructor.
   */
  public MinHeap(E[] h, int curr) {
    heap = h;
    currSize = curr;
    maxSize = h.length;
  }

  /**
   * Constructor supporting preloading of heap structure.
   */
  public MinHeap(E[] h, int curr, int max) {
    heap = h;
    currSize = curr;
    maxSize = max;
  }

  /**
   * Return Current size of the heap.
   */
  public int heapSize() {
    return currSize;
  }

  /**
   * Return True if pos is a leaf in heap, false otherwise.
   */
  public boolean isLeaf(int pos) {
    return (currSize / 2 <= pos) && (pos <= currSize - 1);
  }
  // pos >= currSize/2 : leaf node, trivial lower bound
  // pos < currSize : trivial upper bound

  /**
   * .
   * Return Position for left child of <code>pos</code>
   */
  public int leftchild(int pos) {
    assert pos <= currSize / 2 - 1 : "Position has no left child";
    return 2 * (pos + 1);
  }

  /**
   * .
   * @return Position for right child of <code>pos</code>
   */
  public int rightchild(int pos) {
    assert pos <= (currSize - 1) / 2 - 1 : "Position has no left child";
    return 2 * (pos + 1) + 1;
  }

  /**
   * .
   * @return Position for parent of <code>pos</code>
   */
  public int parent(int pos) {
    assert (pos >= 0) && (pos <= currSize - 1) : "Unreachable position index";
    return pos / 2 - 1;
  }

  /**
   * Insert val into heap.
   */
  public void insert(E val) {
    assert currSize < maxSize : "heap is full";
    // place V at position n of the array. (Put it into the first empty position)
    int curr = currSize++;
    heap[curr] = val;
    // move V to the right place.
    // If ( V reaches the root ) OR ( V >= parent ) : Terminate the loop
    while ((curr != 0) && (heap[curr].compareTo(heap[parent(curr)]) < 0)) {
      DSutil.swap(heap, curr, parent(curr));
      curr = parent(curr);
    }
  }

  /**
   * Heapify contents of heap.
   */
  public void buildheap() {
    for (int i = currSize / 2 - 1; i >= 0; i--) {
      siftdown(i);
    }
  }


  /**
   * Put element in its correct place.
   *
   * @param pos Current position.
   */
  private void siftdown(int pos) {
    assert (pos >= 0) && (pos < currSize) : "Illegal heap position";
    while (!isLeaf(pos)) {
      int j = leftchild(pos);
      //IF there exists right child AND right > left :
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
   * Remove and return maximum value
   */
  public E removemin() {
    assert currSize > 0 : "heap is empty";
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
    assert currSize > 0 : "Removing from empty heap";
    assert (pos >= 0) && (pos < currSize) : "Illegal heap position";
    if (pos == (currSize - 1)) {
      currSize--;
    } else {
      DSutil.swap(heap, pos, --currSize);
      while ((pos > 0) && (heap[pos].compareTo(heap[parent(pos)]) < 0)) {
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
