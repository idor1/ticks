package com.id.tick.controller;

import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.*;
import com.id.tick.schedule.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on 15.05.2015.
 */
@RestController
public class MainController {
    @Autowired
    private ApiConnector apiConnector;

    @Autowired
    private Scheduler scheduler;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping(value = "/reference/{bookingId}", method = RequestMethod.GET)
    public
    @ResponseBody
    Booking getBooking(@PathVariable String bookingId) {
        Booking booking = new Booking();
        booking.setId(bookingId);
        booking.setTrainId("2DF");
        booking.setCabinId("5");
        Collection<String> seats = new ArrayList<String>();
        seats.add("11");
        seats.add("12");
        booking.setSeats(seats);
        return booking;
    }

    @RequestMapping("/schedule")
    public @ResponseBody Schedule getSchedule(@RequestParam String start, @RequestParam String destination,
                                              @RequestParam String date) {
        Schedule schedule = new Schedule();
        Collection<String> trains = new ArrayList<String>();

        Route route = apiConnector.findRoute(start, destination, date);

        schedule.setTrains(trains);
        return schedule;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST, consumes = "application/json")
    public String scheduleBooking(@RequestBody BookingRequest request) {
        return scheduler.scheduleBooking(request);
    }

    @RequestMapping(value = "/station/departures/{criteria}", method = RequestMethod.GET)
    public @ResponseBody Collection<Station> getDepartures(@PathVariable String criteria) {
        return apiConnector.getDepartures(criteria);
    }

    @RequestMapping(value = "/station/arrivals/{criteria}", method = RequestMethod.GET)
    public @ResponseBody Collection<Station> getArrivals(@PathVariable String criteria) {
        return apiConnector.getArrivals(criteria);
    }

}
