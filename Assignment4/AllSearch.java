package Assignment4;



public class AllSearch {
    
    // START LINEAR SEARCH
    public int linearSearch(int[] arr, int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i] == x)
            {
                return i;
            }
        }
        // Otherwise we return -1 (As failed, or not found)
        return -1;
    }
    // END LINEAR SEARCH
    
    // START BINARY SEARCH
    public int binSearch(int[] arr, int search) {
        
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        
        // While our start (or current) has not exceeded the end (which won't change)
        while (start <= end) 
        {
            mid = (start + end) / 2;

            if (arr[mid] == search) 
            {
                return mid;
            } 

            else if (arr[mid] > search) 
            {
                end = mid - 1;
            } 
 
            else if (arr[mid] < search) 
            {
                start = mid + 1;
            }
        }

        return -1;
    }
    // END BINARY SEARCH
    
    // START JUMP SEARCH
        public int jumpSearch(int[] arr, int x) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while (arr[Math.min(step, n)-1] < x) 
        {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) 
            {
                return -1;
            }
        }

        while (arr[prev] < x) 
        {
            prev++;
            if (prev == Math.min(step, n)) 
            {
                return -1;
            }
        }

        if (arr[prev] == x) 
        {
            return prev;
        }

        return -1;
    }
    // END JUMP SEARCH
}
