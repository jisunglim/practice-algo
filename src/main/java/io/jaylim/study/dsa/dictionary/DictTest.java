package io.jaylim.study.dsa.dictionary;

public class DictTest {
  public static void main(String args[]) {

    //IDdict organizes Payroll records by ID
    Dictionary<Integer, Payroll> IDdict = new UALdictionary<Integer, Payroll>();
    //namedict organizes Payroll records by name
    Dictionary<String, Payroll> namedict = new UALdictionary<String, Payroll>();
    //addressdict organizes Payroll records by address
    Dictionary<String, Payroll> addressdict = new UALdictionary<String, Payroll>();

    Payroll foo1 = new Payroll(5, "Joe", "Anytown");
    Payroll foo2 = new Payroll(10, "John", "Mytown");
    Payroll foo3 = new Payroll(11, "Jackson", "Histown");

    IDdict.insert(foo1.getID(), foo1);
    IDdict.insert(foo2.getID(), foo2);
    IDdict.insert(foo3.getID(), foo3);

    namedict.insert(foo1.getName(), foo1);
    namedict.insert(foo2.getName(), foo2);
    namedict.insert(foo3.getName(), foo3);

    addressdict.insert(foo1.getAddress(), foo1);
    addressdict.insert(foo2.getAddress(), foo2);
    addressdict.insert(foo3.getAddress(), foo3);

    System.out.println(IDdict.find(11));
    System.out.println(namedict.find("John"));
    System.out.println(addressdict.find("Anytown"));
  }
}
