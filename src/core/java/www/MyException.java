package core.java.www;

public class MyException extends RuntimeException{
    public MyException() {
    }

    public MyException(final String message) {
        super(message);
    }

    public MyException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
