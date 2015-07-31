package com.id.tick.booking;

/**
 * Created on 30.07.2015.
 */
public class CabinSeat {
    private int cabin;
    private int seat;
    private String name;
    private String surname;

    public CabinSeat(int cabin, int seat, String name, String surname) {
        this.cabin = cabin;
        this.seat = seat;
        this.name = name;
        this.surname = surname;
    }

    public CabinSeat(int cabin, int seat) {
        this.cabin = cabin;
        this.seat = seat;
    }

    public int getCabin() {
        return cabin;
    }

    public void setCabin(int cabin) {
        this.cabin = cabin;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
