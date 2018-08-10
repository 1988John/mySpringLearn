package com.foo.test.drools.domain;

import org.drools.command.Command;

public class Sprinkler implements Command{

    private Room room;

    private boolean on;

    public Sprinkler(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}