package com.company;

public class Point {

    private int x;
    private int y;
    private boolean selected;

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public double distance(Point anotherPoint) {

        int dx = this.x - anotherPoint.x;
        int dy = this.y - anotherPoint.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
