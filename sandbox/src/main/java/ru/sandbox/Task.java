package ru.sandbox;

public class Task {

  public static void main(String[] args) {

    Point p1 = new Point(33.17, 11);
    Point p2 = new Point(25.17, 3);

    System.out.println("Расстояние между точками p1 и p2 = " + p1.distance(p2));
  }
  public double distance(Point p1, Point p2){
    double dx = this.x - p1.x;
    double dy = this.y - this.y;
    return Math.sqrt(dx*dx + dy*dy);
  }
}