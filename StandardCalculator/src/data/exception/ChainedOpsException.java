package data.exception;
public class ChainedOpsException extends BaseException{
    
    public ChainedOpsException(){
        super();
        
    }
    public String PrintMessage(){
        this.msg += "Chained operators";
        return this.msg;
    }
}