package com.id.tick.dto;

import java.util.Collection;

public class Schedule {
    private Collection<String> trains;

    public Schedule() {
    }

    public Collection<String> getTrains() {
        return trains;
    }

    public void setTrains(Collection<String> trains) {
        this.trains = trains;
    }
}
