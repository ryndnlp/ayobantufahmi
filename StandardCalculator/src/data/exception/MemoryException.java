package data.exception;
public class MemoryException extends BaseException{

    public MemoryException(){
        super();
        
    }
    public String PrintMessage(){
        this.msg += "Empty memory";
        return this.msg;
    }
}