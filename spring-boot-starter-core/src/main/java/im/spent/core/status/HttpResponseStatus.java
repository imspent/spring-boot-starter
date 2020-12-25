package im.spent.core.status;

public enum HttpResponseStatus {
    SUCCESS("000000", "操作成功");

    private final String status;
    private final String message;

    HttpResponseStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
