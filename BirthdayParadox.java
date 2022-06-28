package chapter16;

/**
 *
 * @author Jacob Stewart, 11/14/2020, Test for same birthdays among a group of
 * people using a HashSet, CIT-130
 */
import java.util.HashSet;

public class BirthdayParadox {

    public static void main(String[] args) {

        for (int i = 10; i <= 100; i += 10) {
            int collisions = 0;

            for (int j = 0; j < 100000; j++) {
                HashSet<Integer> birthdays = new HashSet<>();

                for (int k = 0; k < i; k++) {

                    int day = (int) (Math.random() * 365 + 1);
                    if (birthdays.contains(day)) {
                        collisions++;
                        break;
                    }
                    birthdays.add(day);
                    
                }
            }
            System.out.println("After 100000 tests there were " + collisions
                    + " occurences of shared birthdays in a set of "
                    + i + " people.");
            System.out.println("Probability: " + (collisions / 100000.0));
        }
    }
}
