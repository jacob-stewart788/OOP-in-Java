package chapter10;

/**
 *
 * @author Jacob Stewart; 10/10/20; Assignment 6; Binary and text IO file; CIT
 * 130
 */
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class BinaryAndTextIO {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean a = true;
        while (a) {
            System.out.println("Enter the file name:");
            String fileName = input.nextLine();
            System.out.println("Choose binary or text file:");
            String binaryOrText = input.nextLine();
            System.out.println("Choose read or write(r/w):");
            String readOrWrite = input.nextLine();
            if (binaryOrText.equalsIgnoreCase("b")) {
                try {
                    RandomAccessFile ioStream = new RandomAccessFile(fileName, "rw");
                    boolean b = true;
                    if (readOrWrite.equalsIgnoreCase("w")) {
                        while (b) {
                            System.out.println("Enter a line of information to write to the file:");
                            String line = input.nextLine();
                            ioStream.writeUTF(line);
                            System.out.println("Would you like to enter another line? (Y/N):");
                            String yesOrNo = input.nextLine();
                            if (yesOrNo.equalsIgnoreCase("n")) {
                                b = false;
                            }
                        }
                    }
                    if (readOrWrite.equalsIgnoreCase("r")) {
                        System.out.println("File contains:");
                        String line = ioStream.readUTF();
                        System.out.println(line);
                    }
                    ioStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Problem opening binary file");
                } catch (IOException e) {
                    System.out.println("Problem with binary file I/O");
                }

            }// end if for binary
            if (binaryOrText.equalsIgnoreCase("t")) {
                PrintWriter outputStream = null;
                if (readOrWrite.equalsIgnoreCase("w")) {
                    try {
                        outputStream = new PrintWriter(new FileOutputStream(fileName));
                    } catch (FileNotFoundException e) {
                        System.out.println("Problem opening text file for writing");
                    }
                    boolean c = true;
                    while (c) {
                        System.out.println("Enter a line of information to write to the file:");
                        String line = input.nextLine();
                        outputStream.println(line);
                        System.out.println("Would you like to enter another line? (Y/N):");
                        String yesOrNo = input.nextLine();
                        if (yesOrNo.equalsIgnoreCase("n")) {
                            c = false;
                        }
                    }
                    outputStream.close();
                } // end if for text writing
                if (readOrWrite.equalsIgnoreCase("r")) {
                    Scanner inputStream = null;
                    try {
                        inputStream = new Scanner(new FileInputStream(fileName));
                    } catch (FileNotFoundException e) {
                        System.out.println("Problem opening text file for reading");
                    }
                    while (inputStream.hasNextLine()) {
                        String line = inputStream.nextLine();
                        System.out.println(line);
                    }
                    inputStream.close();
                }// end if for text reading
            }// end if for text
            System.out.println("Continue? (Y/N):");
            String toContinue = input.nextLine();
            if (toContinue.equalsIgnoreCase("n")) {
                a = false;
            }
        } // end first while
    } // end main
} // end class
