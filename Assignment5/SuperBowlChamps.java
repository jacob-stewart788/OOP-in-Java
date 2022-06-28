package Assignment5;

/**
 *
 * @author Jacob
 */
import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

public class SuperBowlChamps {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        Document doc = Jsoup.connect("https://blog.ticketcity.com/nfl/super-bowl/super-bowl-champions/").get();
        
        String[] champs = new String[56];
        
        Elements data = doc.select("td");
//        System.out.println(data);
        
        int winner = 2; // the winner starts as the third td tag and increments by 6 each time following
        int tdCounter = 0; // counter for current td tag
        int champCounter = 0;// counter for current champs[] index
        for (Element element : data) {
            if(tdCounter == winner){
                champs[champCounter] = element.text();
                champCounter++;
                winner += 6;
            }
            tdCounter++;
        }
//        System.out.println(Arrays.toString(champs));
        System.out.println("Enter a team's name and I can tell you how many Super Bowls they have won.");
        System.out.println("Use full names, for example ( Dallas Cowboys ):");
        String team = input.nextLine();
        
        int teamWins = 0;
        for (String name: champs) {
            if(name.equalsIgnoreCase(team)){
                teamWins++;
            }
        }
        if(teamWins == 0){
            System.out.println("\nHAHAHA that's a good one! The " + team + 
                    " have not won a Super Bowl. \nNot a single one! Nil! Null! "
                            + "Zero! Zip! Zilch! Nada! Nought! Diddly-squat! "
                            + "\nA big 'ole Goose Egg!");
        }
        else{
            System.out.println("\nThe " + team + " have won the Super Bowl " + teamWins + " time(s).");
        }
    }
}
