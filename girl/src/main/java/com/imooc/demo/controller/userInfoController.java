package com.imooc.demo.controller;

import com.imooc.demo.domain.viewModel.userInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userInfoController {

    @RequestMapping("/list")
    public String listUser(Model model, @RequestParam(value = "id", required = false, defaultValue = "0") int myId) {
        List<userInfoEntity> userList = new ArrayList<userInfoEntity>();
        userInfoEntity obj = new userInfoEntity();
        obj.setUserId(10);
        obj.setName("AAA");
        obj.setAddress("");
        obj.setAge(23);
        for (int i = 0; i < 10; i++) {
            userList.add(obj);
        }
        int id = myId;
        model.addAttribute("users", userList);
        return "/user/list";
    }

    /**
     * 初始化添加页面  绑定实体对象，页面展示
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String Add(Model model) {

        model.addAttribute("obj", new userInfoEntity());
        return "/user/add";
    }

    /**
     * 添加页面调用的post方法       传入参数实体不能有构造函数，否则会报错，初始化失败
     */
    @RequestMapping("/dopayin")
    public String Add(@ModelAttribute userInfoEntity obj, Model model, BindingResult bindingResult) throws Exception {

        List<userInfoEntity> userList = new ArrayList<userInfoEntity>();
        for (int i = 0; i < 6; i++) {
            userList.add(obj);
        }
        /**初始化列表页面  或者跳转到结果页面  我这里跳转到了列表页面*/
        model.addAttribute("users", userList);
        userInfoController objList = new userInfoController();
        return objList.listUser(model, 0);

    }


}
