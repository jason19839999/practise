package com.example.demo.controller;

import com.example.demo.aspect.RequestLog;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    public Params getMsg2(@RequestBody @Valid  Params params, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }
        String errorMsg = bindingResult.getFieldError().getDefaultMessage();
        return params;
    }
}

class Params{

    @NotNull
    private String token;
    private String login_name;
    private ArrayList list;
    @Min(10)
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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