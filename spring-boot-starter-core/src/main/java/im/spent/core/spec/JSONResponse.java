package im.spent.core.spec;

import im.spent.core.status.HttpResponseStatus;

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

    public static <T> JSONResponse<T> of(HttpResponseStatus responseStatus, T data) {
        JSONResponse<T> response = new JSONResponse<>();
        response.setStatus(responseStatus.getStatus());
        response.setMessage(responseStatus.getMessage());
        response.setData(data);
        return response;
    }
}
