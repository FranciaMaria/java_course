package drawing.gui;

import drawing.model.Point;
import drawing.model.Shape;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {

    private ArrayList<Shape> shapes = new ArrayList<>();
    private Point startPoint;
//     private FrmDrawing frmDrawing;
//
//    public DrawingPanel(FrmDrawing frmDrawing) {
//        this.frmDrawing = frmDrawing;
//    }
//
//    public FrmDrawing getFrmDrawing() {
//        return frmDrawing;
//    }
//
//    public void setFrmDrawing(FrmDrawing frmDrawing) {
//        this.frmDrawing = frmDrawing;
//    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        g.drawLine(100, 100, 200, 200);
//        g.drawOval(40, 50, 60, 70);
        for (Shape shape : this.shapes) {
            shape.draw(g);
        }
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
}
