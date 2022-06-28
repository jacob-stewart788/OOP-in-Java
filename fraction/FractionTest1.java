package chapter9;

/**
 *
 * @author Jacob Stewart; 10/10/20; Assignment 6; Fraction with exception test
 * file; CIT 130
 */
import java.util.Scanner;

public class FractionTest1 {

    public static void main(String[] args) {
        Fraction1 fraction1 = new Fraction1();
        Fraction1 fraction2 = new Fraction1();
        Scanner input = new Scanner(System.in);
        boolean tryAgain = true;

        System.out.print("Enter the numerator for the target fraction: ");
        int numerator = input.nextInt();

        System.out.print("Enter the denominator for the target fraction: ");
        int denominator = input.nextInt();
        while (tryAgain) {
            try {
                fraction1.setFraction(numerator, denominator);
                tryAgain = false;
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter the numerator for the target fraction: ");
                numerator = input.nextInt();

                System.out.print("Enter the denominator for the target fraction: ");
                denominator = input.nextInt();
            }
        }

        tryAgain = true;
        boolean tryAgain2;
        while (tryAgain) {
            tryAgain2 = true;
            System.out.print("\nEnter the numerator for the next fraction to test: ");
            numerator = input.nextInt();

            System.out.print("Enter the denominator for the next fraction to test: ");
            denominator = input.nextInt();
            while (tryAgain2) {
                try {
                    fraction2.setFraction(numerator, denominator);
                    tryAgain2 = false;
                } catch (DivisionByZeroException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Enter the numerator for the next fraction: ");
                    numerator = input.nextInt();

                    System.out.print("Enter the denominator for the next fraction: ");
                    denominator = input.nextInt();
                }
            }
            if (fraction2.equals(fraction1)) {
                System.out.println("The fraction you just entered EQUALS the first fraction of: " + fraction1 + "\n");
            } else {
                System.out.println("The fraction you just entered DOES NOT EQUAL the first fraction of: " + fraction1 + "\n");
            }
            System.out.print("Would you like to continue(Y/N)? ");
            if (input.next().equalsIgnoreCase("N")) {
                tryAgain = false;
            }
        } // end while
    } // end main
} // end class
