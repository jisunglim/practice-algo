package io.jaylim.study.dsa.binarytree;

/* 1. Binary Tree Traversals
 *	- (1) VISITING
 *		Often we wish to process a binary tree by "visiting"
 *			i)	each of its nodes
 *			ii)	each time performing a specific action
 *	
 *	- (2) TRAVERSAL
 *		Any process for
 *			i)	visiting all of the nodes
 *			ii)	in some order
 *
 *	- (3) ENUMERATION
 *		Any traversal that
 *			i)	lists every node in the tree
 *			ii)	exactly once for each.
 *			
 *		cf) The "in some order" feature might be ignored in some
 *			applications. But it is also ENUMERATION as long as
 *			every node in the tree is visited precisely once for each.
 *
 *	- (4) "___"ORDER TRAVERSAL
 *		Any traversal that
 *			i)	"in some order" feature preserves some relationship
 *			
 *			(4-1) PREORDER TRAVERSAL
 *				A relationship which makes sure that
 *					we visit any given node BEFORE we visit its children
 *
 *			(4-2) POSTORDER TRAVERSAL
 *				A relationship which makes sure that
 *					we visit any given node AFTER we visit its children
 * 
 *			(4-3) INORDER TRAVERSAL
 *				A relationship which follows the procedure that
 *					i)	 first visits the left child
 *						 (including its entire subtree)
 *					ii)  then visits the node
 *					iii) and finally visits the right child
 *						 (including its entire subtree)
 */

/* 2. Traversals Implementation
 *	- (1) Recursively defined traversal
 *		A traversal routine is naturally written as a recursive
 *		function if some traversal rules of relationship can defined
 *		exactly between the parent and children.
 *
 *	- (2) Input Parameter : (BinNode rt)
 *		Its input parameter is a reference to a node which we will call rt
 *		because each node can be viewed as thee root of a some subtree.
 *		
 * 	- (3) Procedure of Recursion
 * 		[Start point of recursion : Root Node of The Tree]
 * 		The initial call to the traversal function passes in a reference to
 * 		the root node of the tree.
 * 		
 * 		[Procedure of recursion in Parent - Child relationship]
 * 		The traversal function visits rt and its children (if any) in the
 * 		desired, or designed, order.
 * 
 * 		[Base case of recursion : Empty child]
 * 		When a recursion function passes in a reference to an empty node,
 * 		the recursively called function must stop its procedure because it's
 * 		the base case of recursion.
 */ 

/* 3. Important Decisions for Implementing Recursive Function on Trees
 * 	DECISION 1 : When to check for an empty subtree
 * 	DECISION 2 : How to define the visitor function
 * 	DECISION 3 : Which members of the collection will be visited
 */

/* DECISION 1 : When to check for an empty subtree
 * 		
 * 		Strategies for Decision
 * 		- Asymptotic analysis for costs of each time and space.
 * 		- Desire more efficient code such as better readability.
 * 		- Don forget the specific cases such as empty tree.
 * 
 * 		i.e.
 * 		Which checking strategy is better implementation?
 * 		+----------------+-------------------+-------------------+
 * 		| Traversal rule | BASE CASE CHECK 1 | BASE CASE CHECK 2 |
 * 		+----------------+-------------------+-------------------+
 * 		|    PREORDER    |    PREORDER 1     |    PREORDER 2     |
 * 		+----------------+-------------------+-------------------+
 * 		|    POSTORDER   |    POSTORDER 1    |    POSTORDER 2    |
 * 		+----------------+-------------------+-------------------+
 * 		|    INORDER     |    INORDER 1      |    INORDER 2      |
 * 		+----------------+-------------------+-------------------+
 * 		
 * 		[BASE CASE CHECK 1, Strategy outline]
 * 		When the function is recursively called, check the base case
 * 		first. if rt, passed from precede function, is empty (null),
 * 		terminate the function, or process its own task.
 * 
 * 		[BASE CASE CHECK 2, Strategy outline] 		
 * 		Before calling the recursion for its children, check the child
 * 		exists. If any, visit the child in some desired order, or do
 * 		not call the function.
 * 	
 * 	- (1) WRT Time consumption 					[Asymptotic analysis]
 * 		At first, the second strategy seems to be more economical than
 * 		the first one because the second one first check if the child
 * 		is empty or not and then, if empty, it do not call the function
 * 		saving its time consumption. This misconception, however, occurs
 * 		because of missing the point that the second check procedure 
 * 		also requires recursion call. 
 * 		Taking the example of two pre-order implementations, the first
 * 		strategy always needs exactly two call for checking. On the other
 * 		hand, the second one needs at least two calls, if not four calls, 
 * 		for checking regardless of its emptiness.
 * 		Hence, The second strategy has little or no performance improvement
 * 		from the first one.
 * 		
 * 	- (2) WRT Generality
 * 		More Complex Tree Case : Awkwardness 	[Efficient code]
 * 		While it is not apparent in this simple example, for more complex
 * 		traversals it can become AWKWARD to place the check for the null
 * 		pointer in the calling code.
 * 		
 * 		Empty Tree case : Exception 			[The specific cases]
 * 		Although, the first strategy can check also the empty tree, but
 * 		the second one can not handle the empty tree. Hence the second tree
 * 		must consider the empty tree case.
 */

