package io.jaylim.study.dsa.designpattern.visitor;

public interface ItemElement {

  public int accept(ShoppingCartVisitor visitor);

  public String accept(ShoppingCartVisitor visitor, String someString);
}