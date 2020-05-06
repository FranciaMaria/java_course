package drawing.test;

import drawing.exceptions.CircleException;
import drawing.model.*;
import drawing.model.Point;
import drawing.model.Rectangle;
import drawing.model.Shape;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Scanner;

public class TestGeometry {

    public static void main(String[] args) {
       // write your code here

       Point p1 = new Point(0, 0);
       Point p2 = new Point(3, 4);

       double distance = p1.distance(p2);

       if (distance == 5.0) {
          System.out.println("Rastojanje je " + distance);
       } else {
          System.out.println("Rastojanje nije 5.0");
       }

       Circle c = new Circle(null, 3);

       double area = c.area();
       System.out.println(area);

       Rectangle r = new Rectangle(null, 4, 6);
       double rectangleArea = r.area();

       if (rectangleArea == 24) {
          System.out.println("Povrsina je " + rectangleArea);
       } else {
          System.out.println("Povrsina nije 24");
       }

       Point p3 = new Point(5, 6);
       System.out.println(p3);

       Point p4 = new Point(10, 20, true);
       System.out.println(p4);

       p3.setSelected(p4.isSelected());
       System.out.println(p4);

       Point p5 = p3;
       System.out.println(p5);
       p3.setX(9);
       System.out.println(p5.getX());

       Point p6 = new Point(p3.getX(), p3.getY());
       System.out.println(p6);

       Point p8 = new Point(10, 20);
       Point p9 = new Point(30, 40);
       p9 = p8;
       p9.finalize();
       System.out.println(p8);
       System.out.println(p9);

       Rectangle proveraDonjeDesneTacke = new Rectangle(new Point(1, 6), 6, 4);
       System.out.println(proveraDonjeDesneTacke.findingLowerRightPoint().getX());
       System.out.println(proveraDonjeDesneTacke.findingLowerRightPoint().getY());

       System.out.println("Upisite parametre za kreiranje tacke:");
       Scanner scanner = new Scanner(System.in);
       String pointInput = scanner.nextLine();

       int px = Integer.parseInt(pointInput.split(" ")[0]);
       int py = Integer.parseInt(pointInput.split(" ")[1]);
       boolean pSelected = false;

       if (pointInput.split(" ").length == 3) {
          pSelected = Boolean.parseBoolean(pointInput.split(" ")[2]);
       }

       Point pointFromInput = new Point(px, py, pSelected);
       System.out.println("x: " + pointFromInput.getX());
       System.out.println("y: " + pointFromInput.getY());
       System.out.println("selected: " + pointFromInput.isSelected());

       Point p10 = p2;
       Point p11 = new Point(3, 4);
       System.out.println("p10 i p2 su jednaki? " + p10.equals(p2));
       System.out.println("p10 i p1 su jednaki? " + p10.equals(p1));
       System.out.println("p11 i p2 su jednaki? " + p11.equals(p2));
       System.out.println("p11 i p1 su jednaki? " + p11.equals(p1));

       Line l1 = new Line(new Point(1, 2), new Point(3, 4));
       Line l2 = l1;
       Line l3 = new Line(new Point(3, 4), new Point(3, 4));
       System.out.println("l1 i l2 su jednaki? " + l1.equals(l2));
       System.out.println("l1 i l3 su jednaki? " + l1.equals(l3));
       System.out.println("l3 i l2 su jednaki? " + l3.equals(l2));

       Circle c1 = new Circle(new Point(1, 2), 5);
       Circle c2 = c1;
       Circle c3 = new Circle(new Point(3, 2), 5);
       System.out.println("c1 i c2 su jednaki? " + c1.equals(c2));
       System.out.println("c1 i c3 su jednaki? " + c1.equals(c3));
       System.out.println("c3 i c2 su jednaki? " + c3.equals(c2));

       Rectangle r1 = new Rectangle(new Point(1, 2), 5, 6);
       Rectangle r2 = r1;
       Rectangle r3 = new Rectangle(new Point(3, 2), 5, 6);
       System.out.println("r1 i r2 su jednaki? " + r1.equals(r2));
       System.out.println("r1 i r3 su jednaki? " + r1.equals(r3));
       System.out.println("r3 i r2 su jednaki? " + r3.equals(r2));

       Donut d1 = new Donut(new Point(1, 2), 5, 6);
       Donut d2 = d1;
       Donut d3 = new Donut(new Point(3, 2), 5, 6);
       System.out.println("d1 i d2 su jednaki? " + d2.equals(d1));
       System.out.println("d1 i d3 su jednaki? " + d1.equals(d3));
       System.out.println("d3 i d2 su jednaki? " + d3.equals(d2));

       ColoredCircle cc = new ColoredCircle(new Point(1, 2), 5, Color.PINK);
       cc.setColor(new Color(0, 0, 0));
       System.out.println("Boja kruga je: " + cc.getColor());

       ColoredCircleWithText ccwt = new ColoredCircleWithText(new Point(1, 2), 5, Color.PINK, "Pink Circle");
       System.out.println("Tekst na krugu je: " + ccwt.getText());

       System.out.println(p10.toString());
       System.out.println(l1.toString());
       System.out.println(c1.toString());
       System.out.println(r1.toString());
       System.out.println(d1.toString());
       System.out.println(cc.toString());
       System.out.println(ccwt.toString());

       Polyline pl = new Polyline();
       Line l4 = new Line(new Point(3, 4), new Point(5, 6));
       Line l5 = new Line(new Point(5, 6), new Point(1, 2));
       pl.addSegments(l1);
       System.out.println("Duzina polilajna: " + pl.length());
       pl.returnElements();
       pl.addSegments(l2);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l3);
       pl.addSegments(l4);
       pl.addSegments(l5);
       System.out.println("Duzina polilajna: " + pl.length());
       pl.returnElements();

