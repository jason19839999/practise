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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

    private static Pattern astock = Pattern.compile("(?<=《).*?(?=》)");
    private static Pattern ostock = Pattern.compile("(?<=【).*?(?=】)");

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {

        StaticSynchronized ss = new StaticSynchronized();
        StaticSynchronized ss2 = new StaticSynchronized();
        StaticSynchronized ss3 = new StaticSynchronized();

//        new Thread(ss).start();
//        new Thread(ss).start();
//        new Thread(ss).start();

        new Thread(ss).start();
        new Thread(ss2).start();
        new Thread(ss3).start();



        Integer i = new Integer(100);
        Integer i2 = new Integer(100);
        Integer j = 100;
        int k = 100;
        boolean isEquals = i == j;
        boolean isRealEquals = i.equals(i2);
        boolean isEquals2 = i == k;
        String tmp ="";
        String[] douhao = "1,6,60".split(",");
        String[] vs = "1.6.60".split("\\.");
        String[] versions = "1.7.56".split("\\.");

        boolean isCurrent = false;
        if(isCurrent ==  false){
            isCurrent = true;
        }

        String strDate = "Wed Aug 08 05:28:44 +0800 2018";
        Date date = parse(strDate, "EEE MMM dd HH:mm:ss Z yyyy");

        SpringApplication.run(DemoApplication.class, args);

    }


    public static Date parse(String strDate, String pattern)
            throws ParseException
    {
        return (strDate == null || strDate.length() == 0) ? null : new SimpleDateFormat(
                pattern, Locale.US).parse(strDate);
    }
}
