package im.spent.core.exception;

public class DataInvalidException extends CommonException {

    public DataInvalidException(String status, String message) {
        super(status, message);
    }

    public DataInvalidException(String status, String message, Throwable cause) {
        super(status, message, cause);
    }
}
