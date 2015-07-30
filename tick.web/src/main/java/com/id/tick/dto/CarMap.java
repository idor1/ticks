package com.id.tick.dto;

import java.util.Collection;

/**
 * Created on 30.07.2015.
 */
public class CarMap {
    private CarInfo car_info;
    private Collection<String> free_places;
    private Collection<String> busy_places;


    public CarInfo getCar_info() {
        return car_info;
    }

    public void setCar_info(CarInfo car_info) {
        this.car_info = car_info;
    }

    public Collection<String> getFree_places() {
        return free_places;
    }

    public void setFree_places(Collection<String> free_places) {
        this.free_places = free_places;
    }

    public Collection<String> getBusy_places() {
        return busy_places;
    }

    public void setBusy_places(Collection<String> busy_places) {
        this.busy_places = busy_places;
    }
}
