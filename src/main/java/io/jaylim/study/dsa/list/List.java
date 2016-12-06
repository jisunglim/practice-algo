package io.jaylim.study.dsa.list;

public interface List<E> {

  /* 1. When you define a interface, do not declare field variables and constructors.
   * It is because that field variables and constructors can not be decided on its interface.
   *   - (1) But, we declare the method for re-initialization :
   *     void clear()
   */

  /**
   * <strong>Clear</strong> all the element in the io.jaylim.study.dsa.list and <strong>re-initialize</strong> the
   * io.jaylim.study.dsa.list.
   */
  void clear();

  /* 2. We will use generic type so that the interface is parameterized over types
   * to increase a flexibility of the data structure.
   *   - Use character E, which means element.
   */

  /* 3. We design io.jaylim.study.dsa.list structure with focusing on the concept of current position.
   *   - We will not declare the specific implementation on an interface.
   * So, just consider what field function is useful to modify current position.
   *   - (1) moveToSomewhere : start, end, previous and next position from current one,
   * and the position specifically decided by position index.
   *   - (2) getCurr : get an specific index of the current position.
   */

  /**
   * Move the <strong>current position</strong> to <strong>start</strong> point.
   */
  void moveToStart();

  /**
   * Move the <strong>current position</strong> to <strong>end</strong> point.
   */
  void moveToEnd();

  /**
   * Move the <strong>current position</strong> to its <strong>previous</strong> one.
   */
  void prev();

  /**
   * Move the <strong>current position</strong> to its <strong>next</strong> one.
   */
  void next();

  /**
   * Move the <strong>current position</strong> to the position specified by its
   * <strong><code>pos</code></strong>.
   *
   * @param pos The position specified by index <code>pos</code>.
   */
  void moveToPos(int pos);

  /**
   * Retrieve the index value of the current position.
   *
   * @return The index value of the <strong>current position</strong>.
   */
  int currPos();

  /* 4. Data structure should make for user a way for manipulating the data in the io.jaylim.study.dsa.list.
   *    - (1) Add data into somewhere(current position or some specific position) :
   *      void insert(E item) and void append(E item)
   *    - (2) Delete data from somewhere(current position) :
   *      E remove()
   *    - (3) Retrieve the value of the element from somewhere(current position) :
   *      E getValue()
   */

  /**
   * <strong>Add</strong> the new item into the array <strong>between current position and its next
   * position</strong>.
   *
   * @param item The item <strong>to be inserted</strong> between two element in the io.jaylim.study.dsa.list.
   */
  void insert(E item);

  /**
   * <strong>Add</strong> the new element after the <strong>end</strong> of the io.jaylim.study.dsa.list.
   *
   * @param item The item <strong>to be appended</strong> into the io.jaylim.study.dsa.list after the io.jaylim.study.dsa.list end.
   */
  void append(E item);

  /**
   * <strong>Delete</strong> the existing element which is <strong>on the current
   * position</strong>.
   *
   * @return The value of the element <strong>to be deleted</strong>
   */
  E remove();

  /**
   * Return the value of the element which is <strong>on the current position</strong>.
   *
   * @return The value of the element <strong>on the current position</strong>
   */
  E getValue();

  /* 5. One of the important information of a data structure is how many element it has.
   *   - (1) Get the size of the data (element) of the data structure :
   *     int length()
   */

  /**
   * Return <strong>the number of element</strong> contained in the io.jaylim.study.dsa.list.
   */
  int length();
}
