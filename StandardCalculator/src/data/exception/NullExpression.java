package data.exception;
public class NullExpression extends BaseException{
    
    public NullExpression(){
        super();
    }
    public String PrintMessage(){
        this.msg += "NullExpression";
        return this.msg;
    }
}