package cl.edu.core.exception.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;

import cl.edu.core.i18n.I18nConfig;

@Component
public class ErrorTypeUtil {

    @Autowired
    private I18nConfig i18nConfig;

    Map<Integer, String> errorMessages;

    private Throwable ex;
    private HttpStatus httpStatus;
    private String message;

    public ErrorTypeUtil(Throwable ex) {
        this.errorMessages = new HashMap<>();
        this.listMessageDefault();
    }

    private void listMessageDefault() {
        this.errorMessages.put(HttpStatus.BAD_REQUEST.value(), "error.bad_request");
        this.errorMessages.put(HttpStatus.UNAUTHORIZED.value(), "error.unauthorized");
        this.errorMessages.put(HttpStatus.PAYMENT_REQUIRED.value(), "error.payment_required");
        this.errorMessages.put(HttpStatus.FORBIDDEN.value(), "error.forbidden");
        this.errorMessages.put(HttpStatus.NOT_FOUND.value(), "error.not_found");
        this.errorMessages.put(HttpStatus.METHOD_NOT_ALLOWED.value(), "error.method_not_allowed");
        this.errorMessages.put(HttpStatus.NOT_ACCEPTABLE.value(), "error.not_acceptable");
        this.errorMessages.put(HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value(), "error.proxy_authentication_required");
        this.errorMessages.put(HttpStatus.REQUEST_TIMEOUT.value(), "error.request_timeout");
        this.errorMessages.put(HttpStatus.CONFLICT.value(), "error.conflict");
        this.errorMessages.put(HttpStatus.GONE.value(), "error.gone");
        this.errorMessages.put(HttpStatus.LENGTH_REQUIRED.value(), "error.length_required");
        this.errorMessages.put(HttpStatus.PRECONDITION_FAILED.value(), "error.precondition_failed");
        this.errorMessages.put(413, "error.payload_too_large");
        this.errorMessages.put(HttpStatus.URI_TOO_LONG.value(), "error.uri_too_long");
        this.errorMessages.put(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "error.unsupported_media_type");
        this.errorMessages.put(416, "error.range_not_satisfiable");
        this.errorMessages.put(HttpStatus.EXPECTATION_FAILED.value(), "error.expectation_failed");
        this.errorMessages.put(418, "error.im_a_teapot");
        this.errorMessages.put(HttpStatus.MISDIRECTED_REQUEST.value(), "error.misdirected_request");
        this.errorMessages.put(HttpStatus.UNPROCESSABLE_CONTENT.value(), "error.unprocessable_entity");
        this.errorMessages.put(HttpStatus.LOCKED.value(), "error.locked");
        this.errorMessages.put(HttpStatus.FAILED_DEPENDENCY.value(), "error.failed_dependency");
        this.errorMessages.put(HttpStatus.TOO_EARLY.value(), "error.too_early");
        this.errorMessages.put(HttpStatus.UPGRADE_REQUIRED.value(), "error.upgrade_required");
        this.errorMessages.put(HttpStatus.PRECONDITION_REQUIRED.value(), "error.precondition_required");
        this.errorMessages.put(HttpStatus.TOO_MANY_REQUESTS.value(), "error.too_many_requests");
        this.errorMessages.put(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.value(),
                "error.request_header_fields_too_large");
        this.errorMessages.put(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value(), "error.unavailable_for_legal_reasons");

        this.errorMessages.put(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error.internal");
        this.errorMessages.put(HttpStatus.NOT_IMPLEMENTED.value(), "error.not_implemented");
        this.errorMessages.put(HttpStatus.BAD_GATEWAY.value(), "error.bad_gateway");
        this.errorMessages.put(HttpStatus.SERVICE_UNAVAILABLE.value(), "error.service_unavailable");
        this.errorMessages.put(HttpStatus.GATEWAY_TIMEOUT.value(), "error.gateway_timeout");
        this.errorMessages.put(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value(), "error.http_version_not_supported");
        this.errorMessages.put(HttpStatus.VARIANT_ALSO_NEGOTIATES.value(), "error.variant_also_negotiates");
        this.errorMessages.put(HttpStatus.INSUFFICIENT_STORAGE.value(), "error.insufficient_storage");
        this.errorMessages.put(HttpStatus.LOOP_DETECTED.value(), "error.loop_detected");
        this.errorMessages.put(510, "error.not_extended");
        this.errorMessages.put(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value(),
                "error.network_authentication_required");
    }

    public void setException(Throwable ex) {
        this.ex = ex;
        this.httpStatus = this.setHttpstatus();
        this.message = this.setMessage();
    }

    private HttpStatus setHttpstatus() {
        return this.ex instanceof ErrorResponse errorResponse
                ? HttpStatus.valueOf(errorResponse.getStatusCode().value())
                : HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private String setMessage() {
        return this.httpStatus != null
                ? this.errorMessages.get(this.httpStatus.value())
                : null;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getMessage() {
        return this.i18nConfig.getMessage(this.message);
    }

}
