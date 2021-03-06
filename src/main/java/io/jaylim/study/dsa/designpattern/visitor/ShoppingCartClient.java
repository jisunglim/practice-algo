package io.jaylim.study.dsa.designpattern.visitor;

public class ShoppingCartClient {

  public static void main(String[] args) {
    ItemElement[] items = new ItemElement[]
        {new Book(20, "1234"),
            new Book(100, "5678"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")};

    int total = calculatePrice(items);
    System.out.println("Total Cost = " + total);

    System.out.println(calculatePriceS(items));
  }

  private static int calculatePrice(ItemElement[] items) {
    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
    int sum = 0;
    for (ItemElement item : items) {
      sum = sum + item.accept(visitor);
    }
    return sum;
  }

  private static String calculatePriceS(ItemElement[] items) {
    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("[sVersion Price Calc]\n");
    for(ItemElement item : items ) {
      String s = item.accept(visitor, "sVersion :: ");
      stringBuilder.append(s + "\n");
    }
    return stringBuilder.toString();
  }
}