       Polyline2 pl2 = new Polyline2();

       pl2.addSegments(l1);
       System.out.println("Duzina polilajna2: " + pl2.length());
       pl2.returnElements();
       pl2.addSegments(l2);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l3);
       pl2.addSegments(l4);
       System.out.println("Duzina polilajna2: " + pl2.length());
       pl2.returnElements();

       ArrayList<Shape> shapes = new ArrayList<>();

       Point p12 = new Point(100, 200);
       Line l12 = new Line(new Point(118, 150), new Point(105, 500));
       Circle c12 = new Circle(new Point(70, 250), 300);
       Rectangle r12 = new Rectangle(new Point(30, 20), 230, 250);

       shapes.add(p12);
       shapes.add(l12);
       shapes.add(c12);
       shapes.add(r12);

       for (Shape shape : shapes) {
          System.out.println(shape.contains(100, 200));
       }

       ArrayList<Shape> movables = new ArrayList<>();

       movables.addAll(shapes);

       for (Shape movable : movables) {

          movable.moveBy(20, 30);
          System.out.println(movable.toString());
       }

       Donut d4 = new Donut(new Point(1, 2), 9, 7);

       System.out.println("Parametri za d4 su " + d4.toString());

       System.out.println("Upisite parametre za kreiranje donut-a");
       Scanner scanner1 = new Scanner(System.in);
       System.out.println("Upisite parametar za unutrasnji poluprecnik:");
       String strInnerRadius = scanner.nextLine();
       System.out.println("Upisite parametar za poluprecnik:");
       String strRadius = scanner.nextLine();

       System.out.println("Parametri za d4 su:\n" + d4.toString());

       try {
          int radius = Integer.parseInt(strRadius);
          int innerRadius = Integer.parseInt(strInnerRadius);
          d4.setRadius(radius);
          d4.setInnerRadius(innerRadius);
          System.out.println("Parametri za d4 su:\n" + d4.toString());
       } catch(NumberFormatException nfe) {
          System.out.println("Nije upisana celobrojna vrednost. " + nfe.getMessage());
       } catch(CircleException ce) {
          System.out.println("Krug pod izuzetkom: " + ce.getCircle().toString());
          System.out.println(ce.getMessage());
       } catch(Exception exc) {
          System.out.println("Greska: " + exc.getMessage());
       }
    }
}
