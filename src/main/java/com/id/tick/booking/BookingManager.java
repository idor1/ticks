package com.id.tick.booking;

import com.id.tick.connector.ApiConnector;
import com.id.tick.dto.request.BillOptions;
import com.id.tick.dto.request.BillRequest;
import com.id.tick.dto.request.Person;
import com.id.tick.dto.request.SeatBookingRequest;
import com.id.tick.dto.response.CarMap;
import com.id.tick.dto.response.Invoice;
import com.id.tick.dto.response.Route;
import com.id.tick.dto.response.RouteVariant;
import com.id.tick.dto.ui.BookingRequest;
import com.id.tick.dto.ui.Passenger;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//        Route route = findRoute(bookingRequest);
        Route route = findRoute(null, null, null);

        RouteVariant routeVariant = findFastestVariant(route.getVars());

        Collection<CabinSeat> freeSeats = findFreeCabinSeats(routeVariant);

        Collection<CabinSeat> seatsToBook = new ArrayList<CabinSeat>();

        for (Passenger passenger : bookingRequest.getPassengers()) {
            String firstName = passenger.getFirstName();
            String lastName = passenger.getLastName();

            if (firstName != null && !firstName.equals("") && lastName != null && !lastName.equals("")) {
                if (routeVariant.getSeats().getRw_sitting().getFree() > 0) {
                    CabinSeat seat = findFreeCabinSeat(freeSeats);
                    seat.setName(firstName);
                    seat.setSurname(lastName);
                    seatsToBook.add(seat);
                }
            }
        }

        return bill(routeVariant.getGuididx(), (byte) cabinNumber, seatsToBook, bookingRequest);
    }

    public Route findRoute(String fromIdx, String toIdx, String date) {
        return apiConnector.findRoute(fromIdx, toIdx, date);
    }

    private String bill(String guididx, byte cabinNumber, Collection<CabinSeat> seatsToBook, BookingRequest bookingRequest) {
        BillRequest billRequest = new BillRequest();
        for (CabinSeat seat : seatsToBook) {
            SeatBookingRequest seatBookingRequest = new SeatBookingRequest();
            Person person = new Person();
            person.setName(seat.getName());
            person.setSurname(seat.getSurname());
            seatBookingRequest.setPerson(person);
            billRequest.getSeats().add(seatBookingRequest);
        }

        BillOptions billOptions = new BillOptions();
        billOptions.setOwner_email(bookingRequest.getEmail());
        billOptions.setOwner_phone("+385556663322");
        billOptions.setType("reservation");
        billRequest.setOptions(billOptions);

        Invoice invoice = apiConnector.bill(guididx, cabinNumber, seatsToBook, billRequest);

        return invoice.getAsps_code_2();
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
