package Practice;

/**
 *
 * @author Jacob
 */
public class FactorialRecursion {

    public static void main(String[] args) {
        int a = 5;
        System.out.println(rec(a));
    }

    public static int rec(int n) {
//        if (n > 1) {
//            return n * rec(n - 1);
//        } else {
//            return 1;
//        }
        if (n == 1) {
            return 1;
        }
        return n * rec(n - 1);
    }
}
