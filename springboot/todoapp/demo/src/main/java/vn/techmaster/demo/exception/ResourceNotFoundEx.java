package vn.techmaster.demo.exception;

public class ResourceNotFoundEx extends RuntimeException{
    public ResourceNotFoundEx(String message) {
        super(message);
    }
}
