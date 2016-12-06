package io.jaylim.study.dsa.binarytree;

/* 1. Pointer-based Binary Tree Node Implementation
 * 	- (1) Binary Tree Nodes typically contain
 * 		i)	Value field
 * 		ii)	Pointers to the two children
 * 		
 * 	- (2) Value Field includes
 * 		i)	Element : A data member of type E
 * 					  To store element value
 * 		ii)	Key		: A data member of type Key
 * 					  To support search structure
 * 
 * 	- (3) Pointer-based Node Implementation has an issue with
 * 		i)	Upward pointer
 * 				If a pointer to parent node is needed, add it. BUT,
 * 				- Almost always, unnecessary.
 * 				- Space overhead
 * 				- Usually driven by improper understanding of recursion***
 * 
 * 		ii)	Consistency of class definition between leaf nodes and internal nodes
 * 			 (1) Using the same class definition
 * 				 * leaf and internal node must have the same type of element
 * 				 + Simple implementation
 * 				 - Space overhead, inefficient
 * 			 (2) Separate the class definition
 * 				 * leaf and internal node can have different type of element
 * 				 + Space efficient
 */

public class BSTNode<Key, E> implements BinNode<E> {
  /* 1. Field Variables
   * Binary Tree Nodes typically contain
   * 	- Value field (Key, Element)
   *  - Pointers to the two children (Left, Right)
   */
  private E element;
  private Key key;
  private BSTNode<Key, E> left;
  private BSTNode<Key, E> right;
//	private BSTNode<Key, E> parent;

  /* 2. Constructor
   *
   */
  public BSTNode() {
    left = right = null;
  }

  public BSTNode(Key k, E val) {
    left = right = null;
    key = k;
    element = val;
  }

  public BSTNode(Key k, E val, BSTNode<Key, E> l, BSTNode<Key, E> r) {
    left = l;
    right = r;
    key = k;
    element = val;
  }

  // 3. Key
  public Key key() {
    return key;
  }

  public void setKet(Key k) {
    key = k;
  }

  // 4. Element
  @Override
  public E element() {
    return element;
  }

  @Override
  public void setElement(E el) {
    element = el;
  }

  // 5. Left
  @Override
  public BSTNode<Key, E> left() {
    return left;
  }

  public void setLeft(BSTNode<Key, E> l) {
    left = l;
  }

  // 6. Right
  @Override
  public BSTNode<Key, E> right() {
    return right;
  }

  public void setRight(BSTNode<Key, E> r) {
    right = r;
  }

//	// 7. Parent
//	@Override
//	public BinNode<E> parent() 
//	{ return parent; }
//	public void setParent(BSTNode<Key, E> p)
//	{ parent = p; }

  // 7. Check leaf
  @Override
  public boolean isLeaf() {
    return (left == null) && (right == null);
  }
}
