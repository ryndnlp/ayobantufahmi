package data.exception;
public class StackException extends BaseException{
    
    public StackException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "Empty stack";
        return this.msg;
    }
}