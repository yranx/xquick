package com.ranx.chowder.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ranx.chowder.aop.annotation.AuthToken;
import com.ranx.chowder.utils.ConstantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author ranx
 * @create 2018-08-07 16:20
 **/
public class AuthorizationInterceptor implements HandlerInterceptor{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorizated";

    //鉴权失败后返回的HTTP错误码，默认401
    private int unanthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    //存放登录用户模型key的Request key
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(AuthToken.class) != null
                || ((HandlerMethod) handler).getBeanType().getAnnotation(AuthToken.class) != null) {
            String token = request.getHeader(httpHeaderName);
            log.info("token is {}", token);
            String username = "";
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            if (token != null && token.length() != 0) {
                username = jedis.get(token);
                log.info("username is {}", username);
            }

            if (username != null && !"".equals(username.trim())) {
                Long tokeBirthTime = Long.valueOf(jedis.get(token + username));
                log.info("token Birth time is :{}", tokeBirthTime);
                Long diff = System.currentTimeMillis() - tokeBirthTime;
                log.info("token is exist : {} ms",diff);
                if (diff > ConstantUtil.TOKEN_RESET_TIME) {
                    jedis.expire(username, ConstantUtil.TOKEN_EXPIRE_TIME);
                    jedis.expire(token, ConstantUtil.TOKEN_EXPIRE_TIME);
                    log.info("Rest expire time success!");
                    Long newBirthTime = System.currentTimeMillis();
                    jedis.set(token + username, newBirthTime.toString());
                }

                //用完关闭
                jedis.close();
                request.setAttribute(REQUEST_CURRENT_KEY, username);
                return true;
            } else {
                JSONObject jsonObject = new JSONObject();
                PrintWriter out = null;
                try {
                    response.setStatus(unanthorizedErrorCode);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    jsonObject.put("code", ((HttpServletResponse) response).getStatus());
                    jsonObject.put("message", HttpStatus.UNAUTHORIZED);

                    out = response.getWriter();
                    out.println(jsonObject);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }
            }
        }
        request.setAttribute(REQUEST_CURRENT_KEY, null);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
