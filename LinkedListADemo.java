package chapter15;

/**
 *
 * @author Jacob Stewart, 11/3/2020, Doubly linked list demo, CIT-130
 */
public class LinkedListADemo {

    public static void main(String[] args) {
        LinkedListA<StockItem> clothes = new LinkedListA<>();
        LinkedListA.LinkedListAIterator i = clothes.iterator();

        clothes.addToStart(new StockItem("shoes", 1));
        clothes.addToStart(new StockItem("pants", 2));
        clothes.addToStart(new StockItem("shirts", 3));
        clothes.addToStart(new StockItem("hats", 4));

        System.out.println("List \"clothes\" contains:");
        System.out.println(clothes);
        System.out.println("Reversed:");
        clothes.outputListBackwards();
        System.out.println("");

        LinkedListA<StockItem> newClothes = new LinkedListA<>(clothes);
        System.out.println("A copy of \"clothes\":");
        System.out.println(newClothes);

        System.out.println("They are equal? " + clothes.equals(newClothes));
        System.out.println("");

        clothes.deleteHeadNode();
        System.out.println("Deleting first item.");
        System.out.println("List \"clothes\" now contains:");
        System.out.println(clothes);

        System.out.println("Our copy stays the same:");
        System.out.println(newClothes);
        System.out.println("They are equal? " + clothes.equals(newClothes));
        System.out.println("");

        System.out.println("Using iterator:");
        i.restart();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("");

        i.restart();
        i.next();
        System.out.println("Deleting: " + i.peek());
        i.delete();

        System.out.println("\"clothes\" now:");
        i.restart();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("");

        i.restart();
        System.out.println("Inserting \"socks 5\" before \"" + i.peek() + "\"");
        i.insertHere(new StockItem("socks", 5));
        System.out.println("\"clothes\" now:");
        i.restart();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("");
        
        System.out.println("Reversed:");
        clothes.outputListBackwards();
    }
}
