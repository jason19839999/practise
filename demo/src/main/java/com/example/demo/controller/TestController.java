package com.example.demo.controller;

import com.example.demo.aspect.RequestLog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public Params getMsg2(@RequestBody Params params){
        return params;
    }
}

class Params{

    private String token;
    private String login_name;
    private ArrayList list;

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

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