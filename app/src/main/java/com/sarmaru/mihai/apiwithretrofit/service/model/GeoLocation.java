package com.sarmaru.mihai.apiwithretrofit.service.model;

import com.google.gson.annotations.SerializedName;

public class GeoLocation {

    @SerializedName("lat")
    private String latitude;
    @SerializedName("lng")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