/* DECISION 2 : How to define the visitor function
 * 		
 * 		Approach 1 : Simply write new version of the traversal for each such
 * 					 visitor function as needed.
 * 		
 * 				Advantage :
 * 				Easy implementation
 * 				
 * 				Disadvantage : 
 * 				Whatever function does, the traversal must have access to the
 * 				BinNode class. it is probably better design to permit only the
 * 				tree class to have access to the BinNode class.
 * 
 * 
 * 		Approach 2 : Supply a generic traversal function which takes the visitor
 * 					 as a function parameter. This is known as the visitor design
 * 					 pattern.
 * 				
 * 				Advantage :
 * 				separate an algorithm from an object structure on which it operates.
 * 				
 * 				Disadvantage :
 * 				Constraint that the signature for all visitor functions must be
 * 				fixed in advance
 * 				
 */

/* DECISION 3 : Which members of the collection will be visited
 * 		
 * 		Some tree "traversals" might in fact visit only some tree nodes,
 * 		while avoiding processing of others.
 * 
 * 		SIMPLE CASE : 
 * 		which requires only a simple local calculation.
 * 
 * 		DIFFICULT CASE : 
 * 		that is not available just by looking at the node's parent or children.
 */
public class BinaryTreeTraversal<E> {

  // 1. some VISITING function
  private void visit(BinNode<E> rt) {
    System.out.println(rt.element());
  }

  private void visitInt(BinNode<Integer> rt) {
    System.out.println(rt.element());
  }

  // 2-1. PREORDER TRAVERSAL (Parent first, Child next)
  public void preorder1(BinNode<E> rt) {
    if (rt == null) return;        // BASE CASE (Empty node) Check
    visit(rt);                                        // Do some operation for each node.
    preorder1(rt.left());                // Recursion call to the left child
    preorder1(rt.right());                // Recursion call to the right child
  }

  // 2-2. PREORDER TRAVERSAL (Parent first, Child next)
  public void preorder2(BinNode<E> rt) {
    visit(rt);                //Do some operation for each node
    if (rt.left() != null) preorder2(rt.left());                //Base case check & recursion call
    if (rt.right() != null) preorder2(rt.right());        //Base case check & recursion call

//		// EMPTY TREE CASE
//		if(rt != null) {
//			if(rt.left() != null) preorder2(rt.left());
//			if(rt.right() != null) preorder2(rt.right());
//		}
  }

  // 3-1. POSTOREDER TRAVERSAL (Child first, Parent next)
  public void postorder1(BinNode<E> rt) {
    if (rt == null) return;
    postorder1(rt.left());
    postorder1(rt.right());
    visit(rt);
  }

  // 3-2. POSTOREDER TRAVERSAL (Child first, Parent next)
  public void postorder2(BinNode<E> rt) {
    if (rt.left() != null) postorder2(rt.left());
    if (rt.right() != null) postorder2(rt.right());
    visit(rt);
  }

  // 4-1. INORDER TRAVERSAL (Left child -> Parent -> Right child)
  public void inorder1(BinNode<E> rt) {
    if (rt == null) return;
    inorder1(rt.left());
    visit(rt);
    inorder1(rt.right());
  }

  // 4-2. INORDER TRAVERSAL (Left child -> Parent -> Right child)
  public void inorder2(BinNode<E> rt) {
    if (rt.left() != null) inorder2(rt.left());
    visit(rt);
    if (rt.right() != null) inorder2(rt.right());
  }

  // 5-1. Count the number of nodes in tree
  //	# of nodes in subtree = 1(root of subtree)
  //						  + l(left child's subtree)
  //						  + r(right child's subtree))
  public int count1(BinNode<E> rt) {
    if (rt == null) return 0;
    return 1 + count1(rt.left()) + count1(rt.right());
  }

  // 5-2. Count the number of nodes in tree (AWKWARDNESS!!!)
  public int count2(BinNode<E> rt) {
    return 1 + (rt.left() != null ? count2(rt.left()) : 0) + (rt.right() != null ? count2(rt.right()) : 0);
  }

  // 6-1. SIMPLE CASE which requires only a simple local calculation.
  public void pathFinder(BinNode<Integer> rt, int criteria) {
    if (rt == null) return;
    visitInt(rt);
    if (criteria < rt.element())
      pathFinder(rt.left(), criteria);
    else if (criteria > rt.element())
      pathFinder(rt.right(), criteria);
    else
      return;
  }

  // 6-2. DIFFICULT CASE that is not available just by looking at the node's parent or children.
  public boolean checkBST(BinNode<Integer> rt, int low, int high) {
    if (rt == null) return true;
    int rootKey = rt.element();
    if ((rootKey < low) || (rootKey > high))
      return false;
    if (!checkBST(rt.left(), low, rootKey))
      return false;
    return checkBST(rt.right(), rootKey, high);
  }

}
