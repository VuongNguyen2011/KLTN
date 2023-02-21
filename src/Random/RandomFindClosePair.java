/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Random;

import static BruteForce.BruteForce.bruteForce;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import main.Point;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author NguyenVuong
 */
public class RandomFindClosePair {

    public int randomFindPair(ArrayList<Point> p) {
        int d = Integer.MAX_VALUE;
        Random rd = new Random();
        int size = (int)Math.pow(p.size(), 0.666667);
        ArrayList<Point> s = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            s.add(p.get(rd.nextInt(p.size())));
//            System.out.println(i+1 +". "+ s.get(i).view());
//        }
        // random index
        Random rn = new Random();
        HashSet<Integer> hSet = new HashSet<>();
        while(hSet.size() != size) {
            hSet.add(rn.nextInt(p.size()));
        }
        for (int i : hSet) {
            s.add(p.get(i));
            System.out.println(i + " " + p.get(i).view());
        }
        //=================
        
        d = bruteForce(s);
        System.out.println(d);
//        System.out.println("(" + pMin1.view() + ";" + pMin2.view() + ")");
        return d;
    }
    public static int tinhD(Point p1, Point p2){
        return p1.x != p2.x && p1.y != p2.y ? ((p1.getX()- p2.getX())*(p1.getX()- p2.getX()) + 
                        (p1.getY()- p2.getY())*(p1.getY()- p2.getY())) : Integer.MAX_VALUE;
    }
}
