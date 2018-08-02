package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        String tmp ="";
        String obj ="201711";
        tmp = obj.substring(0,4) + "年" + obj.substring(4,6) + "月";

        int pageSize = 6;
        int showCount = 30;
        int start;
        int count;
        start = showCount * (pageSize -1) + 1;
        count = showCount;
        String name="weicc-20100107-00001";
        name = name.substring(name.length()-2);//输出01

        String code = "61816988";
        if(!code.equals("") && code != null){
            String header = code.substring(0,3);
            String ender = code.substring(code.length()-3);
            String result = header + "**" + ender;
            header ="";
        }

        String[] vs = "1.6.60".split("\\.");
        String[] versions = "1.7.56".split("\\.");

        Date now = new Date();
        long millis = now.getTime();
        System.out.println(millis);

        SpringApplication.run(DemoApplication.class, args);



    }



}
