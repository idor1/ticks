package com.id.tick.booking;

/**
 * Created on 30.07.2015.
 */
public class CabinSeat {
    private int cabin;
    private int seat;

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
}
