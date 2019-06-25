package ru.sandbox;

public class Task2Test {
  public static void main(String[] args) {

    PointTest p = new PointTest();
    p.pointa = 33.17;
    p.pointb = 25.17;
    p.pointc = 11;
    p.pointd = 3;
    System.out.println("Расстояние между точками #1 = " + distance(p));

    PointTest1 f = new PointTest1(25, 9.5, 17.8, 8.3);
    System.out.println("Расстояние между точками #2 = " + distance(f));

  }
  public static double distance (PointTest p) {
    return Math.sqrt((p.pointa - p.pointb) + (p.pointc - p.pointd));
  }
  public static double distance (PointTest1 f) {
    return Math.sqrt((f.a - f.b) + (f.c - f.d));
  }
}
