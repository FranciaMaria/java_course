package drawing.model;

import java.awt.*;

public class Rectangle extends Shape implements Movable {

    private Point upperLeftPoint;
    private int width;
    private int height;

    public Rectangle(Point upperLeftPoint, int width, int height) {
        super();
        this.upperLeftPoint = upperLeftPoint;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
        super(selected);
        this.upperLeftPoint = upperLeftPoint;
        this.width = width;
        this.height = height;
    }

    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(Point upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

   public double area() {
        return this.height*this.width;
   }

    public boolean contains(Point p) {

        boolean containsX = p.getX() > this.getUpperLeftPoint().getX() && p.getX() < (this.upperLeftPoint.getX() + this.getWidth());
        boolean containsY = p.getY() > this.getUpperLeftPoint().getY() && p.getY() < (this.upperLeftPoint.getY() + this.getHeight());
        return containsX && containsY;
    }

    public boolean contains(int x, int y) {
        return this.contains(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.upperLeftPoint.getX() - 2, this.upperLeftPoint.getY() - 2, 4, 4);
            g.drawRect(this.upperLeftPoint.getX() - 2 + this.width, this.upperLeftPoint.getY() - 2 + this.height, 4, 4);
            g.drawRect(this.upperLeftPoint.getX() - 2, this.upperLeftPoint.getY() + this.height - 2, 4, 4);
            g.drawRect(this.upperLeftPoint.getX() + this.width - 2, this.upperLeftPoint.getY() - 2, 4, 4);
            g.setColor(Color.BLACK);
        }
    }

    /* uzela sam da mi je y-osa usemerena ka gore u poitivnom delu,
       kao i pozitivan deo x-ose
     */

    public Point findingLowerRightPoint() {
        int x = this.upperLeftPoint.getX() + this.getWidth();
        int y = this.upperLeftPoint.getY() + this.getHeight();

        Point lowerRight = new Point(x, y);

        return lowerRight;
    }

    public boolean equals(Object obj){
        if (obj instanceof Rectangle){

            Rectangle r = (Rectangle) obj;

            if (this.upperLeftPoint.equals(r.upperLeftPoint) && this.width == r.width && this.height == r.height){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString(){
        return "Left upper: " + this.upperLeftPoint + ", Width: " + this.width + ", Height: " + this.height;
    }

    @Override
    public void moveBy(int byX, int byY) {
//        this.upperLeftPoint.setX(this.upperLeftPoint.getX() + byX);
//        this.upperLeftPoint.setY(this.upperLeftPoint.getY() + byY);
        this.upperLeftPoint.moveBy(byX, byY);
    }
}
