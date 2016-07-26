package com.estsoft.practice_algo.design_pattern.visitor;

public interface ShoppingCartVisitor {

  int visit(Book book);

  String visit(Book book, String str);

  int visit(Fruit fruit);

  String visit(Fruit fruit, String str);
}