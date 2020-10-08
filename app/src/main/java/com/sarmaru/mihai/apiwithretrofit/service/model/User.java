package com.sarmaru.mihai.apiwithretrofit.service.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int userID;
    @SerializedName("name")
    private String userName;
    @SerializedName("username")
    private String userUsername;
    @SerializedName("email")
    private String userEmail;
    @SerializedName("address")
    private Address userAddress;
    @SerializedName("phone")
    private String userPhoneNumber;
    @SerializedName("website")
    private String userWebsite;
    @SerializedName("company")
    private Company userCompany;

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserWebsite() {
        return userWebsite;
    }

    public Company getUserCompany() {
        return userCompany;
    }
}
