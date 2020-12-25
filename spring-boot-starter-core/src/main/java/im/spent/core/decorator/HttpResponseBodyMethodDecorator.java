package im.spent.core.decorator;

import im.spent.core.spec.JSONResponse;
import im.spent.core.status.HttpResponseStatus;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HttpResponseBodyMethodDecorator implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler processor;

    public HttpResponseBodyMethodDecorator(HandlerMethodReturnValueHandler processor) {
        this.processor = processor;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return this.processor.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        JSONResponse<Object> response = new JSONResponse<>();
        response.setStatus(HttpResponseStatus.SUCCESS.getStatus());
        response.setMessage(HttpResponseStatus.SUCCESS.getMessage());
        response.setData(o);
        this.processor.handleReturnValue(response, methodParameter, modelAndViewContainer, nativeWebRequest);
    }
}
