package data.exception;
public class BracketException extends BaseException{
    
    public BracketException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "Unpaired bracket";
        return this.msg;
    }
}