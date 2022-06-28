package chapter13;

/**
 *
 * @author Jacob Stewart, 10/19/2020, General Binary Search Demo file, CIT-130
 */
public class GeneralBinarySearchDemo {
    public static void main(String[] args) {
        Integer[] a = {-2, 0, 2, 4, 6, 8, 10, 12, 14, 16};
        int finalIndex = 9;

        System.out.println("Array contains:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println();

        int result;
        for (int key = -3; key < 5; key++) {
            result = GeneralBinarySearch.<Integer>search(a, 0, finalIndex, key);
            if (result >= 0) {
                System.out.println(key + " is at index " + result);
            } else {
                System.out.println(key + " is not in the array.");
            }
        }
        System.out.println();
        
        String[] b = {"apples", "bananas", "cherries", "grapes", "lemons", 
            "oranges", "peaches", "pears", "strawberries", "watermelons"};

        System.out.println("Array contains:");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println();
        
        String sKey =  "oranges";
        result = GeneralBinarySearch.<String>search(b, 0, finalIndex, sKey);
        if (result >= 0) {
            System.out.println(sKey + " is at index " + result);
        } else {
            System.out.println(sKey + " is not in the array.");
        }
        
        sKey =  "pineapples";
        result = GeneralBinarySearch.<String>search(b, 0, finalIndex, sKey);
        if (result >= 0) {
            System.out.println(sKey + " is at index " + result);
        } else {
            System.out.println(sKey + " is not in the array.");
        }
        System.out.println();
        System.out.println("Program completed.");
        
    }
}
