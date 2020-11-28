package com.example.springresttemplate.model;

import java.io.Serializable;

/**
 * @author changyanan1
 */
public class HouseInfo implements Serializable {
    private static final long serialVersionUID = 9022618877014183843L;
    private Long id;
    private String city;
    private String province;
    private String region;

    public HouseInfo() {
    }

    public HouseInfo(Long id, String city, String province, String region) {
        this.id = id;
        this.city = city;
        this.province = province;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
