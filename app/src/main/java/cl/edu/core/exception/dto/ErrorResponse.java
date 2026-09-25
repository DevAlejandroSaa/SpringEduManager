package cl.edu.core.exception.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus httpStatus, String messageKey) {

    public Map<String, Object> toMap() {
        Map<String, Object> response = new HashMap<>();
        response.put("cause", messageKey);
        response.put("code", httpStatus.value());
        return response;
    }

}
