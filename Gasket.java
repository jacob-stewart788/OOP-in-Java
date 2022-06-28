package chapter18;

/**
 *
 * @author Jacob Stewart, 11/24/2020, Sierpinski gasket, CIT-130
 */
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;

public class Gasket extends JFrame {

    public static void main(String[] args) {
        Gasket g = new Gasket();
        g.setVisible(true);
    }

    public Gasket() {
        super("Sierpinski Gasket Demonstration - Jacob Stewart");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int[] one = {300, 40};
        int[] two = {20, 580};
        int[] three = {580, 580};

        g.drawLine(one[0], one[1], one[0], one[1]);
        g.drawLine(two[0], two[1], two[0], two[1]);
        g.drawLine(three[0], three[1], three[0], three[1]);

        int[] target = new int[2];
        int[] mid = new int[2];
        int[] current = three;

        int choice;
        for (int i = 0; i < 5000000; i++) {
            choice = (int) (Math.random() * 3 + 1);
            if (choice == 1) {
                target = one;
            } else if (choice == 2) {
                target = two;
            } else if (choice == 3) {
                target = three;
            } else {
                System.out.println("Unexpected error.");
                System.exit(0);
            }
            mid[0] = (current[0] + target[0]) / 2;
            mid[1] = (current[1] + target[1]) / 2;
            g.drawLine(mid[0], mid[1], mid[0], mid[1]);
            current = mid;
        }
    }
}
