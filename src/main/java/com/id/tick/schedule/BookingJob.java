package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.dto.response.Route;
import com.id.tick.dto.response.RouteVariant;
import com.id.tick.dto.ui.BookingRequest;
import org.quartz.*;

import java.util.Collection;

public class BookingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();

//        BookingRequest bookingRequest = bookingJobContext.getBookingRequest();

        ScheduleRequestService scheduleRequestService = (ScheduleRequestService) jobExecutionContext.get(BookingScheduler.SCHEDULE_REQUEST_SERVICE_KEY);

        BookingManager bookingManager = (BookingManager) jobExecutionContext.get(BookingScheduler.BOOKING_MANAGER_SERVICE_KEY);

        //TODO: continue here
        BookingRequest currentRequest = scheduleRequestService.getBookingRequest();

        Route route = bookingManager.findRoute(currentRequest);

        System.out.println("Trains found: " + route);

        String trainId = findSufficientTrain(route, currentRequest);
        if (trainId != null) {
            System.out.println("Specific train found: " + trainId);
            try {
                boolean exists = ScheduleProvider.getScheduler().checkExists(jobKey);
                if (exists) {
                    ScheduleProvider.getScheduler().deleteJob(jobKey);
                }
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    private String findSufficientTrain(Route route, BookingRequest bookingRequest) {
        if (route != null && route.getVars() != null && !route.getVars().isEmpty()) {
            Collection<RouteVariant> vars = route.getVars();
            for (RouteVariant var : vars) {
                if (bookingRequest.getTrainId() != null && bookingRequest.getTrainId().equalsIgnoreCase(var.getTrip().getId())) {
                    return var.getGuididx();
                }
            }
        }

        return null;
    }
}
