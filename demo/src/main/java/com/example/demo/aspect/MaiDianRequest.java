package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Response.ResponseDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 shicong.zhang
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Component
@Scope
@Aspect
@Order(3)
public class MaiDianRequest {

    @Around(value = "@annotation(com.example.demo.aspect.MaiDaianRequest)")
    public Object around(ProceedingJoinPoint joinPoint) throws InterruptedException {
        Object obj = null;
        try {
            obj = joinPoint.proceed();
            String json = JSONObject.toJSONString(obj);//将java对象转换为json对象
            JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject data = jsonObject.getJSONObject("data");
            String total = data.getString("total");
            total = "";
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

}
