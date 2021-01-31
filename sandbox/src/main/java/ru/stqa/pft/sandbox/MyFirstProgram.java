package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    double len = 5;
    double len2 = 10;
    System.out.println("Площать двадрата со стороной " + len + " = " + area(len));
    System.out.println("Площать прямоугольника со сторонами " + len + " и " + len2 + " = " + area(len, len2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
