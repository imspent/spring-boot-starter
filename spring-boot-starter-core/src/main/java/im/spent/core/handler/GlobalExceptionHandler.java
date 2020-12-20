package im.spent.core.handler;

import im.spent.core.exception.CommonException;
import im.spent.core.exception.DataInvalidException;
import im.spent.core.response.JSONResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = DataInvalidException.class)
    public JSONResponse<Void> dataInvalidExceptionHandler(HttpServletRequest request, CommonException exception) {
        logger.error("数据非法异常: 主机 {} 调用地址 {} 错误信息 {}", request.getRemoteHost(), request.getRequestURL(), exception.getMessage());
        return JSONResponse.of(exception.getStatus(), exception.getMessage());
    }
}
