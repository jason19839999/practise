package com.example.demo.aspect;
import java.lang.annotation.*;


//添加lock 注解


@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface RequestLog {
	 String name() default "jason";
	 String description()  default "";
}

