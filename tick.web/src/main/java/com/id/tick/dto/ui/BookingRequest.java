package com.id.tick.dto.ui;

import com.id.tick.dto.response.Station;

import java.util.Collection;

/**
 * Created on 09.07.2015.
 */
public class BookingRequest {
    private Collection<Passenger> passengers;

    private Station from;
    private Station to;

    private String date;

    private String email;

    public Collection<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
