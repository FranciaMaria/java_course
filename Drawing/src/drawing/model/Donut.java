package drawing.model;

import java.awt.*;

public class Donut extends Circle {

    private int innerRadius;
    private boolean selected;

    public Donut(Point p, int radius, int innerRadius) {
        super(p, radius);
        this.innerRadius = innerRadius;
    }

    public Donut(Point p, int radius, boolean selected, int innerRadius) {
        super(p, radius);
        this.selected = selected;
        this.innerRadius = innerRadius;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) throws Exception {
        if (this.innerRadius > super.getRadius()) {
            throw new Exception("Unutrasnji poluprecnik ne moze biti veci od poluprecnika celog Donut-a.");
        }
        this.innerRadius = innerRadius;
    }

    public double area() {
        return super.area() - this.innerRadius * this.innerRadius * Math.PI;
    }

    public boolean equals(Object obj){
        if (obj instanceof Donut){

            Donut d = (Donut) obj;

            if (super.equals(d) && this.innerRadius == d.innerRadius){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString() {
        return super.toString() + ", Inner radius: " + this.innerRadius;
    }

    public boolean contains(Point p) {

        return (this.innerRadius <= super.getCenterPoint().distance(p) && super.getCenterPoint().distance(p) <= super.getRadius());
    }

    public boolean contains(int x, int y) {
        return this.contains(new Point(x, y));
    }

    public void draw(Graphics g) {
        g.drawOval(super.getCenterPoint().getX() - super.getRadius(), super.getCenterPoint().getY() - super.getRadius(), 2*super.getRadius(), 2*super.getRadius());
        g.drawOval(super.getCenterPoint().getX() - this.innerRadius, super.getCenterPoint().getY() - this.innerRadius, 2 * this.innerRadius, 2*this.innerRadius);

        if (this.selected) {
            g.setColor(Color.BLUE);
//            g.drawOval(super.getCenterPoint().getX() - super.getRadius() - 2, super.getCenterPoint().getY() - super.getRadius() - 2, 2*super.getRadius() + 4, 2*super.getRadius() + 4);
//            g.drawOval(super.getCenterPoint().getX() - this.innerRadius - 2, super.getCenterPoint().getY() - this.innerRadius - 2, 2 * this.innerRadius + 4, 2*this.innerRadius + 4);
              g.drawRect(super.getCenterPoint().getX() - 2, super.getCenterPoint().getY() - super.getRadius() - 2, 4, 4);
              g.drawRect(super.getCenterPoint().getX() - super.getRadius() - 2, super.getCenterPoint().getY()  - 2, 4, 4);
              g.drawRect(super.getCenterPoint().getX() - 2, super.getCenterPoint().getY() + super.getRadius() - 2, 4, 4);
              g.drawRect(super.getCenterPoint().getX() + super.getRadius() - 2, super.getCenterPoint().getY()  - 2, 4, 4);

            g.drawRect(super.getCenterPoint().getX() - 2, super.getCenterPoint().getY() - this.getInnerRadius() - 2, 4, 4);
            g.drawRect(super.getCenterPoint().getX() - this.getInnerRadius() - 2, super.getCenterPoint().getY()  - 2, 4, 4);
            g.drawRect(super.getCenterPoint().getX() - 2, super.getCenterPoint().getY() + this.getInnerRadius() - 2, 4, 4);
            g.drawRect(super.getCenterPoint().getX() + this.getInnerRadius() - 2, super.getCenterPoint().getY()  - 2, 4, 4);
            g.setColor(Color.BLACK);
        }
    }
}
