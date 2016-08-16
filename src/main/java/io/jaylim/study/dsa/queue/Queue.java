package io.jaylim.study.dsa.queue;

public interface Queue<E> {
        /* 0. What is a io.jaylim.study.dsa.queue?
	 * 	- (1) The io.jaylim.study.dsa.queue is a io.jaylim.study.dsa.list-like structure that provides restricted
	 * 		  access to its elements.
	 * 	- (2) io.jaylim.study.dsa.queue elements may only be inserted at the back (enqueue)
	 * 		  and removed from the front (dequeue). 
	 * 			
	 * 	- (3) The io.jaylim.study.dsa.queue operates like standing in line at a movie theater
	 * 		  ticket counter. It called FIFO, which stands for "First-In,
	 * 		  First-Out."
	 */

  /**
   * Re-initialize the io.jaylim.study.dsa.queue. The user is responsible for reclaiming the storage used by the io.jaylim.study.dsa.queue
   * elements.
   */
  public void clear();

  /**
   * Place an element at the rear of the io.jaylim.study.dsa.queue.
   *
   * @param item The element being enqueued.
   */
  public void enqueue(E item);

  /**
   * Remove and return element at the front of the io.jaylim.study.dsa.queue.
   *
   * @return The element at the front of the io.jaylim.study.dsa.queue.
   */
  public E dequeue();

  /**
   * @return The front element.
   */
  public E frontValue();

  /**
   * @return The number of elements in the io.jaylim.study.dsa.queue.
   */
  public int length();
}
