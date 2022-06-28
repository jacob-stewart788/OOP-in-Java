package chapter14;

/**
 *
 * @author Jacob Stewart, 10/26/2020, MyMathClass Demo, CIT-130
 */
import java.util.ArrayList;

public class MathClassDemo {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        System.out.println("Integer array 'a' contains:");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Standard deviation is " + MyMathClass.stdev(a));
        System.out.println();

        ArrayList<Double> b = new ArrayList<>(10);
        for (double i = 10; i < 20; i++) {
            b.add(i);
        }
        System.out.println("Double array 'b' contains:");
        for (double x : b) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Standard deviation is " + MyMathClass.stdev(b));
    }
}
