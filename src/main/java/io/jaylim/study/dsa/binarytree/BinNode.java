package io.jaylim.study.dsa.binarytree;

	
/* 1. Binary Tree Structure : Terminology and its definition
 *  - (1) WRT Structure
 *  	 -	Node and Edge
 *  			Two nodes are linked with edge.
 *  	 -	Root and Subtree
 *  			The root of tree has two children, if they are not empty, 
 *  			and each child is the root of each subtree, respectively.
 *  			This root-subtree concept is relatively defined and holds
 *  			for any nodes in tree in cascading manner.
 *  			i.e. any node has its own tree. And the tree is always 
 *  			subtree of its parent's tree.
 *  	 -	Path
 *  			A path of tree can be defined inductively.
 *  			If a node N(0) is exists and N(n) is parent of N(n+1)
 *  			for all  0 <= n < L where N(L) is the first empty node,
 *  			Then there exists a path from N(0) to N(k) for all k in [0,L) 
 *  	 -	Internal node and leaf node
 *  			If a node has both two empty children, then the node is
 *  			called empty node. Otherwise, internal node.
 *  	 -	full tree and complete tree
 *  			If all existing nodes in tree are has both two non-empty
 *  			children node or both two empty children, the tree is full.
 *  			If all possible 2^(N-2) nodes at level N-2 in tree of 
 *  			height N are exist, the tree is complete. 
 *  
 *  - (2) WRT Relationship
 *  	 -	Node - Node relationship
 *  		- Parent : Child
 *  		- Ancestor : Descendant
 *  	 -	(Sub)Tree - (Sub)Tree relationship
 *  		- Disjoint
 *  
 *  - (3) WRT Status
 *  	 -	Length	::= # of links which joint from root to a some node
 *  					in specific path
 *  					(The root must be the ancestor of the last node.)
 *  	 -	Depth	::= # of steps which should be taken to reach a some
 *  					node
 *  	 -	Level	::= All nodes of depth d are at level d in the tree.
 *  	 -	Empty	::= i.  (A position) that there exists no node
 *  						i.e. Child of leaf node
 *  					ii.	(A tree) that desn't have any node.
 *  	 -	Height	::= # of nodes in the longest path
 *  
 */


/* 2. Node Implementation
 *	get/set method
 *		Element / left, light child node
 *	validation method
 *		isLeaf
 */
public interface BinNode<E> {

  // 1. No Field variable and No constructor on an interface

  public E element();

  public void setElement(E el);

  public BinNode<E> left();

  public BinNode<E> right();

//	//Do not define set child method because it should be defined on a case-by-case basis.
//	public void setLeft(BinNode<E> leftChild);
//	public void setRight(BinNode<E> rightChild);

//	//How about parent node?
//	public BinNode<E> parent();
//	public void setParent(BinNode<E> parent);

  public boolean isLeaf();
}

/* - (2) Key Properties : Theorems for tree structure
 * 
 * [Theorem 1, Full Binary Tree Theorem] The number of leaves in a non-empty
 * full binary tree is one more than the number of internal nodes.
 * 
	 * --- Pf. (By Induction)
	 * 
	 * Let P(n) be a predicate that
	 * 
	 * The number of leaves in a full binary tree which has n internal nodes is one
	 * more than the number of internal nodes,
	 * 
	 * and we will use P(n) as an inductive hypothesis.
	 * 
	 * --- Base case : n = 0
	 * 
	 * P(0) is true because there is only a root node and it's leaf node.
	 * 
	 * --- Inductive Steps : SubPf.( of "P(n) implies P(n+1) for all n>=0")
	 * 
	 * Assuming that P(n) is true, then it means that there exist n internal nodes
	 * and n+1 leaves in full binary tree. If we choose any one leaf and add two
	 * children to it, then there exists n+1 internal nodes and n+2 leaf nodes in
	 * full Binary Tree, which indicates that P(n+1). Therefore, P(n+1) is true when
	 * P(n) is true for all n >= 0.
	 * 
	 * --- Conclusion.
	 * 
	 * Hence, by mathematical induction, the Theorem holds.
	 * 
	 * --- QED.
 * 
 * [Theorem 2] The number of empty subtrees in a non-empty binary tree is one
 * more than the number of nodes in the tree.
 * 
	 * --- Pf. (By Induction)
	 * 
	 * At first, empty subtree can be substituted with its own root. That is, the
	 * There exist one more empty nodes than whole existing nodes. So, let P(n) be a
	 * predicate that
	 * 
	 * The number of empty nodes in a non-empty binary tree, which has n nodes, is
	 * one more than the number of nodes in the tree,
	 * 
	 * and we will use P(n) as an inductive hypothesis.
	 * 
	 * --- Base case : n = 0
	 * 
	 * P(0) is true because there is only a root node and it has 2 empty child nodes
	 * because the root node is a leaf node.
	 * 
	 * --- Inductive Steps : SubPf.( of "P(n) implies P(n+1) for all n>=0")
	 * 
	 * Assuming that P(n) is true, then it means that there exist n nodes and n+1
	 * empty node in binary tree. If we choose any position of empty node put a node
	 * in there, then there exists n+1 nodes and n+2 empty nodes in Binary Tree,
	 * which indicates that P(n+1). Therefore, P(n+1) is true when P(n) is true for
	 * all n >= 0.
	 * 
	 * --- Conclusion.
	 * 
	 * Hence, by mathematical induction, the Theorem holds.
	 * 
	 * --- QED.
 */
