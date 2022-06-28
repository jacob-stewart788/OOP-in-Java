package Practice;

/**
 *
 * @author Jacob
 */
import java.util.Arrays;

public class MergeMe {

    public static void main(String[] args) {

        int[] arr = {9, 3, 4, 7, 1, 8, 2, 5, 6};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        arr = mergeSort(arr);
        System.out.println("Sorted : " + Arrays.toString(arr));

    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + j];
        }

        int[] result = new int[arr.length];
        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);

        return result;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer] = left[leftPointer];
                    resultPointer++;
                    leftPointer++;
                } else {
                    result[resultPointer] = right[rightPointer];
                    resultPointer++;
                    rightPointer++;
                }
            } else if (leftPointer < left.length) {
                result[resultPointer] = left[leftPointer];
                resultPointer++;
                leftPointer++;
            } else if (rightPointer < right.length) {
                result[resultPointer] = right[rightPointer];
                resultPointer++;
                rightPointer++;
            }
        }
        return result;
    }
}
