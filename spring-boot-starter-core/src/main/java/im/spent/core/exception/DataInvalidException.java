package im.spent.core.exception;

public class DataInvalidException extends RuntimeException {

    public DataInvalidException() {
    }

    public DataInvalidException(String message) {
        super(message);
    }

    public DataInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataInvalidException(Throwable cause) {
        super(cause);
    }

    public DataInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
