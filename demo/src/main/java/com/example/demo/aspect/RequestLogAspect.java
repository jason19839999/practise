package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Scope
@Aspect
@Order(10000)
//order越小越是最先执行，但更重要的是最先执行的最后结束。order默认值是2147483647
public class RequestLogAspect {


    @Before(value = "@annotation(com.example.demo.aspect.RequestLog)")
    public void before(JoinPoint joinPoint) throws IOException {
        //处理逻辑
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String body = "";
        if (request.getMethod().equals("GET")) {
            body = request.getQueryString();
        } else {
            body = JSONObject.toJSONString(joinPoint.getArgs());
        }

        //获取token，如果token验证通过，那么就放行，否则throw  new  GlobalException......
        String token = request.getParameter("token");
        token = "";

    }

    @AfterReturning(returning = "object", value = "@annotation(com.example.demo.aspect.RequestLog)")
    public void doAfterReturning(Object object) {
        //处理逻辑
        Object obj = object;
    }


}







