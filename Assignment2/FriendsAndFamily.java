package Assignment2;

import java.util.Scanner;

/**
 *
 * @author Jacob Stewart
 */
public class FriendsAndFamily {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Object[] friendsAndFamily;
        Friend fri;
        Family fam;
        String name;
        String relation;
        int timeKnown;
        int type;

        System.out.println(
                "How many friends and/or family members are you entering?:");
        friendsAndFamily = getSize(input);

        for (int i = 0; i < friendsAndFamily.length; i++) {
            type = friendOrFamily(input);

            if (type == 0) {
                name = getName(input, type);
                timeKnown = getTimeKnown(input, name);
                fri = new Friend(name, timeKnown);
                friendsAndFamily[i] = fri;
            } else if (type == 1) {
                name = getName(input, type);
                relation = getRelation(input, name);
                fam = new Family(name, relation);
                friendsAndFamily[i] = fam;
            } else {
                System.out.println("\nError: invalid input\nEnding program...");
                System.exit(0);
            }
        }
        display(friendsAndFamily);
    }

    public static Object[] getSize(Scanner sc) {
        int size = sc.nextInt();
        while (size <= 0) {
            System.out.println(
                 "\nHow many friends and/or family members are you entering?:");
            size = sc.nextInt();
        }
        Object[] sizeArray = new Object[size];
        return sizeArray;
    }

    public static int friendOrFamily(Scanner sc) {
        System.out.println("\nAre you entering a friend or family member?\n"
                + "(Answer with \"friend\" or \"family\"):");
        String f = sc.next();
        if (f.equalsIgnoreCase("friend")) {
            return 0;
        } else if (f.equalsIgnoreCase("family")) {
            return 1;
        } else {
            return 2;
        }
    }

    public static String getName(Scanner sc, int t) {
        switch (t) {
            case 0:
                System.out.println("\nEnter your friend's name: ");
                break;
            case 1:
                System.out.println("\nEnter your family member's name: ");
                break;
            default:
                System.out.println("\nError: invalid input\nEnding Program...");
                System.exit(0);
        }
        sc.nextLine();
        String name = sc.nextLine();
        return name;
    }

    public static String getRelation(Scanner sc, String n) {
        System.out.println("\nWhat is your relation to " + n + "?:");
        String r = sc.nextLine();
        return r;
    }

    public static int getTimeKnown(Scanner sc, String n) {
        System.out.println("\nHow many years have you known " + n + "?:");
        int t = sc.nextInt();
        return t;
    }

    public static void display(Object[] faf) {
        System.out.println();
        for (Object e : faf) {
            System.out.println(e);
        }
    }
}
