package com.id.tick.schedule;

import com.id.tick.booking.BookingManager;
import com.id.tick.dto.ui.BookingRequest;
import com.id.tick.mail.MailSender;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on 09.07.2015.
 */
@Service
public class BookingScheduler {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private BookingManager bookingManager;

    private Map<String, BookingRequest> references = new HashMap<String, BookingRequest>();

    public String scheduleBooking(BookingRequest bookingRequest) {
        String ref = String.valueOf(new Random().nextInt());

//        bookingManager.bookTickets(bookingRequest);
        JobKey jobKey = JobKey.jobKey(JobKeyProvider.nextKey());

        JobDetail job = JobBuilder.newJob(BookingJob.class)
                .withIdentity(jobKey).build();

        job.getJobDataMap().put(jobKey.getName(), new BookingJobContext(bookingRequest, bookingManager));

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(jobKey.getName(), "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInMinutes(5).repeatForever())
                .build();

        try {
            ScheduleProvider.getScheduler().scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        references.put(ref, bookingRequest);
//        try {
//            mailSender.generateAndSendEmail(bookingRequest.getEmail());
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return ref;
    }
}
