package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    /**
     * 业务日志的各种日志打印
     */
    private static final Log BUSINESS_LOG = LogFactory.getLog("BUSINESS.ASYNC");

    @Before(value = "@annotation(com.example.demo.aspect.RequestLog)")
    public void before(JoinPoint joinPoint) throws IOException {
        try {
            //处理逻辑
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String body = "";
            if (request.getMethod().equals("GET")) {
                body = request.getQueryString();
            } else {
                body = JSONObject.toJSONString(joinPoint.getArgs());
            }

            BUSINESS_LOG.info(body);

            //获取token，如果token验证通过，那么就放行，否则throw  new  GlobalException......
            String token = request.getParameter("token");
            token = "";
        }catch(Exception ex){
            BUSINESS_LOG.error(ex.getMessage());
        }

    }

    @AfterReturning(returning = "object", value = "@annotation(com.example.demo.aspect.RequestLog)")
    public void doAfterReturning(Object object) {
        //处理逻辑
        Object obj = object;
        String result =  JSONObject.toJSONString(object);
        BUSINESS_LOG.info(result);
        result = "";
    }


}







