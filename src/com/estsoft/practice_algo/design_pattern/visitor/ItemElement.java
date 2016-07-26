package com.estsoft.practice_algo.design_pattern.visitor;

public interface ItemElement {

  public int accept(ShoppingCartVisitor visitor);

  public String accept(ShoppingCartVisitor visitor, String someString);
}