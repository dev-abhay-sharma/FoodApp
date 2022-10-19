package com.swinfotech.foodapp.signin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginModel {

    @SerializedName("loginToken")
    @Expose
    private String loginToken;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Resp")
    @Expose
    private String resp;

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

}

