package com.foo.test.disruptor.park;

/**
 * @author mawming
 * @version 1.0
 * @create date:2016-9-12.
 */
public class InParkingDataEvent {
    private String carLicense = "";

    public void setCarLicense(String carLicense)
    {
        this.carLicense = carLicense;
    }
    public String getCarLicense()
    {
        return carLicense;
    }
}