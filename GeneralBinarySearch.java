package chapter13;

/**
 *
 * @author Jacob Stewart, 10/19/2020, Generalized Binary Search, CIT-130
 */
public class GeneralBinarySearch {
    
    /**
     * Searches the array a for key. If key is not in the array segment, then -1
     * is returned. Otherwise returns an index in the segment such that key ==
     * a[index]. Precondition: a[first] <= a[first + 1] <= ... <= a[last]
     */
    public static <T extends Comparable> int search(T[] a, int first, int last, T key) {
        int result = 0; // to keep the compiler happy.

        if (first > last) {
            result = -1;
        } else {
            int mid = (first + last) / 2;
            T midValue = a[mid];
            
            if (key.compareTo(midValue) == 0){
                result = mid;
            } else if (key.compareTo(midValue) < 0) {
                result = search(a, first, mid - 1, key);
            } else if (key.compareTo(midValue) > 0) {
                result = search(a, mid + 1, last, key);
            }
        }
        return result;
    }
}