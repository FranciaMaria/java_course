package drawing.gui;

import drawing.model.Line;

import javax.swing.*;
import java.awt.event.*;

public class DlgLine extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblEndPointX;
    private JLabel lblEndPointY;
    private JTextField txtEndPointX;
    private JTextField txtEndPointY;

    private Line line;

    public DlgLine() {
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
        this.line.getEndPoint().setX(Integer.parseInt(this.txtEndPointX.getText()));
        this.line.getEndPoint().setY(Integer.parseInt(this.txtEndPointY.getText()));

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        line = null;
        dispose();
    }

    public static void main(String[] args) {
        DlgLine dialog = new DlgLine();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
        this.txtEndPointX.setText(String.valueOf(line.getEndPoint().getX()));
        this.txtEndPointY.setText(String.valueOf(line.getEndPoint().getY()));
    }
}
