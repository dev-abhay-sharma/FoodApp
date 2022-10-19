package com.swinfotech.foodapp.signin.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpModel {

        @SerializedName("loginToken")
        @Expose
        private String loginToken;
        @SerializedName("Status")
        @Expose
        private Integer status;
        @SerializedName("Resp")
        @Expose
        private String resp;

        /**
         * No args constructor for use in serialization
         *
         */
        public SignUpModel() {
        }

        /**
         *
         * @param resp
         * @param loginToken
         * @param status
         */
        public SignUpModel(String loginToken, Integer status, String resp) {
            super();
            this.loginToken = loginToken;
            this.status = status;
            this.resp = resp;
        }

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
