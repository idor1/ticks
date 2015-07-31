package com.id.tick.dto.request;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on 30.07.2015.
 */
public class BillRequest {
    private BillOptions options;
    private Collection<SeatBookingRequest> seats = new ArrayList<SeatBookingRequest>();

    public BillOptions getOptions() {
        return options;
    }

    public void setOptions(BillOptions options) {
        this.options = options;
    }

    public Collection<SeatBookingRequest> getSeats() {
        return seats;
    }

    public void setSeats(Collection<SeatBookingRequest> seats) {
        this.seats = seats;
    }
}
