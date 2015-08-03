package com.id.tick.dto.response;

import com.id.tick.dto.ui.Trip;

/**
 * Created on 09.07.2015.
 */
public class RouteVariant {
    private String guididx;
    private String dep_date;//date
    private String arr_date;//date
    private String src_dep;//time
    private String dst_arr;//time
    private String duration;

    private Trip trip;

    private Seats seats;

    public String getGuididx() {
        return guididx;
    }

    public void setGuididx(String guididx) {
        this.guididx = guididx;
    }

    public String getDep_date() {
        return dep_date;
    }

    public void setDep_date(String dep_date) {
        this.dep_date = dep_date;
    }

    public String getArr_date() {
        return arr_date;
    }

    public void setArr_date(String arr_date) {
        this.arr_date = arr_date;
    }

    public String getSrc_dep() {
        return src_dep;
    }

    public void setSrc_dep(String src_dep) {
        this.src_dep = src_dep;
    }

    public String getDst_arr() {
        return dst_arr;
    }

    public void setDst_arr(String dst_arr) {
        this.dst_arr = dst_arr;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "RouteVariant{" +
                "guididx='" + guididx + '\'' +
                ", dep_date='" + dep_date + '\'' +
                ", arr_date='" + arr_date + '\'' +
                ", src_dep='" + src_dep + '\'' +
                ", dst_arr='" + dst_arr + '\'' +
                ", duration='" + duration + '\'' +
                ", trip=" + trip +
                ", seats=" + seats +
                '}';
    }
}
