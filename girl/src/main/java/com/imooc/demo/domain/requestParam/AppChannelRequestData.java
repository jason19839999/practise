package com.imooc.demo.domain.requestParam;

public class AppChannelRequestData {
    //--TODO
    private int type; // 0-表示获取订阅和全部；1-获取全部；2-获取订阅

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
