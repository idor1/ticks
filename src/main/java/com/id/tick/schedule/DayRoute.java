package com.id.tick.schedule;

import com.id.tick.dto.ui.BookingRequest;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 20.11.2015.
 */
public class DayRoute {
    private Map<RouteKey, Collection<BookingRequest>> requests;

    public Map<RouteKey, Collection<BookingRequest>> getRequests() {
        return requests;
    }

    public void setRequests(Map<RouteKey, Collection<BookingRequest>> requests) {
        this.requests = requests;
    }
}
