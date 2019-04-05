package com.example.demo;

import com.example.demo.Response.BaseResponse;
import com.example.demo.Response.TableResultResponse;
import com.example.demo.aspect.MaiDaianRequest;
import com.example.demo.entity.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @描述
 * @创建人 shicong.zhang
 * @创建时间 $date$
 * @修改人和其它信息
 */
@RestController
public class MaiDianController {

    @MaiDaianRequest()
    @GetMapping("/search")
    public BaseResponse search() {
        try {
            List<StudentEntity> stuList = new ArrayList<StudentEntity>();
            StudentEntity o1= new StudentEntity();
            o1.setAge(18);
            o1.setName("zhanglaosan");
            StudentEntity o2= new StudentEntity();
            o2.setAge(20);
            o2.setName("houlaosi");
            stuList.add(o1);
            stuList.add(o2);
            return new TableResultResponse<>(20, stuList);
        } catch (Exception e) {
            return new BaseResponse(500, e.getMessage());
        }
    }
}
