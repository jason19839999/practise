package com.example.demo.controller;

import com.example.demo.aspect.RequestLog;
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

    @RequestLog
    @GetMapping("/getMsg")
    public String getMsg(@RequestParam("token") String token){
        return token;
    }

    @RequestLog
    @PostMapping("/getMsg2")
    public String getMsg2(@RequestBody Params params){
        return params.getToken();
    }
}

class Params{

    private String token;
    private String login_name;

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}