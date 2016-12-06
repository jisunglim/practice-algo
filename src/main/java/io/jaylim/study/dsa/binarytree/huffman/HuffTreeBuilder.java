package io.jaylim.study.dsa.binarytree.huffman;

import io.jaylim.study.dsa.binarytree.heap.MinHeap;

public class HuffTreeBuilder {

  static <E> HuffTree<E> buildTree(HuffTree<E>[] h, int num, int max) {
    MinHeap<HuffTree<E>> Hheap = new MinHeap<HuffTree<E>>(h, num, max);
    return buildTree(Hheap);
  }

  static <E> HuffTree<E> buildTree(MinHeap<HuffTree<E>> Hheap) {
    HuffTree<E> tmp1, tmp2, tmp3 = null;

    while (Hheap.heapSize() > 1) {
      tmp1 = Hheap.removemin();
      tmp2 = Hheap.removemin();
      tmp3 = new HuffTree<E>(tmp1.root(), tmp2.root(), tmp1.weight() + tmp2.weight());

      Hheap.insert(tmp3);
    }
    return tmp3;
  }
}
