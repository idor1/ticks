package com.id.tick.controller;

import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.Booking;
import com.id.tick.dto.Schedule;
import com.id.tick.dto.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on 15.05.2015.
 */
@Controller
public class MainController {
    @Autowired
    private ApiConnector apiConnector;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping(value = "/booking/{bookingId}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public @ResponseBody String book(@RequestBody Booking booking) {
        return booking.toString();
    }

//    @RequestMapping("/index")
//    public String index() {
//        return "main";
//    }

    @RequestMapping("/schedule")
    public @ResponseBody Schedule getSchedule(@RequestParam String start, @RequestParam String destination) {
        Schedule schedule = new Schedule();
        Collection<String> trains = new ArrayList<String>();
        trains.add(start + "_FS");
        trains.add(destination + "_LS");
        schedule.setTrains(trains);
        return schedule;
    }

    @RequestMapping("/station/departures/{criteria}")
    public @ResponseBody Collection<Station> getDepartures(@PathVariable String criteria) {
        return apiConnector.getDepartures(criteria);
    }

    @RequestMapping("/station/arrivals/{criteria}")
    public @ResponseBody Collection<Station> getArrivals(@PathVariable String criteria) {
        return apiConnector.getArrivals(criteria);
    }

}
