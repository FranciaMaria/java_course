package drawing_old_version.test;

import drawing_old_version.model.Circle;
import drawing_old_version.model.Point;
import drawing_old_version.model.Rectangle;

public class TestGeometry {

    public static void main(String[] args) {
        // write your code here

       Point p1 = new Point();
       Point p2 = new Point();

       p1.setX(0);
       p1.setY(0);
       p2.setX(3);
       p2.setY(4);

       double distance = p1.distance(p2);

       if (distance == 5.0) {
           System.out.println("Rastojanje je " + distance);
       } else {
           System.out.println("Rastojanje nije 5.0");
       }

       Circle c = new Circle();

       c.setRadius(3);

       double area = c.area();

        System.out.println(area);

        Rectangle r = new Rectangle();

        r.setHeight(6);
        r.setWidth(4);

        double rectangleArea = r.area();

        if (rectangleArea == 24) {
            System.out.println("Povrsina je " + rectangleArea);
        } else {
            System.out.println("Povrsina nije 24");
        }

    }
}
