package com.estsoft.practice_algo.design_pattern.visitor;

public interface ShoppingCartVisitor {

  int visit(Book book);

  int visit(Fruit fruit);
}