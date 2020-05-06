package drawing.model;

import java.awt.*;

public class ColoredCircle extends Circle{

    private Color color = Color.PINK;
    private boolean selected;

    public ColoredCircle(Point centerPoint, int radius, Color color) {
        super(centerPoint, radius);
        this.color = color;
    }

    public ColoredCircle(Point centerPoint, int radius, boolean selected, Color color) {
        super(centerPoint, radius);
        this.selected = selected;
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return super.toString() + ", Color: " + this.color;
    }

}
