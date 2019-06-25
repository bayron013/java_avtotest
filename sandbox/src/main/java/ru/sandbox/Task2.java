package ru.sandbox;

public class Task2 {
  public static void main(String[] args) {

    Point1 p = new Point1();
    p.pointa = 33.17;
    p.pointb = 25.17;
    p.pointc = 11;
    p.pointd = 3;
    System.out.println("Расстояние между точками #1 = " + distance1(p));

    Point2 f = new Point2(25, 9.5, 17.8, 8.3);
    System.out.println("Расстояние между точками #2 = " + distance2(f));

  }
  public static double distance1 (Point1 p) {
    return Math.sqrt((p.pointa - p.pointb) + (p.pointc - p.pointd));
  }
  public static double distance2 (Point2 f) {
    return Math.sqrt((f.a - f.b) + (f.c - f.d));
  }
}
