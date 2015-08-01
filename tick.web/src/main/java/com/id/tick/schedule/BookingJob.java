package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.dto.response.Route;
import com.id.tick.dto.ui.BookingRequest;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BookingJob implements Job {
    private BookingRequest bookingRequest;
    private BookingManager bookingManager;

    public BookingJob(BookingRequest bookingRequest, BookingManager bookingManager) {
        this.bookingRequest = bookingRequest;
        this.bookingManager = bookingManager;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Route route = bookingManager.findRoute(bookingRequest);

        if (route != null && !route.getVars().isEmpty()) {

        }
    }
}
