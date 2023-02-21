/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BruteForce;

import static Random.RandomFindClosePair.tinhD;
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
        int temp = 0;
        Point pMin1 = new Point();
        Point pMin2 = new Point();
        for(int i = 0 ; i < p.size() ; i++){
            for(int j = i + 1; j < p.size() ; j++){
                temp = tinhD(p.get(i),p.get(j));
                if(d > temp){
                    d = temp;
                    pMin1 = p.get(i);
                    pMin2 = p.get(j);
                }
                
            }
        }
        System.out.println("(" + pMin1.view() + ";" + pMin2.view()+")");
        return d;
    } 
    
    // ============================= Hien thị thời gian thực hiện code dưới dạng Lambda =====================
    public <T> T timeIt(String msg, Supplier<T> s) {
        long startTime = System.nanoTime();
        T t = s.get();
        long endTime = System.nanoTime();
        System.out.println(msg + ": " + (endTime - startTime) + " ns");
        return t;
    }
 
    public void timeIt(String msg, Runnable r) {
       timeIt(msg, () -> {r.run(); return null; });
    }
}
