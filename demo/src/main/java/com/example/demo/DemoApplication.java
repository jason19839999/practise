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
        String specialInfo = "";
        Matcher astockMatcher = astock.matcher("《美联储》提议放松对IPO 顶级银行以外金融机构的监管");
        Matcher ostockMatcher = ostock.matcher("《美联储》提议放松对IPO 顶级银行以外金融机构的监管");
        if (astockMatcher.find()) {
            specialInfo = astockMatcher.group();
        } else if (ostockMatcher.find()) {
            specialInfo = ostockMatcher.group();
        }
       if( "跳跃网络赴美上市获批 游戏业新一轮洗牌将临".contains("上市")){
           specialInfo = "";
       }

       String regex = "同花顺_美股 美股公司新闻";
        String[] websiteRegex = regex.split("_");
        String websiteOfMap = websiteRegex[0];
        String regexOfMap = websiteRegex[1];
        if (websiteOfMap.equals("新浪财经") && regexOfMap.contains("美股  美股精选资讯  正文")) {
            regexOfMap = null;
        }


        //如果加密之后有'/',需要在传递之前URLEncoder，之后再用，接收到之后URLDecoder，解密操作。
        String aes = "1021";
        String key ="test201812345678";
        String encyt = null;
        try {
            encyt = AES.AESEncrypt(aes,key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int indexOf = "美股宏观".indexOf("美股");
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
