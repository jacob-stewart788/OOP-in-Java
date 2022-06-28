package Practice;

/**
 *
 * @author Jacob
 */
public class FibonacciRecursion {

    public static void main(String[] args) {
        long x = 0;
        long y = 1;
        int z = 1;
        fib(x, x + y, z);
    }

    public static void fib(long x, long y, int z) {
        System.out.println(z + " in the sequence = " + y);
        z += 1;
        if (z > 40) {
            return;
        }
        fib(y, x + y, z);
    }
    
//    public static void main(String[] args) {
//        long x = 0;
//        long y = 1;
//        int z = 1;
//        System.out.println(fib(x, x + y, z));
//    }
//    public static long fib(long x, long y, int z){
//        if(z >= 10)
//            return y;
//        return fib(y, x + y, z += 1);
//    }
}
