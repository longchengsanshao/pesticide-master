package pesticide.server.interceptor;

import pesticide.server.annotation.Auth;
import pesticide.server.exception.AuthException;
import pesticide.server.util.JwtAuthUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth classAuth = handlerMethod.getBeanType().getAnnotation(Auth.class);
        Auth methodAuth = handlerMethod.getMethodAnnotation(Auth.class);
        if (classAuth != null || methodAuth != null) {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (token == null) {
                throw new AuthException(403, "client need an authorization.");
            }
            int userId = JwtAuthUtils.parseId(token);
            request.getSession().setAttribute("userId", userId);
        }
        return true;
    }
}
