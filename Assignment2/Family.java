package Assignment2;

/**
 *
 * @author Jacob
 */
public class Family {
    
    private String name;
    private String relation;
    
    public Family(String n, String r){
        name = n;
        relation = r;
    }
    
    public String toString(){
        return name + 
              " is a member of your family, your relation is " + relation + ".";
    }
}
