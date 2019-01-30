package com.foo.domain.user;

/**
 * @author Fooisart
 * @date 11:02 30-01-2019
 */
public class Address {
    private Integer id;
    private String province;
    private String city;
    private String town;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
