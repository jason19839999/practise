package com.example.demo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;



@Component
@Scope
@Aspect
@Order(3)
//order越小越是最先执行，但更重要的是最先执行的最后结束。order默认值是2147483647
public class ServicelockAspect {




	@Before(value = "@annotation(com.example.demo.aspect.Servicelock)")
	public  void before() {
		//处理逻辑
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//获取token，如果token验证通过，那么就放行，否则throw  new  GlobalException......
		String token = request.getParameter("token");



	}

	@AfterReturning(returning = "object", value = "@annotation(com.example.demo.aspect.Servicelock)")
	public  void doAfterReturning(Object object) {
		//处理逻辑
		Object obj = object;

	}


}







