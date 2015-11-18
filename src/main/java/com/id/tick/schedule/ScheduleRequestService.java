package com.id.tick.schedule;

import com.id.tick.dto.ui.BookingRequest;
import org.springframework.stereotype.Service;

/**
 * Created on 16.11.2015.
 */
@Service
public class ScheduleRequestService {
    private BookingRequest bookingRequest;

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }
}
