package com.example.test12;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("lat")
    private Double lattitude;
    @SerializedName("lng")
    private Double longitude;

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
