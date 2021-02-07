package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistancePos(){

    Point a = new Point(5, 5);
    Point b = new Point(5, 7);
    Assert.assertEquals(a.distance(b), 2, 0);

  }

}
