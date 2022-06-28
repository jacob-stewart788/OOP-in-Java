/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author Jacob
 */
// Program that checks to see if number of curly braces is balanced
import java.util.*;

public class CurlyChecker {

    public static void main(String[] args) {

        // Empty stack
        Stack<Character> stack = new Stack();

        // Char array of braces
        Character[] braces = {'{', '}'}; // GOOD
        Character[] braces2 = {'{', '}', '{'}; // BAD
        Character[] braces3 = {'{', '}', '{', '{', '}', '}'}; // GOOD

        Character[] braces4 = {'{', '{', '}', '{', '}', '}'}; // GOOD
        Character[] braces5 = {'{', '{', '}', '{', '}', '}', '}'}; // BAD |  Will crash unless else include isEmpty()

        Character[] braces6 = {'{', '}', '{', '}', '}'}; // BAD

        // Show our stack
        System.out.println(stack);

        // Print array contents
        System.out.println(Arrays.toString(braces) + "\n");

        // Call the bChecker method with the empty stack & set of curlys
        bChecker(braces, stack);

        System.out.println("\n****");
        // Display balanced or not
        if (stack.empty()) {
            System.out.println("Balanced!");
        } else {
            System.out.println("Not balanced ..");
        }

    }

    public static void bChecker(Character[] b, Stack s) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] == '{') {
                s.push(b[i]);
                System.out.println("Pushing { ");
            } else if (b[i] == '}') // Have to make sure it's EMPTY before we pop (See brace5)
            {
                if (!s.isEmpty()) {
                    s.pop();
                    System.out.println("Popping } ");
                } // If we find } but it's already empty it's unblanaced so FORCE CLOSE program
                else {
                    System.out.println("\nFound } but stack is empty .. "
                            + "cannot be balanced.");
                    System.out.println("Not balanced ..");
                    System.exit(0);
                }

            } else {
                System.out.println("Move along, nothing to see here.");
            }
        }

    }

}
