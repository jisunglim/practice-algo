package io.jaylim.study.dsa.designpattern.visitor;

public interface ShoppingCartVisitor {

  int visit(Book book);

  String visit(Book book, String str);

  int visit(Fruit fruit);

  String visit(Fruit fruit, String str);
}