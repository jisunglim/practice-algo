package io.jaylim.study.dsa.sorting;

import io.jaylim.study.dsa.sorting.utils.Input;
import io.jaylim.study.dsa.util.DSutil;

/**
 * This class includes a bunch of simple sorting algorithms.
 *
 * Created by jaylim on 11/22/2016.
 */
public class BasicSorting {

  /**
   * The procedure-oriented-style implementation of insertion sort,
   * comparing two records in left-to-right direction.
   *
   * @param input A collection of records stored in an array.
   * @param <E>   The comparable object with key value.
   */
  public static <E extends Input.Record> void InsertionSort(E[] input) {

    int c = 0;
    int s = 0;

    // Step 1. Pick up a record (in turn). i = 1 -> l
    for (int i = 1; i < input.length; i++) {

      // Step 2. Find a right position (with a sequence of comparisons)
      for (int j = 0; j < i; j++) {
        if (input[j].isGreaterThan(input[i])) {
          c++;
          // Step 3. Put the record on the position with a sequence of swaps)
          E temp = input[i];
          for (int k = i; k > j; k--) {
            input[k] = input[k-1];
            s++;
          }
          input[j] = temp;
          break;
        } else {
          c++;
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }

  /**
   * The procedure-oriented-style implementation of insertion sort,
   * comparing two records in right-to-left direction.
   *
   * @param input A collection of records stored in an array.
   * @param <E>   The comparable object with key value.
   */
  public static <E extends Input.Record> void InsertionSort2(E[] input) {

    int c = 0;
    int s = 0;

    // Step 1. Pick up a record (in turn). i = 1 -> l
    for (int i = 1; i < input.length; i++) {

      // Step 2. Find a right position (with a sequence of comparisons)
      for (int j = i - 1; j >= 0; j--) {
        if (input[j].isLessThanOrEqualTo(input[i])) {
          c++;
          // Step 3. Put the record on the position with a sequence of swaps)
          E temp = input[i];
          for (int k = i; k > j + 1; k--) {
            input[k] = input[k-1];
            s++;
          }
          input[j+1] = temp;
          break;
        } else {
          c++;
        }
        if (j == 0) {
          c++;
          E temp = input[i];
          for (int k = i; k > 0; k--) {
            input[k] = input[k-1];
            s++;
          }
          input[0] = temp;
          break;
        } else {
          c++;
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }

  /**
   * The procedure-oriented-style implementation of insertion sort,
   * comparing two records in right-to-left direction.
   *
   * @param input A collection of records stored in an array.
   * @param <E>   The comparable object with key value.
   */
  public static <E extends Input.Record> void InsertionSort3(E[] input) {

    int c = 0;
    int s = 0;

    // Step 1. Pick up a record (in turn). i = 1 -> l
    for (int i = 1; i < input.length; i++) {

      // Step 2. Find a right position (with a sequence of comparison)
      for (int j = i; j > 0; j--) {
        if (input[j].isLessThan(input[j-1])) {
          c++;
          // Step 3. Put the record on the position with a sequence of swaps)
          DSutil.swap(input, j, j-1);
          s++;
        } else {
          break;
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }


}
