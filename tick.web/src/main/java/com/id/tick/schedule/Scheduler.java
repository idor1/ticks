package com.id.tick.schedule;

import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.BookingRequest;
import com.id.tick.dto.Route;
import com.id.tick.dto.RouteVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on 09.07.2015.
 */
@Service
public class Scheduler {
    @Autowired
    private ApiConnector apiConnector;

    private Map<String, BookingRequest> references = new HashMap<String, BookingRequest>();

    public String scheduleBooking(BookingRequest bookingRequest) {
        String ref = String.valueOf(new Random().nextInt());
        references.put(ref, bookingRequest);
        tryToBook(bookingRequest);
        return ref;
    }

    private void tryToBook(BookingRequest bookingRequest) {
        Route route = apiConnector.findRoute(bookingRequest.getFrom().getIdx(), bookingRequest.getTo().getIdx(), bookingRequest.getDate());

        RouteVariant routeVariant = route.getVars().iterator().next();

        routeVariant.getGuididx();
    }
}
