package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.dto.ui.BookingRequest;

/**
 * Created on 03.08.2015.
 */
public class BookingJobContext {
    private BookingRequest bookingRequest;
    private BookingManager bookingManager;

    public BookingJobContext(BookingRequest bookingRequest, BookingManager bookingManager) {
        this.bookingRequest = bookingRequest;
        this.bookingManager = bookingManager;
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public void setBookingManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }
}
