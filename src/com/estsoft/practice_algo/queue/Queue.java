package com.estsoft.practice_algo.queue;

public interface Queue<E> {
        /* 0. What is a queue?
	 * 	- (1) The queue is a list-like structure that provides restricted
	 * 		  access to its elements.
	 * 	- (2) queue elements may only be inserted at the back (enqueue)
	 * 		  and removed from the front (dequeue). 
	 * 			
	 * 	- (3) The queue operates like standing in line at a movie theater
	 * 		  ticket counter. It called FIFO, which stands for "First-In,
	 * 		  First-Out."
	 */

  /**
   * Re-initialize the queue. The user is responsible for reclaiming the storage used by the queue
   * elements.
   */
  public void clear();

  /**
   * Place an element at the rear of the queue.
   *
   * @param item The element being enqueued.
   */
  public void enqueue(E item);

  /**
   * Remove and return element at the front of the queue.
   *
   * @return The element at the front of the queue.
   */
  public E dequeue();

  /**
   * @return The front element.
   */
  public E frontValue();

  /**
   * @return The number of elements in the queue.
   */
  public int length();
}
