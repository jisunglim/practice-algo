package io.jaylim.study.dsa.dictionary;

public class Payroll {
  private Integer ID;
  private String name;
  private String address;

  /**
   * Constructor
   */
  Payroll(int inID, String inname, String inaddr) {
    ID = inID;
    name = inname;
    address = inaddr;
  }

  public Integer getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "Payroll [ID=" + ID + ", name=" + name + ", address=" + address + "]";
  }
}

