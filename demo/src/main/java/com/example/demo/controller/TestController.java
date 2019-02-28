package com.example.demo.controller;

import com.example.demo.aspect.Servicelock;
import org.springframework.web.bind.annotation.*;

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
    public String getMsg(@RequestParam("token") String token){
        return token;
    }

    @Servicelock
    @PostMapping("/getMsg2")
    public String getMsg2(@RequestBody Params params){
        return params.getToken();
    }
}

class Params{

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}