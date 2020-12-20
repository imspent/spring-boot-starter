package im.spent.core.response;

public class JSONResponse<T> {

    private String status;

    private String message;

    private T data;

    public JSONResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> JSONResponse<T> of(String status, String message) {
        JSONResponse<T> response = new JSONResponse<>();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
}
