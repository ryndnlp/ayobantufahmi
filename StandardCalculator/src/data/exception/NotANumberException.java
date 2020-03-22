package data.exception;
public class NotANumberException extends BaseException{
    
    public NotANumberException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "NaN";
        return this.msg;
    }
}