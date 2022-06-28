package Practice;

import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class EnterNameRecursion {

    public static void main(String[] args) {
        String name = "";
        enter();
    }

    public static void enter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name; \"none\" will end the program:");
        String name = input.nextLine();
        if (name.equalsIgnoreCase("none")) {
            return;
        }
        System.out.println("Hello, " + name);
        enter();
    }
}
