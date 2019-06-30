package ru.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {
  @Test
  public void testDistance () {
    Point p1 = new Point(33.17, 11);
    Point p2 = new Point (25.17, 3);
    assert p1.distance(p2) == 11.313708498984761;
    Assert.assertEquals(p1.distance(p2), 11.313708498984761);
  }
}
