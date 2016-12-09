package io.jaylim.study.dsa.sorting;

import io.jaylim.study.dsa.sorting.utils.Input;
import io.jaylim.study.dsa.sorting.utils.Input.Record;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by jaylim on 11/22/2016.
 */
public class Main {
  public static void main(String[] args) throws Exception {
    Input input = new Input(32, 1, 100);
    Record[] original = input.getInput();
//    Record[] original = Input.decreasingOrderRecords(32).clone();

    Class klass = BasicSorting.class;

    // for (Method method : klass.getDeclaredMethods()) {
    //   run(klass, method.getName(), original);
    // }

    run(klass, "insertionSort", original);

    run(klass, "insertionSort2", original);

    run(klass, "insertionSort3", original);

    run(klass, "bubbleSort", original);

    run(klass, "bubbleSort2", original);

    run(klass, "selectionSort", original);

    run(klass, "shellSort", original);

    run(klass, "mergeSort", original);

    run(klass, "mergeSort2", original);

  }

  private static String methodName(Class<?> klass, String methodName, Class<?>... inputParams)
      throws NoSuchMethodException {
    StringBuilder builder = new StringBuilder("");

    builder.append(inputParams[0].getSimpleName()).append(" input").append(0);
    for (int i = 1; i < inputParams.length; i++) {
      builder.append(", ").append(inputParams[i].getSimpleName()).append(" input").append(i);
    }

    String params = builder.toString();

    return klass.getSimpleName() + "." + klass.getMethod(methodName, inputParams).getName() +
        "(" + params + ")";
  }

  private static void run(Class<?> klass, String methodName, Record[] records)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Record[] recordsCopy = Arrays.copyOf(records, records.length);

    Method method = klass.getMethod(methodName, recordsCopy.getClass());
    Class param = records.getClass();
    System.out.println(methodName(klass, methodName, param));

    method.invoke(null, (Object) recordsCopy);

    String separator = null;
    System.out.print("Original ");
    for (Record record : records) {
      separator = (separator == null) ? ": " : ", ";
      System.out.printf(separator + "%2d", record.getKey());
    }
    System.out.println();

    separator = null;
    System.out.print("Sorted   ");
    for (Record record : recordsCopy) {
      separator = (separator == null) ? ": " : ", ";
      System.out.printf(separator + "%2d", record.getKey());
    }
    System.out.println('\n');

    for (int i = 1; i < recordsCopy.length; i++) {
      assert recordsCopy[i].isGreaterThanOrEqualTo(recordsCopy[i - 1]) : "Wrong algorithm!!!!!";
    }
  }

  private static <E> E[] reverse(E[] data) {
    E[] copy = Arrays.copyOf(data, data.length);

    int left = 0;
    int right = copy.length - 1;

    while (left < right) {
      // swap the values at the left and right indices
      E temp = copy[left];
      copy[left] = copy[right];
      copy[right] = temp;

      // move the left and right index pointers in toward the center
      left++;
      right--;
    }

    return copy;
  }
}
