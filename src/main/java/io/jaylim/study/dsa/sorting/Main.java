package io.jaylim.study.dsa.sorting;

import io.jaylim.study.dsa.sorting.utils.Input;

import java.util.Arrays;

/**
 * Created by jaylim on 11/22/2016.
 */
public class Main {
  public static void main(String[] args) {
    Input input = new Input(20, 1, 100);
    Input.Record[] original = input.getInput();

    /* SEGMENT - Insertion sort */
    System.out.println("Insertion Sort");
    Input.Record[] records1 = Arrays.copyOf(original, original.length);

    for (Input.Record record : records1) {
      System.out.print(record.getKey() + ", ");
    }
    System.out.println();

    BasicSorting.InsertionSort(records1);

    for (Input.Record record : records1) {
      System.out.print(record.getKey() + ", ");
    }
    System.out.println("\n");

    /* SEGMENT - Insertion sort 2 */
    System.out.println("Insertion Sort 2");
    Input.Record[] records2 = Arrays.copyOf(original, original.length);

    for (Input.Record record : records2) {
      System.out.print(record.getKey() + ", ");
    }
    System.out.println();

    BasicSorting.InsertionSort2(records2);

    for (Input.Record record : records2) {
      System.out.print(record.getKey() + ", ");
    }
    System.out.println("\n");

    /* SEGMENT - Bubble sort */

  }
}
