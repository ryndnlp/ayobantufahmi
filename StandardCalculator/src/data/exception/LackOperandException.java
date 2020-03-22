package data.exception;
public class LackOperandException extends BaseException{
    
    public LackOperandException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "Lack of operand";
        return this.msg;
    }
}