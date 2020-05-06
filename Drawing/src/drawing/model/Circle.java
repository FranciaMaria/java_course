package drawing.model;

import drawing.exceptions.CircleException;

import java.awt.*;

public class Circle extends Shape implements Movable {

    private Point centerPoint;
    private int radius;
    private boolean selected;

    public Circle(Point centerPoint, int radius) {
        super();
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    public Circle(Point centerPoint, int radius, boolean selected) {
        super(selected);
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws CircleException {
        if (radius <= 0) {
            throw new CircleException("Poluprecnik kruga mora biti veci od 0.", this); // this => circle u celosti :)
        }
        this.radius = radius;
    }

    public double area() {
        return (this.radius*this.radius*Math.PI);
    }

    public boolean contains(Point p) {
        return this.centerPoint.distance(p) <= this.radius;
    }

    public boolean contains(int x, int y) {
        return this.contains(new Point(x, y));
    }

    public boolean equals(Object obj){
        if (obj instanceof Circle){

            Circle c = (Circle) obj;

            if (this.radius == c.radius && this.centerPoint.equals(c.centerPoint)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString(){
        return "Center: " + this.centerPoint + ", Radius: " + this.radius;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(this.centerPoint.getX() - this.radius, this.centerPoint.getY() - this.radius, 2*this.radius, 2*this.radius);
        if (super.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.centerPoint.getX() - 2, this.centerPoint.getY() - this.radius - 2, 4, 4);
            g.drawRect(this.centerPoint.getX() - this.radius - 2, this.centerPoint.getY()  - 2, 4, 4);
            g.drawRect(this.centerPoint.getX() - 2, this.centerPoint.getY() + this.radius - 2, 4, 4);
            g.drawRect(this.centerPoint.getX() + this.radius - 2, this.centerPoint.getY()  - 2, 4, 4);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
        // this.centerPoint.setX(this.getCenterPoint().getX() + byX);
        // this.centerPoint.setY(this.getCenterPoint().getY() + byY);
        this.centerPoint.moveBy(byX, byY);
    }
}
