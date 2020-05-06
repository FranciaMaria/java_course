package drawing.model;

import java.util.*;

public class Polyline {
    private ArrayList<Line> segments;
    private boolean selected;

    public Polyline() {
        this.segments = new ArrayList<>();
    }

    public Polyline(boolean selected) {
        this.segments = new ArrayList<>();
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void addSegments(Line segment) {

        if (this.segments.isEmpty()) {
            this.segments.add(segment);
        } else {
            Line lastSegment = this.segments.get(this.segments.size() - 1);
            if(segment.getStartPoint().equals(lastSegment.getEndPoint())) {
                this.segments.add(segment);
            }
        }
    }

    public double length() {
        double sum = 0;
        for (Line segment : this.segments){
            sum += segment.length();
        }
        return sum;
    }

    public void returnElements() {
        for (Line segment : this.segments){
            System.out.println(segment);
        }
    }
}
