package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Point p1 = new Point();
        Point p2 = new Point();

        double d1 = distance(p1, p2);
        double d2 = p2.distance(p1);
        double d3 = p1.distance(p2);
    }

    public static double distance(Point p1, Point p2) {
        // pitagora
        return 0;
    }
}
