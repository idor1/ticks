package com.id.tick.dto.ui;

import java.util.Collection;

/**
 * Created on 26.05.2015.
 */
public class Booking {
    private String id;
    private String trainId;
    private String cabinId;
    private Collection<String> seats;

    public Booking() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getCabinId() {
        return cabinId;
    }

    public void setCabinId(String cabinId) {
        this.cabinId = cabinId;
    }

    public Collection<String> getSeats() {
        return seats;
    }

    public void setSeats(Collection<String> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", trainId='" + trainId + '\'' +
                ", cabinId='" + cabinId + '\'' +
                ", seats=" + seats +
                '}';
    }
}
