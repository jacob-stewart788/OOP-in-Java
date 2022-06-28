package Practice;

/**
 *
 * @author Jacob
 */
public class BeerRecursion {

    public static void main(String[] args) {
        int n = 99;
        beer(n);
    }
    
    public static void beer(int n){
        if( n == 0)
            return;
        System.out.println(n + " bottles of beer on the wall, " + n 
                + " bottles of beer. You take one down, pass it around, " 
                + --n + " bottles of beer on the wall.");
        beer(n);
    }

}
