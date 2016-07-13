package com.estsoft.practice_algo.binarytree.huffman;
/*Huffman Coding Tree
 *
 *	1. INTRODUCTION
 *
 *	(1)	The space-time tradeoff principle is the main concept of
 *		the data compression. ( time cost ASC, space cost DESC ) 
 *
 *	(2)	The Coding Problems
 *		
 *		To distinguish a set of items, assigning a unique code to
 *		each item might be desirable.
 *		
 *			- Fixed Length 		i.e. ASCII
 *			- Variable Length 	i.e. Huffman Code
 *	
 *	(3)	The Concept at the heart of file compression techniques
 *		
 *		Q.	if some character are used more frequently than others,
 *			is it possible to take advantages of this fact?
 *		
 *		A.	The key idea to obtaining a more efficient coding is to 
 *			use variable-length coding. That is, we assign shorter
 *			codewords to the more frequently occurring symbols and 
 *			longer codewords to the symbols that occur infrequently.
 *		
 *	2. How to build Huffman Coding Tree?
 *
 *	(1) Coding strategy
 *		
 *		Huffman coding assigns codes to characters such that the length
 *		of the code depends on the relative frequency or weight of the
 *		corresponding character.
 *									->	Variable Length Coding Strategy
 *		
 *		QUESTION // 
 *		Does Huffman Code always give advantage comparing to fixed length code?
 *
 *	(2) Properties
 *		
 *		- FULL binary tree
 *
 *		- Each leaf -> Each item in data (i.e. Letter in documents)		
 *		  Weight 	-> Weight (i.e. Frequency of occurrence)
 *
 * 		- Weighted Path Length
 * 					= (weight) * (depth)
 * 		
 * 		- Minimum External Path Weight 
 * 					= Minimum sum of Weighted Path Lengths
 *					
 *		QUESTION // 
 *		What's the Prefix Properties?
 *		
 *	(3) Building process
 *		
 *		[1st]	Create a collection of n initial Huffman trees, each of 
 *				which is a single leaf node containing one of the single
 *				item in data set.
 *		
 *		[2nd]	Put the n partial trees onto a priority queue organized
 *				by weight (frequency).
 *		
 *		[loop]	[3rd]	Remove the first two trees (the ones with lowest
 *		|				weight) from the priority queue.
 *		|
 *		|		[4th]	Join these two trees together to create a new tree
 *		|				whose root has the two trees as children, and whose
 *		|				weight is the sum of the weights of the two trees.
 *		|
 *		|		[5th]	Put this new tree back into the priority queue.
 *		|
 *		[REPEAT UNTIL]	Only one Huffman tree is left in the priority queue.
 *		
 *		[6th]	Remove the last one Huffman tree left.
 *
 *																		END.
 */


/**
 * Huffman tree node implementation : Base class.
 *
 * @param <E> Element for node
 */
public interface HuffBaseNode<E> {
  /**
   * @return True if this node is leaf node, otherwise false.
   */
  public boolean isLeaf();

  /**
   * @return The weight of node
   */
  public int weight();
}
