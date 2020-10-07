package com.sarmaru.mihai.apiwithretrofit.service.model;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("street")
    private String streetName;
    @SerializedName("suite")
    private String apartmentName;
    @SerializedName("city")
    private String cityName;
    @SerializedName("zipcode")
    private String zipCode;

    @SerializedName("geo")
    private GeoLocation getLocation;

    public String getStreetName() {
        return streetName;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public GeoLocation getGetLocation() {
        return getLocation;
    }
}
