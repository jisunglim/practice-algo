package io.jaylim.study.dsa.sorting;

import io.jaylim.study.dsa.sorting.utils.Input;
import io.jaylim.study.dsa.util.DSutil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

  public static <E extends Input.Record> void mergeSort(E[] input) {
    mergeSort(input, new Input.Record[input.length], 0, input.length - 1);

  }

  private static <E extends Input.Record> void mergeSort(E[] input, E[] temp, int fromIdx, int toIdx) {
    final int mid = (fromIdx+toIdx) / 2;
    // length of interval is 1.
    if (fromIdx == toIdx) {
      return;
    }
    // If the length of the interval is greater than 1, process below codes.

    // divide interval into two, process each subinterval.
    mergeSort(input, temp, fromIdx, mid);
    mergeSort(input, temp, mid + 1, toIdx);

    // copy the sorted sublists to the auxiliary array first,
    for (int i = fromIdx; i <= toIdx; i++) {
      temp[i] = input[i];
    }

    // and the merge them back to the original array.
    int idx1 = fromIdx;
    int idx2 = mid + 1;

    for (int curr = fromIdx; curr <= toIdx; curr++) {
      if (idx1 == mid + 1) {
        input[curr] = temp[idx2++];
      } else if (idx2 == toIdx + 1) {
        input[curr] = temp[idx1++];
      } else if (temp[idx1].isLessThan(temp[idx2])) {
        input[curr] = temp[idx1++];
      } else {
        input[curr] = temp[idx2++];
      }
    }
  }

  public static <E extends Input.Record> void mergeSort2(E[] input) {
    mergeSort2(input, new Input.Record[input.length], 0, input.length - 1);
  }

  public static final int MERGE_TO_INSERTION_THRESHOLD = 4;

  private static <E extends Input.Record> void mergeSort2(E[] input, E[] temp, int fromIdx, int toIdx) {

    int i, j, k;
    int mid = (fromIdx + toIdx) / 2;

    // Return if the length = 1
    if (fromIdx == toIdx) {
      return;
    }

    // The first half of an array : fromIdx ... mid
    if (mid - fromIdx >= MERGE_TO_INSERTION_THRESHOLD) {
      mergeSort2(input, temp, fromIdx, mid);
    } else {
      insertionSort3(input, fromIdx, mid);
    }

    // The other half of an array : mid + 1 ... toIdx
    if (toIdx - mid + 1 >= MERGE_TO_INSERTION_THRESHOLD) {
      mergeSort(input, temp, mid + 1, toIdx);
    } else {
      insertionSort3(input, mid + 1, toIdx);
    }

    // copy the first half into auxiliary array : fromIdx ... mid
    for (i = fromIdx; i <= mid; i++) {
      temp[i] = input[i];
    }

    // copy the reverse of the other half into auxiliary array : mid + 1 ... toIdx
    for (j = 1; j <= toIdx - mid; j++) {
      temp[j + mid] = input[toIdx - j + 1];
    }

    // merge sublist back to array.
    for (i = fromIdx, j = toIdx, k = fromIdx; k <= toIdx; k++) {
      if (temp[i].isLessThan(temp[j])) {
        input[k] = temp[i++];
      } else {
        input[k] = temp[j--];
      }
    }


  }

  public static <E extends Input.Record> void insertionSort3(E[] input) {
    insertionSort3(input, 0, input.length - 1);
  }

  private static <E extends Input.Record> void insertionSort3(E[] input, int fromIdx, int toIdx) {
    for (int i = fromIdx + 1; i <= toIdx; i++) {
      for (int j = i; j > fromIdx && input[j].isLessThan(input[j-1]); j--) {
        DSutil.swap(input, j, j-1);
      }
    }
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
