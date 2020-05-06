package drawing.gui;

import drawing.model.Rectangle;

import javax.swing.*;
import java.awt.event.*;

public class DlgRectangle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblUpperLeftX;
    private JLabel lblUpperLeftY;
    private JLabel lblWidth;
    private JLabel lblHeight;
    private JTextField txtUpperLeftX;
    private JTextField txtUpperLeftY;
    private JTextField txtWidth;
    private JTextField txtHeight;

    private Rectangle rectangle;

    public DlgRectangle() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        this.rectangle.getUpperLeftPoint().setX(Integer.parseInt(this.txtUpperLeftX.getText()));
        this.rectangle.getUpperLeftPoint().setY(Integer.parseInt(this.txtUpperLeftY.getText()));
        try {
            this.rectangle.setWidth(Integer.parseInt(this.txtWidth.getText()));
            this.rectangle.setHeight(Integer.parseInt(this.txtHeight.getText()));
        } catch(Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        rectangle = null;
        dispose();
    }

    public static void main(String[] args) {
        DlgRectangle dialog = new DlgRectangle();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle){

        this.rectangle = rectangle;
        this.txtUpperLeftX.setText(String.valueOf(rectangle.getUpperLeftPoint().getX()));
        this.txtUpperLeftY.setText(String.valueOf(rectangle.getUpperLeftPoint().getY()));

        if (rectangle.getWidth() != -1) {
            this.txtHeight.setText(String.valueOf(rectangle.getWidth()));
        }
        if (rectangle.getHeight() != -1) {
            this.txtWidth.setText(String.valueOf(rectangle.getHeight()));
        }
    }
}

//    public void setCircle(Circle circle) {
//        this.circle = circle;
//        this.txtCenterX.setText(String.valueOf(circle.getCenterPoint().getX()));
//        this.txtCenterY.setText(String.valueOf(circle.getCenterPoint().getY()));
//        if (circle.getRadius() != -1) {
//            this.txtRadius.setText(String.valueOf(circle.getRadius()));
//        }
//    }