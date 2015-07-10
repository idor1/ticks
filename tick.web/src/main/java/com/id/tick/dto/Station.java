package com.id.tick.dto;

/**
 * Created on 18.06.2015.
 */
public class Station {
    private String idx;
    private String name;

    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Station{" +
                "idx='" + idx + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
