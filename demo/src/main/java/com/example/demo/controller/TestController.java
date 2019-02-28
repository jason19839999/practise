package com.example.demo.controller;

import com.example.demo.aspect.Servicelock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luoaijun
 * Date: 2019-02-28
 * Time: 13:56
 */
@RestController
public class TestController {

    @Servicelock
    @GetMapping("/getMsg")
    public String getMsg(){

        return "ok";
    }
}
