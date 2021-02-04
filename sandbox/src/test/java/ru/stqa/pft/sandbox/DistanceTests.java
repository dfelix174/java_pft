package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.Test;

public class DistanceTests {

  @Test
  public void testDistancePos(){

    Point a = new Point(5, 5);
    Point b = new Point(5, 7);
    Assert.assertEquals(a.distance(b), 2, 0);

  }

  @Test
  public void testDistance(){

    Point a = new Point(5, 5);
    Point b = new Point(5, 7);
    Assert.assertEquals(a.distance(b), 3, 0);

  }

}
