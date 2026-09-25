package cl.edu.core.interceptor.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import cl.edu.core.interceptor.util.InterceptorLogUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HttpRequestInterceptor implements HandlerInterceptor {

    private final InterceptorLogUtil interceptorLogUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        this.interceptorLogUtil.startRequest(request);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        this.interceptorLogUtil.completeRequest(request, response, ex);
    }

}
