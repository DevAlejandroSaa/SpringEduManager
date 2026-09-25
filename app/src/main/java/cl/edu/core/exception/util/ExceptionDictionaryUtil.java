package cl.edu.core.exception.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import cl.edu.core.exception.custom.CustomNotFoundException;
import cl.edu.core.exception.dto.ErrorResponse;
import cl.edu.core.i18n.I18nConfig;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExceptionDictionaryUtil {

    @Autowired
    private I18nConfig i18nConfig;

    @Autowired
    private ErrorTypeUtil errorTypeUtil;

    private final Map<Class<? extends Throwable>, Function<Throwable, ErrorResponse>> exceptionHandlers;

    public ExceptionDictionaryUtil() {
        this.exceptionHandlers = new HashMap<>();
        this.listError();
    }

    private ErrorResponse newError(HttpStatus httpStatus, String messageKey) {
        return new ErrorResponse(httpStatus, this.i18nConfig.getMessage(messageKey));
    }

    private void listError() {
        this.exceptionHandlers.put(CustomNotFoundException.class,
                ex -> this.newError(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    public ErrorResponse getError(Throwable ex) {
        this.errorTypeUtil.setException(ex);
        String message = this.errorTypeUtil.getMessage();

        if (message != null) {
            return this.newError(this.errorTypeUtil.getHttpStatus(), message);
        }

        return this.exceptionHandlers
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().isAssignableFrom(ex.getClass()))
                .map(entry -> entry.getValue().apply(ex))
                .findFirst()
                .orElse(this.newError(HttpStatus.INTERNAL_SERVER_ERROR, "error.internal"));
    }

}
