package drawing.model;

import java.awt.*;

public class Point extends Shape implements Movable {

    private int x;
    private int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean selected) {
        super(selected);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Point p) {

        int dx = this.x - p.x;
        int dy = this.y - p.y;

        return Math.sqrt(dx*dx + dy*dy);
    }

    /*
    public String toString(){
        return "x: " + this.x + ", y: " + this.y + ", selected: " + this.selected;
    }
    */

    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    public void finalize(){
        System.out.println("Upravo me uklanja GC!");
    }

    public boolean equals(Object obj){
        if (obj instanceof Point){

            Point p = (Point) obj;

            if (this.x == p.x && this.y == p.y){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean contains(Point p) {
        return this.equals(p);
    }

    public boolean contains(int x, int y) {
        return this.distance(new Point(x, y)) < 3;
    }

    @Override
    public void draw(Graphics g) {

        g.drawLine(this.x, this.y, this.x, this.y);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.x - 2, this.y - 2, 4, 4);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
//        this.setX(this.getX() + byX);
//        this.setY(this.getY() + byY);
        this.x += byX;
        this.y += byY;
    }
}
