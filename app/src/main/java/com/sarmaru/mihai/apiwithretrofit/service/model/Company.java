package com.sarmaru.mihai.apiwithretrofit.service.model;

import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    private String companyName;
    @SerializedName("catchPhrase")
    private String companyCatchPhrase;
    @SerializedName("bs")
    private String companyBusiness;

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCatchPhrase() {
        return companyCatchPhrase;
    }

    public String getCompanyBusiness() {
        return companyBusiness;
    }
}
