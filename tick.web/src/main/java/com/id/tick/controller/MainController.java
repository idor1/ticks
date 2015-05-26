package com.id.tick.controller;

import com.id.tick.Booking;
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

    @RequestMapping("/index")
    public String index() {
        return "main";
    }
}
