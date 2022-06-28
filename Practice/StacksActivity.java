package Practice;

/**
 *
 * @author Jacob
 */
import java.util.Stack;
public class StacksActivity {

    
    public static void main(String[] args) {
        
        Stack<String> webpages = new Stack();
        Stack<String> poppedPages = new Stack();
        
        System.out.println("Before opening our browser:");
        System.out.println(webpages);
        
        // Push elements onto the stack
        webpages.push("www.myworkemail.com");
        webpages.push("www.mypersonalemail.com");
        webpages.push("www.youtube.com");
        webpages.push("www.news.com");
        webpages.push("www.ccac.com");
        // Print stack
        System.out.println("\nToday's history so far:");
        System.out.println(webpages);
        
        System.out.println("\nCurrent page: " + webpages.peek());
        
        System.out.println("\nNot ready to work yet, let's go back a "
                + "couple of pages and watch some more youtube ..");
        
        backward(webpages, poppedPages);
        backward(webpages, poppedPages);
        
        System.out.println("\nCurrent page: " + webpages.peek());
        
        // Current stack (after popping)
        System.out.println("Current stack: " + webpages);
        System.out.println("Popped stack: " + poppedPages);
        
        forward(webpages, poppedPages);
        forward(webpages, poppedPages);
        
         System.out.println("\nCurrent page: " + webpages.peek());
         System.out.println("Current stack: " + webpages);
         System.out.println("Popped stack: " + poppedPages);

    }
    
    public static void backward(Stack main, Stack backup){
        System.out.println("\nPopping " + main.peek());
        backup.push(main.pop());
    }
    
    public static void forward(Stack main, Stack backup){
        System.out.println("\nPushing " + backup.peek());
        main.push(backup.pop());
    }
}
