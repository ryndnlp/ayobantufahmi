package data.exception;
public class BracketException extends BaseException{
    
    public BracketException(){
        super();
    }
    public String printMessage(){
        this.msg += "Unpaired bracket";
        return this.msg;
    }
}