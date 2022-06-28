package Assignment4;


/*
 PDF Instructions can be found on blackboard
 Files Required: AllSorts, AllSearch, (And this file)
 */

import java.io.*;
import java.util.*;

public class SortSearchAssign_ {

    public static void main(String[] args) {
        // Looked up a way to get more precise run times
        long startTime = System.currentTimeMillis();
        
        // START HERE
        createFile();
        int[] arr;
        
        arr = getArray();
        
        // Testing to make sure array filled properly
        //System.out.println(arr[0] + " " + arr[1] + " " + arr[999999]);
        
        AllSearch search = new AllSearch();
        //AllSorts sort = new AllSorts();
        
        int lookingFor = 91; 
        // Any combo that includes bubble sort will definitely be the slowest.
        // bubble + jump I think would end up taking the longest but the search,
        // is milliseconds compared to the hours of bubbling. Bubble swaps way 
        // too much to be efficient.
        
        //arr = sort.bubbleSort(arr);
        //int indexOf = search.jumpSearch(arr, lookingFor);
        
        int indexOf = search.linearSearch(arr, lookingFor);
        // A linear search on the unsorted array is the fastest way
        // to find a particular number in the array. I believe the main reason
        // for this is that sorting takes time. Another reason is that the 
        // random numbers are between 0-100. Odds are that the number you are
        // looking for is in the first few hundred numbers of the array. After
        // about 30 runs 303 was the largest index I was able to get. Most
        // were under 100 . If your looking for sorted arrays then merge was the
        // only sort algo to take under a second. Binary and jump search were
        // pretty even in their run times; binary might be a bit faster.
        // Linear averaged 570ms while merge + bin/jump avg was 790ms
        System.out.println(lookingFor + " found at index: " + indexOf);
        
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " milliseconds");

    }

    // Method which generates text file containing 1 million random numbers
    public static void createFile() 
    {
        // File to be created in default directory
        File file = new File("somanynumbers.txt");
        Random rng = new Random();
        int r;

        try {
            // Create the file
            PrintWriter output = new PrintWriter(file);

            // Write random numbers into a file
            for (int i = 0; i < 1000000; i++) 
            {
                // Genereates a random number in range of (0 - 100)
                r = rng.nextInt(101);
                output.write(r + ", ");
            }
            System.out.println("File created.");
            // Close file
            output.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Cannot do that.");
        }
    }
    
    // STUDENT TODO
    public static int[] getArray()
    {
        File f = new File("somanynumbers.txt");
        Scanner input = null;
        try{
            input = new Scanner(f);
        
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        System.out.println("File loaded.");
        
        int[] arr = new int[1000000];
        String x = ""; // String to be assigned input.next()
        int n; // number from file to be placed in array
        int i = 0; // counter for array index
        
        while(input.hasNext()){
            x = input.next(); // reads number including ", "
            x = x.substring(0, x.indexOf(",")); // cuts off ", "
            n = Integer.parseInt(x);
            arr[i] = n;
            i++;
        }
        input.close();
        System.out.println("Finished reading file & creating array.");
        return arr;
    }
}