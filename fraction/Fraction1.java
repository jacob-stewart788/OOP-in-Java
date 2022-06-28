package chapter9;

/**
 *
 * @author Jacob Stewart; 10/10/20; Assignment 6; Fraction file with 
 * exception for divide by zero ; CIT 130
 */
public class Fraction1 {

    private int num;
    private int den;

    public Fraction1() {
        num = 0;
        den = 1;
    }

    public Fraction1(int a, int b) throws DivisionByZeroException{
        setFraction(a, b);
    }

    public String toString() {
        return (num + "/" + den);
    }

    public void setFraction(int a, int b) throws DivisionByZeroException {
        if(b == 0)
            throw new DivisionByZeroException("Error: cannot divide by 0.");
        num = a;
        den = b;
    }

    public boolean equals(Fraction1 f) {
        return (getNum() * f.getDen() == getDen() * f.getNum());
    }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }
}
