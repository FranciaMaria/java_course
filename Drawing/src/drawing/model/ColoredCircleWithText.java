package drawing.model;

import java.awt.*;

public class ColoredCircleWithText extends ColoredCircle {

    private String text;
    private boolean selected;

    public ColoredCircleWithText(Point centerPoint, int radius, Color color, String text) {
        super(centerPoint, radius, color);
        this.text = text;
    }

    public ColoredCircleWithText(Point centerPoint, int radius, boolean selected, Color color, String text) {
        super(centerPoint, radius, color);
        this.selected = selected;
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return super.toString() + ", Text: " + this.text;
    }

}
