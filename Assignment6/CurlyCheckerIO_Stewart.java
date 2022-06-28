package Assignment6;

/**
 *
 * @author Jacob
 */
import java.io.*;
import java.util.*;

public class CurlyCheckerIO_Stewart {

    public static void main(String[] args) {
        System.out.println("---First File---");
        //Empty stack
        
        String s1 = "SportsTeam1.java", s2 = "SportsTeam2.java";
        boolean bal;

        // Create array of curlys from file read in
        Character[] arr = getArray(s1);
        bal = bChecker(arr);
        printBal(s1, bal);

        System.out.println("---Second File---");
        arr = getArray(s2);
        bal = bChecker(arr);
        printBal(s2, bal);
        
        //More tests
//        String s3 = "third.java", s4 = "fourth.java", s5 = "fifth.java",
//                s6 = "sixth.java", s7 = "seventh.java";
//        System.out.println("THIRD");
//        arr = getArray(s3);
//        bal = bChecker(arr);
//        printBal(s3, bal);
//        
//        System.out.println("FOURTH");
//        arr = getArray(s4);
//        bal = bChecker(arr);
//        printBal(s4, bal);
//        
//        System.out.println("FIFTH");
//        arr = getArray(s5);
//        bal = bChecker(arr);
//        printBal(s5, bal);
//        
//        System.out.println("SIXTH");
//        arr = getArray(s6);
//        bal = bChecker(arr);
//        printBal(s6, bal);
//        
//        arr = getArray("nothing");
//        bal = bChecker(arr);
//        printBal("nothing", bal);
//        
//        System.out.println("SEVENTH");
//        arr = getArray(s7);
//        bal = bChecker(arr);
//        printBal(s7, bal);

    }

    public static Character[] getArray(String fName) {
        File f = new File(fName);
        Scanner input = null;
        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("Ending Program...");
            System.exit(0);
        }
        System.out.println("File Loaded.");

        ArrayList<Character> arr = new ArrayList();
        String string = "";
        char c;

        while (input.hasNext()) {
            string = input.next();

            for (int i = 0; i < string.length(); i++) {
                c = string.charAt(i);
                if (c == '{' || c == '}') {
                    arr.add(c);
                }
            }
        }
        input.close();
        Character[] charArr = new Character[arr.size()];
        arr.toArray(charArr);
        System.out.println("Finished reading file and creating array.");
        System.out.println(Arrays.toString(charArr));
        return charArr;
    }

    public static boolean bChecker(Character[] b) {
        Stack<Character> s = new Stack();
        if(b.length == 0){
            System.out.println("Error... No curly braces found.");
            return false;
        }
        for (Character b1 : b) {
            if (b1 == '{') {
                s.push(b1);
            } else if (b1 == '}') {
                if (!s.isEmpty()) {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                System.out.println("Error ... ENDING PROGRAM");
                System.exit(0);
            }
        }
        //System.out.println(s);
        return s.isEmpty();
    }

    public static void printBal(String s, boolean b) {
        if (b) {
            System.out.println(s + " is BALANCED.\n");
        } else {
            System.out.println(s + " is NOT BALANCED.\n");
        }
    }
}
