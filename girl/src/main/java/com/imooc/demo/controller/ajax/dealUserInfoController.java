package com.imooc.demo.controller.ajax;

import com.imooc.demo.domain.baseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imooc.demo.domain.requestParam.userInfo;

import java.util.List;

@RestController
@RequestMapping("/dealUserInfo")
public class dealUserInfoController {

    @RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
    public baseResponse AddUserInfo(@RequestBody List<userInfo> lst) {
        baseResponse result = new baseResponse();

        lst.get(0).setSessionId("CCC");

        result.setStatus(0);
        result.setMsg("恭喜您，已经添加成功！");
        result.setData(lst);
        return result;
    }

    @RequestMapping("/add")
    public String Add() {

        return "1";
    }
}
