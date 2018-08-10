package com.foo.test.drools.domain;

import org.drools.command.Command;

public class Fire implements Command{

    private Room room;

    public Fire(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}