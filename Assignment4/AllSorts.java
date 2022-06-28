package Assignment4;



/*
Contains all sort methods in one class

NOTE: Merge Sort's (merg) and Quick Sort's (partition) methods are private to avoid confusion when calling
- Also, no longers static

In this version, all sort methods return a an integer array (before some were void)
BE CAREFUL, you MUST reset the array to it's original value before performing a second sort
 */

public class AllSorts {

    // START BUBBLE SORT
    public int[] bubbleSort(int[] arr) {
        // The clone of the array we will return
        
        int n = arr.length;
        int temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        return arr;
    }
    // END BUBBLE SORT

    // START  SELECTION SORT
    public int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Asign smallest value to whatever is at index i (0 to start)
            int min = i;
            // Nested for starts at number to the right of i (to compare)
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    // Assign new min each time we find one
                    min = j;
                }
            }

            // Swap (Refer back to our swapping algorithm)
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            
            // Do it all again but i = 1 | j = 2, BECAUSE, 0 is now in its correct place
        }
        return arr;
    }
    // END SELECTION SORT

    // START INSERTION SORT
    public int[] insertionSort(int arr[]) {
        int n = arr.length;
        int key, j;
        // Loop through the array starting at index 1
        for (int i = 1; i < n; i++) {
            // Our current position in the array (i) is refered to as the "key"
            key = arr[i];
            // j is the element to the left of our current index (key)
            j = i - 1;

            // While j is index 0 or greater (otherwise out of bounds) AND,
            // the value of the jTH element is LARGER than our key (iTH) element
            while (j >= 0 && arr[j] > key) {
                // Store the element to our left (j) to our right
                arr[j + 1] = arr[j];
                // Reset j to the index to the left of where we are now
                j = j - 1;
                // We are stuck inside of this while loop until !j>= 0 & arr[j] > key
            }
            // Assign j + 1 index to our new starting point next time around,
            // because everything to the left of it is already sorted
            arr[j + 1] = key;
        }

        return arr;
    }
    // END INSERTION SORT
    
    // START MERGE SORT
        public int[] mergeSort(int[] arr)
    {
       // Base case when to stop recursion call
        if(arr.length <= 1)
        {
            return arr;
        }
        // Otherwise, we will define the left and right sides of the array (the splits)
        
        // Find middle of the array and split it into left and right sectiosn (below)
        int mid = arr.length / 2;
        
        // Left array is half the size of the array
        int[] left = new int[mid];
        // Right array is length - mid (Incase we run into an uneven array)
        int[] right = new int[arr.length - mid];
        
        // Populate each array (L)
        for (int i = 0; i < left.length; i++) 
        {
            left[i] = arr[i];
        }
        
        // Populate each array (R)
        for (int j = 0; j < right.length; j++) 
        {
            // mid + j ensures we start filling the (R) array with values
            // that are AFTER the mid, otherwise its a clone of (L)
            right[j] = arr[mid + j];
        }
        
        // What will be the finished array (Currently empty)
        int[] result = new int[arr.length];
        
        // Recursive part, call the method (itself) again for each sub array 
        // breaking down L & R each time until 1
        left = mergeSort(left); 
        right = mergeSort(right);
        
        // Returned from merge method (AFTER) the recurive calls above
        // This is called for each sub array as we merge the array size 1's back together
        result = merge(left, right);
        
        return result;
    }
    
    // Merges the Left & Right arrays together
    private int[] merge(int[] left, int[] right)
    {
        // Result array is the size of the original array (our splits combined)
        int[] result = new int[left.length + right.length];
        
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        
        // While there are elements in either the L or R array we merge
        // (Ensures we have something to merge) | once we hit length we finsihed that array
        while(leftPointer < left.length || rightPointer < right.length)
        {
            // If there are elements in the left AND the right array
            if(leftPointer < left.length && rightPointer < right.length)
            {
                // NESTED: If both L & R have elements in them we compare L & R
                // If element left < right
                if(left[leftPointer] < right[rightPointer])
                {
                    // Then the result pointer current element will be the left (smallest) of the two
                    result[resultPointer] = left[leftPointer];
                    leftPointer++;
                    resultPointer++;
                }
                else
                {
                    // If we're here it's because right < left
                    result[resultPointer] = right[rightPointer];
                    rightPointer++;
                    resultPointer++;
                }
            }
            // If there are ONLY elements in the LEFT ARRAY
            else if(leftPointer < left.length)
            {
                // Take the leftPointer and store in the result
                result[resultPointer] = left[leftPointer];
                leftPointer++;
                resultPointer++;
            }
            // If there are ONLY elements in the RIGHT ARRAY
            else if(rightPointer < right.length)
            {
                // Take the leftPointer and store in the result
                result[resultPointer] = right[rightPointer];
                rightPointer++;
                resultPointer++;
            }
        }
        
        // Return the finished array
        return result; 
    }
    // END MERGE SORT
    
    // START QUICK SORT
     private int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public int[] quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            // pi is partitioning index, arr[pi] is  now at right place
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before partition and after partition 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
        
        return arr;
    } 
    // END QUICK SORT


}
