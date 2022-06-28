package chapter14;

/**
 *
 * @author Jacob Stewart, 10/26/2020, return standard deviation from average of
 * any number type, CIT-130
 */
import java.util.ArrayList;

public class MyMathClass<T extends Number> {

    public static <T extends Number> double stdev(ArrayList<T> a) {
        double total = 0;
        for (T x : a) {
            total = total + x.doubleValue();
        }
        double average = total / a.size();
        total = 0;
        for(T x: a){
            total = total + (x.doubleValue() - average) * 
                        (x.doubleValue() - average);
        }
        total = total / (a.size() - 1);
        double dev = Math.sqrt(total);
        return dev;
    }
}
