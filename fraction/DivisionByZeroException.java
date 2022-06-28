package chapter9;

/**
 *
 * @author Jacob Stewart; 10/10/20; Assignment 6; Division by zero exception;
 *                                                                  CIT 130
 */
public class DivisionByZeroException extends Exception{
    public DivisionByZeroException(){
        super("Division by Zero!");
    }
    public DivisionByZeroException(String message){
        super(message);
    }
}
