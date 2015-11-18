package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.dto.ui.BookingRequest;
import com.id.tick.mail.MailSender;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on 09.07.2015.
 */
@Service
public class BookingScheduler {
    public static final String SCHEDULE_REQUEST_SERVICE_KEY = "ScheduleRequestService";
    public static final String BOOKING_MANAGER_SERVICE_KEY = "BookingManagerService";

    @Autowired
    private MailSender mailSender;
    @Autowired
    private ScheduleRequestService scheduleRequestService;
    @Autowired
    private BookingManager bookingManager;

    private Map<String, BookingRequest> references = new HashMap<String, BookingRequest>();

    @PostConstruct
    public void initializeJobs() {
        JobKey jobKey = JobKey.jobKey(JobKeyProvider.nextKey());

        JobDetail job = JobBuilder.newJob(BookingJob.class)
                .withIdentity(jobKey).build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(jobKey.getName(), "trainNumberGroup")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInMinutes(1).repeatForever())
                .build();

        try {
            Scheduler scheduler = ScheduleProvider.getScheduler();

            scheduler.getContext().put(SCHEDULE_REQUEST_SERVICE_KEY, scheduleRequestService);
            scheduler.getContext().put(BOOKING_MANAGER_SERVICE_KEY, bookingManager);

            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public String scheduleBooking(BookingRequest bookingRequest) {
        String ref = String.valueOf(new Random().nextInt());

        //TODO add here
//        bookingManager.bookTickets(bookingRequest);
        references.put(ref, bookingRequest);
//        try {
//            mailSender.generateAndSendEmail(bookingRequest.getEmail());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return ref;
    }
}
