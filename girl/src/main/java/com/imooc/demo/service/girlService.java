package com.imooc.demo.service;

import com.imooc.demo.domain.baseResponse;
import com.imooc.demo.domain.requestParam.appUserinfo;
import com.imooc.demo.domain.requestParam.userInfo;

import java.util.List;

public class girlService {


    /**
     * 事务处理  Transactional
     */
    public baseResponse GetInfo(appUserinfo lst) {
        baseResponse result = new baseResponse();
        result.setStatus(0);
        result.setMsg("恭喜，调用成功！");
        result.setData(lst);
        return result;
    }
}
