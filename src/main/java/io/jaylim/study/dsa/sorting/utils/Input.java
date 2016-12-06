package io.jaylim.study.dsa.sorting.utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jaylim on 11/22/2016.
 */
public class Input {
  private Record[] input;

  private final AtomicLong NEXT_ID = new AtomicLong(0);

  /**
   * Create input array whose records are uniformly distributed int value between 0 (inclusive)
   * and {@code Integer.MAX_VALUE} (exclusive).
   *
   * @param size The number of records in input array
   */
  public Input(int size) {
    this(size, Integer.MAX_VALUE);
  }

  /**
   * Create input array whose records are uniformly distributed int value between 0 (inclusive)
   * and max (exclusive).
   *
   * @param size The number of records in input array
   * @param max The exclusive upper bound of key value which randomly generated from {@link Random}
   */
  public Input(int size, int max) {
    this(size, 0, max);
  }

  /**
   * Create input array whose records are uniformly distributed int value between min (inclusive)
   * and max (exclusive).
   *
   * @param size The number of records in input array
   * @param min The inclusive lower bound of each key value which randomly generated from {@link Random}
   * @param max The exclusive upper bound of eachkey value which randomly generated from {@link Random}
   */
  public Input(int size, int min, int max) {
    input = new Record[size];

    Random random = new Random();
    for (int i = 0; i < size; i++) {
      long id = NEXT_ID.getAndIncrement();
      int key = random.nextInt(max - min) + min;
      input[i] = new Record(id, key);
    }
  }

  public Record[] getInput() {
    return input;
  }

  public void setInput(Record[] input) {
    this.input = input;
  }

  /**
   * The implementation of the {@link RecordImpl}, which is comparable and sortable.
   */
  public static class Record extends RecordImpl {

    private final long id;
    public Record(long id, int key) {
      super(key);
      this.id = id;
    }

    public long getId() {
      return id;
    }

    @Override
    public String toString() {
      return getId() + ":" + getKey();
    }

  }

  public static Record[] increasingOrderRecords(int length) {
    Record[] records = new Record[length];

    for (int i = 0; i < length; i++) {
      records[i] = new Record(i, i);
    }
    return records;
  }

  public static Record[] decreasingOrderRecords(int length) {
    Record[] records = new Record[length];

    for (int i = 0; i < length; i++) {
      records[i] = new Record(i, length - i);
    }
    return records;
  }
}
