package data.exception;
public class StackException extends BaseException{
    
    public StackException(){
        super();
    }
    public String printMessage(){
        this.msg += "Empty stack";
        return this.msg;
    }
}