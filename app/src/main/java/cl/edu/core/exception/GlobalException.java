package cl.edu.core.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.edu.core.exception.dto.ErrorResponse;
import cl.edu.core.exception.util.ExceptionDictionaryUtil;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalException {

    private final ExceptionDictionaryUtil exceptionDictionaryUtil;

    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleException(Throwable ex) {
        return this.exceptionDictionaryUtil.getError(ex);
    }

}
