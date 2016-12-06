/* 0. The Concept of a Key and Comparable Objects.
 * 	- (1) Key, (or search key)
 * 		  How should we describe what we are looking for?
 *
 * 		--	We do not want to describe what we are looking for by
 * 			detailing and matching the entire contents of the record.
 *
 * 		--	We typically define what record we want in terms of a
 * 			key value.
 *
 * 	- (2) Comparable
 * 		  To implement the search function, we require that
 * 		  keys be comparable.
 *
 * 		--	AT A MINIMUM :
 * 			At a minimum, we must be able to take two keys and reliably
 * 			determine whether they are equal or not. That is enough to
 * 			enable a sequential search through a database of records
 * 			and find one that matches a given key.
 *
 * 		--	TOTAL ORDER :
 * 			However, we typically would like for the keys to define a
 * 			total order, which means that we can tell which of two keys
 * 			is greater than the other. Using key types with total orderings
 * 			gives the database implementor the opportunity to organize a
 * 			collection of records in a way that makes searching more
 * 			efficient such as, for example, binary search.
 *
 * 		--	MULTI-DIMENSIONAL NATURE :
 * 			Ordering fields that are naturally multidimensional, such as
 * 			a point in two or three dimensions, present special opportunities
 * 			if we wish to take advantage of their multidimensional nature.
 *
 * 1. Searching issues
 * 	- (1) To search for records in multiple ways
 *
 * 	- (2) To find record that matches a given key
 * 			Q. How to extract key from a record.
 * 			A. We would like any given io.jaylim.study.dsa.dictionary implementation
 * 			   to support arbitrary record types. So we need some mechanism
 *
 */


package io.jaylim.study.dsa.dictionary;

/**
 * <h2>ADT for Dictionary</h2>
 *
 *
 * <ul> (1) insert <li>Method insert takes a record and inserts it into the io.jaylim.study.dsa.dictionary. </ul> <ul>
 * (2) find <li>Method find takes a key value and returns some record from the io.jaylim.study.dsa.dictionary whose key
 * matches the one provided. <li>If there are multiple records in the io.jaylim.study.dsa.dictionary with that key
 * value, there is no requirement as to which one is returned. </ul> <ul> (3) remove <li>The remove
 * method is similar to find, except that it also deletes the record returned from the io.jaylim.study.dsa.dictionary.
 * </ul> <ul> (4) removeAny <li>This is similar to remove, except that it does not take a key value.
 * Instead, it removes an arbitrary record from the io.jaylim.study.dsa.dictionary, if one exists. <li>The purpose of
 * this method is to allow a user the ability to iterate over all elements i nthe io.jaylim.study.dsa.dictionary.
 * <li>Without the removeAny method, a io.jaylim.study.dsa.dictionary user could not get at a record of the io.jaylim.study.dsa.dictionary
 * that he didn't already know the key value for. With the removeAny method, the user can process
 * all records in the io.jaylim.study.dsa.dictionary as shown in the following code fragment. </ul> <ul> (5) size
 * <li>Method size returns the number of elements in the io.jaylim.study.dsa.dictionary. </ul>
 */
public interface Dictionary<Key, E> {

  /**
   * Re-initialize io.jaylim.study.dsa.dictionary
   */
  public void clear();

  /**
   * Insert a record
   *
   * @param k The key for the record being inserted.
   * @param e The record being inserted.
   */
  public void insert(Key k, E e);

  /**
   * Remove and return a record.
   *
   * @param k The key of the record to be removed.
   * @return A matching record.<br> If multiple records match <code><strong>k</strong></code>,
   * remove an arbitrary one. <br>Return <code><strong>null</strong></code> if no record with key
   * <code><strong>k</strong></code> exists.
   */
  public E remove(Key k);

  /**
   * Remove and return an arbitrary record from io.jaylim.study.dsa.dictionary.
   *
   * @return The record removed, or <code><strong>null</strong> </code> if none exists.
   * <blockquote><code><b>while</b> (dict.size() > 0) <br>{ <br>it = dict.removeAny();
   * <br>doSomething(it); <br>}</blockquote>
   */
  public E removeAny();

  /**
   * @param k The key of the record to find
   * @return A record matching <code><strong>k</strong></code> (<code><strong>null</strong></code>
   * if none exists).<br> If multiple records match, return an arbitrary one.
   */
  public E find(Key k);

  /**
   * @return The number of records in the io.jaylim.study.dsa.dictionary.
   */
  public int size();
}
