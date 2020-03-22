package data.exception;
public class MemoryException extends BaseException{

    public MemoryException(){
        super();
        
    }
    public String printMessage(){
        this.msg += "Empty memory";
        return this.msg;
    }
}