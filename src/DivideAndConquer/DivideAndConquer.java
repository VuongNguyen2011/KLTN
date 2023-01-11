/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DivideAndConquer;

import java.util.ArrayList;
import java.util.Comparator;
import main.Point;

/**
 *
 * @author NguyenVuong
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        ArrayList<Point> p = new ArrayList<Point>();
        p.add(new Point(1, 2));
        p.add(new Point(3, 3));
        p.add(new Point(8, 3));
        p.add(new Point(5, 6));
        p.add(new Point(2, 6));
        p.sort(new PointXComparator());
        for (Point point : p) {
            System.out.println(point.x);
        }
    }
}
// A structure to represent a Point in 2D plane
class PointXComparator implements Comparator<Point> {
  
  // Needed to sort array of points
  // according to X coordinate
  @Override
  public int compare(Point pointA, Point pointB) {
    return Integer.compare(pointA.x, pointB.x);
  }
  
}
  
//class PointYComparator implements Comparator<Point> {
//  
//  // Needed to sort array of points
//  // according to Y coordinate
//  @Override
//  public int compare(Point pointA, Point pointB) {
//    return Integer.compare(pointA.y, pointB.y);
//  }
  
}
