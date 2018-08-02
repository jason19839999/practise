package com.imooc.demo.controller;

import com.imooc.demo.GirlApplication;
import com.imooc.demo.domain.baseResponse;
import com.imooc.demo.domain.girlEntity;
import com.imooc.demo.domain.requestParam.appUserinfo;
import com.imooc.demo.domain.requestParam.userInfo;
import com.imooc.demo.properties.girlProperties;
import com.imooc.demo.service.girlService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    /**
     * Map 应用： https://www.cnblogs.com/lzq198754/p/5780165.html
     *
     *
     * */

    /**
     * @Value("${cupSize}") 获取单个配置
     * private  java.lang.String cupSize;
     */

    @Autowired                                      /**       获取多个配置*/
            girlProperties objgirlProperties;
    /**
     * 这个注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get。
     */
    @Autowired
    girlEntity objGirlEntity;

    @RequestMapping(value = {"/getGirl/{id}", "getG/{id}"}, method = RequestMethod.GET)
    /**   http://localhost:8082/api/hello/getGirl/9988   */
    public java.lang.String HelloSpringBoot(@PathVariable("id") int id) {
        return "Hello SPRINGBOOT!" + objgirlProperties.getCupSize() + "--" + objgirlProperties.getAge() + "--" + objgirlProperties.getContent() + id;
        /**return "index";  配置模板 添加Directory templates必须是这个名字*/
    }

    @RequestMapping(value = "/requestDeal", method = RequestMethod.GET)
    /**   http://localhost:8082/api/hello/requestDeal?id=99   */
    public java.lang.String RequestDeal(@RequestParam(value = "id", required = false, defaultValue = "0") int myId,
                                        @RequestParam(value = "name", required = false, defaultValue = "") java.lang.String myName) {

        return "RequestDeal! id= " + myId + "---Name: " + myName;
    }

    @RequestMapping(value = "/dealMap", method = RequestMethod.GET)
    /**   key-value 返回   */
    public Map<java.lang.String, Object> MapDeal() {

        Map<java.lang.String, Object> map = new HashMap<java.lang.String, Object>();
        map.put("girlObject", objgirlProperties);
        map.put("girlDesc", "不错");

        List<java.lang.String> versions = Arrays.asList("1.6.6", "1.7.5");
        return map;
    }

    @RequestMapping(value = "/paraDeal", method = RequestMethod.POST)
    /**  处理参数为json对象，这个常用   */
    public baseResponse DealParaJson(@RequestBody appUserinfo lst) throws InterruptedException {
        long startTimes = System.currentTimeMillis();
        baseResponse result = new baseResponse();
        girlService objService = new girlService();
        result = objService.GetInfo(lst);

        Thread.sleep(2000);
        long endTeims = System.currentTimeMillis();
        long results = endTeims - startTimes;
        System.out.print("执行时间： " + results);
        return result;
    }


}
