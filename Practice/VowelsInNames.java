package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class VowelsInNames {

    public static void main(String[] args) {
        Scanner input = null;
        File f = new File("names.txt");
        String strName;
        int total;

        try {
            input = new Scanner(f);

        } catch (FileNotFoundException e) {
            System.out.println(f + " not found.");
            System.exit(0);
        }

        while (input.hasNext()) {
            strName = input.next().toLowerCase();
            total = countVowels(strName);
            System.out.println(strName + " contains " + total + " vowels.");
        }
        input.close();
    }

    public static int countVowels(String name) {
        char[] vowels = "aeiouy".toCharArray();
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (name.charAt(i) == vowels[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
