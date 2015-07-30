package com.id.tick.booking;

import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.*;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created on 30.07.2015.
 */
@Service
public class BookingManager {
    @Autowired
    private ApiConnector apiConnector;
    private int cabinNumber = 2;

    public String bookTickets(BookingRequest bookingRequest) {
        assert bookingRequest.getDate() != null;

        Route route = apiConnector.findRoute(bookingRequest.getFrom().getIdx(), bookingRequest.getTo().getIdx(), bookingRequest.getDate());

        RouteVariant routeVariant = findFastestVariant(route.getVars());

        Collection<CabinSeat> freeSeats = findFreeCabinSeats(routeVariant);

        for (Passenger passenger : bookingRequest.getPassengers()) {
            String firstName = passenger.getFirstName();
            String lastName = passenger.getLastName();

            if (firstName != null && lastName != null) {
                if (routeVariant.getSeats().getRw_sitting().getFree() > 0) {
                    CabinSeat seat = findFreeCabinSeat(freeSeats);
                }
            }
        }

        return "";
    }

    private Collection<CabinSeat> findFreeCabinSeats(RouteVariant routeVariant) {
        Collection<CabinSeat> seats = new LinkedHashSet<CabinSeat>();

        CarMap carMap = apiConnector.carMap(routeVariant.getGuididx(), cabinNumber);
        Collection<String> free_places = carMap.getFree_places();
        if (free_places != null && !free_places.isEmpty()) {
            for (String place : free_places) {
                CabinSeat cabinSeat = new CabinSeat(cabinNumber, Integer.valueOf(place));
                seats.add(cabinSeat);
            }
        }
        return seats;
    }

    private CabinSeat findFreeCabinSeat(Collection<CabinSeat> freeSeats) {
        if (!freeSeats.isEmpty()) {
            return freeSeats.iterator().next();
        } else {
            return null;
        }
    }

    private RouteVariant findFastestVariant(Collection<RouteVariant> vars) {
        if (!vars.isEmpty()) {
            RouteVariant fastest = vars.iterator().next();

            for (RouteVariant variant : vars) {
                fastest = fastest(fastest, variant);
            }

            return fastest;
        } else {
            return null;
        }
    }

    private RouteVariant fastest(RouteVariant variant1, RouteVariant variant2) {
        PeriodFormatter hoursMinutes = new PeriodFormatterBuilder()
                .appendHours()
                .appendSeparator(":")
                .appendMinutes()
                .toFormatter();

        Period period = Period.parse(variant1.getDuration(), hoursMinutes);
        Duration duration1 = period.toStandardDuration();

        period = Period.parse(variant2.getDuration(), hoursMinutes);
        Duration duration2 = period.toStandardDuration();

        if (duration1.isShorterThan(duration2)) {
            return variant1;
        } else {
            return variant2;
        }
    }
}
