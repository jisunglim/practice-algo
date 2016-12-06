package io.jaylim.study.dsa.sorting.utils;

/**
 * Created by jaylim on 11/22/2016.
 */
public abstract class RecordImpl implements Comparable<RecordImpl>, Sortable {

  private final int key;

  public RecordImpl(int key) {
    this.key = key;
  }

  @Override
  public int getKey() {
    return key;
  }

  public boolean isLessThan(RecordImpl another) {
    return this.compareTo(another) < 0;
  }

  public boolean isGreaterThan(RecordImpl another) {
    return this.compareTo(another) > 0;
  }

  public boolean isLessThanOrEqualTo(RecordImpl another) {
    return this.compareTo(another) <= 0;
  }

  public boolean isGreaterThanOrEqualTo(RecordImpl another) {
    return this.compareTo(another) >= 0;
  }

  public boolean isEqualTo(RecordImpl another) {
    return this.compareTo(another) == 0;
  }

  @Override
  public int compareTo(RecordImpl another) {
    return this.key - another.key;
  }


}
