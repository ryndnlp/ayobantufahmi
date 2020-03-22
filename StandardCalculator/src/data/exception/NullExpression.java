package data.exception;
public class NullExpression extends BaseException{
    
    public NullExpression(){
        super();
    }
    public String printMessage(){
        this.msg += "NullExpression";
        return this.msg;
    }
}