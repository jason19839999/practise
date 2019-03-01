package com.example.demo;

import com.example.demo.filter.VersionFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

    private static Pattern astock = Pattern.compile("(?<=《).*?(?=》)");
    private static Pattern ostock = Pattern.compile("(?<=【).*?(?=】)");
    private static final Log BUSINESS_LOG = LogFactory.getLog("BUSINESS.ASYNC");

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
        BUSINESS_LOG.info("OK le ---------------------------------------------OK le");
        SpringApplication.run(DemoApplication.class, args);

    }


    public static Date parse(String strDate, String pattern)
            throws ParseException
    {
        return (strDate == null || strDate.length() == 0) ? null : new SimpleDateFormat(
                pattern, Locale.US).parse(strDate);
    }




    @Bean
    public VersionFilter versionFilterobj(){
        return new VersionFilter();
    }

    @Bean
    public FilterRegistrationBean versionFilter(){
        VersionFilter filter =  versionFilterobj();  //这样做的目的是为了能在TokenFilter使用@Autowire。要不然注入为null....
        return filtersGen(filter, Arrays.asList("/getMsg11","/getMsg21"),null, "versionFilter", 1);
    }


    private FilterRegistrationBean filtersGen(Filter filter, List<String> uris, Map<String,String> params, String name, int order){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);

        if(uris != null && uris.size() > 0) {
            for(String uri : uris)
                registration.addUrlPatterns(uri);
        }

        if(params != null && params.size() > 0) {
            for(Map.Entry<String,String> entry : params.entrySet()){
                registration.addInitParameter(entry.getKey(),entry.getValue());
            }

        }

        registration.setName(name);
        registration.setOrder(order);
        return registration;
    }
}
