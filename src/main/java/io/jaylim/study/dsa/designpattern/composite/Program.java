package io.jaylim.study.dsa.designpattern.composite;

public class Program {
  public static void main(String[] args) {
    //Initialize four ellipses
    Graphic ellipse1 = new Ellipse();
    Graphic Triangle = new Triangle();
    Graphic Circle = new Circle();

    //Initialize three composite graphics
    CompositeGraphic graphic = new CompositeGraphic();

    CompositeGraphic graphic1 = new CompositeGraphic();
    CompositeGraphic graphic2 = new CompositeGraphic();

    //Composes the graphics
    graphic1.add(ellipse1);
    graphic1.add(Triangle);

    graphic2.add(Circle);

    graphic.add(graphic1);
    graphic.add(graphic2);

    //Prints the complete graphic
    graphic.print();
  }
}
