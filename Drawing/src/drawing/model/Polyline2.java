package drawing.model;

public class Polyline2 {

    private Line[] segments;
    private final int maxElement = 10;
    private boolean selected;

    public Polyline2() {
        this.segments = new Line[maxElement];
    }

    public Polyline2(boolean selected) {
        this.segments = new Line[maxElement];
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void addSegments(Line segment) {

        if (this.segments[0] == null) {
            this.segments[0] = segment;
        } else {
            Line lastSegment = this.segments[this.numberOfElements() - 1];
            if (this.numberOfElements() != maxElement && segment.getStartPoint().equals(lastSegment.getEndPoint())) {
                this.segments[this.numberOfElements()] = segment;
            }
        }
    }

    public int numberOfElements() {
        int counter = 0;
        for (int i = 0; i < this.segments.length; i++) {
            if (this.segments[i] != null)
                counter++;
        }
        return counter;
    }

    public double length() {
        double sum = 0;
        for (int i = 0; i < this.segments.length; i++) {
            if (this.segments[i] != null) {
                sum += this.segments[i].length();
            }
        }
        return (double) sum;
    }

    public void returnElements() {
        for (Line segment : this.segments){
            System.out.println(segment);
        }
    }
}
