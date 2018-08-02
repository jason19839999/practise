package com.imooc.demo.domain.requestParam;

public class userInfo {
    private int userId;
    private String userName;
    private String sessionId;

    private AppChannelRequestData request_data;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public AppChannelRequestData getRequest_data() {
        return request_data;
    }

    public void setRequest_data(AppChannelRequestData request_data) {
        this.request_data = request_data;
    }
}
