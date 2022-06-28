package Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class CaesarCipher_Stewart {

    public static void main(String[] args) {
        File f = new File("passwords.txt"); // change to passwords.txt
        Scanner input = null;
        int shift = 5; // change to 5
        String list = "";
        String currentPass = "";

        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println(f + " not found, exiting program...");
            System.exit(0);
        }

        while (input.hasNext()) {
            currentPass = input.next();
            list += decrypt(currentPass, shift) + "\n";
        }
        System.out.println("***Decrypted***\n" + list);
        input.close();
    }

    public static String decrypt(String pass, int shift) {
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String decrypt = "";
        int pos;
        int dif;
        char currentChar;

        for (int i = 0; i < pass.length(); i++) {
            currentChar = pass.charAt(i);
            pos = String.valueOf(alph).indexOf(currentChar);
            dif = pos - shift;
            if (dif < 0) {
                dif += 26;
            }
            decrypt += alph[dif];
        }

        return decrypt;
    }
}
