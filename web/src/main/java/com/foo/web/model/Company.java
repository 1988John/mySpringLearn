package com.foo.web.model;

import com.alibaba.fastjson.JSON;
import com.foo.web.common.MockUtils;

/**
 * @author Fooisart
 * @date 14:26 01-04-2019
 */
public class Company {
    private Location location;
    private Employee employee;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static void main(String[] args) {
        Company o = MockUtils.mockData(Company.class);

        System.out.println(JSON.toJSON(o));
    }
}

