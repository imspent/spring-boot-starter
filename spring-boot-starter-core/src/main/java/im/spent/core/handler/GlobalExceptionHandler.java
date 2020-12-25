package im.spent.core.handler;

import im.spent.core.exception.DataInvalidException;
import im.spent.core.spec.JSONResponse;
import im.spent.core.status.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = DataInvalidException.class)
    public JSONResponse<String> dataInvalidExceptionHandler(HttpServletRequest request, DataInvalidException exception) {
        logger.error("数据非法异常: 主机 {} 调用地址 {} 错误信息 {}", request.getRemoteHost(), request.getRequestURL(), exception.getMessage());
        return JSONResponse.of(HttpResponseStatus.REQUEST_DATA_INVALID, exception.getMessage());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public JSONResponse<String> sqlIntegrityConstraintViolationExceptionHandler(HttpServletRequest request, SQLIntegrityConstraintViolationException exception) {
        logger.error("数据非法异常: 主机 {} 调用地址 {} 错误信息 {}", request.getRemoteHost(), request.getRequestURL(), exception.getMessage());
        return JSONResponse.of(HttpResponseStatus.SQL_CONSTRAINT_VIOLATION, exception.getMessage());
    }
}
