package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
        //如果加密之后有'/',需要在传递之前URLEncoder，之后再用，接收到之后URLDecoder，解密操作。
        String aes = "1021";
        String key ="test201812345678";
        String encyt = null;
        try {
            encyt = AES.AESEncrypt(aes,key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        encyt =  URLEncoder.encode(encyt,"utf-8");
        encyt = URLDecoder.decode(encyt,"utf-8");
        String decryt = null;
        try {
            decryt = AES.AESDecrypt(encyt,key);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        String[] douhao = "1,6,60".split(",");
        String[] vs = "1.6.60".split("\\.");
        String[] versions = "1.7.56".split("\\.");

        String strDate = "Wed Aug 08 05:28:44 +0800 2018";

        Date date = parse(strDate, "EEE MMM dd HH:mm:ss Z yyyy");


        Date now = new Date();
        long millis = now.getTime();
        System.out.println(millis);

        SpringApplication.run(DemoApplication.class, args);



    }


    public static Date parse(String strDate, String pattern)
            throws ParseException
    {
        return (strDate == null || strDate.length() == 0) ? null : new SimpleDateFormat(
                pattern, Locale.US).parse(strDate);
    }
}
