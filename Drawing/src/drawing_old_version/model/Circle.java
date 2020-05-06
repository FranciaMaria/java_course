package drawing_old_version.model;

public class Circle {

    private Point centerPoint;
    private int radius;
    private boolean selected;

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double area() {
        return (this.radius*this.radius*Math.PI);
    }

}
