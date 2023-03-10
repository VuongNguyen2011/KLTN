/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import main.Point;

/**
 * @author Trần Kim Phú
 */
public class EfficientClosestPair {

    public static double efficientClosestPair(Point[] P, Point[] Q) {
        int n = P.length;
        if (n <= 3) {
            return bruteForceClosestPair(P);
        }

        Point[] Pl = Arrays.copyOfRange(P, 0, n / 2);
        Point[] Ql = Arrays.copyOfRange(Q, 0, n / 2);
        Point[] Pr = Arrays.copyOfRange(P, n / 2, n);
        Point[] Qr = Arrays.copyOfRange(Q, n / 2, n);

        double dl = efficientClosestPair(Pl, Ql);
        double dr = efficientClosestPair(Pr, Qr);
        double d = Math.min(dl, dr);
        double m = P[n / 2 - 1].x;

        List<Point> S = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(Q[i].x - m) < d) {
                S.add(Q[i]);
            }
        }

        double dminsq = d * d;

        int num = S.size();

        for (int i = 0; i < num - 1; i++) {
            int k = i + 1;
            while (k < num && (S.get(k).y - S.get(i).y) * (S.get(k).y - S.get(i).y) < dminsq) {
                double distsq = distanceSquared(S.get(i), S.get(k));
                dminsq = Math.min(distsq, dminsq);
                k++;
            }
        }
        return Math.sqrt(dminsq);
    }

    public static double bruteForceClosestPair(Point[] P) {
        int n = P.length;
        double dminsq = Double.POSITIVE_INFINITY;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distsq = distanceSquared(P[i], P[j]);
                dminsq = Math.min(distsq, dminsq);
            }
        }
        return Math.sqrt(dminsq);
    }

    public static double distanceSquared(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    public static <T> T timeIt(String msg, Supplier<T> s) {
        long startTime = System.nanoTime();
        T t = s.get();
        long endTime = System.nanoTime();
        System.out.println(msg + ": " + (endTime - startTime) + " ns");
        return t;
    }

    public static void timeIt(String msg, Runnable r) {
        timeIt(msg, () -> {
            r.run();
            return null;
        });
    }
}

// output:
//2.23606797749979
//Execution time in nanoseconds  : 2489600 ns
