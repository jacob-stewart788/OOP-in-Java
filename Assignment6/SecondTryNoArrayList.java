package Assignment6;

/**
 *
 * @author Jacob
 */
import java.io.*;
import java.util.*;

public class SecondTryNoArrayList {

  public static void main(String[] args) {
    System.out.println("---First File---");

    int last;
    boolean bal;
    String s1 = "SportsTeam1.java", s2 = "SportsTeam2.java";

    // Create array of curlys from file read in
    Character[] arr = getArray(s1);
    last = findLastIndex(arr);
    bal = bChecker(arr, last);
    printBal(arr, last, s1, bal);
    
    System.out.println("---Second File---");
    arr = getArray(s2);
    last = findLastIndex(arr);
    bal = bChecker(arr, last);
    printBal(arr, last, s2, bal);  

    // //More test
    // String s3 = "3.java", s4 = "4.java", s5 = "5.java", s6 = "6.java";

    // arr = getArray(s3);
    // last = findLastIndex(arr);
    // bal = bChecker(arr, last);
    // printBal(arr, last, s3, bal);

    // arr = getArray(s4);
    // last = findLastIndex(arr);
    // bal = bChecker(arr, last);
    // printBal(arr, last, s4, bal);

    // arr = getArray(s5);
    // last = findLastIndex(arr);
    // bal = bChecker(arr, last);
    // printBal(arr, last, s5, bal);

    // arr = getArray(s6);
    // last = findLastIndex(arr);
    // bal = bChecker(arr, last);
    // printBal(arr, last, s6, bal);
  }

  public static Character[] getArray(String fName) {
    File f = new File(fName);
    Scanner input = null;
    try {
      input = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      System.exit(0);
    }
    Character[] arr = new Character[100];
    String string = "";
    int n = 0; // array counter
    char c;
    while (input.hasNext()) {
      string = input.next();
      for (int i = 0; i < string.length(); i++) {
        c = string.charAt(i);
        if (c == '{' || c == '}') {
          arr[n] = c;
          n++;
        }
      }
    }
    input.close();
    return arr;
  }

  public static int findLastIndex(Character[] arr) {
    int i = 0;
    for (Character c : arr) {
      if (c == null) {
        return i;
      }
      i++;
    }
    return 0;
  }

  public static boolean bChecker(Character[] arr, int last) {
    if (arr.length == 0) {
      System.out.println("Error: No curly braces found.");
      return false;
    }
    Stack<Character> stack = new Stack<>();
    Character c;
    for (int i = 0; i < last; i++) {
      c = arr[i];
      if (c == '{') {
        stack.push(c);
      } else if (c == '}') {
        if (!stack.isEmpty()) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        System.out.println("Error: ENDING PROGRAM");
        System.exit(0);
      }
    }
    return stack.isEmpty();
  }

  public static void printBal(Character[] arr, int last, String s, boolean b) {
    System.out.print("[");
    for(int i = 0; i < last; i++){
      System.out.print(arr[i]);
      if(!(i + 1 == last)){
        System.out.print(", ");
      }
    }
    System.out.println("]");
    if (b) {
      System.out.println(s + " is BALANCED.\n");
    } else {
      System.out.println(s + " is NOT Balanced.\n");
        System.out.println("Sup losers");
    }
  }
}
