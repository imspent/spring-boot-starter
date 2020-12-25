package im.spent.core.status;

public enum HttpResponseStatus {
    SUCCESS("000000", "操作成功"),
    REQUEST_DATA_INVALID("R00001", "请求报文不合法"),
    SQL_CONSTRAINT_VIOLATION("S00001", "数据完整性异常");

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
