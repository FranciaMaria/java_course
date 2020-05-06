package drawing_old_version.model;

public class Line {

    private Point startPoint;
    private Point endPoint;
    private boolean selected;

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double lenght() {
        return this.startPoint.distance(this.endPoint);
    }
}
