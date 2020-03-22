package data.exception;
public class InvalidOperandException extends BaseException{
    

    public InvalidOperandException(){
        super();
    }
    public String PrintMessage(){
        this.msg += "Invalid operand";
        return this.msg;
    }
}