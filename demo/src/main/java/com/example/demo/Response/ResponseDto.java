package com.example.demo.Response;

/**
 * @描述
 * @创建人 shicong.zhang
 * @创建时间 $date$
 * @修改人和其它信息
 */
public class ResponseDto {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InfoDto getData() {
        return data;
    }

    public void setData(InfoDto data) {
        this.data = data;
    }

    private int status = 200;
    private String message = "request success";
    private InfoDto data;

}
