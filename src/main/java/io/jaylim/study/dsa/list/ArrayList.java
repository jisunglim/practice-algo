package io.jaylim.study.dsa.list;

public class ArrayList<E> implements List<E> {

  /* 1. Field Variables :
   *    - (1) WRT declaring size initially :
   *        Since array requires declaration of its size at initialization,
   *        we should define two field variables for default and limitation.
   *
   *        static final int DEFAULT_SIZE = (some positive integer value);
   *        int maxSize;
   *
   *    - (2) WRT repository :
   *        The ArrayList stores its objects, or elements, on the listArray.
   *        (Java, however, most naturally stores references to objects,
   *        meaning that only a single copy of an object such as a payroll
   *        record will be maintained, even if it is on multiple lists.)
   *
   *        E[] listArray;
   *
   * 		- (3) WRT current information : ArrayList<E> should define member
   *        variable to maintain the information like 'where the current
   *        position is?' and 'How many items are in the io.jaylim.study.dsa.list?'
   *
   *        int curr;
   *        int currSize;
   */
  private static final int DEFAULT_SIZE = 20;
  private int maxSize;

  private E[] listArray;

  private int curr;
  private int currSize;

  /* 2. Define constructor and re-initializer :
   *    - (1) Constructor considering default case :
   *        When we construct the new ArrayList, we should declare
   *        the size of array which stores the items. Since ArrayList
   *        inherits the constructor receiving no parameter from List
   *        interface, we use the DEFAULT_SIZE which we define above.
   *        ArrayList();
   *        ArrayList(int size);
   *
   *    - (2) Re-initializer :
   *        To clear the ArrayList object, we declare currSize = 0 and curr = 0.
   *        void clear();
   */
  public ArrayList() {
    this(DEFAULT_SIZE);
  }

  @SuppressWarnings("unchecked")
  public ArrayList(int size) {
    this.listArray = (E[]) new Object[size];
    this.maxSize = size;
    this.curr = this.currSize = 0;
  }

  public void clear() {
    this.curr = this.currSize = 0;
  }

  /* 3. Define some functions for the concept of current position
   *    - (1) move-to-somewhere function :
   *        Since we use current position as the pointer to access the elements,
   *        we should define some functions to move the pointer to where we want
   *        it to be.
   *        void moveToStart();
   *        void moveToEnd();
   *        void prev();
   *        void next();
   *        void moveToPos(int pos);
   *    - (2) get-current-position function :
   *        To access the elements, we use current position. Then, what if we
   *        need to know "Where the current position is?" In ArrayList implementation,
   *        we could know the the position information with the index because the List
   *        ADT has the concept of mathematical sequence and the ArrayList inherits it.
   *        Hence, we should define the function to get the index of the current position.
   *        int currPos();
   */
  public void moveToStart() {
    this.curr = 0;
  }

  public void moveToEnd() {
    this.curr = this.currSize;
  }

  public void prev() {
    if (this.curr != 0) {
      this.curr--;
    }
  }

  public void next() {
    if (this.curr != this.currSize) {
      this.curr++;
    }
  }

  public void moveToPos(int pos) {
    assert 0 <= pos && pos <= currSize : "Position index is out of bound";
    this.curr = pos;
  }

  public int currPos() {
    return this.curr;
  }

  /* 4. Define some functions for manipulating the elements
   *    - (1) Add element in the ArrayList :
   *        We have two strategies to add element in ArrayList. The first one is just put
   *        element in the next to the last element. Although it desn't make any troublesome
   *        work to manipulating other elements besides the new one, it gives no way to
   *        add element into somewhere we want the element to be, it only can add an element
   *        in the end. Hence we need some more powerful function, which the second strategy
   *        provides. Taking advantage of the concept of current position, it put an element
   *        next to the current position. There exists, however, troublesome works. Since the
   *        next position of the current one is already occupied, There is no space to stores
   *        a new element. So, all elements which follows the current element must shift one
   *        position toward the tail to make room, and it takes theta(n) time for both average
   *        case and worst case.
   *        void append(E item);
   *        void insert(E item);
   *
   *    - (2) Delete element in the ArrayList :
   *        Delete strategy seems like the second one of adding element. It first delete the
   *        element in the current position and the element shift toward the head by one
   *        position to fill in the gap.
   *        E remove();
   */
  public void insert(E item) {
    if (this.maxSize == this.currSize) {
      return;
    }
    for (int i = this.currSize; i > this.curr; i--) {
      this.listArray[i] = this.listArray[i - 1];
    }
    this.listArray[this.curr] = item;
    this.currSize++;
  }

  public void append(E item) {
    if (this.maxSize == this.currSize) {
      return;
    }
    this.listArray[currSize] = item;
    this.currSize++;
  }

  public E remove() {
    if (this.currSize == 0) {
      return null;
    }
    E temp = this.listArray[this.currSize];
    for (int i = this.currSize; i < this.currSize - 1; i++) {
      this.listArray[i] = this.listArray[i + 1];
    }
    return temp;
  }

  /* 5. Define some functions to get current informations
   *    - (1) get-value function :
   *        E getValue();
   *    - (2) get-size function :
   *        int length();
   */
  public E getValue() {
    return this.listArray[this.curr];
  }

  public int length() {
    return this.currSize;
  }

}
