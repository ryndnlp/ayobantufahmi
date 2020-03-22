package data.exception;
public class ChainedOpsException extends BaseException{
    
    public ChainedOpsException(){
        super();
        
    }
    public String printMessage(){
        this.msg += "Chained operators";
        return this.msg;
    }
}