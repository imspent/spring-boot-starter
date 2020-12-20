package im.spent.core.exception;

public abstract class CommonException extends RuntimeException {

    private String status;

    public CommonException(String status, String message) {
        super(message);
        this.status = status;
    }

    public CommonException(String status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
