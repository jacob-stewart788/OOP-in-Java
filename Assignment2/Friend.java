package Assignment2;

/**
 *
 * @author Jacob
 */
public class Friend {
    
    private String name;
    private int timeKnown;
    
    public Friend(String n, int tk){
        name = n;
        timeKnown = validateTimeKnown(tk);
    }
    
    public int validateTimeKnown(int tk){
        if(tk < 0){
            return 0;
        }else{
            return tk;
        }
    }
    
    public String toString(){
        return name + " has been your bud for " + timeKnown + " year(s).";
    }
}
