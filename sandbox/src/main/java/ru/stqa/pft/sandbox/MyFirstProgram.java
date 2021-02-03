package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    Square s = new Square(5);

    Rectangle r = new Rectangle(5, 10);

    System.out.println("Площать двадрата со стороной " + s.l + " = " + s.area());
    System.out.println("Площать прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }
}
