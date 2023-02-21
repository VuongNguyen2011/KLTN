/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import BruteForce.BruteForce;
import DivideAndConquer.EfficientClosestPair;
import Random.RandomFindClosePair;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author NguyenVuong
 */
public class Main {
    public static void main(String[] args) {
        
        ArrayList<Point> p = renderData();
        
        long startTime = System.nanoTime();
        BruteForce brForce = new BruteForce();
        System.out.println(brForce.bruteForce(p));

        RandomFindClosePair randomFind = new RandomFindClosePair();
        randomFind.randomFindPair(p);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds  : " + totalTime + " ns");

        System.out.println();
//        ============================================================================================================
        Point[] P = {new Point(1, 2), new Point(3, 3), new Point(5, 6)};
        long startTime1 = System.nanoTime();

        // Sort the array of points by x-coordinate and y-coordinate
        Arrays.sort(P, (p1, p2) -> Double.compare(p1.x, p2.x));
        Point[] Q = Arrays.copyOf(P, P.length);

        Arrays.sort(Q, (p1, p2) -> Double.compare(p1.y, p2.y));

        // Find the closest pair of points using the efficientClosestPair method
        double closestDist = EfficientClosestPair.efficientClosestPair(P, Q);
        System.out.println("The closest distance is: " + closestDist);

        long endTime1 = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("Execution time in nanoseconds  : " + totalTime1 + " ns");
//        timeIt("BruteForce Lambda : ", () -> {System.out.println(bruteForce(p));});

    }
    public static ArrayList<Point> renderData(){
        ArrayList<Point> p = new ArrayList<Point>();
        p.add(new Point(1, 2));
        p.add(new Point(1, 3));
        p.add(new Point(1, 4));
        p.add(new Point(2, 3));
        p.add(new Point(2, 6));
        p.add(new Point(3, 7));
        p.add(new Point(3, 8));
        p.add(new Point(4, 3));
        p.add(new Point(4, 4));
        p.add(new Point(5, 7));
        p.add(new Point(3, 4));
        p.add(new Point(5, 5));
        p.add(new Point(5, 6));
        p.add(new Point(7, 7));
        p.add(new Point(7, 8));
        p.add(new Point(8, 2));
        p.add(new Point(8, 3));
        p.add(new Point(9, 1));
        p.add(new Point(1, 9));
        p.add(new Point(2, 5));
        p.add(new Point(3, 3));
        p.add(new Point(4, 1));
        p.add(new Point(5, 1));
        p.add(new Point(6, 1));
        p.add(new Point(7, 1));
        p.add(new Point(8, 1));
        p.add(new Point(9, 2));
        return p;
    }
}
