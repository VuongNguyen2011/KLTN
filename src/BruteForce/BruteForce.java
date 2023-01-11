/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BruteForce;

import main.Point;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 *
 * @author NguyenVuong
 */
public class BruteForce {
    public static int bruteForce(ArrayList<Point> p){
        int d = Integer.MAX_VALUE;
        for(int i = 0 ; i < p.size() ; i++){
            for(int j = i + 1; j < p.size() ; j++){
                Point p1 = p.get(i);
                Point p2 = p.get(j);
                d = Integer.min(d,((p1.getX()- p2.getX())*(p1.getX()- p2.getX()) + 
                        (p1.getY()- p2.getY())*(p1.getY()- p2.getY())));
            }
        }
        return d;
    } 
    public static void main(String[] args) {
        
        ArrayList<Point> p = new ArrayList<Point>();
        p.add(new Point(1, 2));
        p.add(new Point(3, 3));
        p.add(new Point(5, 6));
        long startTime = System.nanoTime();
        System.out.println(bruteForce(p));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Execution time in nanoseconds  : " + totalTime + " ns");

        
//        timeIt("BruteForce Lambda : ", () -> {System.out.println(bruteForce(p));});
            
        

    }
    // ============================= Hien thị thời gian thực hiện code dưới dạng Lambda =====================
    public static <T> T timeIt(String msg, Supplier<T> s) {
        long startTime = System.nanoTime();
        T t = s.get();
        long endTime = System.nanoTime();
        System.out.println(msg + ": " + (endTime - startTime) + " ns");
        return t;
    }
 
    public static void timeIt(String msg, Runnable r) {
       timeIt(msg, () -> {r.run(); return null; });
    }
}
