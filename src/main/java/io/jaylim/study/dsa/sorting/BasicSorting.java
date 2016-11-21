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
    for (int i = 1; i < input.length; i++) {

      for (int j = 0; j < i; j++) {

        if (input[j].isGreaterThan(input[i])) {
          E temp = input[i];
          for (int k = i; k > j; k--) {
            input[k] = input[k-1];
          }
          input[j] = temp;
          break;
        }
      }
    }
  }

  /**
   * The procedure-oriented-style implementation of insertion sort,
   * comparing two records in right-to-left direction.
   *
   * @param input A collection of records stored in an array.
   * @param <E>   The comparable object with key value.
   */
  public static <E extends Input.Record> void InsertionSort2(E[] input) {
    for (int i = 1; i < input.length; i++) {
      for (int j = i; j > 0; j--) {
        if (input[j].isLessThan(input[j-1])) {
          DSutil.swap(input, j, j-1);
        } else {
          break;
        }
      }
    }
  }


}
