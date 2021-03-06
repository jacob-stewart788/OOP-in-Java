package chapter18;

/**
 *
 * @author Jacob Stewart, 11/25/2020, Image of smiling face that can be changed
 * to frown and back again with a button, CIT-130
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;

public class HappyAndSad extends JFrame {

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;
    public static final int FACE_DIAMETER = 200;
    public static final int X_FACE = 100;
    public static final int Y_FACE = 100;
    public static final int EYE_WIDTH = 20;
    public static final int EYE_HEIGHT = 10;
    public static final int X_RIGHT_EYE = X_FACE + 55;
    public static final int Y_RIGHT_EYE = Y_FACE + 60;
    public static final int X_LEFT_EYE = X_FACE + 130;
    public static final int Y_LEFT_EYE = Y_FACE + 60;
    public static final int MOUTH_WIDTH = 100;
    public static final int MOUTH_HEIGHT = 50;
    public static final int X_MOUTH = X_FACE + 50;
    public static final int Y_MOUTH = Y_FACE + 100;
    public static final int MOUTH_START_ANGLE = 180;
    public static final int MOUTH_ARC_SWEEP = 180;
    private boolean frown;
    JButton mouthButton;

    private class mouthAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(frown){
                frown = false;
                mouthButton.setText("Frown");
                repaint();
            }else{
                frown = true;
                mouthButton.setText("Smile");
                repaint();
            }
        }
    } // End of WinkAction inner class

    public static void main(String[] args) {
        HappyAndSad drawing = new HappyAndSad();
        drawing.setVisible(true);
    }

    public HappyAndSad() {

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle(
                "Smile/Frown Demo - Jacob Stewart");
        setLayout(
                new BorderLayout());
        getContentPane()
                .setBackground(Color.white);
        mouthButton = new JButton("Frown");

        mouthButton.addActionListener(
                new mouthAction());
        add(mouthButton, BorderLayout.SOUTH);
        frown = false;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
        //Draw Right Eye:
        g.fillOval(X_RIGHT_EYE, Y_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
        //Draw Left Eye:
        g.fillOval(X_LEFT_EYE, Y_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
        //Draw Mouth:
        if(frown){
            g.drawArc(X_MOUTH, Y_MOUTH + 20, MOUTH_WIDTH, MOUTH_HEIGHT,
                 0, MOUTH_ARC_SWEEP);
        }else{
            g.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT,
                 MOUTH_START_ANGLE, MOUTH_ARC_SWEEP);
        }
    }
}
