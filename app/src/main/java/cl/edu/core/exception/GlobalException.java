package cl.edu.core.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.edu.core.exception.dto.ErrorResponse;
import cl.edu.core.exception.util.ExceptionDictionaryUtil;

@RestControllerAdvice
public class GlobalException {

    @Autowired
    private ExceptionDictionaryUtil exceptionDictionaryUtil;

    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleException(Throwable ex) {
        return this.exceptionDictionaryUtil.getError(ex);
    }

}
