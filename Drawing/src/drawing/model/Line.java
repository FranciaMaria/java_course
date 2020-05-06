package drawing.model;

import java.awt.*;

public class Line extends Shape implements Movable {

    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(Point startPoint, Point endPoint, boolean selected) {
        super(selected);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public double length() {
        return this.startPoint.distance(this.endPoint);
    }

    public boolean equals(Object obj){
        if (obj instanceof Line){

            Line l = (Line) obj;

            if (this.startPoint.equals(l.startPoint) && this.endPoint.equals(l.endPoint)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString(){
        return "Start: " + this.startPoint + ", End: " + this.endPoint;
    }

//    public boolean contains(Point p) {
//        return this.startPoint.distance(p) + this.endPoint.distance(p) == this.length();
//    }

    public boolean contains(Point p) {
        return this.startPoint.distance(p) + this.endPoint.distance(p) - this.length() <= 3.0D;
    }

    public boolean contains(int x, int y) {
        return this.contains(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawLine(this.startPoint.getX() - 2, this.startPoint.getY() - 2, this.endPoint.getX() - 2, this.endPoint.getY() - 2);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
//        this.startPoint.setX(this.startPoint.getX() + byX);
//        this.startPoint.setY(this.startPoint.getY() + byY);
//        this.endPoint.setX(this.endPoint.getX() + byX);
//        this.endPoint.setY(this.endPoint.getY() + byY);

        this.startPoint.moveBy(byX, byY);
        this.endPoint.moveBy(byX, byY);
    }
}
