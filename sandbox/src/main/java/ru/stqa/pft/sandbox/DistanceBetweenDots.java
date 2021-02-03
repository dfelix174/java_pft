package ru.stqa.pft.sandbox;

public class DistanceBetweenDots {
  public static void main (String[] args){
    Point a = new Point(5, 5);
    Point b = new Point(5, 7);

    System.out.println("Расстояние между точками (" + a.x + ":" + a.y + ") и ("  + b.x + ":" + b.y + ") = " + distance(a, b));
  }

  public static double distance (Point a, Point b) {
    return Math.sqrt((a.x - b.x)*(a.x - b.x)+(a.y - b.y)*(a.y - b.y));
  }
}
