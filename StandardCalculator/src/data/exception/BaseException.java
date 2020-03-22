package data.exception;
public class BaseException extends Exception{
    protected String msg;

    public BaseException(){
        this.msg = "Err: ";
    }
}