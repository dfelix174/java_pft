package ru.stqa.pft.sandbox;

public class DistanceBetweenDots {
  public static void main (String[] args){
    Point a = new Point(5, 5);
    Point b = new Point(5, 7);

    System.out.println("Расстояние между точками ("
            + (int)a.x + ":" + (int)a.y + ") и ("  + (int)b.x + ":" + (int)b.y + ") = "
            + a.distance(b));
  }
}
