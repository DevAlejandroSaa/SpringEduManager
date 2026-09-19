package cl.edu.core.interceptor.util;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InterceptorLogUtil {

    private static final String START_TIME_ATTRIBUTE = InterceptorLogUtil.class.getName() + ".startTime";

    public void startRequest(HttpServletRequest request) {
        request.setAttribute(START_TIME_ATTRIBUTE, Instant.now());
        log.info("Inicio de solicitud: {} {}", request.getMethod(), request.getRequestURI());
    }

    public void completeRequest(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        Instant startTime = (Instant) request.getAttribute(START_TIME_ATTRIBUTE);
        long duration = startTime != null ? Duration.between(startTime, Instant.now()).toMillis() : 0;
        if (ex != null) {
            log.error("Error en solicitud: {} {} - estado={} - duración={} ms", request.getMethod(),
                    request.getRequestURI(), response.getStatus(), duration, ex);
            return;
        }
        log.info("Solicitud completada: {} {} - estado={} - duración={} ms", request.getMethod(),
                request.getRequestURI(), response.getStatus(), duration);
    }

}
