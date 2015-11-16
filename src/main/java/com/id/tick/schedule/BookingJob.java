package com.id.tick.schedule;

import com.id.tick.dto.response.Route;
import com.id.tick.dto.response.RouteVariant;
import com.id.tick.dto.ui.BookingRequest;
import org.quartz.*;

import java.util.Collection;

public class BookingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();

        BookingJobContext bookingJobContext = (BookingJobContext) jobExecutionContext.getJobDetail().getJobDataMap().get(jobKey.getName());

        BookingRequest bookingRequest = bookingJobContext.getBookingRequest();

        Route route = bookingJobContext.getBookingManager().findRoute(bookingRequest);
        System.out.println("Trains found: " + route);

        String trainId = findSufficientTrain(route, bookingRequest);
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
