package com.imooc.demo.domain;


import org.springframework.context.annotation.Configuration;

@Configuration
public class girlEntity {


    public int id;


    public int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
