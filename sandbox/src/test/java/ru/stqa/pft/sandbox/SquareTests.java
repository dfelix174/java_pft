package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.Test;

public class SquareTests {

  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 24, 0);
  }

}
