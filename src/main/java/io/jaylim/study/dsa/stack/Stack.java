package io.jaylim.study.dsa.stack;

public interface Stack<E> {
        /* 0. What is a Stack?
	 * 	- (1) Stack is a io.jaylim.study.dsa.list-like structure in which elements may
	 * 		  be inserted or removed from only one end.
	 * 	- (2) Stack is less flexible than lists, but it is efficient
	 * 		  for those operations(insert, remove) they can do and
	 * 		  easy to implement.
	 * 		
	 * 		- Efficient for Operations
	 * 			The insert and remove operate only one specific position
	 * 		- Easy to Implement :
	 * 			No need to take the concept of current position
	 * 			
	 * 	- (3) Stack has special vocabulary : top, push, pop
	 * 		- TOP : The accessible element of the io.jaylim.study.dsa.stack is called the
	 * 				top element. Top is defined to be the first free 
	 * 				position or the position occupied by the newest
	 * 				element.
	 *
	 * 		- PUSH : Elements are not said to be inserted, they are
	 * 				 pushed onto the io.jaylim.study.dsa.stack. Push is defined to place
	 * 				 an element into the first free position position,
	 * 				 which is decided by the top.
	 *
	 * 		- POP : When removed, an element is said to be popped from
	 * 				the io.jaylim.study.dsa.stack. Push is defined to remove an newest
	 * 				element from the io.jaylim.study.dsa.stack.
	 */
	
	/* 1. The Concept of Unique Accessibility
	 * 	Since the io.jaylim.study.dsa.stack structure allows to access only the newest element
	 * 	which is called top, it needs much less operations Than the io.jaylim.study.dsa.list does,
	 * 	and it is because that the io.jaylim.study.dsa.stack implementations is much easier than
	 * 	the io.jaylim.study.dsa.list. (Actually, There is no need to consider the current position!)
	 * 	- (1) WET Construction and Re-initialization
	 * 			void Clear();
	 * 	
	 * 	- (2) WRT operations to manipulation
	 * 		- No need to define append
	 * 		- Only push and pop is needed
	 * 			void push(E item);
	 * 			E pop();
	 * 
	 *  - (3) WRT operations to get information
	 * 			E topValue();
	 * 			int length();
	 * 		
	 */

  /**
   * Reinitialize the io.jaylim.study.dsa.stack. The user is responsible for reclaiming the storage used by the io.jaylim.study.dsa.stack
   * elements.
   */
  public void clear();

  /**
   * Push an element onto the top of the io.jaylim.study.dsa.stack.
   *
   * @param item The element being pushed onto the io.jaylim.study.dsa.stack.
   */
  public void push(E item);

  /**
   * Remove and return the element at the top of the io.jaylim.study.dsa.stack.
   *
   * @return The element at the top of the io.jaylim.study.dsa.stack.
   */
  public E pop();

  /**
   * @return A copy of the top element.
   */
  public E topValue();

  /**
   * @return The number of elements in the io.jaylim.study.dsa.stack.
   */
  public int length();
}
