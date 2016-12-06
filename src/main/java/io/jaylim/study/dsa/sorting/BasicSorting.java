package io.jaylim.study.dsa.sorting;

import io.jaylim.study.dsa.sorting.utils.Input;
import io.jaylim.study.dsa.util.DSutil;

/**
 * This class includes a bunch of simple sorting algorithms.
 * <p>
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
  public static <E extends Input.Record> void insertionSort(E[] input) {

    int c = 0;
    int s = 0;

    for (int i = 1; i < input.length; i++) {
      for (int j = 0; j < i; j++) {
        c++;
        if (input[j].isGreaterThan(input[i])) {
          E temp = input[i];
          for (int k = i; k > j; k--) {
            input[k] = input[k - 1];
            s++;
          }
          input[j] = temp;
          break;
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
  public static <E extends Input.Record> void insertionSort2(E[] input) {

    int c = 0;
    int s = 0;

    for (int i = 1; i < input.length; i++) {
      for (int j = i; j > 0 && (input[j].isLessThan(input[j - 1])); j--) {
        c++;
        s++;
        DSutil.swap(input, j, j - 1);
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }

  /**
   * The
   *
   * @param input A collection of records stored in an array.
   * @param <E>   The comparable object with key value.
   */
  public static <E extends Input.Record> void bubbleSort(E[] input) {

    int c = 0;
    int s = 0;

    for (int i = input.length; i > 0; i--) {
      for (int j = 1; j < i; j++) {
        c++;
        if (input[j].isLessThan(input[j - 1])) {
          s++;
          DSutil.swap(input, j, j - 1);
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }

  public static <E extends Input.Record> void bubbleSort2(E[] input) {

    int c = 0;
    int s = 0;

    for (int i = 0; i < input.length; i++) {
      for (int j = input.length - 1; j > i; j--) {
        c++;
        if (input[j].isLessThan(input[j - 1])) {
          s++;
          DSutil.swap(input, j, j - 1);
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);
  }

  public static <E extends Input.Record> void selectionSort(E[] input) {

    int c = 0;
    int s = 0;

    for (int i = 0; i < input.length; i++) {
      int min = i;
      for (int j = input.length - 1; j > i; j--) {
        c++;
        if (input[min].isGreaterThan(input[j])) {
          min = j;
        }
      }
      s++;
      DSutil.swap(input, i, min);
    }

    System.out.println("comparison : " + c + ", swap : " + s);
  }

  public static <E extends Input.Record> void shellSort(E[] input) {

    int c = 0;
    int s = 0;

    final int base = 3;
    final int len = input.length;
//    assert isPositivePowerOf(base, len) :
//        "The number of values to be sorted, for convenience, should be a power of " + base + ".";

    for (int interval = len / base; 0 < interval; interval /= base) {
      for (int subIdx = 0; subIdx < interval; subIdx++) {
        // Insertion sort
        for (int j = subIdx + interval; j < len; j += interval) {
          for (int k = j; k >= interval && (input[k].isLessThan(input[k - interval])); k -= interval) {
            c++;
            s++;
            DSutil.swap(input, k, k - interval);
          }
        }
      }
    }
    System.out.println("comparison : " + c + ", swap : " + s);

    // Break the list into virtual sublist, sort them, and  then recombine the sublists.

  }

  public static boolean isPositivePowerOf(int base, int num) {
    int i = base;

    while (i <= num) {
      if (i == num) {
        return true;
      } else {
        i *= base;
      }
    }
    return false;
  }


}
