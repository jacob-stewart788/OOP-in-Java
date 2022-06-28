package chapter11;

/**
 *
 * @author Jacob Stewart; 10/12/20; Assignment 7; Towers of Hanoi; CIT-130
 */
public class towersOfHanoi {
     public static void main(String[] args) {
        int plates = 3;
        
        solve(plates, "A", "B", "C");
    }
     
     public static void solve(int n, String a, String b, String c){
         if(n > 0){
             solve(n - 1, a, c, b);
             System.out.println(a + " -> " + c);
             solve(n - 1, b, a, c);
         }else{
             System.out.println(a + " -> " + c);
         }
     }
}
