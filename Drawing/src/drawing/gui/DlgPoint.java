package drawing.gui;

import drawing.model.Circle;
import drawing.model.Point;

import javax.swing.*;
import java.awt.event.*;

public class DlgPoint extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblPointX;
    private JLabel lblPointY;
    private JTextField txtPointX;
    private JTextField txtPointY;

    private Point point;

    public DlgPoint() {
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
        this.point.setX(Integer.parseInt(this.txtPointX.getText()));
        this.point.setY(Integer.parseInt(this.txtPointY.getText()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        point = null;
        dispose();
    }

    public static void main(String[] args) {
        DlgPoint dialog = new DlgPoint();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        this.txtPointX.setText(String.valueOf(point.getX()));
        this.txtPointY.setText(String.valueOf(point.getY()));
    }
}
