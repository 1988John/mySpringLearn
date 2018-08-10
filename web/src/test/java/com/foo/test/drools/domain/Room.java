package com.foo.test.drools.domain;

import org.drools.command.Command;

public class Room implements Command{

    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}