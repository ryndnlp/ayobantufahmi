package data.exception;
public class LackOperatorException extends BaseException{
    
    public LackOperatorException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "Lack of operator";
        return this.msg;
    }
}