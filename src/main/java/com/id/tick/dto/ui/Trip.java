package com.id.tick.dto.ui;

/**
 * Created on 09.07.2015.
 */
public class Trip {
    private String id;
    private String el;
    private String boarding_pass;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEl() {
        return el;
    }

    public void setEl(String el) {
        this.el = el;
    }

    public String getBoarding_pass() {
        return boarding_pass;
    }

    public void setBoarding_pass(String boarding_pass) {
        this.boarding_pass = boarding_pass;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", el='" + el + '\'' +
                ", boarding_pass='" + boarding_pass + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
